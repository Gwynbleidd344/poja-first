package test.poja.first.endpoint.rest.controller.calculus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<Integer> add(@RequestParam("a") int a, @RequestParam("b") int b) {
    return ResponseEntity.ok(calcService.add(a, b));
  }

  @GetMapping("/subtract")
  public ResponseEntity<Integer> subtract(@RequestParam("a") int a, @RequestParam("b") int b) {
    return ResponseEntity.ok(calcService.subtract(a, b));
  }

  @GetMapping("/multiply")
  public ResponseEntity<Integer> multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
    return ResponseEntity.ok(calcService.multiply(a, b));
  }

  @GetMapping("/divide")
  public ResponseEntity<Double> divide(@RequestParam("a") int a, @RequestParam("b") int b) {
    return ResponseEntity.ok(calcService.divide(a, b));
  }
}
