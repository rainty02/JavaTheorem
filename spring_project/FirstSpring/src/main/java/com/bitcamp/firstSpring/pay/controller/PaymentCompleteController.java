package com.bitcamp.firstSpring.pay.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentCompleteController {
	
	@RequestMapping(value="payment/complete", method = RequestMethod.GET)
	  public String paymentComplete() {
		  return "payment/paymentComplete";
	  }
	  
}