package cn.edu.zhku.oa.manager;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Document;

public class DocumentManagerTest extends TestCase {
	
	private static BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

	public void testAddDocument() {
		fail("Not yet implemented");
	}

	public void testUpdateDocument() {
		fail("Not yet implemented");
	}

	public void testFindDocument() {
		fail("Not yet implemented");
	}

	public void testSearchMyDocuments() {
		fail("Not yet implemented");
	}

	public void testDelDocument() {
		fail("Not yet implemented");
	}

	public void testAddApproveInfo() {
		fail("Not yet implemented");
	}

	public void testSearchApprovedDocuments() {
		fail("Not yet implemented");
	}

	public void testSearchApproveInfos() {
		fail("Not yet implemented");
	}

	public void testSearchApprovingDocuments() {
		DocumentManager documentManager = (DocumentManager) factory.getBean("documentManager");
		PagerModel pm = documentManager.searchApprovingDocuments(1);
		List docList = pm.getDatas();
			for(Iterator<Document> iter=docList.iterator();iter.hasNext();){
				Document doc = iter.next();
				System.out.println(doc.getTitle()+":"+doc.getDescription()+":"+doc.getStatus());
			}
	}

	public void testSearchNextSteps() {
		fail("Not yet implemented");
	}

	public void testSubmitToWorkflow() {
		fail("Not yet implemented");
	}

	public void testSearchAllFinishedDocuments() {
		fail("Not yet implemented");
	}

}
