package com.tcs.service;

import java.util.ArrayList;

import com.tcs.bean.Dependant;
import com.tcs.bean.Patient;
import com.tcs.dao.PatientDAO;
import com.tcs.exception.ServiceLayerException;

public class PatientService {
	PatientDAO obj=new PatientDAO();
	public Patient addPatient(Patient p)
	{
		return obj.addPatient(p);

	}
	public ArrayList<Patient> viewPatients(){
		
		return obj.viewPatients();
	}
	public Patient getPatientById(int id)
	{
		return obj.getPatientById(id);
	}
	public Patient getPatientByMobile(long mobile)
	{
		return obj.getPatientByMobile(mobile);
	}
	public boolean updatePatient(int id,String fname,String lname,String gender,int age,String address,long contactNumber,long healthInsuranceNumber)
	{
		return obj.updatePatient(id, fname, lname, gender, age, address, contactNumber, healthInsuranceNumber);
	}
	public boolean deletePatient(int id)
	{
		return obj.deletePatient(id);
	}
	//adding dependant
	public boolean addDependant(Dependant d)
	{
		return obj.addDependant(d);
	}
	public ArrayList<Integer> gethcpid()
	{
		return obj.gethcpid();
	}
	
	//CHANGE PSWD
		public boolean changepassword(int id,String oldpassword,String newpswd1) 
		{
		
			return obj.changepassword(id, oldpassword, newpswd1);
		}
		// FORGOT PSWD
		
		public boolean VerifySecurity(int id,ArrayList<String> securitylist)
		{
			
			
			return obj.VerifySecurity(id, securitylist);
			
			
		}
		public int checkpatientid(int id)throws ServiceLayerException
		{
			if(obj.checkpatientid(id)==1)
			{
				return obj.checkpatientid(id);
			}
			else
			{
				throw new ServiceLayerException("The id does not exists please enter valid id");
			}
		}
		public String getPatientPasswordById(int id)
		{
			return obj.getPatientPasswordById(id);
		}
		public int getCount(String relationship, int userId) {
			
			return obj.getCount(relationship,userId);
		}
		
			//view dependant
		
		
				public ArrayList<Dependant> viewDependentList(int userId)
				{
					return obj.viewDependentList(userId);
				}
				
				
				//getting dependant by id
				public Dependant getDependantById(int id)
				{
					return obj.getDependantById(id);
				}
				
				
				//Updating dependant by patient id
				public boolean updateDependantByPatientId(int id,String name,String address,long contactno,long insuranceno)
				{
					return obj.updateDependantByPatientId(id, name, address, contactno, insuranceno);
				}
				
				
				//deleting dependant by patient id
				
				public boolean deleteDependantByPatientId(int id)
				{
					return obj.deleteDependantByPatientId(id);
				}
				
				
		
}
