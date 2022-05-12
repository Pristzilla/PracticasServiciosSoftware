package es.unican.ss.ssjornadas.filters;

import java.io.IOException;
import java.nio.charset.MalformedInputException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureException;

@Provider
@isAuthenticated
public class AuthorizationRequestFilter implements ContainerRequestFilter {

	private static final String SECRET_KEY = "Javi_y_Sara";

	public void filter(ContainerRequestContext requestContext) throws IOException {

		String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		try {

			Jws<Claims> jwt = Jwts.parser().
					requireSubject("sara").require("numGrupos", "2").
					setSigningKey(SECRET_KEY). // Misma key usada en la creacion
					parseClaimsJws(token); // Valida el token

			if(token == null) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("No tienes permisos.").build());
			}
		} catch (MissingClaimException e) {
			// El token no incluye ese claim
		} catch (IncorrectClaimException e) {
			// El token incluye el claim pero el valor no coincide
		} catch (MalformedJwtException e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Token incorrecto: " + token).build());
		} catch (SignatureException e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Token no valido: " + token).build());

		}
	}

}
