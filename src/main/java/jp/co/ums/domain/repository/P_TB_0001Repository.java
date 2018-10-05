package jp.co.ums.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.ums.domain.model.P_TB_0001Entity;

@ConfigAutowireable
@Dao
public interface P_TB_0001Repository {
	@Select
	P_TB_0001Entity selectMailaddress();
	@Select
	P_TB_0001Entity selectPassword();
}
