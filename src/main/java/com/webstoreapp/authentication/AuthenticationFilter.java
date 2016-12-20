package com.webstoreapp.authentication;

import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;
import javax.annotation.Priority;
import javax.crypto.SecretKey;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    private final SecretKey secretKey = SecretKeyFactory.getSecretKey();

    @Inject
    @AuthenticatedUser
    Event<Integer> userAuthenticatedEvent;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        Optional<Integer> outputToken = Optional.ofNullable(requestContext.getHeaderString(HttpHeaders.AUTHORIZATION))
                                               .filter(header -> header.startsWith("Bearer "))
                                               .map(header -> header.substring("Bearer".length()).trim())
                                               .map(token -> validateToken(token));


        if (outputToken.isPresent()) {
            userAuthenticatedEvent.fire(outputToken.get());
        } else {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }

    }

    private Integer validateToken(String token) {
        String key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        Optional<String> userId = Optional.ofNullable(Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key)).parseClaimsJws(token).getBody().getSubject());
        return Integer.parseInt(userId.get());
   }

}
