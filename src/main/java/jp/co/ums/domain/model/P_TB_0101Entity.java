package jp.co.ums.domain.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "P_TB_0101")

public class P_TB_0101Entity {
	@Id
	private String usr_u_id;
	private String usr_m_addr;
	private String usr_upd_dt;

	public String getUsr_u_id() {
		return usr_u_id;
	}

	public void setUsr_u_id(String usr_u_id) {
		this.usr_u_id = usr_u_id;
	}

	public String getUsr_m_addr() {
		return usr_m_addr;
	}

	public void setUsr_m_addr(String usr_m_addr) {
		this.usr_m_addr = usr_m_addr;
	}

	public String getUsr_upd_dt() {
		return usr_upd_dt;
	}

	public void setUsr_upd_dt(String usr_upd_dt) {
		this.usr_upd_dt = usr_upd_dt;
	}



}
