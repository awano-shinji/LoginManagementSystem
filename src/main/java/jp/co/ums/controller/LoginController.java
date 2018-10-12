package jp.co.ums.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.ums.domain.model.P_TB_0001Entity;
import jp.co.ums.domain.model.P_TB_0104Entity;
import jp.co.ums.domain.repository.P_TB_0001Repository;
import jp.co.ums.domain.repository.P_TB_0104Repository;
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
	@Autowired
	P_TB_0104Repository p_tb_0104Repository;

	@RequestMapping(value = "/userInfoCheck", method = RequestMethod.POST)
	public String userInfoCheck(@ModelAttribute("mailAddress") String mail,
			@ModelAttribute("password") String password, Model model, RedirectAttributes attributes) {
		//管理者を管理するインスタンス、ユーザを管理するリストを生成
		P_TB_0001Entity managerList = new P_TB_0001Entity();
		List<P_TB_0001Entity> userList = new ArrayList<P_TB_0001Entity>();

		//DBの情報を格納
		managerList = p_tb_0001Repository.selectManagerInfo();
		userList.addAll(p_tb_0001Repository.selectUserInfo());

		//管理者のメールアドレス、パスワードを取得
		String mmail = managerList.getUsr_m_addr();
		String mpass = managerList.getAth_majinai();

		//入力値をもとに、DB処理後、ページへ遷移
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsr_m_addr().equals(mail) && userList.get(i).getAth_majinai().equals(password)) {
				List<P_TB_0104Entity> userInfo = new ArrayList<P_TB_0104Entity>();
				userInfo.addAll(p_tb_0104Repository.selectHelloUser());
				for (int j = 0; j < userInfo.size(); j++) {
					if (userInfo.get(j).getUsr_m_addr().equals(mail)) {
						String lastName = userInfo.get(j).getUsr_l_name();
						String firstName = userInfo.get(j).getUsr_f_name();
						String age = String.valueOf(userInfo.get(j).getUsr_age());
						attributes.addFlashAttribute("lastName", lastName);
						attributes.addFlashAttribute("firstName", firstName);
						attributes.addFlashAttribute("age", age);

					}
				}
				return "redirect:/logedin";
			}
		}
		if (mpass.equals(password) && mmail.equals(mail)) {
			return "/userInfoCheck";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logedin", method = RequestMethod.GET)
	public String logedin() {
		return "logedin";
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
