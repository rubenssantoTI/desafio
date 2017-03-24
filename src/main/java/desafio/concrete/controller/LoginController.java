package desafio.concrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import desafio.concrete.exceptions.PasswordNotFoundException;
import desafio.concrete.exceptions.UserNotFoundException;
import desafio.concrete.model.Usuario;import desafio.concrete.service.JwtService;
import desafio.concrete.service.UsuarioService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private JwtService jwtService; 
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody ResponseEntity<Usuario> authenticate(@RequestBody Usuario user) {
		Usuario userSaved = usuarioService.findUserByEmail(user);
		if (userSaved == null) {
			throw new UserNotFoundException();
		} else if (!this.isEqualsPassword(user, userSaved)) {
			throw new PasswordNotFoundException();
		}
		this.atualizarUsuario(userSaved);
		return new ResponseEntity<>(userSaved, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Update the user
	 * 
	 * @param user1
	 * @param user2
	 * @return
	 */
	private void atualizarUsuario(Usuario userSaved) {
		userSaved.setToken(jwtService.createJWT(userSaved));
		usuarioService.update(userSaved);
	}
	
	/**
	 * Verifify if the password are equals
	 * 
	 * @param user1
	 * @param user2
	 * @return
	 */
	private Boolean isEqualsPassword(Usuario user1, Usuario user2) {
		return usuarioService.isEqualsPassword(user1.getPassword(),user2.getPassword());
		
	}
	
}
