package com.example.pranala.service;

import com.example.pranala.common.Form;
import com.example.pranala.common.Type;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PranalaService {

  public Object data(Form form) {
    if (Type.TRIANGLE.equals(form.getType())) {
      return triangleForm(form.getNumber());
    } else if (Type.ODD_NUMBERS.equals(form.getType())) {
      return oddNumbers(form.getNumber());
    } else {
      return primaNumbers(form.getNumber());
    }
  }


  public List<String> triangleForm(Integer number) {

    validation(number);

    String string = number.toString();

    List<String> result = new ArrayList<>();
    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      String row = c
          + "0".repeat(i + 1);

      result.add(row);
    }
    return result;
  }

  public String oddNumbers(Integer number) {
    validation(number);

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < number; i++) {
      if (i % 2 == 1) {
        result.append(" ").append(i);
      }
    }
    return result.toString();
  }

  public String primaNumbers(Integer number) {

    validation(number);

    StringBuilder result = new StringBuilder();
    for (int i = 0 ;  i < number; i++) {
      int bil = 0;

      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          bil = bil+1;
        }
      }

      if (bil == 2) {
        result.append(" ").append(i);
      }
    }

    return result.toString();
  }

  private void validation(Integer number) {

    if (number == null) {
      throw new NullPointerException("Number must not be null");
    }

    if (number < 0) {
      throw new RuntimeException("Number must greater or equals to 0");
    }
  }

}
