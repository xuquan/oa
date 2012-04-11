package cn.edu.zhku.oa.manager;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Mail;

/**   
 * 邮件接口   
 * 编写作者：许权
 * 编写日期：2011-4-18 下午04:02:50
 */
public interface MailManager {    
   
    /**   
     * 获得发件人的地址和姓名   
     */   
    public String getFrom();
    
    /**   
     * 获得发件人的姓名   
     */ 
    public String getUserName();
    
   
    /**   
     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址   
     */   
    public String getMailAddress(String type);   
      
   
    /**   
     * 获得邮件主题   
     * @throws MessagingException 
     */   
    public String getSubject();   
       
   
    /**   
     * 获得邮件发送日期   
     */   
    public String getSentDate();    
      
    
    /**   
     * 获得邮件正文内容   
     */   
    public String getBodyText();   
   
   
    /**   
     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析   
     */   
    public void getMailContent(Part part);    
      
   
    /**    
     * 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false"   
     */    
    public boolean getReplySign() ;    
      
    
    /**   
     * 获得此邮件的Message-ID   
     */   
    public String getMessageId();
   
    /**   
     * 判断此邮件是否已读，如果未读返回返回false,反之返回true
     */   
    public boolean isNew() ;   
      
   
    /**   
     * 判断此邮件是否包含附件   
     */   
    public boolean isContainAttach(Part part);    
    
    /**
     * 获取邮件大小
     * @param msg
     * @return
     */
    public int getSize(Message msg);
    
    /**
     * 获取邮件的序号
     * @param msg
     * @return
     */
    public int getMsgNum(Message msg);
     
    /**    
     * 保存附件    
     */    
    public void saveAttachMent(Part part) ;    
       
    /**   
     * 设置日期显示格式   
     */   
    public void setDateFormat(String format);    
   
    /**   
     * 获得附件存放路径   
     */   
    public String getAttachPath();    
    
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
