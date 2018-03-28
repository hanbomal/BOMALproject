<%@page import="studygroup.StudyVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 List<StudyVO> allList= new ArrayList<>();
 StudyVO a1= new StudyVO();
 a1.setStudyName("t1");
 StudyVO a2= new StudyVO();
 a2.setStudyName("t2");

 allList.add(a1);
 allList.add(a2);
 
 String info="";
 for(StudyVO study: allList){
 	info+="\""+study.getStudyName()+"\",";	 
 }
 
 request.setAttribute("info", info);
%>


${info}
</body>
</html>