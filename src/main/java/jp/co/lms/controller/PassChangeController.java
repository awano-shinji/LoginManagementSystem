package jp.co.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PassChangeController {
	@RequestMapping(value = "/passChange", method = RequestMethod.POST)
	public String passChange() {
		return "login";
	}
}
