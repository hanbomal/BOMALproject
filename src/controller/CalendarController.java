package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import calendar.CalendarDAO;
import calendar.CalendarVO;

public class CalendarController  extends Action {
	public String listview(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		
			CalendarDAO cpro=CalendarDAO.getInstance();
			
	        
			List li  = null;
			
			li=	cpro.getCalendarList(1);	//임의로 1로 해놓음
			
			
			
	       req.setAttribute("list", li);
	        
	        return "/calendar/study_calendar.jsp";}
	  
	public String test(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		
		CalendarDAO cpro=CalendarDAO.getInstance();
		
        
		List li  = null;
		
		li=	cpro.getCalendarList(1);	//임의로 1로 해놓음
		
		System.out.println(li);
		
       req.setAttribute("list", li);
        
        return "/calendar/study_calendar2.jsp";}
  
	
    public String addPro1(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		
    	CalendarDAO cpro=CalendarDAO.getInstance();
    	CalendarVO calendar=new CalendarVO();
    	
    	calendar.setTitle(req.getParameter("title"));
    	if(req.getParameter("description")!=null) {
    	calendar.setDescription(req.getParameter("description"));
    	}else {
    		calendar.setDescription("");
    	}
    	if(req.getParameter("place")!=null) {
    		calendar.setPlace(req.getParameter("place"));
        	}else {
        		calendar.setPlace("");
        	}
        	
    	calendar.setStartdate(req.getParameter("startdate"));
    	calendar.setEnddate(req.getParameter("enddate"));
    	calendar.setStudynum(1);	//임의로 1로 해놓음
    	
    	cpro.addCalendar(calendar);
    	System.out.println(calendar);
    	
        
        return "/calendar/addComp.jsp";}
	  
    
    
        public String contents(HttpServletRequest req, HttpServletResponse res) throws Throwable {
    		
        	  String id = req.getParameter("id");
        	  CalendarDAO cpro=CalendarDAO.getInstance();
        	  CalendarVO calendar=cpro.getCalendar(id);
        	  req.setAttribute("calendar",calendar); 
        	
            
            return "/calendar/contentsView.jsp";
        
}
	        
	       
	        
	
	
}
