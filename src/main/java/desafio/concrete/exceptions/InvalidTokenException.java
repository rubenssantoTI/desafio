package desafio.concrete.exceptions;

import static java.lang.String.format;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.IM_USED, reason="Não autorizado")
public class InvalidTokenException extends RuntimeException{
	private static final long serialVersionUID = -6999475804487963563L;
	
	public InvalidTokenException() {
		 super(format("Não autorizado"));
	}
}
