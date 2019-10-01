package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.Dependant;
import com.tcs.bean.Patient;
import com.tcs.exception.DataLayerException;
import com.tcs.util.DatabaseUtil;

public class PatientDAO {
	 
		Connection con=null;
		PreparedStatement ps1=null;
		ResultSet rs=null;
		
	public Patient addPatient(Patient p)
	{
		
		
		int pid=0;
		int pwd=0;
		int  i=0;
		String password="Patient@";
		con=DatabaseUtil.getConnection();
		
		String query1="select pidgen_B1.nextval from dual";
		try {
			ps1=con.prepareStatement(query1);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				pid=rs1.getInt(1);
				System.out.println(pid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query2="select pidpswdgen_B1.nextval from dual";
		try {
			ps1=con.prepareStatement(query2);
			ResultSet rs2=ps1.executeQuery();
			if(rs2.next())
			{
				pwd=rs2.getInt(1);
				password=password+pwd;
				System.out.println(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			String query3="insert into Patient_13455624 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps1=con.prepareStatement(query3);
			ps1.setInt(1, pid);
			ps1.setString(2, password);
			ps1.setString(3, p.getFirstName());
			ps1.setString(4, p.getLastName());
			ps1.setString(5, p.getGender());
			ps1.setInt(6, p.getAge());
			ps1.setString(7, p.getAddress());
			ps1.setLong(8, p.getContactNumber());
			ps1.setString(9, p.getComplaint());
			ps1.setString(10, p.getDoctor());
			ps1.setString(11, p.getInsuranceCover());
			ps1.setLong(12, p.getHealthInsuranceNumber());
			ps1.setString(13, p.getYourbirthcity());
			ps1.setString(14, p.getYourfavoriteactor());
			ps1.setString(15, p.getYourfavoritefood());
			ps1.setString(16, p.getYourfavoritecrickter());
			ps1.setString(17, p.getYourfavoritesport());
			
			ps1.setInt(18, p.getHcpId());
			i=ps1.executeUpdate();
			
			
		}  catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DataLayerException(e1.getMessage());
		}
		finally
		{
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(ps1);
		}
		
		Patient pat = new Patient(pid, password, p.getFirstName(), p.getLastName());
		
		return pat;
		
	}

		public ArrayList<Patient> viewPatients(){
			int i=0;
			ArrayList<Patient>patlist = new ArrayList<Patient>();
			//HashMap<ArrayList<Patient>, Integer> hm=new HashMap<>();
			con = DatabaseUtil.getConnection();
			
			try {
				ps1= con.prepareStatement("select * from Patient_13455624");
				ResultSet rs = ps1.executeQuery();
				
				while(rs.next()){
					System.out.println("entering into rs loop");
					
					Patient p= new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getLong(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getLong(12), rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getInt(18));
					System.out.println(p);
					patlist.add(p);
					i++;
					
				}
			}  catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			//hm.put(patlist, i);
			return patlist;
		}
		public Patient getPatientById(int id)
		{
			Patient p=null;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select * from Patient_13455624 where patientId=?" );
				ps1.setInt(1, id);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					 p=new Patient(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getLong(8), rs.getLong(12));
				}
				
			}  catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			
			
			return p;
		}
		public Patient getPatientByMobile(long mobile)
		{
			Patient p=null;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select * from Patient_13455624 where ContactNumber=?" );
				ps1.setLong(1, mobile);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					p=new Patient(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getLong(8), rs.getLong(12));
				}
				
			}  catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			
			
