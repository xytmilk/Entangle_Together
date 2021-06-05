package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Membership;
import Util.JNDI;

public class MembershipDAO implements IMembershipDAO {

	//SQL命令
	private final String select_All = "select * from MEMBERSHIP";
	private final String select_One_Member="SELECT Id, account, password, realName, IdNumber, photo, email, authority, statusDescription, points, bankAccount, fiveStartsRank, nickname, to_char(CreatedDate,'yyyy-mm-dd') CreatedDate, to_char(UpdateDate,'yyyy-mm-dd') UpdateDate From MEMBERSHIP where id=?";
	private final String log_in_from_account="SELECT Id, account, password, realName, IdNumber, photo, email, authority, statusDescription, points, bankAccount, fiveStartsRank, nickname, to_char(CreatedDate,'yyyy-mm-dd') CreatedDate, to_char(UpdateDate,'yyyy-mm-dd') UpdateDate From MEMBERSHIP where account=?";
	private final String insert_in_to="insert into MEMBERSHIP(Id, account, password, realName, idNumber, photo, email, statusDescription, bankAccount, nickname, CreatedDate, UpdateDate) values (dis_id_seq.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)";
		
			
	@Override
	public List<Membership> selectAll() {
		JNDI jndi = new JNDI();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Membership> membership = new ArrayList<>();
		try {
			conn = jndi.init();
			pstmt = conn.prepareStatement(select_All);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
				Membership mem = new Membership();

				mem.setId(rs.getInt(1));
				mem.setAccount(rs.getString(2));
				mem.setPassword(rs.getString(3));
				mem.setRealName(rs.getString(4));
				mem.setIdNumber(rs.getString(5));
				mem.setPhoto(rs.getBytes(6));
				mem.setEmail(rs.getString(7));
				mem.setAuthority(rs.getString(8));
				mem.setStatusDescription(rs.getString(9));
				mem.setPoints(rs.getInt(10));
				mem.setBankAccount(rs.getInt(11));
				mem.setFiveStartsRank(rs.getInt(12));
				mem.setNickname(rs.getString(13));
				mem.setCreatedDate(rs.getDate(14));
				mem.setUpdateDate(rs.getDate(15));

				membership.add(mem);

			}
			System.out.println(membership);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}
		return membership;
		
	}

	@Override
	public void delete() {
		JNDI jndi = new JNDI();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = jndi.init();
			pstmt = conn.prepareStatement("");
			
			rs = pstmt.executeQuery();
			
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}

	}

	@Override
	public Membership selectOneMember(String id) {

		JNDI jndi = new JNDI();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Membership oneMember = null;
		
		try {
			conn = jndi.init();
			pstmt = conn.prepareStatement(select_One_Member);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				oneMember = new Membership();
				
				oneMember.setId(rs.getInt(1));
				oneMember.setAccount(rs.getString(2));
				oneMember.setPassword(rs.getString(3));
				oneMember.setRealName(rs.getString(4));
				oneMember.setIdNumber(rs.getString(5));
				oneMember.setPhoto(rs.getBytes(6));
				oneMember.setEmail(rs.getString(7));
				oneMember.setAuthority(rs.getString(8));
				oneMember.setStatusDescription(rs.getString(9));
				oneMember.setPoints(rs.getInt(10));
				oneMember.setBankAccount(rs.getInt(11));
				oneMember.setFiveStartsRank(rs.getInt(12));
				oneMember.setNickname(rs.getString(13));
				oneMember.setCreatedDate(rs.getDate(14));
				oneMember.setUpdateDate(rs.getDate(15));
				
								
			}
			System.out.println(rs.next());
			System.out.println("我是select_one_member的DAO，我有執行到");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}
		return oneMember;
	}

	@Override
	public void updateDate() {
		JNDI jndi = new JNDI();
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = jndi.init();			
			pstmt = conn.prepareStatement("");
			
			
			rs = pstmt.executeQuery();
			
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}

	}

	@Override
	public Membership logInFromAccount(String account){
		Membership membership = null;
		JNDI jndi = new JNDI();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = jndi.init();
			
			pstmt = conn.prepareStatement(log_in_from_account);
			
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				membership = new Membership();
				
				membership.setId(rs.getInt(1));
				membership.setAccount(rs.getString(2));
				membership.setPassword(rs.getString(3));
				membership.setRealName(rs.getString(4));
				membership.setIdNumber(rs.getString(5));
				//membership.setPhoto(rs.getByte(6));
				membership.setEmail(rs.getString(7));
				membership.setAuthority(rs.getString(8));
				membership.setStatusDescription(rs.getString(9));
				membership.setPoints(rs.getInt(10));
				membership.setBankAccount(rs.getInt(11));
				membership.setFiveStartsRank(rs.getInt(12));
				membership.setNickname(rs.getString(13));
				membership.setCreatedDate(rs.getDate(14));
				membership.setUpdateDate(rs.getDate(15));
				
								
			}
			System.out.println("我是log_in_from_account的DAO，我有執行到");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}
		return membership;
	}

	@Override
	public void insert(Membership membership) {
		JNDI jndi = new JNDI();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("我是DAO的insert,我有執行到");
		System.out.println("DAO的" + membership);
		
		try {
			conn = jndi.init();
			
			pstmt = conn.prepareStatement(insert_in_to);
			
			pstmt.setString(1, membership.getAccount());
			pstmt.setString(2, membership.getPassword());
			pstmt.setString(3, membership.getRealName());
			pstmt.setString(4, membership.getIdNumber());
			pstmt.setBytes(5, membership.getPhoto());
			pstmt.setString(6, membership.getEmail());
			pstmt.setString(7, membership.getStatusDescription());
			pstmt.setInt(8, membership.getBankAccount());
			pstmt.setString(9, membership.getNickname());
							 
			rs = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}
		
	}
	
	
	
	
}
