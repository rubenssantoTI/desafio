package desafio.concrete.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.IM_USED, reason="E-mail j� existente")
public class ExistingEmail extends AuthenticationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistingEmail() {
        super("E-mail j� existente");
    }
}
