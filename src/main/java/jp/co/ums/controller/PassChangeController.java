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
import jp.co.ums.domain.model.P_TB_0002Entity;
import jp.co.ums.domain.model.P_TB_0003Entity;
import jp.co.ums.domain.repository.P_TB_0001Repository;
import jp.co.ums.domain.repository.P_TB_0002Repository;
import jp.co.ums.domain.repository.P_TB_0003Repository;

@Controller
public class PassChangeController {
	@Autowired
	P_TB_0001Repository p_tb_0001Repository;
	@Autowired
	P_TB_0002Repository p_tb_0002Repository;
	@Autowired
	P_TB_0003Repository p_tb_0003Repository;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String passChange(@ModelAttribute("password") String password, @ModelAttribute("newPassword") String newPass,
			Model model, RedirectAttributes attributes) {
		List<P_TB_0003Entity> passList = new ArrayList<P_TB_0003Entity>();
		passList.addAll(p_tb_0003Repository.selectPassInfo());
		//入力値(メールアドレス・パスワード)が既に使用されている場合のエラー表示
		for (int i = 0; i < passList.size(); i++) {
			if (passList.get(i).getAth_majinai().equals(newPass)) {
				String msg = "入力された新パスワードは既に使用されています";
				attributes.addFlashAttribute("passerror", msg);
				return "redirect:/PassChange";
			}
		}
		List<String> pass = new ArrayList<String>();
		for (int i = 0; i < passList.size(); i++) {
			String data = passList.get(i).getAth_majinai();
			pass.add(data);
		}
		if (pass.contains(password)) {
			//ユーザーの姓名を管理するテーブル
			P_TB_0002Entity p_tb_0002Entity = new P_TB_0002Entity();
			//現在日時の取得
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd' 'HH':'mm':'ss");
			String id = "";
			for (int i = 0; i < passList.size(); i++) {
				if (passList.get(i).getAth_majinai().equals(password)) {
					id = passList.get(i).getUsr_u_id();
				}
			}
			p_tb_0002Entity.setHath_u_id(id);
			p_tb_0002Entity.setHath_majinai(password);
			p_tb_0002Entity.setHath_upd_dt(sdf.format(date));
			p_tb_0002Repository.insert(p_tb_0002Entity);

			P_TB_0001Entity p_tb_0001Entity = new P_TB_0001Entity();
			p_tb_0001Entity = p_tb_0001Repository.selectPassword(password);
			p_tb_0001Entity.setAth_majinai(newPass);
			p_tb_0001Repository.update(p_tb_0001Entity);
		} else {
			String msg = "入力された現パスワードに誤りがあります。";
			attributes.addFlashAttribute("notPass", msg);
			return "redirect:/PassChange";

		}
		return "login";
	}

	@RequestMapping(value = "/PassChange", method = RequestMethod.GET)
	public String passChange() {
		return "/PassChange";
	}
}
