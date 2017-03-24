package desafio.concrete.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import desafio.concrete.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Service
@Component
public class JwtService {
	
	private Key key ;
	
	public JwtService() {
		key = MacProvider.generateKey();
	}
	
	public String createJWT(Usuario user) {
		
		return Jwts.builder().setSubject(user.getEmail()).setExpiration(this.getDateExpirion())
				.claim("id", user.getId()).signWith(SignatureAlgorithm.HS256, key)
				.compact();

	}

	public Boolean isTokenValido(String token) {
		Boolean retorno = Boolean.TRUE;
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			retorno = Boolean.FALSE;
		}
		return retorno;
	} 
	
	private Date getDateExpirion() {
		Date date = new Date();
		date.setTime(System.currentTimeMillis() + 30 * 60 * 1000);
		return date;
	}
	
	public Boolean isEqualsToken(String tokenSaved, String token) {
    	return tokenSaved.equals(token); 
    }

}
