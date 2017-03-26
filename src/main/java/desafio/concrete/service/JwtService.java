package desafio.concrete.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import desafio.concrete.model.User;
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
	/**
	 * Create a token
	 * @param user
	 * @return
	 */
	public String createJWT(User user) {
		
		return Jwts.builder().setSubject(user.getEmail()).setExpiration(this.getDateExpirion())
				.claim("id", user.getId()).signWith(SignatureAlgorithm.HS256, key)
				.compact();

	}

	/**
	 * Verify if is a token valid
	 * @param token
	 * @return
	 */
	public Boolean isTokenValido(String token) {
		Boolean retorno = Boolean.TRUE;
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			retorno = Boolean.FALSE;
		}
		return retorno;
	} 
	
	/**
	 * add date expiration
	 * @return
	 */
	private Date getDateExpirion() {
		Date date = new Date();
		date.setTime(System.currentTimeMillis() + 30 * 60 * 1000);
		return date;
	}
	/**
	 * 
	 * Verify is equal token
	 * 
	 * @param tokenSaved
	 * @param token
	 * @return
	 */
	public Boolean isEqualsToken(String tokenSaved, String token) {
    	return tokenSaved.equals(token); 
    }

}
