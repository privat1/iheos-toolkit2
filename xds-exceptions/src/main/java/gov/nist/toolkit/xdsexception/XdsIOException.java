package gov.nist.toolkit.xdsexception;

import gov.nist.toolkit.xdsexception.client.XdsInternalException;

public class XdsIOException extends XdsInternalException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XdsIOException(String msg) {
		super(msg);
	}

	public XdsIOException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
