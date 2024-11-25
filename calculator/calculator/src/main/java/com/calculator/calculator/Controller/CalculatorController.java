package com.calculator.calculator.Controller;

import com.calculator.calculator.Model.CalculationRequest;
import com.calculator.calculator.Model.CalculationResponse;
import com.calculator.calculator.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculate")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;


    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@RequestBody CalculationRequest request) {
        double result = calculatorService.add(request.getNum1(), request.getNum2());
        CalculationResponse response = new CalculationResponse();
        response.setResult(result);
        response.setMessage("Addition successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(@RequestBody CalculationRequest request) {
        double result = calculatorService.subtract(request.getNum1(), request.getNum2());
        CalculationResponse response = new CalculationResponse();
        response.setResult(result);
        response.setMessage("Subtraction successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiply(@RequestBody CalculationRequest request) {
        double result = calculatorService.multiply(request.getNum1(), request.getNum2());
        CalculationResponse response = new CalculationResponse();
        response.setResult(result);
        response.setMessage("Multiplication successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/divide")
    public ResponseEntity<CalculationResponse> divide(@RequestBody CalculationRequest request) {
        Double result = calculatorService.divide(request.getNum1(), request.getNum2());
        CalculationResponse response = new CalculationResponse();
        if (result == null) {
            response.setMessage("Cannot divide by zero");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.setResult(result);
        response.setMessage("Division successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}






