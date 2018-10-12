package jp.co.ums.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ums.domain.model.P_TB_0001Entity;
import jp.co.ums.domain.repository.P_TB_0001Repository;
import jp.co.ums.domain.repository.P_TB_0104Repository;

@Service
public class P_TB_0001Service {
	@Autowired
	P_TB_0001Repository p_tb_0001Repository;
	@Autowired
	P_TB_0104Repository p_tb_0104Repository;

	public String userInfoCheck() {
		return "/userInfoCheck";
	}

    public P_TB_0001Entity getManager() {
        return p_tb_0001Repository.selectManagerInfo();
    }
}
