package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.bean.HCP;
import com.tcs.bean.Patient;
import com.tcs.exception.DataLayerException;
import com.tcs.util.DatabaseUtil;

public class LoginDAO {
	public int checkhcpid(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
	  int x=0;
		try
		{
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from HCP_groupb where hcpID=?");
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
	public HCP getPwdByHCPId(int id) 
	{
		 Connection con=null;
		 PreparedStatement ps=null;
		 HCP h=new HCP();
		try
		{ 
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select hcpId,password,hcpName from hcp_groupb where hcpId=?");
			ps.setInt(1, id);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				h.setHcpID(rs.getInt(1));
				h.setPassword(rs.getString(2));
				h.setHcpName(rs.getString(3));
				
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
		return h;
	}
	
	public int checkpatientid(int id,long contactNumber)
	{
		Connection con=null;
		PreparedStatement ps=null;
	  int x=0;
		try
		{
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from Patient_13455624 where patientId=? or ContactNumber=?");
			ps.setInt(1,id);
			ps.setLong(2, contactNumber);
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
	public Patient getPwdByPatientId(int id,long contactNumber) 
	{
		System.out.println("emtering patient pswd  method");
		System.out.println(id);
		System.out.println(contactNumber);
		 Connection con=null;
		 PreparedStatement ps=null;
		Patient p=new Patient();
		try
		{ 
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select patientId,patientPassword,FirstName,LastName from Patient_13455624 where patientId=? or ContactNumber=?");
			ps.setInt(1, id);
			ps.setLong(2, contactNumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p.setPatientId(rs.getInt(1));
				p.setPatientPassword(rs.getString(2));
				p.setFirstName(rs.getString(3));
				p.setLastName(rs.getString(4));
				
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
		return p;
	}
}
