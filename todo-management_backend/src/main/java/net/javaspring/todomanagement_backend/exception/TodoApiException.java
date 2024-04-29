package net.javaspring.todomanagement_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class TodoApiException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
