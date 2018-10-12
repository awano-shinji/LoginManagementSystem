package jp.co.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PassChangeController {
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String passChange(@ModelAttribute("password") String password, @ModelAttribute("newPassword") String newPas,Model model, RedirectAttributes attributes) {


		return "login";
	}
}
