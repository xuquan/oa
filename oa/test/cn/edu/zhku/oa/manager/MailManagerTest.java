package cn.edu.zhku.oa.manager;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;

import cn.edu.zhku.oa.manager.impl.MailManagerImpl;
import junit.framework.TestCase;

public class MailManagerTest extends TestCase {

	public void testGetFrom() throws MessagingException {
        Properties props = System.getProperties();   
        props.put("mail.smtp.host", "smtp.126.com");   
        props.put("mail.smtp.auth", "true");   
        Session session = Session.getDefaultInstance(props, null);   
        URLName urln = new URLName("pop3", "pop3.126.com", 110, null,   
                "xuqu_an_happy", "811801");   
        Store store = session.getStore(urln);   
        store.connect();   
        Folder folder = store.getFolder("INBOX");   
        folder.open(Folder.READ_ONLY);   
        Message message[] = folder.getMessages();   
        System.out.println("Messages's length: " + message.length);   
        MailManagerImpl pmm = null;   
        for (int i = 0; i < message.length; i++) {   
            System.out.println("======================");   
            pmm = new MailManagerImpl(message[i]);   
            System.out.println("Message " + i + " subject: " + pmm.getSubject());   
            System.out.println("Message " + i + " sentdate: "+ pmm.getSentDate());   
            System.out.println("Message " + i + " replysign: "+ pmm.getReplySign());   
            System.out.println("Message " + i + " hasRead: " + pmm.isNew());   
            System.out.println("Message " + i + "  containAttachment: "+ pmm.isContainAttach(message[i]));   
            System.out.println("Message " + i + " form: " + pmm.getFrom());   
            System.out.println("Message " + i + " to: "+ pmm.getMailAddress("to"));   
            System.out.println("Message " + i + " cc: "+ pmm.getMailAddress("cc"));   
            System.out.println("Message " + i + " bcc: "+ pmm.getMailAddress("bcc"));   
            pmm.setDateFormat("yy年MM月dd日 HH:mm");   
            System.out.println("Message " + i + " sentdate: "+ pmm.getSentDate());   
            System.out.println("Message " + i + " Message-ID: "+ pmm.getMessageId());   
            // 获得邮件内容===============   
            pmm.getMailContent(message[i]);   
            System.out.println("Message " + i + " bodycontent: \r\n"   
                    + pmm.getBodyText());   
            pmm.setAttachPath("c:\\");    
            pmm.saveAttachMent(message[i]);    
        }    
	}

	public void testGetUserName() {
		fail("Not yet implemented");
	}

	public void testGetMailAddress() {
		fail("Not yet implemented");
	}

	public void testGetSubject() {
		fail("Not yet implemented");
	}

	public void testGetSentDate() {
		fail("Not yet implemented");
	}

	public void testGetBodyText() {
		fail("Not yet implemented");
	}

	public void testGetMailContent() {
		fail("Not yet implemented");
	}

	public void testGetReplySign() {
		fail("Not yet implemented");
	}

	public void testGetMessageId() {
		fail("Not yet implemented");
	}

	public void testIsNew() {
		fail("Not yet implemented");
	}

	public void testIsContainAttach() {
		fail("Not yet implemented");
	}

	public void testGetSize() {
		fail("Not yet implemented");
	}

	public void testGetMsgNum() {
		fail("Not yet implemented");
	}

	public void testSaveAttachMent() {
		fail("Not yet implemented");
	}

	public void testSetDateFormat() {
		fail("Not yet implemented");
	}

	public void testGetAttachPath() {
		fail("Not yet implemented");
	}

}
