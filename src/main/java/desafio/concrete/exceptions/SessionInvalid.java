package desafio.concrete.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.REQUEST_TIMEOUT, reason="Sess�o inv�lida")
public class SessionInvalid extends AuthenticationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SessionInvalid() {
        super("Sess�o inv�lida");
    }
}
