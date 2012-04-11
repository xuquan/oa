package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Mail;

/**
 * 邮件接口
 * 编写作者：许权
 * 编写日期：2011-4-18 下午03:49:57
 */
public interface MailDao {
	/**
	 * 添加邮件
	 */
	public void addMail(Mail mail);
	
	/**
	 * 删除邮件
	 */
	public void delMail(int mailId);
	
	/**
	 * 修改邮件
	 */
	public void updateMail(Mail mail);
	
	/**
	 * 查找特定邮件
	 * @param mailId
	 * @return
	 */
	public Mail findMailById(int mailId);
	
	/**
	 * 查找所有邮件
	 * @return
	 */
	public PagerModel findMails();
	
	/**
	 * 查找某用户发送的邮件
	 * @param userId
	 * @return
	 */
	public PagerModel findMail(int userId);
	
}
