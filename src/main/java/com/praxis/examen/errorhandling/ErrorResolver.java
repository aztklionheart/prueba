package com.praxis.examen.errorhandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ErrorResolver {

	private static final Logger logger = LoggerFactory.getLogger(ErrorResolver.class);

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDescriptor resolveHttpMessageNotReadableException(HttpServletRequest req,
			HttpMessageNotReadableException e) {
		logger.error(e.getMessage(), e);

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();
		
		String message = e.getMessage();
        int index = message.indexOf(':');
        message = message.substring(0, index);

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(message);
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorDescriptor resolveMethodArgumentNotValidException(HttpServletRequest req,
			MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setPath(req.getRequestURI());

		Map<String, List<String>> groupedErrors = new HashMap<>();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			String message = fieldError.getDefaultMessage();
			String field = fieldError.getField();

			List<String> fieldsByMessage = groupedErrors.get(message);
			if (fieldsByMessage == null) {
				fieldsByMessage = new ArrayList<>();
				groupedErrors.put(message, fieldsByMessage);
			}
			fieldsByMessage.add(field);
		}

		if (!groupedErrors.isEmpty()) {
			errorDescriptor.setMessage(groupedErrors.toString());
		}

		return errorDescriptor;
	}
	//
	
	
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDescriptor resolveNumberFormatException(HttpServletRequest req, NumberFormatException e) {
		logger.error(e.getMessage(), e);

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDescriptor.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDescriptor resolveException(HttpServletRequest req, Exception e) {
		logger.error(e.getMessage(), e);

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDescriptor.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public ErrorDescriptor resolveDataNotFoundException(HttpServletRequest req, DataNotFoundException e) {
		logger.error(e.getMessage());

		ErrorDescriptor errorDescriptor = new ErrorDescriptor();

		errorDescriptor.setTimestamp(System.currentTimeMillis());
		errorDescriptor.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		errorDescriptor.setError(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
		errorDescriptor.setMessage(e.getMessage());
		errorDescriptor.setPath(req.getRequestURI());

		return errorDescriptor;
	}
	
}