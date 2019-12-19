package com.product.errors;

public class ExceptionBadRequest extends Exception {

	private static final long serialVersionUID = 6638449655745431888L;

	public ExceptionBadRequest() {
		super();
	}

	public ExceptionBadRequest(final String message) {
		super(message);
	}
}
