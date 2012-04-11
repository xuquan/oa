package cn.edu.zhku.oa.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import cn.edu.zhku.oa.manager.SystemException;

/**
 * 公文
 * 作者：许权
 * @hibernate.class table="t_document"
 */
public class Document {
	public final static String STATUS_NEW = "新建";
	public final static String STATUS_END = "完成";
	
	private Logger logger = Logger.getLogger(Document.class);
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 标题
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * 描述
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * 公文内容，即上传文件的内容，
	 * 这些上传文件的内容将会被保存到数据库
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] content;
	
	/**
	 * 创建者
	 * @hibernate.many-to-one
	 */
	private User creator;
	
	/**
	 * 创建时间
	 * @hibernate.property
	 */
	private Date createTime;
	
	/**
	 * 公文所走的流程
	 * @hibernate.many-to-one
	 */
	private Workflow workflow;
	
	/**
	 * 流程实例的标识
	 * @hibernate.property
	 */
	private long processInstanceId;
	
	/**
	 * 公文的当前状态信息：
	 * 只有新建状态的公文，才可以被更新和删除
	 * 只有已完成状态的公文，才可以被归档
	 * @hibernate.property
	 */
	private String status;
	
	/**
	 * 表单的动态属性, key:String, value:DocumentProperty
	 * @hibernate.map table="t_document_properties"
	 * @hibernate.key column="documentId"
	 * @hibernate.map-key type="string" column="propertyName"
	 * @hibernate.composite-element class="cn.edu.zhku.oa.model.DocumentProperty"
	 */
	private Map props;
	
	//从界面上接收过来的各种属性值，即尚未转换之前的值
	public void setPropertiesMap(Map props){
		if(workflow.getFlowForm() == null){  
			return;
		}
		Set fields = workflow.getFlowForm().getFields();
		FormField formField = null;
		for (Iterator iterator = fields.iterator(); iterator.hasNext();) {
			FormField field = (FormField) iterator.next();
			setProperty(field.getFieldName(),props.get(field.getFieldName()));
		}
	}
	
	//设置对应的属性
	public void setProperty(String name,Object value){

		try {
			//FieldType的type属性必需与DocumentProperty类中的属性名称一致！
			String type = getPropertyType(name);
			DocumentProperty dp = new DocumentProperty();
			if(!DocumentProperty.support(type)){
				throw new SystemException("不支持的数据类型！");
			}
			
			//触发相应的Converter被调用
			BeanUtils.copyProperty(dp, type, value);
			
			if(props == null){
				props = new HashMap();
			}
			props.put(name, dp);
			
		} catch (Exception e) {
			throw new SystemException("设置属性的时候出现异常！",e);
		}
	}
	
	//获取对应的属性
	public Object getProperty(String name){
		//根据对应的fieldType，从DocumentProperty转换为相应的类型，并返回
		try {
			if(props == null){
				return null;
			}
			DocumentProperty dp = (DocumentProperty)props.get(name);
			String type = getPropertyType(name);
			
			return PropertyUtils.getProperty(dp, type);
			
		} catch (Exception e) {
			throw new SystemException("获取公文属性["+name+"]的时候发生异常！",e);
		}
		
	}
	
	//获得对应属性的类型名称
	private String getPropertyType(String name){
		//需根据对应fieldType，转换为相应的类型(DocumentProperty)，并存储
		try {
			Set fields = workflow.getFlowForm().getFields();
			FormField formField = null;
			for (Iterator iterator = fields.iterator(); iterator.hasNext();) {
				FormField field = (FormField) iterator.next();
				if(field.getFieldName().equals(name)){
					formField = field;
					break;
				}
			}
			
			//获得对应属性的类型名称
			return formField.getFieldType().getType();
			
		} catch (Exception ignore) {
			logger.warn("获取对应属性["+name+"]的类型名称时出现异常！",ignore);
		}
		
		throw new SystemException("无法获得对应属性的类型名称");
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public long getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map getProps() {
		return props;
	}

	public void setProps(Map props) {
		this.props = props;
	}
	
}
