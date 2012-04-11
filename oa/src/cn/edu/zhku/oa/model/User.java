package cn.edu.zhku.oa.model;

import java.util.Date;
import java.util.Set;

/**
 * 作者：许权
 * @hibernate.mapping auto-import="false"
 * @hibernate.class table="t_user"  lazy="false"
 */
public class User {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 *登录账号 
	 *@hibernate.property
	 *		not-null="true"
	 *		unique="true"
	 */
	private String username;
	
	/**
	 * 登录密码
	 * @hibernate.property
	 *		not-null="true"
	 */
	private String password;
	
	/**
	 * 账号创建时间
	 * @hibernate.property
	 */
	private Date createTime;
	
	
	/**
	 * 账号失效时间
	 * @hibernate.property
	 */
	private Date expireTime;
	
	/**
	 * 对应的人员信息
	 * @hibernate.many-to-one
	 * 		unique="true"
	 */
	private Person person;
	
	/**
	 * 借用的车辆
	 * @hibernate.set inverse="true" lazy="false"
	 * @hibernate.key column="user_car_id"
	 * @hibernate.one-to-many class="cn.edu.zhku.oa.model.Car" 
	 */
	private Set cars;
	
	/**
	 * 通信录
	 * @hibernate.set inverse="true" lazy="false"
	 * @hibernate.key column="userId"
	 * @hibernate.one-to-many class="cn.edu.zhku.oa.model.AddressBook"
	 */
	private Set addressBooks;
	
	/**
	 * 公共信息
	 * @hibernate.set inverse="true" lazy="false"
	 * @hibernate.key column="user_info_id"
	 * @hibernate.one-to-many class="cn.edu.zhku.oa.model.Info"
	 */
	private Set infos;
	
	/**
	 * 邮件
	 * @hibernate.set inverse="true" lazy="false"
	 * @hibernate.key column="user_mail_id"
	 * @hibernate.one-to-many class="cn.edu.zhku.oa.model.Mail"
	 */
	private Set mails;
	
	/**
	 * 用户<-->邮箱
	 * @hibernate.one-to-one
	 */
	private MailUser mailUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set getCars() {
		return cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

	public Set getAddressBooks() {
		return addressBooks;
	}

	public void setAddressBooks(Set addressBooks) {
		this.addressBooks = addressBooks;
	}

	public Set getInfos() {
		return infos;
	}

	public void setInfos(Set infos) {
		this.infos = infos;
	}

	public Set getMails() {
		return mails;
	}

	public void setMails(Set mails) {
		this.mails = mails;
	}

	public MailUser getMailUser() {
		return mailUser;
	}

	public void setMailUser(MailUser mailUser) {
		this.mailUser = mailUser;
	}
	
	
}
