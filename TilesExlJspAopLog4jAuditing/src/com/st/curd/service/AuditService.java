package com.st.curd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.st.curd.dao.AuditDao;
import com.st.curd.pojo.AuditPojo;
import com.st.curd.pojo.GeoHierPojo;
@Component
public class AuditService {
	@Autowired
	private AuditDao auditDao;
	@Transactional
	public void doAudit(GeoHierPojo preObject, GeoHierPojo currentObject){
		
		//List<AuditPojo> audilist=new ArrayList<AuditPojo>();
	
		if(!preObject.getEntitytype().equals(currentObject.getEntitytype())){
			AuditPojo auditPojo=new AuditPojo();
			auditPojo.setPropertyname("entitytype");
			auditPojo.setClassname(GeoHierPojo.class.toString());
			auditPojo.setPreviousvalue(preObject.getEntitytype());
			auditPojo.setCurrentvalue(currentObject.getEntitytype());		
			auditPojo.setUser("user1");
			auditPojo.setWhen(new Date());
			auditPojo.setIpAddress("192.168.1.94");
			auditDao.doAudit(auditPojo);
			//audilist.add(auditPojo);
		}
		if(!preObject.getCode().equals(currentObject.getCode())){
			AuditPojo auditPojo=new AuditPojo();
			auditPojo.setPropertyname("code");
			auditPojo.setClassname(GeoHierPojo.class.toString());
			auditPojo.setPreviousvalue(preObject.getCode());
			auditPojo.setCurrentvalue(currentObject.getCode());
			auditPojo.setUser("user1");
			auditPojo.setWhen(new Date());
			auditPojo.setIpAddress("192.168.1.94");
			//audilist.add(auditPojo);
			
			
			auditDao.doAudit(auditPojo);
		}
		
	}
	
	

}
