package DAO;

import java.sql.Connection;
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
	private final String select_One_Member="SELECT Id, account, password, realName, IdNumber, photo, email, authority, statusDescription, points, bankAccount, fiveStartsRank, nickname, to_char(CreatedDate,'yyyy-mm-dd') CreatedDate, to_char(UpdateDate,'yyyy-mm-dd') UpdateDate From MEMBERSHIP where id=";

	
	@Override
	public List<Membership> selectAll() {
		JNDI jndi = new JNDI();
		Connection conn = null;
		
		List<Membership> membership = new ArrayList<>();
		try {
			conn = jndi.init();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_All);

			while (rs.next()) {

				Membership mem = new Membership();
				mem.setId(rs.getInt(1));
				mem.setAccount(rs.getString(2));
				mem.setPassword(rs.getString(3));
				mem.setRealName(rs.getString(4));
				mem.setIdNumber(rs.getString(5));
				mem.setPhoto(rs.getByte(6));
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
		try {
			conn = jndi.init();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("");
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}

	}

	@Override
	public List<Membership> selectOneMember(String id) {

		Membership membership = null;
		JNDI jndi = new JNDI();
		Connection conn = null;
		List<Membership> oneMember = new ArrayList<>();
		
		try {
			conn = jndi.init();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_One_Member+id);
			while (rs.next()) {
				membership = new Membership();
				
				membership.setId(rs.getInt(1));
				membership.setAccount(rs.getString(2));
				membership.setPassword(rs.getString(3));
				membership.setRealName(rs.getString(4));
				membership.setIdNumber(rs.getString(5));
				membership.setPhoto(rs.getByte(6));
				membership.setEmail(rs.getString(7));
				membership.setAuthority(rs.getString(8));
				membership.setStatusDescription(rs.getString(9));
				membership.setPoints(rs.getInt(10));
				membership.setBankAccount(rs.getInt(11));
				membership.setFiveStartsRank(rs.getInt(12));
				membership.setNickname(rs.getString(13));
				membership.setCreatedDate(rs.getDate(14));
				membership.setUpdateDate(rs.getDate(15));
				
				oneMember.add(membership);
								
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
		try {
			conn = jndi.init();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("");
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jndi.close(conn);
		}

	}

}
