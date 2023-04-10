package com.example.pranala.controller;


import com.example.pranala.common.Form;
import com.example.pranala.common.Type;
import com.example.pranala.service.PranalaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pranala")
public class PranalaController {

  private final PranalaService service;


  public PranalaController(PranalaService service) {
    this.service = service;
  }

  // to test it please change @RestController to  @Controller
  @GetMapping("/form")
  public String form(Model model){
    model.addAttribute("Form", new Form());
    return "form_view";
  }


  // to test it please change @RestController to  @Controller
  @PostMapping(value = "/form", params = "triangle")
  public Object getTriangle(@ModelAttribute("form") Form form) {
    return service.data(form);
  }

  @PostMapping(value = "/form", params = "odd")
  public Object getOddNumbers(@ModelAttribute("form") Form form) {
    return service.data(form);
  }

  @PostMapping(value = "/form", params = "prima")
  public Object getPrimaNumbers(@ModelAttribute("form") Form form) {
    return service.data(form);
  }

  // to test it please change  @Controller to @RestController
  // test use postman with rest request
  @PostMapping("/result")
  public Object getResult(@RequestParam("type") Type type,
      @RequestParam("value") Integer number) {
    if (Type.TRIANGLE.equals(type)) {
      return service.triangleForm(number);
    } else if (Type.ODD_NUMBERS.equals(type)) {
      return service.oddNumbers(number);
    } else {
      return service.primaNumbers(number);
    }
  }
}
