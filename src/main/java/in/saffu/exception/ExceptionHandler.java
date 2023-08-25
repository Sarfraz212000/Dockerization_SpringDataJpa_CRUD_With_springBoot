package in.saffu.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handleMethodArgumentNotValidException( MethodArgumentNotValidException ex){
		
		Map<String, String> map= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldError = ((FieldError)error).getField();
			String defaultError = error.getDefaultMessage();
			map.put(fieldError, defaultError);
			
		});
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
	}

}
