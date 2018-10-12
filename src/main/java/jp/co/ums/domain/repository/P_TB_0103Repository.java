package jp.co.ums.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.ums.domain.model.P_TB_0103Entity;

@ConfigAutowireable
@Dao
public interface P_TB_0103Repository {
	@Insert
	int insert(P_TB_0103Entity p_tb_0103Entity);
}
