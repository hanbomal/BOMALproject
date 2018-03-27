package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.msk.Action;

import studygroup.RelationDAO;
import studygroup.StudyDAO;
import studygroup.StudyVO;

public class PageController extends Action {
	public void autoComplete(HttpServletRequest req) throws Throwable{
		StudyDAO studyDB = StudyDAO.getInstance();
		//auto_complete
		List<StudyVO> allList=studyDB.getAllStudy();
		String nameList="";
		for(StudyVO study: allList){
			nameList+="\""+study.getStudyName()+"\",";	 
		}
		req.setAttribute("nameList", nameList);
	}
	
	
	public String main(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		autoComplete(req);
		//search_studyRoom
		StudyDAO studyDB = StudyDAO.getInstance();
		String studyName = req.getParameter("studyName");
		String reqNum = req.getParameter("reqNum");
		if (reqNum == null) {
			reqNum = "";
		}
		if(studyName==null) {
			studyName="defaultName";
		}
		//검색 결과에따라서 리스트가 달라지게끔
/*		List<StudyVO> li=studyDB.resultList(studyName);
		List<String> status = studyDB.getStatus(studyName, "gon");
		
		GroupInfo group= new GroupInfo();
		group.setStudy(li);
		group.setStatus(status);
*/
		List<StudyVO> group=studyDB.resultList(studyName,getSessionId(req));
		req.setAttribute("group", group);
		return "/view/main.jsp";
	}


	public void requestJoin(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		String reqNum = req.getParameter("reqNum");
		String studyName = req.getParameter("studyName");
		String leader=req.getParameter("leader");
		if (reqNum == null) {
			reqNum = "0";
		}
		// reqNum을 받아왔을 때, relation 테이블에 추가
		RelationDAO dbPro = RelationDAO.getInstance();
		if (reqNum.equals("1")) {
			dbPro.requestJoin(getSessionId(req), studyName,"member_nick","회원",leader);
		}
	}

	public String cancelJoin(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		String delNum = req.getParameter("delNum");
		String studyName = req.getParameter("studyName");
		if (delNum == null) {
			delNum = "";
		}
		// delNum을 받아왔을 때, relation 테이블에 삭제
		RelationDAO dbPro = RelationDAO.getInstance();
		if (delNum.equals("1")) {
			dbPro.cancelJoin(getSessionId(req), studyName);
		}
		res.sendRedirect(req.getContextPath() + "/page/main");
		return null;
	}

	public String about(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "/view/about.jsp";
	}

	public String test(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "/view/study_test.jsp";
	}

	public String study_board(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "/view/study_board.jsp";
	}

	public String study_album(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "/view/study_album.jsp";
	}

	public String study_making(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "/view/study_making.jsp";
	}
	public String getSessionId(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String memberid=(String) session.getAttribute("memberid");
		return memberid;
	}
	
	public String makingPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		
		
		String realFolder = "";
		String encType = "utf-8";
		int maxSize = 10 * 1024 * 1024;
		ServletContext context = req.getServletContext();
		realFolder = context.getRealPath("fileSave");
		MultipartRequest multi = null;
		multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();

		String[] filename = new String[2];
		File[] file = new File[2];
		int index = 0;

		while (files.hasMoreElements()) {
			String name = (String) files.nextElement();
			System.out.println(index + ";" + name);

			filename[index] = multi.getFilesystemName(name);
			System.out.println(multi.getContentType(name));
			file[index] = multi.getFile(name);
			index++;
		}

		StudyVO room = new StudyVO();
		room.setStudyName(multi.getParameter("studyName"));
		room.setPeopleCount(1);
		room.setLeader(getSessionId(req));
		room.setStudy_intro(multi.getParameter("study_intro"));

		if (file[0] != null) {
			room.setStudy_pro(filename[0]);
			room.setProSize((int) file[0].length());
		} else {
			room.setStudy_pro("");
			room.setProSize(0);
		}
		if (file[1] != null) {
			room.setStudy_back(filename[1]);
			room.setBackSize((int) file[1].length());
		} else {
			room.setStudy_back("");
			room.setBackSize(0);
		}

		// filename =0이 background
		// =1 은 profile

		StudyDAO dbPro = StudyDAO.getInstance();
		dbPro.makingStudy(room);
		res.sendRedirect(req.getContextPath() + "/page/main");
		return null;
	}

}
