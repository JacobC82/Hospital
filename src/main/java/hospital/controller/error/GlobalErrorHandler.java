package hospital.controller.error;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import hospital.controller.error.GlobalErrorHandler;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> handleNoSuchElementException(NoSuchElementException exception){
		
		log.info("No Such Element Exception has occured: {}", exception.getMessage());
		
		Map<String, String> errorMessager = new HashMap<>();
		errorMessager.put("message", exception.toString());
		
		return errorMessager;
	}
	
}
