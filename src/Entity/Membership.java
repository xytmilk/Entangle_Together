package Entity;

public class Membership {

	private int Id;// 1
	private String account;// 2
	private String Password;// 3
	private String realName;// 4
	private String IdNumber;// 5
	private byte photo;// 6
	private String Email;// 7
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
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdNumber() {
		return IdNumber;
	}

	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
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
		return "Membership [Id=" + Id + ", account=" + account + ", Password=" + Password + ", realName=" + realName
				+ ", IdNumber=" + IdNumber + ", photo=" + photo + ", Email=" + Email + ", authority=" + authority
				+ ", statusDescription=" + statusDescription + ", points=" + points + ", bankAccount=" + bankAccount
				+ ", fiveStartsRank=" + fiveStartsRank + ", nickname=" + nickname + ", CreatedDate=" + CreatedDate
				+ ", UpdateDate=" + UpdateDate + "]";
	}



	
}
