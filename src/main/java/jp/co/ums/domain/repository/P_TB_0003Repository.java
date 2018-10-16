package jp.co.ums.domain.repository;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.ums.domain.model.P_TB_0003Entity;
@ConfigAutowireable
@Dao
public interface P_TB_0003Repository {
	@Select
	List<P_TB_0003Entity> selectPassInfo();
}
