package studygroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;

public class StudyDAO extends MybatisConnector{
	private static StudyDAO instance = new StudyDAO();
	private StudyDAO() {
	}
	public static StudyDAO getInstance() {
		return instance;
	}
    private final String namespace="study";
    SqlSession sqlSession;
    
	public void makingStudy(StudyVO room) {
		sqlSession=sqlSession();
		int num=sqlSession.selectOne(namespace+".getNextNum");
		room.setNum(num);
		sqlSession.insert(namespace+".makingStudy",room);
		sqlSession.commit();
		sqlSession.close();
	}
	public List resultList(String studyName) {
		sqlSession=sqlSession();
		Map<String,String> map = new HashMap<>();
		map.put("studyName", studyName);
		List li=sqlSession.selectList(namespace+".resultList",map);
		sqlSession.close();
		return li;
	}
	public String getStatus(String correctName,String memberId ) {
		sqlSession=sqlSession();
		Map<String,String> map = new HashMap<>();
		map.put("studyName", correctName);
		map.put("memberId", memberId);
		String status=sqlSession.selectOne(namespace+".getStatus",map);
		sqlSession.close();
		return status;
	}
	
	public List getAllStudy() {
		sqlSession=sqlSession();
		List li=sqlSession.selectList(namespace+".getAllStudy");
		sqlSession.close();
		return li;
	}
}
