package desafio.concrete.exceptions;

import static java.lang.String.format;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Password Not Unauthorized")
public class PasswordNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -480556387020361843L;

	public PasswordNotFoundException() {
        super(format("Usuário e/ou senha inválidos"));
    }
}
