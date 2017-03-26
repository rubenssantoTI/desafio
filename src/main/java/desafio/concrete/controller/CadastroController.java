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

import desafio.concrete.exceptions.ExistingEmail;
import desafio.concrete.model.User;
import desafio.concrete.service.UsuarioService;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {
	
	@Autowired
	private UsuarioService usuarioService;
   
    @RequestMapping(value = "/new", consumes=MediaType.APPLICATION_JSON_VALUE, 
    					produces=MediaType.APPLICATION_JSON_VALUE, 
    					method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> login(@RequestBody User user) {
	   
	  if (usuarioService.findUserByEmail(user) != null) {
		  throw new ExistingEmail();
	  } else {
		  usuarioService.create(user);
	  }
      
	  return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
    
}

 

