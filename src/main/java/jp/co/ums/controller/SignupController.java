package jp.co.ums.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.ums.domain.model.P_TB_0001Entity;
import jp.co.ums.domain.model.P_TB_0101Entity;
import jp.co.ums.domain.model.P_TB_0102Entity;
import jp.co.ums.domain.model.P_TB_0103Entity;
import jp.co.ums.domain.repository.P_TB_0001Repository;
import jp.co.ums.domain.repository.P_TB_0101Repository;
import jp.co.ums.domain.repository.P_TB_0102Repository;
import jp.co.ums.domain.repository.P_TB_0103Repository;
import jp.co.ums.domain.service.P_TB_0101Service;

@Controller
public class SignupController {
	@Autowired
	P_TB_0101Service p_tb_0101Service;
	@Autowired
	P_TB_0001Repository p_tb_0001Repository;
	@Autowired
	P_TB_0101Repository p_tb_0101Repository;
	@Autowired
	P_TB_0102Repository p_tb_0102Repository;
	@Autowired
	P_TB_0103Repository p_tb_0103Repository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String signup(@ModelAttribute("mail") String mail, @ModelAttribute("lastName") String lastName,
			@ModelAttribute("firstName") String firstName, @ModelAttribute("password") String password,
			@ModelAttribute("age") String age, Model model, RedirectAttributes attributes) {
		//管理者を管理するインスタンス、ユーザを管理するリストを生成
		P_TB_0001Entity managerList = new P_TB_0001Entity();
		List<P_TB_0001Entity> userList = new ArrayList<P_TB_0001Entity>();

		//DBの情報を格納
		managerList = p_tb_0001Repository.selectManagerInfo();
		userList.addAll(p_tb_0001Repository.selectUserInfo());

		//管理者のメールアドレス、パスワードを取得
		String mmail = managerList.getUsr_m_addr();
		String mpass = managerList.getAth_majinai();

		//入力値(メールアドレス・パスワード)が既に使用されている場合のエラー表示
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsr_m_addr().equals(mail) || mmail.equals(mail)) {
				String msg = "入力されたメールアドレスは既に使用されています。";
				attributes.addFlashAttribute("mailerror", msg);
				return "redirect:/signup";
			}
			if (userList.get(i).getAth_majinai().equals(password) || mpass.equals(password)) {
				String msg = "入力されたパスワードは既に使用されています。";
				attributes.addFlashAttribute("passerror", msg);
				return "redirect:/signup";
			}
		}
		//IDを管理するテーブル
		P_TB_0101Entity p_tb_0101Entity = new P_TB_0101Entity();
		//ユーザーの姓名を管理するテーブル
		P_TB_0102Entity p_tb_0102Entity = new P_TB_0102Entity();
		//ユーザの年齢を管理するテーブル
		P_TB_0103Entity p_tb_0103Entity = new P_TB_0103Entity();
		//ユーザ認証に使用する情報を管理するテーブル
		P_TB_0001Entity p_tb_0001Entity = new P_TB_0001Entity();

		//現在日時の取得
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd' 'HH':'mm':'ss");
		//P_TB_0101テーブルのレコード数取得
		int id = p_tb_0101Repository.selectCount();
		//重複しないよう+1をカウント
		id++;

		//IDを管理するテーブルの更新
		p_tb_0101Entity.setUsr_u_id(String.format("%05d", id));
		p_tb_0101Entity.setUsr_m_addr(mail);
		p_tb_0101Entity.setUsr_upd_dt(sdf.format(date));
		p_tb_0101Repository.insert(p_tb_0101Entity);

		//ユーザの姓名を管理するテーブルの更新
		p_tb_0102Entity.setUsr_u_id(String.format("%05d", id));
		p_tb_0102Entity.setUsr_l_name(lastName);
		p_tb_0102Entity.setUsr_f_name(firstName);
		p_tb_0102Entity.setUsr_upd_dt(sdf.format(date));
		p_tb_0102Repository.insert(p_tb_0102Entity);

		//ユーザの年齢を管理するテーブルの更新
		p_tb_0103Entity.setUsr_m_addr(mail);
		if(!(age.isEmpty())&&age!= null) {
			p_tb_0103Entity.setUsr_age(Integer.parseInt(age));
		}
		p_tb_0103Entity.setUsr_upd_dt(sdf.format(date));
		p_tb_0103Repository.insert(p_tb_0103Entity);

		//ユーザ認証に使用する情報を管理するテーブル
		p_tb_0001Entity.setUsr_m_addr(mail);
		p_tb_0001Entity.setAth_majinai(password);
		p_tb_0001Entity.setUsr_upd_dt(sdf.format(date));
		p_tb_0001Repository.insert(p_tb_0001Entity);

		return "/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "/signup";
	}
}
