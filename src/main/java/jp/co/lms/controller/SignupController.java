package jp.co.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String back() {
		return "login";
	}
}
