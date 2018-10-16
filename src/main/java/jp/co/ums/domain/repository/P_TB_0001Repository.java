package jp.co.ums.domain.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.ums.domain.model.P_TB_0001Entity;

@ConfigAutowireable
@Dao
public interface P_TB_0001Repository {
	@Select
	List<P_TB_0001Entity> selectUserInfo();
	@Select
	P_TB_0001Entity selectManagerInfo();
	@Select
	P_TB_0001Entity selectPassword(String password);
	@Insert
	int insert(P_TB_0001Entity p_tb_0001Entity);
	@Update(exclude = {"usr_m_addr", "usr_upd_dt"})
	int update(P_TB_0001Entity p_tb_0001Entity);
}
