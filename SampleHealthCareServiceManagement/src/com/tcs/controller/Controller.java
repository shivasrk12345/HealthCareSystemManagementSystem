package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.ns.SessionAtts;

import com.tcs.bean.Dependant;
import com.tcs.bean.HCP;
import com.tcs.bean.LSP;
import com.tcs.bean.Patient;
import com.tcs.exception.ServiceLayerException;
import com.tcs.service.HCPService;
import com.tcs.service.LoginService;
import com.tcs.service.PatientService;


/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		
		System.out.println(action);
		HCPService hs=new HCPService();
		PatientService obj=new PatientService();
		LoginService loginservice=new LoginService();
		if(action=="" || action==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/home.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("home"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/home.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("signup"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpregistration.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("hcp"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/hcplogin.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("aboutus"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/aboutus.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("contactus"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("JSP/contactus.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("hcpdetails"))
		{
			int id=Integer.parseInt(request.getParameter("name"));
			
			String password=request.getParameter("password");
			
			try {
                 HCP h=loginservice.getPwdByHCPId(id);
				if(h.getPassword().equals(password))
				{
					HttpSession session=request.getSession();
				    session.setAttribute("HCP", h);
				    String check=h.getHcpName();
					session.setAttribute("username", check);
				RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpdetails.jsp");
				rd.forward(request, response);
				}
				else 
				{
					request.setAttribute("message", "The id and password does not match");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/hcplogin.jsp");
					rd.forward(request, response);
				}
			} catch (ServiceLayerException e) {
				request.setAttribute("message",e.getMessage());
				RequestDispatcher rd=request.getRequestDispatcher("JSP/hcplogin.jsp");
				rd.forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("RegisterHCP"))
		{
			String name=request.getParameter("name");
			String licensenum=request.getParameter("licensenum");
			String address=request.getParameter("address");
			long contactnum=Long.parseLong(request.getParameter("contactnum"));
			long alternatecontact=Long.parseLong(request.getParameter("alternatecontact"));
			String email=request.getParameter("email");
			String question1=request.getParameter("ques1");
			String answer1=request.getParameter("ans1");
			String question2=request.getParameter("ques2");
			String answer2=request.getParameter("ans2");
			HCP h=new HCP(name, licensenum, address,  contactnum, alternatecontact, email, question1, answer1, question2, answer2);
			HCP hcp=hs.addHCP(h);
			if(hcp!=null)
			{ 
				request.setAttribute("message","The following details of HCP added successfully");
				request.setAttribute("HCP",hcp);
				RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpregsuccess.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/errorpage.jsp");
				rd.forward(request, response);
			}
		}
			
			else if(action.equalsIgnoreCase("viewhcp"))
			{
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
				
				ArrayList<HCP> listhcp=hs.viewHCP();
				if(listhcp!=null)
				{
					request.setAttribute("message","Details of HCP");
					request.setAttribute("HCP",listhcp);
					RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpdetailsview.jsp");
					rd.forward(request, response);
				}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/hcplogin.jsp");
					rd.forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("viewhcpbyid"))
			{
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
					RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpdetailsviewbyid.jsp");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/hcplogin.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("viewbyid"))
				
			{
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
					int id=Integer.parseInt(request.getParameter("id"));
					try {
						HCP h=hs.viewHCPbyid(id);
						if(h!=null)
						{
						request.setAttribute("HCP",h);
						request.setAttribute("message","The details of HCP are as follows");
						RequestDispatcher rd=request.getRequestDispatcher("JSP/viewbyidsuccess.jsp");
						rd.forward(request, response);
						}
						
					}
					 
					catch (ServiceLayerException e) {
						request.setAttribute("message",e.getMessage());
						RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpdetailsviewbyid.jsp");
						rd.forward(request, response);
					}
					
					
					
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/hcplogin.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("updatebyid"))
					{
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
					 int id=Integer.parseInt(request.getParameter("id"));
				        String name=request.getParameter("name");
				        String address=request.getParameter("address");
				        long number=Long.parseLong(request.getParameter("contactnum"));
				        long alternate=Long.parseLong(request.getParameter("alternatecontact"));
				        String email=request.getParameter("email");
				        HCP h=new HCP(id, name, address, number, alternate, email);
				        boolean flag=hs.updatehcpdetails(h);
				        if(flag==true)
				        {
				        	request.setAttribute("message","Updated details are as follows");
				        	request.setAttribute("HCP",h);
							RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpupdatesuccess.jsp");
							rd.forward(request, response);
				        }
				        else
				        {
				        	request.setAttribute("message","Details not updated");
				        	
							RequestDispatcher rd=request.getRequestDispatcher("JSP/hcpupdatesuccess1.jsp");
							rd.forward(request, response);
				        }
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/hcplogin.jsp");
					rd.forward(request, response);
				}
				       
					}
		
		///////////////patient controller
			else if(action.equalsIgnoreCase("patient"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/patientlogin.jsp");
				rd.forward(request, response);
			}
			else if(action.equalsIgnoreCase("signuppatient"))
			{
				ArrayList<Integer> hcpid=obj.gethcpid();
				if(hcpid!=null)
				{
					request.setAttribute("listhcpid",hcpid);
					RequestDispatcher rd=request.getRequestDispatcher("JSP/patientregistration.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("patienthcpregistration"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("JSP/patienthcpregistration.jsp");
				rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("PatientRegistration"))
			{
				long HealthInsuranceNumber=0;
				String FirstName=request.getParameter("fname");
				String LastName =request.getParameter("lname");
				String Gender =request.getParameter("gender");
				int Age =Integer.parseInt(request.getParameter("age"));
				String Address =request.getParameter("address");
				long ContactNumber =Long.parseLong(request.getParameter("number"));
				String Complaint =request.getParameter("medical");
				String Doctor=request.getParameter("doctor");
				String InsuranceCover =request.getParameter("selType");
				if(InsuranceCover.equalsIgnoreCase("Yes"))
				{
				 HealthInsuranceNumber =Long.parseLong(request.getParameter("health"));
				}
				
				int hcpId=Integer.parseInt(request.getParameter("hcpId"));
				
				String birthcity=null;
				String favoriteactor=null;
				String favoritefood=null;
				String favoritecrickter=null;
				String favoritesport=null;
				
				String security1=request.getParameter("security1");
				String securityanswer1=request.getParameter("securityanswer1");
				
				if(security1.equalsIgnoreCase("yourbirthcity"))
				{
					birthcity=securityanswer1;
				}
				else if(security1.equalsIgnoreCase("yourfavoriteactor"))
				{
					
					favoriteactor=securityanswer1;
				}
				else if(security1.equalsIgnoreCase("yourfavoritefood")){
					
					favoritefood=securityanswer1;
					
				}
				else if(security1.equalsIgnoreCase("yourfavoritecrickter")){
					
					favoritecrickter=securityanswer1;
					
				}
				else if(security1.equalsIgnoreCase("yourfavoritesport")){
					
					favoritesport= securityanswer1;
					
				}
				String security2=request.getParameter("security2");
				String securityanswer2=request.getParameter("securityanswer2");
				if(security2.equalsIgnoreCase("yourbirthcity"))
				{
						birthcity=securityanswer2;
				}
				else if(security2.equalsIgnoreCase("yourfavoriteactor"))
				{
					
						favoriteactor=securityanswer2;
				}
				else if(security2.equalsIgnoreCase("yourfavoritefood")){
					
					 	favoritefood=securityanswer2;
					
				}
				else if(security2.equalsIgnoreCase("yourfavoritecrickter")){
					
					 	favoritecrickter=securityanswer2;
					
				}
				else if(security2.equalsIgnoreCase("yourfavoritesport")){
					
					 	favoritesport= securityanswer2;
					
				}
				
				
				
				Patient p=new Patient(FirstName, LastName, Gender, Age, Address, ContactNumber, Complaint, Doctor, InsuranceCover, HealthInsuranceNumber, birthcity, favoriteactor,favoritefood, favoritecrickter, favoritesport, hcpId);
				
				System.out.println(p);
				Patient pp =obj.addPatient(p);
				System.out.println(pp);
				
				if(pp!=null){
					
					request.setAttribute("Message", "Patient Registered Succesfully");
					request.setAttribute("Patient", pp);
					RequestDispatcher rd = request.getRequestDispatcher("JSP/registersuccess.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("RegistrationMessage", "Patient   Registration failed ");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/FailedPage.jsp");
					rd.forward(request, response);
				}
			
				
			}
			else if (action.equalsIgnoreCase("patientdetails"))
			{
				int id=0;
				long contactNumber=0;
				Patient p=null;
				long username=Long.parseLong(request.getParameter("username"));
				String password=request.getParameter("password");
				
				try {
					if(username<99999)
					{
						id=(int )username;
					}
					else
					{
						contactNumber=username;
					}
					
					p=loginservice.getPwdByPatientId(id,contactNumber);
					if(p.getPatientPassword().equals(password))
					{
						System.out.println("equal");
						HttpSession session=request.getSession();
					session.setAttribute("Patient", p);
					session.setAttribute("password", password);
					String check=p.getFirstName();
					session.setAttribute("username", check);
					RequestDispatcher rd = request.getRequestDispatcher("JSP/patientdetails.jsp");
					rd.forward(request, response);
					//session.setMaxInactiveInterval(4);
					}
					else 
					{
						request.setAttribute("message", "The username and password does not match");
						RequestDispatcher rd=request.getRequestDispatcher("JSP/patientlogin.jsp");
						rd.forward(request, response);
					}
				} catch (ServiceLayerException e) {
					request.setAttribute("message",e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("JSP/patientlogin.jsp");
					rd.forward(request, response);
				}
				
				
			}
		//VIEWING ALL PATIENTS
			else if(action.equalsIgnoreCase("viewpatients")){
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
				System.out.println("viewing patients"+action);
			    ArrayList<Patient> plist= obj.viewPatients();
				
				
				
				if(plist!=null){
					
					request.setAttribute("Message", "Patients List");
					request.setAttribute("Patientlist", plist);
					RequestDispatcher rd = request.getRequestDispatcher("JSP/viewsuccess.jsp");
					rd.forward(request, response);
					
				}
				else
				{
					request.setAttribute("ViewpatientsMessage", "No patients to display");
					
					RequestDispatcher rd = request.getRequestDispatcher("JSP/FailedPage.jsp");
					rd.forward(request, response);
					
				}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/patientlogin.jsp");
					rd.forward(request, response);
				}
				
			}
			/*else if(action.equalsIgnoreCase("viewProfile")){
				
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/viewByIdPage.jsp");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/patientlogin.jsp");
					rd.forward(request, response);
				}
				
				
			}*/

			// VIEW bY ID
			else if(action.equalsIgnoreCase("viewProfile"))
			{
				
				int id=Integer.parseInt(request.getParameter("id"));
				Patient p=obj.getPatientById(id);
				System.out.println(p);
				if(p!=null)
				{
					HttpSession session=request.getSession();
					request.setAttribute("msg", "success");
					session.setAttribute("patient", p);
					RequestDispatcher rd = request.getRequestDispatcher("JSP/viewByIdMobPageSuccess.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("ViewFailedMessage", "cannot viewed");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/FailedPage.jsp");
					rd.forward(request, response);
				}
				
			}
		// VIEW BY MOBILE
			else if(action.equalsIgnoreCase("ViewByMobile1"))
			
			{
				long mobile=Long.parseLong(request.getParameter("search"));
				Patient p=obj.getPatientByMobile(mobile);
				if(p!=null)
				{
					HttpSession session=request.getSession();
					request.setAttribute("msg", "success");
					session.setAttribute("patient", p);
					RequestDispatcher rd = request.getRequestDispatcher("JSP/viewByIdMobPageSuccess.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("ViewFailedMessage", "cannot viewed");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/FailedPage.jsp");
					rd.forward(request, response);
				}
			}
		///Updateeeee
			else if(action.equalsIgnoreCase("update"))			
			{
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
				int id=Integer.parseInt(request.getParameter("id"));
				Patient p=obj.getPatientById(id);
				if(p!=null)
				{
					request.setAttribute("msg", "success");
					request.setAttribute("patient", p);
				
				RequestDispatcher rd = request.getRequestDispatcher("JSP/UpdatePage.jsp");
				rd.forward(request, response);
				}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/patientlogin.jsp");
					rd.forward(request, response);
				}
				
			}
			// UPDATING THE PATIENT DETAILS
			else if(action.equalsIgnoreCase("updating"))			
			{
				HttpSession session=request.getSession(false);
				String username=(String)session.getAttribute("username");
				if(username!=null)
				{
				int id=Integer.parseInt(request.getParameter("id"));
				String fname=request.getParameter("fname");
				String lname=request.getParameter("lname");
				String address=request.getParameter("address");
				String gender=request.getParameter("gender");
				int age=Integer.parseInt(request.getParameter("age"));
				long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
				long healthInsuranceNumber=Long.parseLong(request.getParameter("healthInsuranceNumber"));
				Patient p=new Patient(id, fname, lname, gender, age, address, contactNumber, healthInsuranceNumber);
				boolean flag=obj.updatePatient(id, fname, lname, gender, age, address, contactNumber, healthInsuranceNumber);
				System.out.println(flag);
				if(flag)
				{
					request.setAttribute("msg","The  following details are updated successfully");
					request.setAttribute("Patient",p);
				
				RequestDispatcher rd = request.getRequestDispatcher("JSP/UpdateSuccessPage.jsp");
				rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/patientlogin.jsp");
					rd.forward(request, response);
				}
				}
			}
		//DELETING THE PATIENT
			else if(action.equalsIgnoreCase("delete"))			
			{
				int id=Integer.parseInt(request.getParameter("id"));
			boolean flag=obj.deletePatient(id);
			System.out.println(flag);
				if(flag)
				{
					request.setAttribute("msg", "patient with"+id+"is successfully deleted");
					
					
					RequestDispatcher rd = request.getRequestDispatcher("JSP/DeleteSuccessPage.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Please clear the bill amounts");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/DeleteSuccessPage.jsp");
					rd.forward(request, response);
				}
			}
		//ADDING DEPENDANT

			else if(action.equalsIgnoreCase("addDependant"))			
			{
				HttpSession session=request.getSession();
				int id=Integer.parseInt(request.getParameter("id"));
				session.setAttribute("PatientDependantId",id);
				RequestDispatcher rd = request.getRequestDispatcher("JSP/DependantListPage.jsp");
				rd.forward(request, response);
			}
			/*else if(action.equalsIgnoreCase("dependents"))			
			{
				String relation=request.getParameter("relation");
				//String strUser1 = relation.options[relation.selectedIndex].text;
				if(relation.equalsIgnoreCase("Child"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/children.jsp");
					rd.forward(request, response);
				}
				else if(relation.equalsIgnoreCase("Parents"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/parents.jsp");
					rd.forward(request, response);
				}
				else if(relation.equalsIgnoreCase("Spouse"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("JSP/spouse.jsp");
					rd.forward(request, response);
				}
			}*/
			else if (action.equals("dependents")) {

				HttpSession session = request.getSession(false);
				int userId = (Integer.parseInt(request.getParameter("id"))); 
				if (userId != 0) {

					String relationship = request.getParameter("relation");
					if (relationship.equals("Spouse") || relationship.equals("Mother") || relationship.equals("Father")) {

						int count = obj.getCount(relationship, userId);
						if (count >= 1) {
							request.setAttribute("message", "Cannot Add Dependent As It Is Already Added");
							RequestDispatcher rd = request.getRequestDispatcher("JSP/DependantListPage.jsp");
							rd.forward(request, response);

						} else {
							request.setAttribute("relationship", relationship);
							

							RequestDispatcher rd = request.getRequestDispatcher("JSP/children.jsp");
							rd.forward(request, response);

						}
					} else {

						request.setAttribute("relationship", relationship);
						

						RequestDispatcher rd = request.getRequestDispatcher("JSP/children.jsp");
						rd.forward(request, response);
					}
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("JSP/LoginPatient.jsp");
					rd.forward(request, response);
				}
			}
			/*else if(action.equalsIgnoreCase("spouseRegistration"))			
			{
				int patientId=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String relationship=request.getParameter("relationship");
				String gender=request.getParameter("gender");
				int age=Integer.parseInt(request.getParameter("age"));
				String address=request.getParameter("address");
				long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
				String insuranceCover =request.getParameter("insuranceCover");
				long healthInsuranceNumber=Long.parseLong(request.getParameter("healthInsuranceNumber"));
				Dependant d=new Dependant(patientId, name, relationship, gender, age, address, contactNumber, insuranceCover, healthInsuranceNumber);
				boolean flag=obj.addDependant(d);
				if(flag)
				{
					request.setAttribute("dependant",d);
					request.setAttribute("msg", "dependant registered successfully");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/DependantRegSuccess.jsp");
					rd.forward(request, response);

				}
				
			}*/
			else if(action.equalsIgnoreCase("DependantRegistration"))			
			{
				int patientId=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String relationship=request.getParameter("relationship");
				String gender=request.getParameter("gender");
				int age=Integer.parseInt(request.getParameter("age"));
				String address=request.getParameter("address");
				long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
				String insuranceCover =request.getParameter("insuranceCover");
				long healthInsuranceNumber=Long.parseLong(request.getParameter("healthInsuranceNumber"));
				Dependant d=new Dependant(patientId, name, relationship, gender, age, address, contactNumber, insuranceCover, healthInsuranceNumber);
				boolean flag=obj.addDependant(d);
				if(flag)
				{
					request.setAttribute("dependant",d);
					request.setAttribute("msg", "dependant registered successfully");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/DependantRegSuccess.jsp");
					rd.forward(request, response);

				}
				
			}
			/*else if(action.equalsIgnoreCase("parentsRegistration"))			
			{
				int patientId=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String relationship=request.getParameter("relationship");
				String gender=request.getParameter("gender");
				int age=Integer.parseInt(request.getParameter("age"));
				String address=request.getParameter("address");
				long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
				String insuranceCover =request.getParameter("insuranceCover");
				long healthInsuranceNumber=Long.parseLong(request.getParameter("healthInsuranceNumber"));
				Dependant d=new Dependant(patientId, name, relationship, gender, age, address, contactNumber, insuranceCover, healthInsuranceNumber);
				
				boolean flag=obj.addDependant(d);
				if(flag)
				{
					request.setAttribute("dependant",d);
					request.setAttribute("msg", "dependant registered successfully");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/DependantRegSuccess.jsp");
					rd.forward(request, response);

				}
				
			}*/
		
		//////////////logout
			else if(action.equalsIgnoreCase("logout"))
		{
			HttpSession session=request.getSession(false);
			session.removeAttribute("check");
			session.invalidate();
			RequestDispatcher rd= request.getRequestDispatcher("JSP/home.jsp");
			rd.forward(request, response);
			
		}
		
		
///////////////patient change PASSWORD
		else if(action.equalsIgnoreCase("changepwdpatient"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("patientid", id);
			RequestDispatcher rd = request.getRequestDispatcher("JSP/changepassword.jsp");
			rd.forward(request, response);
		}
		
		/////////hcp change password
		else if(action.equalsIgnoreCase("hcpchangepwdpatient"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("HCPID", id);
			RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpchangepassword.jsp");
			rd.forward(request, response);
		}
		
	
	//CHANGE PASSWORD LOGIC
		else if(action.equalsIgnoreCase("ChangePassword"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String oldpassword=request.getParameter("password1");
			String newpassword1=request.getParameter("password2");
			
			
			
			boolean flag=obj.changepassword(id, oldpassword, newpassword1);
			System.out.println(flag);
			if(flag)
			{
				request.setAttribute("msg", "Your Password is changed successfully");
				RequestDispatcher rd = request.getRequestDispatcher("JSP/confirmnewpasswordsuccess.jsp");
				rd.forward(request, response);
			}
			else
			{
				int id1=Integer.parseInt(request.getParameter("id"));
				request.setAttribute("patientid", id1);
				request.setAttribute("msg", "Please enter your correct credentials to change your password");
				RequestDispatcher rd = request.getRequestDispatcher("JSP/changepassword.jsp");
				rd.forward(request, response);
			}
			
			
		}
		////////////////hcp change password
		else if(action.equalsIgnoreCase("hcpchangepassword"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String oldpassword=request.getParameter("password1");
			String newpassword1=request.getParameter("password2");
			
			
			
			boolean flag=hs.changepasswordhcp(id, oldpassword, newpassword1);
			System.out.println(flag);
			if(flag)
			{
				request.setAttribute("msg", "Your Password is changed successfully");
				RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpconfirmnewpwd.jsp");
				rd.forward(request, response);
			}
			else
			{
				int id1=Integer.parseInt(request.getParameter("id"));
				request.setAttribute("HCPID", id1);
				request.setAttribute("msg", "Please enter your correct credentials to change your password");
				RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpchangepassword.jsp");
				rd.forward(request, response);
			}
			
			
		}
	//forgot PASSWORD
		else if(action.equalsIgnoreCase("forgotpwdpatient"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("JSP/forgot1.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("verifybypatientid"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				int id1=obj.checkpatientid(id);
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("JSP/forgot2.jsp");
				rd.forward(request, response);
			}catch (ServiceLayerException e) {
				request.setAttribute("msg",e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("JSP/forgot1.jsp");
				rd.forward(request, response);
				
			}
			
			
		}
		else if(action.equalsIgnoreCase("verifySecurityAnswers"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			String birthcity=null;
			String favoriteactor=null;
			String favoritefood=null;
			String favoritecrickter=null;
			String favoritesport=null;
			
			
			String security1=request.getParameter("security1");
			String securityanswer1=request.getParameter("securityanswer1");
			
			if(security1.equalsIgnoreCase("yourbirthcity"))
			{
				birthcity=securityanswer1;
			}
			else if(security1.equalsIgnoreCase("yourfavoriteactor"))
			{
				
				favoriteactor=securityanswer1;
			}
			else if(security1.equalsIgnoreCase("yourfavoritefood")){
				
				favoritefood=securityanswer1;
				
			}
			else if(security1.equalsIgnoreCase("yourfavoritecrickter")){
				
				favoritecrickter=securityanswer1;
				
			}
			else if(security1.equalsIgnoreCase("yourfavoritesport")){
				
				favoritesport= securityanswer1;
				
			}
			String security2=request.getParameter("security2");
			String securityanswer2=request.getParameter("securityanswer2");
			if(security2.equalsIgnoreCase("yourbirthcity"))
			{
					birthcity=securityanswer2;
			}
			else if(security2.equalsIgnoreCase("yourfavoriteactor"))
			{
				
					favoriteactor=securityanswer2;
			}
			else if(security2.equalsIgnoreCase("yourfavoritefood")){
				
				 	favoritefood=securityanswer2;
				
			}
			else if(security2.equalsIgnoreCase("yourfavoritecrickter")){
				
				 	favoritecrickter=securityanswer2;
				
			}
			else if(security2.equalsIgnoreCase("yourfavoritesport")){
				
				 	favoritesport= securityanswer2;
				
			}
			//System.out.println(birthcity+favoriteactor+favoritefood+favoritecrickter+favoritesport);
			ArrayList<String> securitylist=new ArrayList<String>();
			securitylist.add(birthcity);
			securitylist.add(favoriteactor);
			securitylist.add(favoritefood);
			securitylist.add(favoritecrickter);
			securitylist.add(favoritesport);
			ArrayList<String> securitylist1=new ArrayList<String>();
			for(String s:securitylist)
			{
				if(s!=null)
					securitylist1.add(s);
			}
			boolean flag = obj.VerifySecurity(id, securitylist1);
				System.out.println(flag);
				if(flag)
				{
					
				
					String pswd=obj.getPatientPasswordById(id);
					System.out.println(pswd);
					if(pswd!=null)
					{
						request.setAttribute("msg","successfully verified");
						request.setAttribute("id", id);
						request.setAttribute("password",pswd);
						RequestDispatcher rd = request.getRequestDispatcher("JSP/ForgotPswdRetrieved.jsp");
						rd.forward(request, response);
					}
						
						
					
					
				}
				else
				{
					request.setAttribute("msg","security answers entered are incorect-");
					RequestDispatcher rd = request.getRequestDispatcher("JSP/verificationfailure.jsp");
					rd.forward(request, response);
				}
			
			
			
		
			
		}
	
		/////forgot hcp
		else if(action.equalsIgnoreCase("hcpforgotpwd"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpforgot1.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("verifybyhcpid"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				int id1=hs.checkhcpid(id);
				
				request.setAttribute("id", id);
				RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpforgot2.jsp");
				rd.forward(request, response);
			}catch (ServiceLayerException e) {
				request.setAttribute("msg",e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpforgot1.jsp");
				rd.forward(request, response);
				
			}
			
			
		} 
		else if(action.equalsIgnoreCase("hcpverifySecurityAnswers"))
				{
			        int id=Integer.parseInt(request.getParameter("id"));
			        String answer1=request.getParameter("securityanswer1");
			        String answer2=request.getParameter("securityanswer2");
			        HCP hcp=hs.forgotPass(id);
			        System.out.println(hcp);
			        if (answer1.equalsIgnoreCase(hcp.getAnswer1())
							&& answer2.equalsIgnoreCase(hcp.getAnswer2()) ){
						request.setAttribute("id", hcp.getHcpID());
						request.setAttribute("password", hcp.getPassword());
						request.setAttribute("msg","The details of hcp password are as follows ");
						RequestDispatcher rd = request
								.getRequestDispatcher("JSP/ForgotPswdRetrieved.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("id",hcp.getHcpID());
						request.setAttribute("msg",
								"ANSWERS ARE WRONG");
						RequestDispatcher rd = request.getRequestDispatcher("JSP/hcpforgot2.jsp");
								
						rd.forward(request, response);
					}
			        
				}
		
		///////////////////VIEW LSP
			else if(request.getParameter("action").equals("viewlsp"))
			{
					ArrayList<String> ls1=hs.getValues("name", null, null);
					request.setAttribute("list1", ls1);
				
					ArrayList<String> ls2=hs.getValues(null, "name", null);
					request.setAttribute("list2", ls2);
					
					ArrayList<String> ls3=hs.getValues(null, null, "name");
					request.setAttribute("list3", ls3);
					
					RequestDispatcher rd=request.getRequestDispatcher("JSP/TrySearch.jsp");
					rd.forward(request, response);
			}
			
			else if(request.getParameter("action").equals("search1"))
			{
				String name1=request.getParameter("selType");
				System.out.println(name1);

				if(name1.equalsIgnoreCase("Search by city"))
				{
					String name=request.getParameter("selOption1");
					System.out.println(name);
					ArrayList<LSP> ls1=hs.search(name, null, null);
					request.setAttribute("list1", ls1);
				}
				
				else if(name1.equalsIgnoreCase("search by Test name"))
				{
					String name=request.getParameter("selOption2");
					System.out.println(name);
					ArrayList<LSP> ls1=hs.search(null, name, null);
					request.setAttribute("list1", ls1);
				}
				
				else if(name1.equalsIgnoreCase("Search by LSP name"))
				{
					String name=request.getParameter("selOption3");
					System.out.println(name);
					ArrayList<LSP> ls1=hs.search(null, null, name);
					request.setAttribute("list1", ls1);
				}
				
				RequestDispatcher rd=request.getRequestDispatcher("JSP/ViewTest.jsp");
				rd.forward(request, response);
			}
			else if(action.equalsIgnoreCase("patienthcpview"))
					{
				
				        int id=Integer.parseInt(request.getParameter("id"));
				        ArrayList<Patient> plist=hs.getPtientDetailsByHCPId(id);
				        if(plist!=null)
				        {
				        	request.setAttribute("message","Details of Patinets in HCP");
				        	request.setAttribute("Plist",plist);
				        	RequestDispatcher rd=request.getRequestDispatcher("JSP/ViewPatientsinHCP.jsp");
							rd.forward(request, response);
				        }
					}
			else if(action.equalsIgnoreCase("updatepatientbyhcp"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				Patient p=hs.getPatientById(id);
				 if(p!=null)
			        {
			        	request.setAttribute("message","Details of Patient in HCP");
			        	request.setAttribute("Pat",p);
			        	RequestDispatcher rd=request.getRequestDispatcher("JSP/ViewPatientprofileinHCP.jsp");
						rd.forward(request, response);
			        }
				
			}
			else if(action.equalsIgnoreCase("uphcppat"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String address=request.getParameter("address");
				long number=Long.parseLong(request.getParameter("number"));
				boolean flag=hs.updatePatient(id, name, address, number);
				if(flag)
				{
					RequestDispatcher rd=request.getRequestDispatcher("JSP/ViewPatientprofileinHCPsuccess.jsp");
					rd.forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("deletepatientbyhcp"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				boolean flag=hs.deletePatient(id);
				if(flag)
				{
					request.setAttribute("message","Patient Deleted Successfully");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/DeletePatientsuccessbyhcp.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("message","Patient Not Deleted Successfully....Please Pay the bill");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/DeletePatientsuccessbyhcp.jsp");
					rd.forward(request, response);
				}
			}
		//view dependants of Patient by using his patientId
			else if(action.equalsIgnoreCase("viewdependantsById"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				ArrayList<Dependant> dlist=obj.viewDependentList(id);
				if(dlist!=null)
				{
					request.setAttribute("msg", "dependant list");
					request.setAttribute("dependantlist", dlist);
					RequestDispatcher rd=request.getRequestDispatcher("JSP/DependantListviewbypateint.jsp");
					rd.forward(request, response);
				}
			}
		//update dependants of Patient by using his patientId
		//retrieving dependant by using patientid
			else if(action.equalsIgnoreCase("updateDependantById"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				Dependant d=obj.getDependantById(id);
				if(d!=null)
				{
					request.setAttribute("msg", "dependant ");
					request.setAttribute("dep", d);
					RequestDispatcher rd=request.getRequestDispatcher("JSP/Dependantupdateviewbypateint.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "dependant does not exist ");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/.jsp");
					rd.forward(request, response);	
				}
			}
		//update dependants of Patient by using his patientId
			else if(action.equalsIgnoreCase("UpdateDependantByPid"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String depaddress=request.getParameter("depaddress");
				long depcontactNumber=Long.parseLong(request.getParameter("depcontactNumber"));
				long HealthInsuranceNumber=Long.parseLong(request.getParameter("HealthInsuranceNumber"));
				boolean flag=obj.updateDependantByPatientId(id, name, depaddress, depcontactNumber,HealthInsuranceNumber);
				if(flag)
				{
					request.setAttribute("msg", "dependant update successfully ");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/Dependantupdateviewbypateintsuccess.jsp");
					rd.forward(request, response);	
				}
				else
				{
					request.setAttribute("msg", "dependant  cannot update his details");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/.jsp");
					rd.forward(request, response);	
				}
				
				
			}
		//delete dependants of Patient by using his patientId
			else if(action.equalsIgnoreCase("deleteDependantsById"))
			{
				int id=Integer.parseInt(request.getParameter("id"));
				boolean flag=obj.deleteDependantByPatientId(id);
				if(flag)
				{
					request.setAttribute("msg", "dependant deleted successfully ");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/Dependantdeletebypateintsuccess.jsp");
					rd.forward(request, response);	
				}
				else 
				{
					request.setAttribute("msg", "dependant cannot be deleted  ");
					RequestDispatcher rd=request.getRequestDispatcher("JSP/.jsp");
					rd.forward(request, response);	
				}
			}
		
			
		
		
		}
		
			
		
		}
	


