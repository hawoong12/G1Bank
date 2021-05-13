package com.gbank.data;

public class DebitData {

  public final String G1_BANK = "000"; /* G1 BANK �����ڵ� */
  public final String SH_BANK = "001"; /* �������� �����ڵ� */
  public final String KB_BANK = "002"; /* �������� �����ڵ� */
  public final String HN_BANK = "003"; /* �ϳ����� �����ڵ� */
  public final String CT_BANK = "004"; /* ��Ƽ���� �����ڵ� */
  public final String KO_BANK = "005"; /* īī����ũ �����ڵ� */
  public final String K_BANK = "006";  /* ���̹�ũ �����ڵ� */
  public final String KD_BANK = "007"; /* ������� �����ڵ� */

  private int accountBalance;    // �����ܰ�
  private String debitNum;    // ���¹�ȣ
  private String bankNo;      // ���� ������ȣ
  private String debitName;    // ���� �̸�
  private String debitUserName;  // ���� �̸�
  private String debitPhone;    // ���¼����� ����ȣ (���� �����Ϳ� �̾����� PK)
  private String debitStatus;  // ������ ������ (��� : U, ���� : S, �̻�� : X)

  public DebitData() {
	  
  }
  
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

  public int getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(int accountBalance) {
    this.accountBalance = accountBalance;
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

  public String getDebitUserName() {
    return debitUserName;
  }

  public void setDebitUserName(String debitUserName) {
    this.debitUserName = debitUserName;
  }
}
