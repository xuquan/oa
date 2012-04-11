package cn.edu.zhku.oa.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class MailActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String subject;
	
	private String content;
	
	private Date sentDate;
	
	private int userId;
	
	private String toAddrsStr;
	
	private String[] toAddrs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToAddrsStr() {
		return toAddrsStr;
	}

	public void setToAddrsStr(String toAddrsStr) {
		this.toAddrsStr = toAddrsStr;
		this.toAddrs = toAddrsStr.split(";");
	}

	public String[] getToAddrs() {
		return toAddrs;
	}

}
