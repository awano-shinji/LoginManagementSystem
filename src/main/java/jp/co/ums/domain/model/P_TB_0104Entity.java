package jp.co.ums.domain.model;

import org.seasar.doma.Entity;

@Entity
public class P_TB_0104Entity {
	private String usr_m_addr;
	private String usr_l_name;
	private String usr_f_name;
	private int usr_age;
	private String usr_upd_dt;

	public String getUsr_m_addr() {
		return usr_m_addr;
	}

	public void setUsr_m_addr(String usr_m_addr) {
		this.usr_m_addr = usr_m_addr;
	}

	public String getUsr_l_name() {
		return usr_l_name;
	}

	public void setUsr_l_name(String usr_l_name) {
		this.usr_l_name = usr_l_name;
	}

	public String getUsr_f_name() {
		return usr_f_name;
	}

	public void setUsr_f_name(String usr_f_name) {
		this.usr_f_name = usr_f_name;
	}

	public int getUsr_age() {
		return usr_age;
	}

	public void setUsr_age(int usr_age) {
		this.usr_age = usr_age;
	}

	public String getUsr_upd_dt() {
		return usr_upd_dt;
	}

	public void setUsr_upd_dt(String usr_upd_dt) {
		this.usr_upd_dt = usr_upd_dt;
	}
}
