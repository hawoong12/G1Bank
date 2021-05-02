package com.gbank.data;

public class DebitData {
	
	public final static String G1_BANK 	= "000"; /*G1 BANK �����ڵ�*/
	public final static String SH_BANK 	= "001"; /*�������� �����ڵ�*/
	public final static String KB_BANK 	= "002"; /*�������� �����ڵ�*/
	public final static String HN_BANK 	= "003"; /*�ϳ����� �����ڵ�*/
	public final static String CT_BANK 	= "004"; /*��Ƽ���� �����ڵ�*/
	public final static String KO_BANK 	= "005"; /*īī����ũ �����ڵ�*/
	public final static String K_BANK 	= "006"; /*���̹�ũ �����ڵ�*/
	public final static String KD_BANK 	= "007"; /*������� �����ڵ�*/

	
	private int 	debitBalance;		//�����ܰ� 
	private String 	debitNum;			//���¹�ȣ 
	private String	bankNo;				//���� ������ȣ		
	private String  debitName;			//���� �̸� 
	private String 	debitPhone;			//���¼����� ����ȣ (���� �����Ϳ� �̾����� PK)
	private String  debitStatus;		//������ ������ (��� : U, ���� : S, �̻�� : X)
	

	public String getDebitStatus() {
		return debitStatus;
	}
	public void setDebitStatus(String debitStatus) {
		this.debitStatus = debitStatus;
	}

	public String getDebitNum() {
		return debitNum;
	}
	public void setDebitNum(String debitNum) {
		this.debitNum = debitNum;
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
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
}
