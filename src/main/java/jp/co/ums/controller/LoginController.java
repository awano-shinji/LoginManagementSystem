package jp.co.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.ums.domain.model.P_TB_0001Entity;
import jp.co.ums.domain.repository.P_TB_0001Repository;
import jp.co.ums.domain.service.P_TB_0001Service;

@Controller
public class LoginController {
	// ログイン画面へ
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@Autowired
	P_TB_0001Service p_tb_0001Service;
	@Autowired
	P_TB_0001Repository p_tb_0001Repository;

	@RequestMapping(value = "/userInfoCheck", method = RequestMethod.POST)
	public String userInfoCheck(@ModelAttribute("mailAddress") String formmail,
			@ModelAttribute("password") String formpass, Model model, RedirectAttributes attributes) {
		P_TB_0001Entity mail = new P_TB_0001Entity();
		P_TB_0001Entity pass = new P_TB_0001Entity();
		mail = p_tb_0001Repository.selectMailaddress();
		pass = p_tb_0001Repository.selectPassword();
		String datamail = mail.getUsr_m_addr();
		String datapass = pass.getAth_majinai();
		if (formmail.equals(datamail) && formpass.equals(datapass)) {
			return "/userInfoCheck";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String eroor(@Param(value = "eroor") String msg, Model model) {
		msg = "※ログインに失敗しました。\r再度、メールアドレス、パスワードを入力し、ログインしてください。";
		model.addAttribute("error", msg);
		return "login";
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
