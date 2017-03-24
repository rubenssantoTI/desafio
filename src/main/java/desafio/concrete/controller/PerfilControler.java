package desafio.concrete.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import desafio.concrete.exceptions.InvalidTokenException;
import desafio.concrete.model.Usuario;
import desafio.concrete.service.JwtService;
import desafio.concrete.service.UsuarioService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilControler {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JwtService jwtService; 

	@RequestMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Usuario> login(@RequestBody Usuario user, HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		Usuario userSaved = usuarioService.find(user.getId());
		if (!StringUtils.isNotBlank(token) || !jwtService.isEqualsToken(userSaved.getToken(), token)) {
			 throw new InvalidTokenException(); 
		} else if (!jwtService.isTokenValido(token)) {
			throw new InvalidTokenException();
		}
		return new ResponseEntity<>(userSaved, HttpStatus.ACCEPTED);
	}

}
