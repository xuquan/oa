package cn.edu.zhku.oa.manager.impl;

import java.util.List;

import cn.edu.zhku.oa.dao.FormDao;
import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.manager.FormManager;
import cn.edu.zhku.oa.model.FieldInput;
import cn.edu.zhku.oa.model.FieldType;
import cn.edu.zhku.oa.model.FlowForm;
import cn.edu.zhku.oa.model.FormField;
import cn.edu.zhku.oa.model.Workflow;

public class FormManagerImpl implements FormManager {
	private FormDao formDao;
	private WorkflowDao workflowDao;
	
	public void setFormDao(FormDao formDao) {
		this.formDao = formDao;
	}
	public void setWorkflowDao(WorkflowDao workflowDao) {
		this.workflowDao = workflowDao;
	}

	public void addField(FormField field, int formId,int fieldTypeId,int fieldInputId) {
		
		field.setFlowForm(formDao.findForm(formId));
		
		field.setFieldInput(formDao.findFieldInput(fieldInputId));
		
		field.setFieldType(formDao.findFieldType(fieldTypeId));
		
		formDao.addField(field);
	}

	public FormField findFormField(int fieldId) {
		return formDao.findFormField(fieldId);
	}

	public void addForm(FlowForm form,int workflowId) {
		Workflow wf = workflowDao.findWorkflowById(workflowId);
		form.setWorkflow(wf);
		formDao.addForm(form);
	}

	public void updateFieldItems(int fieldId, List items) {
		FormField field = formDao.findFormField(fieldId);
		field.setItems(items);
		formDao.updateFieldItems(field);
	}

	public void delField(int fieldId) {
		formDao.delField(fieldId);
	}

	public void delForm(int formId) {
		formDao.delForm(formId);			
	}

	public FlowForm findForm(int workflowId) {
		return formDao.findForm(workflowId);
	}

	public List searchAllFields(int formId) {
		return formDao.searchAllFields(formId);
	}

	public List searchAllForms() {
		return formDao.searchAllForms();
	}

	public List searchFieldInputs() {
		return formDao.searchFieldInputs();
	}

	public List searchFieldTypes() {
		return formDao.searchFieldTypes();
	}

	public FieldInput findFieldInput(int inputId) {
		return formDao.findFieldInput(inputId);
	}

	public FieldType findFieldType(int typeId) {
		return formDao.findFieldType(typeId);
	}

}
