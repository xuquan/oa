package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.model.FieldInput;
import cn.edu.zhku.oa.model.FieldType;
import cn.edu.zhku.oa.model.FlowForm;
import cn.edu.zhku.oa.model.FormField;

/**
 * 表单管理器
 * @author Lee
 *
 */
public interface FormDao {
	
	//表单
	public void addForm(FlowForm form);
	public void delForm(int formId);
	public FlowForm findForm(int workflowId);
	public List searchAllForms();
	
	//表单域
	public void addField(FormField field);
	public void delField(int fieldId);
	public FormField findFormField(int fieldId);
	public List searchAllFields(int formId);

	//表单域类型
	public FieldType findFieldType(int typeId);
	public List searchFieldTypes();
	
	//表单域输入框
	public FieldInput findFieldInput(int inputId);
	public List searchFieldInputs();
	
	public void updateFieldItems(FormField field);
}
