package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import member.MemberVO;;

public class MemberDAO {

	
		// 싱글턴
		private static MemberDAO instance = new MemberDAO();
		private String id;
		private MemberDAO() {
			
		} 
		
		public static MemberDAO getInstance() {
			return instance;
		}
		// 싱클턴 end.
		
		// 데이터베이스 연결 가져오기
		public static Connection getConnection() {
			Connection conn = null;
			try {
				String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
				String dbId = "scott";
				String dbpwd = "tiger";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(jdbcUrl, dbId, dbpwd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		// Close
		public void close (Connection conn, ResultSet rs, PreparedStatement pstmt) {
			if(conn!=null) try {conn.close();} catch(SQLException ex) {}
			if(rs!=null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
		}
		
		// 회원가입 (추가) 메소드
		public void insertMember(MemberVO member) {
			String sql="";
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int number=0;
			try {
				pstmt = conn.prepareStatement("select memberSer.nextval from dual");
				rs = pstmt.executeQuery();
				if (rs.next())
					number = rs.getInt(1) + 1;
				else number = 1;
				
				sql = "insert into member(num,listid, memberid, passwd, nickname, joindate, lastdate)";
				sql += "values(?,?,?,?,?, sysdate, sysdate)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, number);
				pstmt.setString(2, member.getListid());
				pstmt.setString(3, member.getMemberid());
				pstmt.setString(4, member.getPasswd());
				pstmt.setString(5, member.getNickname());
				
				
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(conn, rs, pstmt);
			}
			
		}
		
		// 회원 수 메소드
		public int getMemberCount(String listid) throws SQLException {
			int x = 0;
			String sql = "SELECT nvl(count(*),0) FROM member WHERE listid = ?";
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int number = 0;
			
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, listid);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { x = rs.getInt(1); }
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, rs, pstmt);
			}
			
			return x;
		}
		
		// 회원리스트 목록출력 메소드
		public List getMembers(int startRow, int endRow, String listid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List memberList = null;
			String sql = "";
			try {
				conn = getConnection();
				sql = "select * from (select rownum rnum, a.* from (select num, memberid, passwd, nickname, joindate, lastdate from member where listid = ?)"
						+ " a) where rnum between ? and ? order by joindate desc";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, listid);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					memberList = new ArrayList();
				
					do { 
						MemberVO member = new MemberVO();
						member.setNum(rs.getInt("num"));
						member.setMemberid(rs.getString("memberid"));
						member.setPasswd(rs.getString("passwd"));
						member.setNickname(rs.getString("nickname"));
						member.setJoindate(rs.getTimestamp("joindate"));
						member.setLastdate(rs.getTimestamp("lastdate"));
						memberList.add(member);
					} while (rs.next()); 
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				close(conn, rs, pstmt);
			}
			return memberList;
			
		}
		public MemberVO getMember(String memberid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVO member = null;
			String sql = "";
			try {
				conn = getConnection();
				sql="select * from member where memberid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberid);
				rs=pstmt.executeQuery();
				
				member = new MemberVO();
				if(rs.next()) {
					member.setMemberid(rs.getString("memberid"));
					member.setNickname(rs.getString("nickname"));
					member.setPasswd(rs.getString("passwd"));
					member.setLastdate(rs.getTimestamp("lastdate"));
					member.setJoindate(rs.getTimestamp("joindate"));
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, rs, pstmt);
			}
		
			return member;
			
		}
		
		
		// 회원 수정할때 정보 불러오기
		public MemberVO getmember(String id, String passwd) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			 MemberVO member = null;
			String sql = "";
			try {
				conn = getConnection();
				sql="select * from member where id = ? and passwd = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, passwd);
				rs=pstmt.executeQuery();
				
				member = new MemberVO();
				if(rs.next()) {
					member.setNum(rs.getInt("num"));
					member.setMemberid(rs.getString("memberid"));
					member.setPasswd(rs.getString("passwd"));
					member.setNickname(rs.getString("nickname"));
					member.setJoindate(rs.getTimestamp("joindate"));
					member.setLastdate(rs.getTimestamp("lastdate"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, rs, pstmt);
			}
		
			return member;
			
		}
		
		

		
		
	    
	    public int deleteMember (String memberid, String passwd) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "delete from member where memberid=? and passwd=?";
			int x = -1;
			try { 
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberid);
				pstmt.setString(2, passwd);
				x=pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				close(conn, rs, pstmt);
			}
			return x;
		}
	    
	    public int updateMember (MemberVO member) {
			String sql ="";
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			int chk= 0; 
			
			try {
				conn = getConnection();
				sql = "update member set memberid=?, nickname=?, passwd=? where num=?";
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, member.getMemberid());
				pstmt.setString(2, member.getNickname());
				pstmt.setString(3, member.getPasswd());
				pstmt.setInt(4, member.getNum());
				
				
				chk = pstmt.executeUpdate(); //컬럼이 업데이트가 되었을때 숫자를 반환
				/*pstmt.executeUpdate(); <- 썼던거.*/

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn, null, pstmt);
			}
			return chk;
			
		}
	    
		 
	   
	}

