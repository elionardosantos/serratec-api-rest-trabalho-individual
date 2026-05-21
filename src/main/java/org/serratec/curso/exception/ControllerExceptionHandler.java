package org.serratec.curso.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

// @ControllerAdvice
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> erros = new ArrayList<>();

		for (FieldError error: ex.getBindingResult().getFieldErrors()) {
			erros.add(error.getField() + ": " + error.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(status.value(),
				"Existem Campos Inválidos, confira o preenchimento", LocalDateTime.now(), erros);
		
		return super.handleExceptionInternal(ex, erroResposta,headers, status, request);
	}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> handleAllExceptions(Exception ex, WebRequest request) {
        
        List<String> erros = List.of(ex.getMessage());
        ErroResposta erroResposta = new ErroResposta(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Erro interno no servidor",
            LocalDateTime.now(),
            erros
        );

        return new ResponseEntity<>(erroResposta, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroResposta> handleConstraintViolation(
            ConstraintViolationException ex,
            WebRequest request) {

        List<String> erros = new ArrayList<>();
        
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
        String mensagem = violation.getMessage();
        
            if (!erros.contains(mensagem)) {
                erros.add(mensagem);
            }
        }

        ErroResposta erroResposta = new ErroResposta(
            HttpStatus.BAD_REQUEST.value(),
            "Erros de validação",
            LocalDateTime.now(),
            erros);

        return ResponseEntity.badRequest().body(erroResposta);
    }
	
}
