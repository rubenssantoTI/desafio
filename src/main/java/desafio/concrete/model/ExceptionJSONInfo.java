package desafio.concrete.model;

public class ExceptionJSONInfo {
	
	private String HttpStatus;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHttpStatus() {
		return HttpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		HttpStatus = httpStatus;
	}

	
}
