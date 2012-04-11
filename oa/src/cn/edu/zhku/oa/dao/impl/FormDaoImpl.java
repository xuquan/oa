package cn.edu.zhku.oa.dao.impl;

import java.util.List;

import cn.edu.zhku.oa.dao.FormDao;
import cn.edu.zhku.oa.model.FieldInput;
import cn.edu.zhku.oa.model.FieldType;
import cn.edu.zhku.oa.model.FlowForm;
import cn.edu.zhku.oa.model.FormField;

public class FormDaoImpl extends AbstractDao implements FormDao {

	public void addField(FormField field) {
		getHibernateTemplate().saveOrUpdate(field);
	}

	public FormField findFormField(int fieldId) {
		return (FormField)getHibernateTemplate().load(FormField.class, fieldId);
	}

	public void addForm(FlowForm form) {
		getHibernateTemplate().saveOrUpdate(form);
	}

	public void updateFieldItems(FormField field) {
		getHibernateTemplate().update(field);
	}

	public void delField(int fieldId) {
		getHibernateTemplate().delete(
				getHibernateTemplate().load(FormField.class, fieldId)
				);
	}

	public void delForm(int formId) {
		getHibernateTemplate().delete(
				getHibernateTemplate().load(FlowForm.class, formId)
		);				
	}

	public FlowForm findForm(int workflowId) {
		
		return (FlowForm)getSession()
			.createQuery("select f from FlowForm f where f.workflow.id = ?")
			.setParameter(0, workflowId)
			.uniqueResult();
	}

	public List searchAllFields(int formId) {
		
		return getHibernateTemplate().find("select ff from FormField ff where ff.flowForm.id = ?",formId);
	}

	public List searchAllForms() {
		
		return getHibernateTemplate().find("from FlowForm");
	}

	public List searchFieldInputs() {
		
		return getHibernateTemplate().find("select fi from FieldInput fi");
	}

	public List searchFieldTypes() {
		return getHibernateTemplate().find("select ft from FieldType ft");
	}

	public FieldInput findFieldInput(int inputId) {
		return (FieldInput)getHibernateTemplate().load(FieldInput.class, inputId);
	}

	public FieldType findFieldType(int typeId) {
		return (FieldType)getHibernateTemplate().load(FieldType.class, typeId);
	}

}
