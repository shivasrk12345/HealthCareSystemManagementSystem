package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.HCP;
import com.tcs.bean.LSP;
import com.tcs.bean.Patient;
import com.tcs.bean.Test;
import com.tcs.exception.DataLayerException;
import com.tcs.util.DatabaseUtil;

public class HCPDAO {

	public HCP addHCP(HCP h)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int hcpid=0;
		String password=null;
		int x=0;
		HCP hc = null;
		
		
			con=DatabaseUtil.getConnection();
			try {
				ps=con.prepareStatement("select hcpid.nextval from dual");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					hcpid=rs.getInt(1);
					System.out.println(hcpid);
					password="hcp"+hcpid+"@TVM";
					System.out.println(password);
				}
				ps=con.prepareStatement("insert into HCP_groupb values(?,?,?,?,?,?,?,?,?,?,?,?)");
				System.out.println("insert");
				ps.setInt(1,hcpid);
				ps.setString(2,password);
				ps.setString(3,h.getHcpName());
				System.out.println("insert");
				ps.setString(4,h.getLicenseNumber());
				ps.setString(5,h.getAddress());
				ps.setLong(6, h.getContactNumber());
				ps.setLong(7,h.getAlernateContactnumber());
				ps.setString(8,h.getEmail());
				ps.setString(9, h.getQuestion1());
				ps.setString(10,h.getAnswer1());
				ps.setString(11, h.getQuestion2());
				ps.setString(12,h.getAnswer2());
				x=ps.executeUpdate();
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps);
			}
		hc = new HCP(hcpid, password, h.getHcpName());
		return hc;

}
	
	public ArrayList<HCP> viewHCP()
	{
		System.out.println("dao");
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<HCP> list=new ArrayList<HCP>();
		try
		{
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from HCP_groupb");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				HCP h=new HCP();
				h.setHcpID(rs.getInt(1));
				h.setPassword(rs.getString(2));
				h.setHcpName(rs.getString(3));
				h.setLicenseNumber(rs.getString(4));
				h.setAddress(rs.getString(5));
				h.setContactNumber(rs.getLong(6));
				h.setAlernateContactnumber(rs.getLong(7));
				h.setEmail(rs.getString(8));
				h.setQuestion1(rs.getString(9));
				h.setAnswer1(rs.getString(10));
				h.setQuestion2(rs.getString(11));
				h.setAnswer2(rs.getString(12));
				list.add(h);
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
		System.out.println(list);
		return list;
	}
	
	public HCP viewHCPbyid(int id)
	{
		
		Connection con=null;
		PreparedStatement ps=null;
	    HCP h=new HCP();
		try
		{
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from HCP_groupb where hcpID=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				h.setHcpID(rs.getInt(1));
				h.setPassword(rs.getString(2));
				h.setHcpName(rs.getString(3));
				h.setLicenseNumber(rs.getString(4));
				h.setAddress(rs.getString(5));
				h.setContactNumber(rs.getLong(6));
				h.setAlernateContactnumber(rs.getLong(7));
				h.setEmail(rs.getString(8));
				h.setQuestion1(rs.getString(9));
				h.setAnswer1(rs.getString(10));
				h.setQuestion2(rs.getString(11));
				h.setAnswer2(rs.getString(12));
				
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
	public boolean updatehcpdetails(HCP h)
	{
		Connection con=null;
		PreparedStatement ps=null;
	  int x=0;
	  con=DatabaseUtil.getConnection();
	  try {
		ps=con.prepareStatement("update HCP_groupb set hcpName=?,address=?,contactNumber=?,alernateContactnumber=?,email=? where hcpID=?");
		ps.setString(1, h.getHcpName());
		ps.setString(2, h.getAddress());
		ps.setLong(3, h.getContactNumber());
		ps.setLong(4, h.getAlernateContactnumber());
		ps.setString(5,h.getEmail());
		ps.setInt(6, h.getHcpID());
		x=ps.executeUpdate();
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
		
		return x>0;
	}
	
	////////////////LSP search
	
	public ArrayList<String> getValues(String city,String testName,String lspName)
	{
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<String> list=new ArrayList<String>();
		try
		{
			con=DatabaseUtil.getConnection();
			if(city!=null)
			{
				pst=con.prepareStatement("select distinct City from lsp_1390");
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{					
					list.add(rs.getString(1));
				}
			}
			else if(testName!=null)
			{
					pst=con.prepareStatement("select distinct TestName from test_1390");
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						list.add(rs.getString(1));
					}
			}
			else if(lspName!=null)
			{
					pst=con.prepareStatement("select distinct LSPName from lsp_1390");
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						list.add(rs.getString(1));
					}
			}
		}
		
		 catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(pst);
			}
		
		return list;
	}
	
	
	public ArrayList<LSP> search(String city,String testName,String lspName)
	{
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<LSP> list=new ArrayList<LSP>();

		try
		{
			con=DatabaseUtil.getConnection();
			if(city!=null)
			{
				
				pst=con.prepareStatement("select t.LabId,t.TestName,t.TestCode,t.TestDescription,t.TestDuration,t.TestCost,t.LabHome,l.LSPName,l.Address,l.Zipcode,l.State,l.City from lsp_1390 l , test_1390 t where l.City=? and l.LabId=t.LabId");
				pst.setString(1, city);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Test t=new Test();
					t.setTestName(rs.getString(2));
					t.setTestCode(rs.getString(3));
					t.setTestDesc(rs.getString(4));
					t.setDuration(rs.getString(5));
					t.setCost(rs.getDouble(6));
					t.setLabAtHome(rs.getString(7));
					
					ArrayList<Test> test=new ArrayList<Test>();
					test.add(t);	

					LSP lsp=new LSP();
					lsp.setLSPName(rs.getString(8));
					lsp.setAddress(rs.getString(9));
					lsp.setZipcode(rs.getInt(10));
					lsp.setState(rs.getString(11));
					lsp.setCity(rs.getString(12));
						
					lsp.setTest(test);
					list.add(lsp);					
				}	
			}
			else if(testName!=null)
			{
					pst=con.prepareStatement("select t.LabId,t.TestName,t.TestCode,t.TestDescription,t.TestDuration,t.TestCost,t.LabHome,l.LSPName,l.Address,l.Zipcode,l.State,l.City from lsp_1390 l , test_1390 t where t.TestName=? and l.LabId=t.LabId");
					pst.setString(1, testName);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						Test t=new Test();
						t.setTestName(rs.getString(2));
						t.setTestCode(rs.getString(3));
						t.setTestDesc(rs.getString(4));
						t.setDuration(rs.getString(5));
						t.setCost(rs.getDouble(6));
						t.setLabAtHome(rs.getString(7));
						
						LSP lsp=new LSP();
						lsp.setLSPName(rs.getString(8));
						lsp.setAddress(rs.getString(9));
						lsp.setZipcode(rs.getInt(10));
						lsp.setState(rs.getString(11));
						lsp.setCity(rs.getString(12));
		
						ArrayList<Test> test=new ArrayList<Test>();
						
						test.add(t);	
						lsp.setTest(test);
						list.add(lsp);
											
					}
			}
			else if(lspName!=null)
			{
					pst=con.prepareStatement("select t.LabId,t.TestName,t.TestCode,t.TestDescription,t.TestDuration,t.TestCost,t.LabHome,l.LSPName,l.Address,l.Zipcode,l.State,l.City from lsp_1390 l , test_1390 t where l.LSPName=? and l.LabId=t.LabId");
					pst.setString(1, lspName);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						Test t=new Test();
						t.setTestName(rs.getString(2));
						t.setTestCode(rs.getString(3));
						t.setTestDesc(rs.getString(4));
						t.setDuration(rs.getString(5));
						t.setCost(rs.getDouble(6));
						t.setLabAtHome(rs.getString(7));
						
						ArrayList<Test> test=new ArrayList<Test>();
						test.add(t);

						LSP lsp=new LSP();
						lsp.setLSPName(rs.getString(8));
						lsp.setAddress(rs.getString(9));
						lsp.setZipcode(rs.getInt(10));
						lsp.setState(rs.getString(11));
						lsp.setCity(rs.getString(12));
												
						lsp.setTest(test);						
						list.add(lsp);
					}
			}
		}
		
		 catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(pst);
			}
		
		return list;
	}
