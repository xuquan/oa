package cn.edu.zhku.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class AclActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String principalType;

	private int principalSn;

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getPrincipalSn() {
		return principalSn;
	}

	public void setPrincipalSn(int principalSn) {
		this.principalSn = principalSn;
	}
}
