package org.s3valkov.cooking4love.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Category doesn't exist!")
public class CategoryNotFoundException extends RuntimeException{
    private int status;

    public CategoryNotFoundException() {
        this.status = 404;
    }

    public CategoryNotFoundException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }

}
