package org.s3valkov.cooking4love.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Recipe doesn't exist!")
public class RecipeNotFoundException extends RuntimeException{
    private int status;

    public RecipeNotFoundException() {
        this.status = 404;
    }

    public RecipeNotFoundException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }

}
