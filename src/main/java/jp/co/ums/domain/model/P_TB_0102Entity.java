package jp.co.ums.domain.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "P_TB_0102")
public class P_TB_0102Entity {
	@Id
	private String usr_u_id;
	private String usr_l_name;
	private String usr_f_name;
	private String usr_upd_dt;
	public String getUsr_u_id() {
		return usr_u_id;
	}
	public void setUsr_u_id(String usr_u_id) {
		this.usr_u_id = usr_u_id;
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
	public String getUsr_upd_dt() {
		return usr_upd_dt;
	}
	public void setUsr_upd_dt(String usr_upd_dt) {
		this.usr_upd_dt = usr_upd_dt;
	}



}
