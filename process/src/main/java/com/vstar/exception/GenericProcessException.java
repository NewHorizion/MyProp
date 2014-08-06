package com.vstar.exception;

/**
 * Generic Process Exception
 *
 */
public class GenericProcessException extends RuntimeException
{
	private static final long serialVersionUID = 7468183355555779922L;
	private String msg;

	/**
	 * Constructs GenericProcessException.
	 * @param exception
	 */
	public GenericProcessException(String msg) 
	{
		super(msg);
		this.msg = msg;
	}

	/**
	 * Constructs GenericProcessException. 
	 * @param exception the root cause of the exception.
	 */
	public GenericProcessException(Throwable exception) 
	{
		super(exception.getMessage(), exception);
	}
	
	/**
	 * Constructs GenericProcessException.
	 * @param msg the error message of the exception.
	 * @param exception the root cause of the exception.
	 */
	public GenericProcessException(String msg, Throwable exception) 
	{
		super(msg, exception);
	}

	/** (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() 
	{
		return ("Exception cause = " + this.msg);
	}
}
