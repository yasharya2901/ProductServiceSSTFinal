package com.yasharya2901.github.productservicesstfinal.exceptionHandler;

import com.yasharya2901.github.productservicesstfinal.dtos.ExceptionDTO;
import com.yasharya2901.github.productservicesstfinal.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticException() {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something Went Wrong");
        dto.setResolution("Arithmetic Exception");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBoundsException() {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something Went Wrong");
        dto.setResolution("Array Index out of Bounds Exception");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException() {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something Went Wrong");
        dto.setResolution("Exception Found");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Product with the ID "+ productNotFoundException.getId()+ " doesn't exist");
        dto.setResolution("Please enter a valid ID");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

}
