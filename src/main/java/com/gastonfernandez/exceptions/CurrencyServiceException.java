package com.gastonfernandez.exceptions;

public class CurrencyServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception exceptionApiServicePrimary;
	private Exception exceptionApiServiceSecundary;

	public CurrencyServiceException(Exception exceptionApiServicePrimary, Exception exceptionApiServiceSecundary) {
		super();
		this.exceptionApiServicePrimary = exceptionApiServicePrimary;
		this.exceptionApiServiceSecundary = exceptionApiServiceSecundary;
		this.setStackTrace(concatenarStackTraces(exceptionApiServicePrimary, exceptionApiServiceSecundary));
	}

	private StackTraceElement[] concatenarStackTraces(Exception exceptionApiServicePrimary,
			Exception exceptionApiServiceSecundary) {
		StackTraceElement[] stackTraceApiServicePrimary = exceptionApiServicePrimary.getStackTrace();
		StackTraceElement[] stackTraceApiServiceSecundary = exceptionApiServiceSecundary.getStackTrace();
		StackTraceElement[] stackTrace = new StackTraceElement[stackTraceApiServicePrimary.length
				+ stackTraceApiServiceSecundary.length];
		System.arraycopy(stackTraceApiServicePrimary, 0, stackTrace, 0, stackTraceApiServicePrimary.length);
		System.arraycopy(stackTraceApiServiceSecundary, 0, stackTrace, stackTraceApiServicePrimary.length,
				stackTraceApiServiceSecundary.length);
		return stackTrace;
	}

	public Exception getExceptionApiServicePrincipal() {
		return exceptionApiServicePrimary;
	}

	public Exception getExceptionApiServiceSecundario() {
		return exceptionApiServiceSecundary;
	}

	@Override
	public String getMessage() {
		return "Excepción en el Api service principal: " + exceptionApiServicePrimary.getMessage()
				+ ", Excepción en el api service secundario: " + exceptionApiServiceSecundary.getMessage();
	}

}
