package cn.edu.zhku.oa.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.model.Workflow;

public class WorkflowDaoImpl extends HibernateDaoSupport implements WorkflowDao {

	@Override
	public Workflow findWorkflowByName(String workflowName) {
		return (Workflow) getSession().createQuery("select w from Workflow w where w.name = ?")
				.setParameter(0, workflowName).uniqueResult();
	}

	@Override
	public void saveWorkflow(Workflow workflow) {
		getHibernateTemplate().save(workflow);
	}

	@Override
	public void updateWorkflow(Workflow workflow) {
		getHibernateTemplate().update(workflow);
	}

	@Override
	public void delWorkflow(Workflow workflow) {
		getHibernateTemplate().delete(workflow);
	}

	@Override
	public Workflow findWorkflowById(int workflowId) {
		return (Workflow) getHibernateTemplate().load(Workflow.class, workflowId);
	}

	@Override
	public List searchAllWorkflows() {
		return getHibernateTemplate().find("from Workflow");
	}
}
