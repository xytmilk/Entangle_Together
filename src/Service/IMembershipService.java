package Service;

import Entity.Membership;

public interface IMembershipService {
		
	public void getData();//��DAO���o�������
	//��s�W��Ʃ�JDAO
	public Membership addData(String account, String password, String realName, String IdNumber, byte[] photo, String Email,
			String statusDescription, int bankAccount, String nickname);
	
	
	
}
