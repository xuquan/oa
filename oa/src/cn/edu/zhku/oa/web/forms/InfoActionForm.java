package cn.edu.zhku.oa.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class InfoActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String title;
	
	private String content;
	
	private Date time;
	
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
