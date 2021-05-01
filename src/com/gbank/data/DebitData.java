package com.gbank.data;

public class DebitData {
	
	private int		debitNo;			//계좌 고유번호
	private int 	debitNum;			//계좌번호 
	private int 	debitBalance;		//계좌잔고 
	private String  debitName;			//계좌 이름 
	private String 	debitPhone;			//계좌소유자 폰번호 (유저 데이터와 이어지는 PK)
	private String  debitStatus;		//계좌의 현상태 (사용 : U, 정지 : S, 미사용 : X)
	

	public String getDebitStatus() {
		return debitStatus;
	}
	public void setDebitStatus(String debitStatus) {
		this.debitStatus = debitStatus;
	}

	public int getDebitNum() {
		return debitNum;
	}
	public void setDebitNum(int debitNum) {
		this.debitNum = debitNum;
	}

	public int getDebitNo() {
		return debitNo;
	}
	public void setDebitNo(int debitNo) {
		this.debitNo = debitNo;
	}

	public int getDebitBalance() {
		return debitBalance;
	}

	public void setDebitBalance(int debitBalance) {
		this.debitBalance = debitBalance;
	}
	public String getDebitName() {
		return debitName;
	}

	public void setDebitName(String debitName) {
		this.debitName = debitName;
	}

	public String getDebitPhone() {
		return debitPhone;
	}
	public void setDebitPhone(String debitPhone) {
		this.debitPhone = debitPhone;
	}
}
