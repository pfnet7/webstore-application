package com.webstoreapp.error;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final static String NOT_FOUND_MESSAGE = "User not found";

    private final int errorCode;
    private final String message;

    public static Response buildNotFoundResponse() {
        return Response.status(HttpServletResponse.SC_NOT_FOUND)
                .entity(new ErrorResponse(HttpServletResponse.SC_NOT_FOUND, NOT_FOUND_MESSAGE)).build();
    }

    public static Response buildBadRequestResponse(String exceptionMessage) {
        return Response.status(HttpServletResponse.SC_BAD_REQUEST)
                .entity(new ErrorResponse(HttpServletResponse.SC_BAD_REQUEST, exceptionMessage)).build();
    }

}
