package gov.nist.toolkit.xdsexception;

import gov.nist.toolkit.xdsexception.client.XdsException;

public class XdsUnknownPatientIdException extends XdsException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XdsUnknownPatientIdException(String message, String resource) {
		super(message, resource);
	}

	public XdsUnknownPatientIdException(String msg, String resource, Throwable cause) {
		super(msg, resource, cause);
	}
}
