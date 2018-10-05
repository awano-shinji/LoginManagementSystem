package jp.co.ums.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ums.domain.model.P_TB_0001Entity;
import jp.co.ums.domain.repository.P_TB_0001Repository;

@Service
public class P_TB_0001Service {
	@Autowired
	P_TB_0001Repository p_tb_0001Repository;

	public P_TB_0001Entity getMailaddress() {
		return p_tb_0001Repository.selectMailaddress();
	}

	public P_TB_0001Entity getPassword() {
		return p_tb_0001Repository.selectPassword();
	}
}
