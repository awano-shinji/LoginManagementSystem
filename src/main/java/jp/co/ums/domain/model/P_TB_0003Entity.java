package jp.co.ums.domain.model;

import org.seasar.doma.Entity;

@Entity
public class P_TB_0003Entity {

	private String usr_u_id;
	private String ath_majinai;
	private String usr_upd_dt;

	public String getUsr_u_id() {
		return usr_u_id;
	}

	public void setUsr_u_id(String usr_u_id) {
		this.usr_u_id = usr_u_id;
	}

	public String getAth_majinai() {
		return ath_majinai;
	}

	public void setAth_majinai(String ath_majinai) {
		this.ath_majinai = ath_majinai;
	}

	public String getUsr_upd_dt() {
		return usr_upd_dt;
	}

	public void setUsr_upd_dt(String usr_upd_dt) {
		this.usr_upd_dt = usr_upd_dt;
	}

}
