package com.webstoreapp.authentication;

import com.webstoreapp.mybatis.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationController {

    private final long TOKEN_EXPIRATION_INTERVAL = 3600000;

    @Inject
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {

        return Optional.ofNullable(userService.getUserByUsername(username))
                       .filter(user -> user.isUserPassword(password))
                       .map(user -> Response.ok(this.createJwtToken(user.getId())).build())
                       .orElse(Response.status(Response.Status.UNAUTHORIZED).build());

    }

    private String createJwtToken(Integer userId) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + TOKEN_EXPIRATION_INTERVAL;

        Date currentTime = new Date(nowMillis);
        Date expirationTime = new Date(expMillis);

        JwtBuilder builder = Jwts.builder().setIssuedAt(currentTime)
                                           .setSubject(userId.toString())
                                           .setExpiration(expirationTime)
                                           .signWith(SignatureAlgorithm.HS512, SecretKeyFactory.getSecretKey());

        return builder.compact();
    }

}
