package jp.co.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	// ログイン画面へ
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/userInfoCheck", method = RequestMethod.POST)
	public String userInfoCheck() {
		return "userInfoCheck";
	}
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}

	@RequestMapping("/passChange")
	public String passChange() {
		return "passChange";
	}
}
