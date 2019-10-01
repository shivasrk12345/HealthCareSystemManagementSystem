package com.tcs.service;

import java.util.ArrayList;

import com.tcs.bean.HCP;
import com.tcs.bean.LSP;
import com.tcs.bean.Patient;
import com.tcs.dao.HCPDAO;
import com.tcs.exception.ServiceLayerException;

public class HCPService {
 private HCPDAO dao=new HCPDAO();
 public HCP addHCP(HCP h)
	{
	 return dao.addHCP(h);
	}
 public ArrayList<HCP> viewHCP()
	{
	 System.out.println("service");
	 return dao.viewHCP();
	}
 public HCP viewHCPbyid(int id)throws ServiceLayerException
	{
	 if(dao.checkhcpid(id)==1)
	 {
	 return dao.viewHCPbyid(id);
	 }
	 else
	 {
		 throw new ServiceLayerException("The hcp id "+id+" is incorrect");
	 }
	}
 public boolean updatehcpdetails(HCP h)
	{
	   return dao.updatehcpdetails(h);
	}
 
 public ArrayList<LSP> search(String city,String testName,String lspName)
	{
		System.out.println(city);
		return dao.search(city, testName, lspName);
	}
	public ArrayList<String> getValues(String city,String testName,String lspName)
	{
		return dao.getValues(city, testName, lspName);
	}
	/*public boolean Updatepassword(HCP h,String newpassword)
	{
		if(dao.checkoldPassword(h.getPassword()))
		{
			return dao.Updatepassword(h, newpassword);
		}
	}*/
	public boolean changepasswordhcp(int id,String oldpassword,String newpswd1) 
	{
		return dao.changepasswordhcp(id, oldpassword, newpswd1);
	}
	public HCP forgotPass(int userId)  {
		{
			return dao.forgotPass(userId);
		}
	}
	public int checkhcpid(int id)throws ServiceLayerException
	
	{
		if(dao.checkhcpid(id)==1)
		 {
		 return dao.checkhcpid(id);
		 }
		 else
		 {
			 throw new ServiceLayerException("The hcp id "+id+" is incorrect...........");
		 }
	}
	public ArrayList<Patient> getPtientDetailsByHCPId(int hcpid)
	{
		return dao.getPtientDetailsByHCPId(hcpid);
	}
	public Patient getPatientById(int id)
	{
		return dao.getPatientById(id);
	}
	public boolean updatePatient(int id,String fname,String address,long contactNumber)
	{
		return dao.updatePatient(id, fname, address, contactNumber);
	}
	public boolean deletePatient(int id)
	{
		return dao.deletePatient(id);
	}
}
