package com.gbank.data;

public class BankData {

	private String trHisNo; 		/* �ŷ�������ȣ */
	private String trState; 		/* ��,��ݿ���(�Ա� : D, ��� : W) */
	private String recvUserName; 	/* �����ڸ� */
	private String recvDebitNum; 	/* ������ ���¹�ȣ */
	private String recvDate; 		/* ���ų�¥ */
	private String callUserName;	/* �߽��ڸ� */
	private String callUserNum; 	/* �߽��� ���¹�ȣ */
	private int callRemittance;		/* �߽��� �۱ݾ�*/
	private int debitBalance; 		/* ������ �ܾ� */

	public String getTrState() {
		return trState;
	}

	public void setTrState(String trState) {
		this.trState = trState;
	}

	public String getTrHisNo() {
		return trHisNo;
	}

	public void setTrHisNo(String trHisNo) {
		this.trHisNo = trHisNo;
	}

	public String getRecvUserName() {
		return recvUserName;
	}

	public void setRecvUserName(String recvUserName) {
		this.recvUserName = recvUserName;
	}

	public String getRecvDebitNum() {
		return recvDebitNum;
	}

	public void setRecvDebitNum(String recvDebitNum) {
		this.recvDebitNum = recvDebitNum;
	}

	public String getRecvDate() {
		return recvDate;
	}

	public void setRecvDate(String recvDate) {
		this.recvDate = recvDate;
	}

	public String getCallUserName() {
		return callUserName;
	}

	public void setCallUserName(String callUserName) {
		this.callUserName = callUserName;
	}

	public String getCallUserNum() {
		return callUserNum;
	}

	public void setCallUserNum(String callUserNum) {
		this.callUserNum = callUserNum;
	}

	public int getCallRemittance() {
		return callRemittance;
	}

	public void setCallRemittance(int callRemittance) {
		this.callRemittance = callRemittance;
	}

	public int getDebitBalance() {
		return debitBalance;
	}

	public void setDebitBalance(int debitBalance) {
		this.debitBalance = debitBalance;
	}

	

}
