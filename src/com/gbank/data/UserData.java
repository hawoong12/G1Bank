package com.gbank.data;

public class UserData {


	
	private int	   userNo;					//가입 순서 
	private String userName;				//유저 이름 
	private String userPhone;				//유저 폰 번호 
	private String userBirth;				//유저 생년월일
	private String userStatus;				//유저 상태 (사용중 : P, 정지 : S, 탈퇴 : X)
	
	
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
