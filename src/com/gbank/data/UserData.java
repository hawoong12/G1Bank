package com.gbank.data;

public class UserData {


	
	private int	   userNo;					//���� ���� 
	private String userName;				//���� �̸� 
	private String userPhone;				//���� �� ��ȣ 
	private String userBirth;				//���� �������
	private String userStatus;				//���� ���� (����� : P, ���� : S, Ż�� : X)
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	

}
