package cn.edu.zhku.oa.web.forms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class DocumentActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private int id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 公文内容，即上传文件的内容，
	 * 这些上传文件的内容将会被保存到数据库
	 */
	private FormFile contentFile;
	
	/**
	 * 创建者
	 * @hibernate.many-to-one
	 */
	private int creatorId;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 公文所走的流程
	 */
	private int workflowId;
	
	/**
	 * 下一步流向的名称
	 */
	private String transitionName;
	
	private String approveInfo;
	
	//传递动态的属性
	private Map props = new HashMap();
	
	//标识是否回退操作
	private boolean back;

	public FormFile getContentFile() {
		return contentFile;
	}

	public void setContentFile(FormFile contentFile) {
		this.contentFile = contentFile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public int getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public String getTransitionName() {
		return transitionName;
	}

	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}

	public String getApproveInfo() {
		return approveInfo;
	}

	public void setApproveInfo(String approveInfo) {
		this.approveInfo = approveInfo;
	}

	public Map getProps() {
		return props;
	}

	public void setProps(Map props) {
		this.props = props;
	}

	public boolean isBack() {
		return back;
	}

	public void setBack(boolean back) {
		this.back = back;
	}
}
