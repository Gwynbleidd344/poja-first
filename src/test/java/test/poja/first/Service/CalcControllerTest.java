package test.poja.first.Service;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import test.poja.first.endpoint.rest.controller.calculus.CalcController;
import test.poja.first.service.CalcService;

@ExtendWith(MockitoExtension.class)
class CalcControllerTest {

  @Mock private CalcService calcService;

  @InjectMocks private CalcController calcController;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(calcController).build();
  }

  @Test
  void add_shouldReturnSum() throws Exception {
    when(calcService.add(2, 3)).thenReturn(5);

    mockMvc
        .perform(get("/add").param("a", "2").param("b", "3"))
        .andExpect(status().isOk())
        .andExpect(content().string("5"));
  }

  @Test
  void add_shouldHandleNegativeNumbers() throws Exception {
    when(calcService.add(-5, 3)).thenReturn(-2);

    mockMvc
        .perform(get("/add").param("a", "-5").param("b", "3"))
        .andExpect(status().isOk())
        .andExpect(content().string("-2"));
  }

  @Test
  void subtract_shouldReturnDifference() throws Exception {
    when(calcService.subtract(10, 4)).thenReturn(6);

    mockMvc
        .perform(get("/subtract").param("a", "10").param("b", "4"))
        .andExpect(status().isOk())
        .andExpect(content().string("6"));
  }

  @Test
  void subtract_shouldHandleNegativeResult() throws Exception {
    when(calcService.subtract(3, 10)).thenReturn(-7);

    mockMvc
        .perform(get("/subtract").param("a", "3").param("b", "10"))
        .andExpect(status().isOk())
        .andExpect(content().string("-7"));
  }

  @Test
  void multiply_shouldReturnProduct() throws Exception {
    when(calcService.multiply(4, 5)).thenReturn(20);

    mockMvc
        .perform(get("/multiply").param("a", "4").param("b", "5"))
        .andExpect(status().isOk())
        .andExpect(content().string("20"));
  }

  @Test
  void multiply_shouldHandleZero() throws Exception {
    when(calcService.multiply(0, 999)).thenReturn(0);

    mockMvc
        .perform(get("/multiply").param("a", "0").param("b", "999"))
        .andExpect(status().isOk())
        .andExpect(content().string("0"));
  }

  @Test
  void multiply_shouldHandleNegativeNumbers() throws Exception {
    when(calcService.multiply(-3, 4)).thenReturn(-12);

    mockMvc
        .perform(get("/multiply").param("a", "-3").param("b", "4"))
        .andExpect(status().isOk())
        .andExpect(content().string("-12"));
  }

  @Test
  void divide_shouldReturnQuotient() throws Exception {
    when(calcService.divide(10, 2)).thenReturn(5.0);

    mockMvc
        .perform(get("/divide").param("a", "10").param("b", "2"))
        .andExpect(status().isOk())
        .andExpect(content().string("5.0"));
  }

  @Test
  void divide_shouldReturnDecimalResult() throws Exception {
    when(calcService.divide(7, 2)).thenReturn(3.5);

    mockMvc
        .perform(get("/divide").param("a", "7").param("b", "2"))
        .andExpect(status().isOk())
        .andExpect(content().string("3.5"));
  }
}