/////////to change pwd
	public boolean changepasswordhcp(int id,String oldpassword,String newpswd1) 
	{
		String pswd=null;
		int i=0;
		Connection con=DatabaseUtil.getConnection();
		PreparedStatement ps1=null;
		try {
			ps1=con.prepareStatement("select password from hcp_groupb where hcpId=?");
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
			
				ps1=con.prepareStatement("update hcp_groupb set password=? where hcpId=?");
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
	//////////////forgot password
	public HCP forgotPass(int userId)  {
		HCP hcp=new HCP();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from hcp_groupb where HCPId=?");
			ps.setInt(1, userId);
			rs=ps.executeQuery();
				while(rs.next()){
					hcp.setQuestion1(rs.getString(9));
					hcp.setAnswer1(rs.getString(10));
					hcp.setQuestion2(rs.getString(11));
					hcp.setAnswer2(rs.getString(12));
					hcp.setHcpID(rs.getInt(1));
					hcp.setPassword(rs.getString(2));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e1.getMessage());
			}
			finally
			{
				DatabaseUtil.closeConnection(con);
				DatabaseUtil.closeStatement(ps);
			}
			
		System.out.println(hcp);
		return hcp;
	}
	///////////HCP view Patients
	
	public ArrayList<Patient> getPtientDetailsByHCPId(int hcpid)
	{
		Connection con=null;
		PreparedStatement pst=null;
		ArrayList<Patient> list=new ArrayList<Patient>();
		try
		{
			con=DatabaseUtil.getConnection();
			pst=con.prepareStatement("select p.patientId,p.FirstName,p.Address,p.ContactNumber,h.hcpId from Patient_13455624 p,hcp_groupb h where p.hcpId=h.hcpId and h.hcpid=?");
			pst.setInt(1,hcpid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Patient p=new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getInt(5));
				list.add(p);
			
			}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DataLayerException(e1.getMessage());
		}
		finally
		{
			DatabaseUtil.closeConnection(con);
			DatabaseUtil.closeStatement(pst);
		}
		return list;
	}
	public Patient getPatientById(int id)
	{
		Connection con=null;
		PreparedStatement ps1=null;
		Patient p=null;
		con=DatabaseUtil.getConnection();
		try {
			ps1=con.prepareStatement("select * from Patient_13455624 where patientId=?" );
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				 p=new Patient(rs.getInt(1), rs.getString(3), rs.getString(7), rs.getLong(8), rs.getInt(19));
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
	public boolean updatePatient(int id,String fname,String address,long contactNumber)
	{
		Connection con=null;
		PreparedStatement ps1=null;
		int c=0;
		con=DatabaseUtil.getConnection();
		try {
			ps1=con.prepareStatement("update Patient_13455624 set FirstName=?,Address=?,ContactNumber=? where patientId=?");
		ps1.setString(1, fname);
		ps1.setString(2, address);
		ps1.setLong(3,contactNumber );
		
		ps1.setInt(4, id);
		
		c=ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataLayerException(e.getMessage());
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
		Connection con=null;
		PreparedStatement ps1=null;
		
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
}
