package jp.co.ums.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ums.domain.repository.P_TB_0101Repository;

@Service
public class P_TB_0101Service {
	@Autowired
	P_TB_0101Repository p_tb_0101Repository;

	public int getCountId() {
		return p_tb_0101Repository.selectCount();
	}
}
