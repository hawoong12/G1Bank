package com.gbank.data;

public class BankData {

  public final String DEPOSIT = "00";  /* �Ա� �ڵ� */
  public final String WITHDRAWAL = "01";  /* ��� �ڵ� */
  public final String RECV_REMITTANCE = "02"; /* �۱� �ޱ� */
  public final String CALL_REMITTANCE = "03"; /* �۱� ������ */


  private String debitUniq;    /* ���� ����ũ ��ȣ */
  private String trHisNo;    /* �ŷ�������ȣ */
  private String userDebitNum;  /* ���� ������ ���¹�ȣ */
  private String trState;    /* ��,����ڵ� */
  private String recvUserName;  /* �����ڸ� */
  private String recvDebitNum;  /* ������ ���¹�ȣ */
  private String recvBankName;  /* ������ �����ڵ� */
  private String recvDate;    /* ���ų�¥ */
  private String callUserName;  /* �߽��ڸ� */
  private String callDebitNum;  /* �߽��� ���¹�ȣ */
  private String callBankName;  /* �߽��� �����ڵ� */
  private int callRemittance;    /* �߽��� �۱ݾ� */
  private int debitBalance;    /* ������ �ܾ� */

  public BankData() {
  }

  public BankData(String debitUniq, String trHisNo, String userDebitNum, String trState,
      String recvUserName
      , String recvDebitNum, String recvBankName, String recvDate, String callUserName,
      String callDebitNum
      , String callBankName, int callRemittance, int debitBalance) {
    this.debitUniq = debitUniq;
    this.trHisNo = trHisNo;
    this.userDebitNum = userDebitNum;
    this.trState = trState;
    this.recvUserName = recvUserName;
    this.recvDebitNum = recvDebitNum;
    this.recvBankName = recvBankName;
    this.recvDate = recvDate;
    this.callUserName = callUserName;
    this.callDebitNum = callDebitNum;
    this.callBankName = callBankName;
    this.callRemittance = callRemittance;
    this.debitBalance = debitBalance;
  }

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

  public String getDebitUniq() {
    return debitUniq;
  }

  public void setDebitUniq(String debitUniq) {
    this.debitUniq = debitUniq;
  }

  public String getCallDebitNum() {
    return callDebitNum;
  }

  public void setCallDebitNum(String callDebitNum) {
    this.callDebitNum = callDebitNum;
  }

  public String getRecvBankName() {
    return recvBankName;
  }

  public void setRecvBankName(String recvBankName) {
    this.recvBankName = recvBankName;
  }

  public String getCallBankName() {
    return callBankName;
  }

  public void setCallBankName(String callBankName) {
    this.callBankName = callBankName;
  }

  public String getUserDebitNum() {
    return userDebitNum;
  }

  public void setUserDebitNum(String userDebitNum) {
    this.userDebitNum = userDebitNum;
  }


}
