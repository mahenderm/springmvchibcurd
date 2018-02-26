package com.st.curd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.st.curd.pojo.AuditPojo;
@Component
public class AuditDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void doAudit(AuditPojo auditPojo){
		
		hibernateTemplate.save(auditPojo);
	}

}
