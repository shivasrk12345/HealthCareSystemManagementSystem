package com.tcs.service;

import com.tcs.bean.HCP;
import com.tcs.bean.Patient;
import com.tcs.dao.LoginDAO;

import com.tcs.exception.ServiceLayerException;

public class LoginService {
 private LoginDAO logindao=new LoginDAO();

 public HCP getPwdByHCPId(int id) throws ServiceLayerException
 {
	 if(logindao.checkhcpid(id)==1)
	 {
		 return logindao.getPwdByHCPId(id);
	 }
	 else
	 {
		 throw new ServiceLayerException("The HCP id does not exists please enter valid id");
	 }
 }
	
 public Patient getPwdByPatientId(int id,long contactNumber) throws ServiceLayerException
	{
	   if(logindao.checkpatientid(id,contactNumber)==1)
	   {
		   return logindao.getPwdByPatientId(id,contactNumber);
	   }
	   else
		 {
			 throw new ServiceLayerException("The patient id does not exists please enter valid id");
		 }
	}
}
