package com.gbank.data;

public class DebitData {
	
	private int		debitNo;			//���� ������ȣ
	private int 	debitNum;			//���¹�ȣ 
	private int 	debitBalance;		//�����ܰ� 
	private String  debitName;			//���� �̸� 
	private String 	debitPhone;			//���¼����� ����ȣ (���� �����Ϳ� �̾����� PK)
	private String  debitStatus;		//������ ������ (��� : U, ���� : S, �̻�� : X)
	

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
