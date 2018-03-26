package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sist.msk.Action;

import member.MemberDAO;
import member.MemberVO;

public class MemberController extends Action {


public String join(HttpServletRequest request,
		 HttpServletResponse response)  throws Throwable { 
	
	int num=0;
	String listid = request.getParameter("listid");
	
	if (listid==null) listid = "1";
	
	if (request.getParameter("num")!=null) {
		num = Integer.parseInt(request.getParameter("num"));
	}
	request.setAttribute("num", num);
	request.setAttribute("listid", listid);
	
		 return  "/view/join.jsp";
		} 

public String joinPro(HttpServletRequest request,
		 HttpServletResponse response)  throws Throwable { 
	
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null || pageNum == "") {
		pageNum = "1";
	}
	String listid = request.getParameter("listid");
	if (listid==null) listid = "1";
	
	
	MemberVO member=new MemberVO();
	MemberDAO dbpro=MemberDAO.getInstance(); 
	
	
	member.setListid(listid);
	member.setMemberid(request.getParameter("memberid"));
	member.setNickname(request.getParameter("nickname"));
	member.setPasswd(request.getParameter("passwd"));
	dbpro.insertMember(member);
	
   response.sendRedirect(request.getContextPath()+"/view/main.jsp");
	
   
   
		 return null ; 
		} 



	
	

	
}
