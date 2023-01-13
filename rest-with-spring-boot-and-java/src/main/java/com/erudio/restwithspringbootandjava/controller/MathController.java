package com.erudio.restwithspringbootandjava.controller;

import com.erudio.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import com.erudio.restwithspringbootandjava.services.MathServices;
import com.erudio.restwithspringbootandjava.utils.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @Autowired
    MathServices mathServices;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value= "numberOne") String numberOne,
            @PathVariable(value= "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return mathServices.sum(
                NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/subtration/{numberOne}/{numberTwo}")
    public Double subtraction (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws  Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }

        return mathServices.subtraction(
                NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws  Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }

        return mathServices.multiplication(
                NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws  Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }

        return mathServices.division(
                NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable(value= "numberOne") String numberOne,
            @PathVariable(value= "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return mathServices.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping("/squareRoot/{numberOne}")
    public Double squareRoot(
            @PathVariable(value= "numberOne") String number
    ) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return Math.sqrt(NumberConverter.convertToDouble(number));
    }

}
