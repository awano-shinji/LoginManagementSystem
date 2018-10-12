package jp.co.ums.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.ums.domain.model.P_TB_0102Entity;

@ConfigAutowireable
@Dao
public interface P_TB_0102Repository {
	@Insert
	int insert(P_TB_0102Entity p_tb_0102Entity);
}
