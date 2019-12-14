package org.s3valkov.cooking4love.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Comment doesn't exist!")
public class CommentNotFoundException extends RuntimeException  {
    private int status;

    public CommentNotFoundException() {
        this.status = 404;
    }

    public CommentNotFoundException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }
}
