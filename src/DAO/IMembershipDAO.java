package DAO;

import java.util.List;

import Entity.Membership;

public interface IMembershipDAO {
	
	public List<Membership> selectAll();
	public void delete();
	public Membership selectOneMember(String id);
	public void updateDate();
	public Membership logInFromAccount(String account);
	public void insert(Membership membership);
}
