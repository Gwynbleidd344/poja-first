package test.poja.first.service;

import org.springframework.stereotype.Service;
import java.lang.ArithmeticException;

@Service
public class CalcService {

  public int add(int a, int b) {
    long result = (long) a + b;
    checkOverflow(result);
    return (int) result;
  }

  public int subtract(int a, int b) {
    long result = (long) a - b;
    checkOverflow(result);
    return (int) result;
  }

  public int multiply(int a, int b) {
    long result = (long) a * b;
    checkOverflow(result);
    return (int) result;
  }

  public double divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero is not allowed");
    }
    return (double) a / b;
  }

  private void checkOverflow(long result) {
    if (result > Integer.MAX_VALUE) {
      throw new ArithmeticException(
        "Result exceeds Integer.MAX_VALUE (" + Integer.MAX_VALUE + "): " + result);
    }
    if (result < Integer.MIN_VALUE) {
      throw new ArithmeticException(
        "Result is below Integer.MIN_VALUE (" + Integer.MIN_VALUE + "): " + result);
    }
  }
}
