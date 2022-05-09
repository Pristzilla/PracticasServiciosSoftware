package es.unican.ss.ssjornadas.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;

@Provider
@isAuthenticated
public class AuthorizationRequestFilter implements ContainerRequestFilter {
	
	private static final String SECRET_KEY = "Javi_y_Sara";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		try {
			String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			 Jws<Claims> jwt = Jwts.parser().
			 requireSubject("sara").require("numGrupos", "2").
			 setSigningKey(SECRET_KEY). // Misma key usada en la creaci�n
			 parseClaimsJws(token); // Valida el token
			} catch (MissingClaimException e) {
			 // El token no incluye ese claim
			} catch (IncorrectClaimException e) {
			 // El token incluye el claim pero el valor no coincide
			} 
	}

}
