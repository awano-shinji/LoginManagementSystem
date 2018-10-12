package jp.co.ums.domain.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name = "P_TB_0103")
public class P_TB_0103Entity {

	private String usr_m_addr;
	private int usr_age;
	private String usr_upd_dt;

	public String getUsr_m_addr() {
		return usr_m_addr;
	}

	public void setUsr_m_addr(String usr_m_addr) {
		this.usr_m_addr = usr_m_addr;
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
