package cn.edu.zhku.oa.manager;

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
public interface FormManager {
	
	//表单
	public void addForm(FlowForm form,int workflowId);
	public void delForm(int formId);
	public FlowForm findForm(int workflowId);
	public List searchAllForms();
	
	//表单域
	public void addField(FormField field,int formId,int fieldTypeId,int fieldInputId);
	public void delField(int fieldId);
	public FormField findFormField(int fieldId);
	public List searchAllFields(int formId);

	//表单域类型
	public FieldType findFieldType(int typeId);
	public List searchFieldTypes();
	
	//表单域输入框
	public FieldInput findFieldInput(int inputId);
	public List searchFieldInputs();
	
	public void updateFieldItems(int fieldId,List items);
}