			return p;
		}
		public boolean updatePatient(int id,String fname,String lname,String gender,int age,String address,long contactNumber,long healthInsuranceNumber)
		{
			int c=0;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("update Patient_13455624 set FirstName=?,LastName=?,Gender=?,Age=?,Address=?,ContactNumber=?,HealthInsuranceNumber=? where patientId=?");
			ps1.setString(1, fname);
			ps1.setString(2, lname);
			ps1.setString(3, gender);
			ps1.setInt(4, age);
			ps1.setString(5, address);
			ps1.setLong(6,contactNumber );
			ps1.setLong(7, healthInsuranceNumber);
			ps1.setInt(8, id);
			
			c=ps1.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				DatabaseUtil.closeStatement(ps1);
				DatabaseUtil.closeConnection(con);
			}
			return c>0;
		}
		public boolean deletePatient(int id)
		{
			
			int c=0;
			String paymentStatus=null;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select paymentStatus from Patient_13455624 where patientId=? ");
				ps1.setInt(1, id);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					paymentStatus=rs.getString(1);
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			if(paymentStatus.equalsIgnoreCase("paid"))
			{
		
			try {
				ps1=con.prepareStatement("delete from Patient_13455624 where patientId=?");
				ps1.setInt(1, id);
				c=ps1.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			
		}

			return c>0;
		}
		//Adding dependants
		
		public boolean addDependant(Dependant d)
		{
			int c=0;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("insert into dependant_13455624 values(?,?,?,?,?,?,?,?,?)");
				ps1.setInt(1, d.getPatientId());
				ps1.setString(2, d.getName());
				ps1.setString(3, d.getRelationship());
				ps1.setString(4, d.getGender());
				ps1.setInt(5, d.getAge());
				ps1.setString(6, d.getAddress());
				ps1.setLong(7, d.getContactNumber());
				ps1.setString(8, d.getInsuranceCover());
				ps1.setLong(9, d.getHealthInsuranceNumber());
				c=ps1.executeUpdate();
				
			}  catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			return c>0;
		}
		
		///////////////to get hcp id
		public ArrayList<Integer> gethcpid()
		{
			ArrayList<Integer> listhcpid=new ArrayList<Integer>();
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select hcpId from hcp_groupb");
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					listhcpid.add(rs.getInt(1));
				}
			}  catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			
			return listhcpid;
		}
		/////////to change pwd
		public boolean changepassword(int id,String oldpassword,String newpswd1) 
		{
			String pswd=null;
			int i=0;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select patientPassword from Patient_13455624 where patientId=?");
				ps1.setInt(1, id);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					pswd=rs.getString(1);
					System.out.println(pswd);
				}
			
			if(pswd.equalsIgnoreCase(oldpassword))
			{
				System.out.println("equal");
				
					ps1=con.prepareStatement("update Patient_13455624 set patientPassword=? where patientId=?");
					ps1.setString(1, newpswd1);
					
					ps1.setInt(2, id);
					
					i=ps1.executeUpdate();
				
			}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new DataLayerException(e1.getMessage());
				}
				finally
				{
					DatabaseUtil.closeConnection(con);
					DatabaseUtil.closeStatement(ps1);
				}
			
		
			return i>0;
		}
		
		public boolean VerifySecurity(int id,ArrayList<String> securitylist)
		{
			//System.out.println(securitylist);
			ArrayList<String> securitylist1=new ArrayList<String>();
			int i=0;
			String birthcity1=null;
			String favoriteactor1=null;
			String favoritefood1=null;
			String favoritecrickter1=null;
			String favoritesport1=null;
			con=DatabaseUtil.getConnection();
			
			try {
				ps1=con.prepareStatement("select yourbirthcity,yourfavoriteactor,yourfavoritefood,yourfavoritecrickter,yourfavoritesport from Patient_13455624 where patientId=?");
				ps1.setInt(1, id);
				ResultSet rs=ps1.executeQuery();
				if(rs.next())
				{
					  birthcity1=rs.getString(1);
					  favoriteactor1=rs.getString(2);
					  favoritefood1=rs.getString(3);
					  favoritecrickter1=rs.getString(4);
					  favoritesport1=rs.getString(5);
					System.out.println(birthcity1+favoriteactor1+favoritefood1+favoritecrickter1+favoritesport1);
				}
			}  catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}
			
			securitylist1.add(birthcity1);
			securitylist1.add(favoriteactor1);
			securitylist1.add(favoritefood1);
			securitylist1.add(favoritecrickter1);
			securitylist1.add(favoritesport1);
			ArrayList<String> securitylist2=new ArrayList<String>();
			for(String s:securitylist1)
				if(s!=null)
					securitylist2.add(s);
			
			if(securitylist.containsAll(securitylist2))
			i=1;
			return i>0;
			
		}
		public String getPatientPasswordById(int id)
		{
			System.out.println(id);
			String pswd=null;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select patientPassword from Patient_13455624 where patientId=?");
				ps1.setInt(1, id);
				ResultSet rs=ps1.executeQuery();
				while(rs.next())
				{
					pswd=rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(pswd);
			return pswd;
		}
		public int checkpatientid(int id)
		{
			Connection con=null;
			PreparedStatement ps=null;
		  int x=0;
			try
			{
				con=DatabaseUtil.getConnection();
				ps=con.prepareStatement("select * from Patient_13455624 where patientId=?");
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					x=1;
				}
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps);
			}
			
			return x;
		}
		public int getCount(String relationship, int userId) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			int count=0;
			con =  DatabaseUtil.getConnection();
			try {
				ps = con.prepareStatement("select count(relationship) from dependant_13455624 where relationship=? and patientId=?");
				ps.setString(1,relationship);
				ps.setInt(2,userId);
				rs = ps.executeQuery();
				while(rs.next()){
					count=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps);
			}

			return count;
		}
		//view dependant
		
		
		public ArrayList<Dependant> viewDependentList(int userId)
		{
			ArrayList<Dependant> list = new ArrayList<Dependant>();
			con = DatabaseUtil.getConnection();
			try {
				ps1 = con.prepareStatement("select Name,relationship,ContactNumber,Address from dependant_13455624 where patientId= ?");
				ps1.setInt(1,userId);
				rs = ps1.executeQuery();
				while(rs.next()){
					Dependant d = new Dependant(rs.getString(1), rs.getString(2), rs.getString(4), rs.getLong(3));
					list.add(d);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps1);
			}

			return list;
		}
		//getting dependant by id
		public Dependant getDependantById(int id)
		{
			Dependant d=null;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("select * from dependant_13455624 where patientId=?");
				ps1.setInt(1,id);
				rs=ps1.executeQuery();
				while(rs.next())
				{
					d=new Dependant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getLong(9));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d;
		}
		
		
		
		
		
		
		//Updating dependant by patient id
		public boolean updateDependantByPatientId(int id,String name,String address,long contactno,long insuranceno)
		{
			int c=0;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("update dependant_13455624  set Name=?,Address=?,ContactNumber=?,HealthInsuranceNumber=? where patientId=?");
				ps1.setString(1, name);
				ps1.setString(2, address);
				ps1.setLong(3, contactno);
				ps1.setLong(4, insuranceno);
				ps1.setInt(5, id);
				c=ps1.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c>0;
		}
		
		
		//deleting dependant by patient id
		
		public boolean deleteDependantByPatientId(int id)
		{
			int c=0;
			con=DatabaseUtil.getConnection();
			try {
				ps1=con.prepareStatement("delete from dependant_13455624 where patientId=?");
				ps1.setInt(1, id);
				c=ps1.executeUpdate();
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c>0;
		}
		
		
		
	}


