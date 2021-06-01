package Service;

import Entity.Membership;

public interface IMembershipService {
		
	public void getData();//跟DAO取得全部資料
	//把新增資料放入DAO
	public Membership addData(String account, String password, String realName, String IdNumber, byte[] photo, String Email,
			String statusDescription, int bankAccount, String nickname);
	
	
	
}
