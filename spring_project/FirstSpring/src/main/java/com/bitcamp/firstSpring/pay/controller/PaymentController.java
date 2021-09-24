package com.bitcamp.firstSpring.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping
public class PaymentController {

	@RequestMapping(value="/pay/pay", method = RequestMethod.GET)
	public String paymentPrice1() {
		return "pay/payment";

	}
	
	
	@RequestMapping(value="/pay/pay", method = RequestMethod.POST)
	public String paymentPrice(@RequestParam("cridx") int cridx, @RequestParam("crname") String crname,
			@RequestParam("paynum") int paynum, @RequestParam("payprice") int payprice, HttpServletRequest request,
			Model model) {

//		HttpSession session = request.getSession();
//		SessionDto sessionDto = (SessionDto) session.getAttribute("loginSession");
//		session.setAttribute("idx", sessionDto.getMemidx());
//		session.setAttribute("name", sessionDto.getMemname());
//		System.out.println("세션 변수(memidx) : " + sessionDto.getMemidx());
//		System.out.println("세션 변수(memname) : " + sessionDto.getMemname());
		System.out.println("페이 컨트롤러 이동");
		model.addAttribute("cridx", cridx);
		model.addAttribute("crname", crname);
		model.addAttribute("paynum", paynum);
		model.addAttribute("payprice", payprice);
		

		return "pay/payment";

	}
	
	@RequestMapping(value="/pay/complete", method = RequestMethod.POST)
	public String savePayment() {

		return "pay/paymentComplete";
	}

}