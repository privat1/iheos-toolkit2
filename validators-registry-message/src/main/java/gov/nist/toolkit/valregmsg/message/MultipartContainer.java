package gov.nist.toolkit.valregmsg.message;

import gov.nist.toolkit.errorrecording.ErrorRecorder;
import gov.nist.toolkit.errorrecording.client.XdsErrorCode;
import gov.nist.toolkit.http.MultipartMessageBa;
import gov.nist.toolkit.http.MultipartParserBa;
import gov.nist.toolkit.http.PartBa;
import gov.nist.toolkit.valsupport.client.ValidationContext;
import gov.nist.toolkit.valsupport.engine.MessageValidatorEngine;
import gov.nist.toolkit.valsupport.message.AbstractMessageValidator;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MultipartContainer extends AbstractMessageValidator {
	MultipartParserBa mp;
	private Map<String, StoredDocumentInt> contentMap = new HashMap<String, StoredDocumentInt>();

	public MultipartContainer(ValidationContext vc, MultipartParserBa mp) {
		super(vc);
		this.mp = mp;
	}

	public void run(ErrorRecorder er, MessageValidatorEngine mvc)  {
		this.er = er;
		er.registerValidator(this);
		
		MultipartMessageBa mm = mp.getMultipartMessage();
		er.detail("Have content for ...");
		for (int i=0; i<mm.getPartCount(); i++) {
			PartBa p = mm.getPart(i);
			String contentId = p.getContentId();
			try {
				contentId = java.net.URLDecoder.decode(contentId, "UTF-8");
			} catch (Exception e) {
				er.err(XdsErrorCode.Code.XDSRepositoryError, e);
				er.unRegisterValidator(this);
				return;
			}
			byte[] body = p.getBody();
			if (contentId !=  null && body != null) {
				StoredDocumentInt sdi = new StoredDocumentInt();
				sdi.content = body;
				String contentType = p.getContentType();
				String charset = p.getCharset();
				sdi.mimeType = contentType;
				sdi.charset = charset;
				contentMap.put(contentId, sdi);
				er.detail(contentId + " ==> " + body.length + " characters");
//				if (i > 0 && vc.getInnerContextCount() > 0) {
//					er.detail("Scheduling validation of CCDA in part " + (i + 1));
//					CommonMessageValidatorFactory.getValidatorForCCDA(er.getErrorRecorderBuilder(), body, mvc, vc.getInnerContext(0));
//				}
			}
		}
        er.unRegisterValidator(this);
	}
	
	public StoredDocumentInt getContent(String url) throws UnsupportedEncodingException {
		url = java.net.URLDecoder.decode(url, "UTF-8");
		return contentMap.get(url);
	}

}
