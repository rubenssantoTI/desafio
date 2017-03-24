package desafio.concrete.web.advices;

import static org.springframework.http.HttpStatus.IM_USED;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import desafio.concrete.exceptions.EmailNotExisting;
import desafio.concrete.exceptions.ExistingEmail;
import desafio.concrete.exceptions.InvalidTokenException;
import desafio.concrete.exceptions.PasswordNotFoundException;
import desafio.concrete.exceptions.UserNotFoundException;
import desafio.concrete.model.ExceptionJSONInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public @ResponseBody ResponseEntity<ExceptionJSONInfo> userNotFound(HttpServletRequest request, Exception ex){
		ExceptionJSONInfo msg = new ExceptionJSONInfo();
    	msg.setHttpStatus(HttpStatus.UNAUTHORIZED.toString());
    	msg.setMessage(ex.getMessage());
    	return ResponseEntity.status(UNAUTHORIZED).body(msg);
	}

    @ExceptionHandler(PasswordNotFoundException.class)
    public @ResponseBody ResponseEntity<ExceptionJSONInfo> unauthorized(HttpServletRequest request, Exception ex) {
    	ExceptionJSONInfo msg = new ExceptionJSONInfo();
    	msg.setHttpStatus(HttpStatus.UNAUTHORIZED.toString());
    	msg.setMessage(ex.getMessage());
		return ResponseEntity.status(UNAUTHORIZED).body(msg);
    }
    
    @ExceptionHandler(ExistingEmail.class)
    public @ResponseBody ResponseEntity<ExceptionJSONInfo> existingEmail(HttpServletRequest request, Exception ex) {
    	ExceptionJSONInfo msg = new ExceptionJSONInfo();
    	msg.setHttpStatus(HttpStatus.IM_USED.toString());
    	msg.setMessage(ex.getMessage());
		return ResponseEntity.status(IM_USED).body(msg);
    }
    
    @ExceptionHandler(EmailNotExisting.class)
    public @ResponseBody ResponseEntity<ExceptionJSONInfo>emailNotxisting(HttpServletRequest request, Exception ex) {
    	ExceptionJSONInfo msg = new ExceptionJSONInfo();
    	msg.setHttpStatus(HttpStatus.IM_USED.toString());
    	msg.setMessage(ex.getMessage());
		return ResponseEntity.status(IM_USED).body(msg);
    }
    
    @ExceptionHandler(InvalidTokenException.class)
    public @ResponseBody ResponseEntity<ExceptionJSONInfo>invalidToken(HttpServletRequest request, Exception ex) {
    	ExceptionJSONInfo msg = new ExceptionJSONInfo();
    	msg.setHttpStatus(HttpStatus.UNAUTHORIZED.toString());
    	msg.setMessage(ex.getMessage());
		return ResponseEntity.status(UNAUTHORIZED).body(msg);
    }
    
    
}
