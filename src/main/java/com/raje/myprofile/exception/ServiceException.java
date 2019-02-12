package com.raje.myprofile.exception;

/**
 * This exception in used as a wrapper over any exception caught in the service
 * layer.
 * 
 * @author fsylvia
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	private Exception e;

	public ServiceException(String message, Exception e) {
		super();
		this.message = message;
		this.e = e;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the e
	 */
	public Exception getE() {
		return e;
	}

	/**
	 * @param e the e to set
	 */
	public void setE(Exception e) {
		this.e = e;
	}

}
