package org.s3valkov.cooking4love.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Restaurant doesn't exist!")
public class RestaurantNotFoundException extends RuntimeException{
    private int status;

    public RestaurantNotFoundException() {
        this.status = 404;
    }

    public RestaurantNotFoundException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }
}
