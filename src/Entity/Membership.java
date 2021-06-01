package Entity;

import java.io.InputStream;
import javax.servlet.http.Part;

public class Membership {

	private int Id;// 1
	private String account;// 2
	private String password;// 3
	private String realName;// 4
	private String idNumber;// 5
	private byte[] photo;// 6
	private String email;// 7
	private String authority;// 8
	private String statusDescription;// 9
	private int points;// 10
	private int bankAccount;// 11
	private int fiveStartsRank;// 12
	private String nickname;// 13
	private java.sql.Date CreatedDate;// 14
	private java.sql.Date UpdateDate;// 15

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getFiveStartsRank() {
		return fiveStartsRank;
	}

	public void setFiveStartsRank(int fiveStartsRank) {
		this.fiveStartsRank = fiveStartsRank;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public java.sql.Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		CreatedDate = createdDate;
	}

	public java.sql.Date getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		UpdateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Membership [Id=" + Id + ", account=" + account + ", Password=" + password + ", realName=" + realName
				+ ", IdNumber=" + idNumber + ", photo=" + photo + ", Email=" + email + ", authority=" + authority
				+ ", statusDescription=" + statusDescription + ", points=" + points + ", bankAccount=" + bankAccount
				+ ", fiveStartsRank=" + fiveStartsRank + ", nickname=" + nickname + ", CreatedDate=" + CreatedDate
				+ ", UpdateDate=" + UpdateDate + "]";
	}



	
}
