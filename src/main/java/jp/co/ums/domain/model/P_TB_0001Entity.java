package jp.co.ums.domain.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "P_TB_0001")

public class P_TB_0001Entity {
	@Id
	private String usr_m_addr;
	private String ath_majinai;

	public String getUsr_m_addr() {
		return usr_m_addr;
	}

	public void setUsr_m_addr(String usr_m_addr) {
		this.usr_m_addr = usr_m_addr;
	}

	public String getAth_majinai() {
		return ath_majinai;
	}

	public void setAth_majinai(String ath_majinai) {
		this.ath_majinai = ath_majinai;
	}
}
