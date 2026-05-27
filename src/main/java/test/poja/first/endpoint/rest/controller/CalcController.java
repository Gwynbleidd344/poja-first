package test.poja.first.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.poja.first.service.CalcService;

@RestController
public class CalcController {

  private final CalcService calcService;

  public CalcController(CalcService calcService) {
    this.calcService = calcService;
  }

  @GetMapping("/add")
  public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
    return ResponseEntity.ok(calcService.add(a, b));
  }

  @GetMapping("/subtract")
  public ResponseEntity<Integer> subtract(@RequestParam int a, @RequestParam int b) {
    return ResponseEntity.ok(calcService.subtract(a, b));
  }

  @GetMapping("/multiply")
  public ResponseEntity<Integer> multiply(@RequestParam int a, @RequestParam int b) {
    return ResponseEntity.ok(calcService.multiply(a, b));
  }

  @GetMapping("/divide")
  public ResponseEntity<Double> divide(@RequestParam int a, @RequestParam int b) {
    return ResponseEntity.ok(calcService.divide(a, b));
  }
}