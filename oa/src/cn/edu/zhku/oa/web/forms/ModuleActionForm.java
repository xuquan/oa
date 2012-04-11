package cn.edu.zhku.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class ModuleActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String name;

	private String sn;

	private String url;

	private int orderNo;

	private int parentId;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public int getParentId() {
		return parentId;
	}

	public String getSn() {
		return sn;
	}

	public String getUrl() {
		return url;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
