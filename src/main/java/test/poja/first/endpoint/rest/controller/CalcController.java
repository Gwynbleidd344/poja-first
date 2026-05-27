package test.poja.first.endpoint.rest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.poja.first.service.CalcService;

@RestController
public class CalcController {
    private final CalcService calcService;    

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }
    
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calcService.add(a, b);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return calcService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return calcService.multiply(a, b);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return calcService.divide(a, b);
    }
}
