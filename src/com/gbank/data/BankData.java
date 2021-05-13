package com.gbank.data;

public class BankData {

  public final String DEPOSIT = "00";  /* 입금 코드 */
  public final String WITHDRAWAL = "01";  /* 출금 코드 */
  public final String RECV_REMITTANCE = "02"; /* 송금 받기 */
  public final String CALL_REMITTANCE = "03"; /* 송금 보내기 */


  private String debitUniq;    /* 계좌 유니크 번호 */
  private String trHisNo;    /* 거래내역번호 */
  private String userDebitNum;  /* 계좌 소유자 계좌번호 */
  private String trState;    /* 입,출금코드 */
  private String recvUserName;  /* 수신자명 */
  private String recvDebitNum;  /* 수신자 계좌번호 */
  private String recvBankName;  /* 수신자 은행코드 */
  private String recvDate;    /* 수신날짜 */
  private String callUserName;  /* 발신자명 */
  private String callDebitNum;  /* 발신자 계좌번호 */
  private String callBankName;  /* 발신자 은행코드 */
  private int callRemittance;    /* 발신자 송금액 */
  private int debitBalance;    /* 수신자 잔액 */

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
