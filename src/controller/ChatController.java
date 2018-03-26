package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.msk.Action;

import calendar.CalendarDAO;
import calendar.CalendarVO;

public class ChatController  extends Action {

	
 public String intro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		

 
 return "/chat/websocketGroup.jsp";

}     
	        
	
	
}
