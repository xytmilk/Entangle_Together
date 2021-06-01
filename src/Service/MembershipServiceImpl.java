package Service;

import DAO.IMembershipDAO;
import DAO.MembershipDAO;
import Entity.Membership;

public class MembershipServiceImpl implements IMembershipService {

	private IMembershipDAO memDAO = new MembershipDAO();
	@Override
	public void getData() {	}

	@Override
	public Membership addData(String account,String password, String realName, String idNumber, byte[] photo, String email, String statusDescription, int bankAccount, String nickname ) {
		Membership membership = new Membership();
		membership.setAccount(account);
		membership.setPassword(password);
		membership.setRealName(realName);
		membership.setIdNumber(idNumber);
		membership.setPhoto(photo);
		membership.setEmail(email);
		membership.setStatusDescription(statusDescription);
		membership.setBankAccount(bankAccount);
		membership.setNickname(nickname);
		
		System.out.println("�ڬOMembershipServiceImpl�A�ڦ������");
		System.out.println("�ڪ�membership�O" + membership);
		
		memDAO.insert(membership);
		
		return membership;
	}

}
