package com.task.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.task.dto.ErrorMessage;
import com.task.exception.NotFoundBaseException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ErrorMessage handleException(NotFoundBaseException ex) {
        ErrorMessage errorMessage = createErrorMessage(ex);
        return errorMessage;
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage handleException(NumberFormatException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setDocumentation("Invalid Request");
        return errorMessage;
    }

	private ErrorMessage createErrorMessage(NotFoundBaseException ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setDocumentation("Entity not found");
		return errorMessage;
	}
}
