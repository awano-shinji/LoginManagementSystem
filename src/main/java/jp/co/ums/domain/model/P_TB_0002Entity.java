package jp.co.ums.domain.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "P_TB_0002")
public class P_TB_0002Entity {
	@Id
	private String hath_u_id;
	private String hath_majinai;
	private String hath_upd_dt;

	public String getHath_u_id() {
		return hath_u_id;
	}

	public void setHath_u_id(String hath_u_id) {
		this.hath_u_id = hath_u_id;
	}

	public String getHath_majinai() {
		return hath_majinai;
	}

	public void setHath_majinai(String hath_majinai) {
		this.hath_majinai = hath_majinai;
	}

	public String getHath_upd_dt() {
		return hath_upd_dt;
	}

	public void setHath_upd_dt(String hath_upd_dt) {
		this.hath_upd_dt = hath_upd_dt;
	}
}
