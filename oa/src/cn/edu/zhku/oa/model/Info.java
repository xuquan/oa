package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * 公共信息
 * 编写作者：许权
 * 编写日期：2011-4-14 上午10:06:21
 * @hibernate.class table="t_info"
 */
public class Info {
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * 标题
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * 内容
	 * @hibernate.property
	 */
	private String content;
	
	/**
	 * 发布时间
	 * @hibernate.property
	 */
	private Date time;
	
	/**
	 * 发布人
	 * @hibernate.many-to-one column="user_info_id"
	 */
	private User publisher;

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

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
}
