package com.gbank.data;

public class BankData {

	private String trHisNo; 		/* 거래내역번호 */
	private String trState; 		/* 입,출금여부(입금 : D, 출금 : W) */
	private String recvUserName; 	/* 수신자명 */
	private String recvDebitNum; 	/* 수신자 계좌번호 */
	private String recvDate; 		/* 수신날짜 */
	private String callUserName;	/* 발신자명 */
	private String callUserNum; 	/* 발신자 계좌번호 */
	private int callRemittance;		/* 발신자 송금액*/
	private int debitBalance; 		/* 수신자 잔액 */

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
