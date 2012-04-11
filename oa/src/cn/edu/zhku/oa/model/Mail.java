package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * 邮件
 * 编写作者：许权
 * 编写日期：2011-4-17 下午07:58:27
 * @hibernate.class table="t_mail"
 */
public class Mail {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * 主题
	 * @hibernate.property
	 */
	private String subject;
	
	/**
	 * 正文
	 * @hibernate.property
	 */
	private String content;
	
	/**
	 * 发送时间
	 * @hibernate.property
	 */
	private Date sentDate;
	
	/**
	 * 发件人
	 * @hibernate.many-to-one column="user_mail_id"
	 */
	private User sender;
	
	/**
	 * 收件人地址
	 * @hibernate.array table="t_to_addrs"
	 * @hibernate.key column="id"
	 * @hibernate.list-index column="to_addres_index"
	 * @hibernate.element type="string" column="to_addrs"
	 */
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

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String[] getToAddrs() {
		return toAddrs;
	}

	public void setToAddrs(String[] toAddrs) {
		this.toAddrs = toAddrs;
	}
	
}
