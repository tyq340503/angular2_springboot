package com.example.demo.response;

public class Response {
	private boolean success;
	private String message;
	private Object object;

	public Response(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public Response(boolean success, String message, Object object) {
		this.success = success;
		this.message = message;
		this.object = object;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return object;
	}

	public void setBody(Object object) {
		this.object = object;
	}
}
