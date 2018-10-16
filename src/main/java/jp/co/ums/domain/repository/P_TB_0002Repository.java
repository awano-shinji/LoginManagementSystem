package jp.co.ums.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.ums.domain.model.P_TB_0002Entity;
@ConfigAutowireable
@Dao
public interface P_TB_0002Repository {
	@Insert
	int insert(P_TB_0002Entity p_tb_0002Entity);
}
