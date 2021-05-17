package com.gbank.controller;

import com.gbank.data.BankData;
import com.gbank.data.DebitData;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BankController {

  BankData bd = new BankData();
  /*�Ա� ��� �����Է� ��Ʈ�ѷ�*/
  public void depsitNWithdrawalHisController(ArrayList<DebitData> debitData,
      ArrayList<BankData> bankData, int deposit, int debitUniq, String hisType) {
    if (hisType == bd.DEPOSIT) {
      depsitHisInsert(debitData, bankData, deposit, debitUniq);
    } else if (hisType == bd.WITHDRAWAL) {
      withdrawalHisInsert(debitData, bankData, deposit, debitUniq);
    }
  }
  
  /*�۱��ϱ�, �۱ݹޱ� �����Է� ��Ʈ�ѷ�*/
  public void recvNcallRemittanceHisController(ArrayList<DebitData> debitData,
      ArrayList<BankData> bankData, int debitUniq, String userName, String bankName, String debitNum, int deposit, String hisType) {
    if (hisType == bd.RECV_REMITTANCE) {
        recvBankRemittanceHisInsert(debitData, bankData, debitUniq, userName, bankName, debitNum, deposit);

    } else if (hisType == bd.CALL_REMITTANCE) {
        callBankRemittanceHisInsert(debitData, bankData, debitUniq, userName, bankName, debitNum, deposit);
    }
  }
  
  /*����� ���� ��� ��Ʈ�ѷ�*/
  public void depsWithHisPrintController(ArrayList<BankData> bankData, String debitNum) {
    //System.out.println("��ȣ / ���¹�ȣ / �ŷ����� / �����ڸ� / ������ ���¹�ȣ / ������ �����ڵ� / ");
	String bankCodeName = null;
    for (int i = 0; i < bankData.size(); i++) {
      if (bankData.get(i).getUserDebitNum().equals(debitNum)) {
        BankData tempBD = bankData.get(i);
        if(tempBD.getTrState() != null) {
        	if (tempBD.getTrState().equals(bd.DEPOSIT)) {
        		bankCodeName = "�Ա�";
            } else if (tempBD.getTrState().equals(bd.WITHDRAWAL)) {
            	bankCodeName = "���";
            } else if (tempBD.getTrState().equals(bd.RECV_REMITTANCE)) {
            	bankCodeName = "�۱ݹޱ�";
            } else if (tempBD.getTrState().equals(bd.CALL_REMITTANCE)) {
            	bankCodeName = "�۱��ϱ�";
            }
        	depsWithHisPrint(tempBD, bankCodeName);
        }
      }
    }
  }


  /*���� �Ա�*/
  public void depositAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, int deposit) {
    //�������� ����� �ּ��� ���� �����Ҽ� �ְ� AccountBalance �̷��� �������� ���������� ���ذ� �ȵǴϱ�
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, recvDebitNum));
    int accountBalance = debitData.get(debitUniq).getAccountBalance();
    int CalculateBalance = accountBalance + deposit;


    debitData.get(debitUniq).setAccountBalance(CalculateBalance);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "���� ���� �ܰ�� "
        + debitData.get(debitUniq).getAccountBalance() + " ���Դϴ�.");

    depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.DEPOSIT);
  }

  /*���� ���*/
  public void WithdrawalAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String callDebitNum, int deposit) {
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, callDebitNum));
    int accountBalance = debitData.get(debitUniq).getAccountBalance();
    int CalculateBalance = accountBalance - deposit;


    if (!checkNegativeBalance(CalculateBalance)) {
      return;
    }
    debitData.get(debitUniq).setAccountBalance(accountBalance - deposit);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "���� ���� �ܰ�� "
        + debitData.get(debitUniq).getAccountBalance() + " ���Դϴ�.");

    depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.WITHDRAWAL);
  }

  /*�۱� �ޱ�*/
  public void recvBankRemittance(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, String callUserName, String callBankName, String callDebitNum, int deposit) {
	  int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, recvDebitNum));
      int accountBalance = debitData.get(debitUniq).getAccountBalance();
      int CalculateBalance = accountBalance + deposit;
      
      debitData.get(debitUniq).setAccountBalance(CalculateBalance);

      System.out.println(recvDebitNum + "���� "
      		+ debitData.get(debitUniq).getDebitPhone() + "�Կ��� " + deposit + "���� �۱��Ͽ��� �ܾ��� "
              + debitData.get(debitUniq).getAccountBalance() + " ���Դϴ�.");
      
      recvNcallRemittanceHisController(debitData, bankData, debitUniq, callUserName, callBankName, callDebitNum, deposit, bd.RECV_REMITTANCE);

  }

  /*�۱� ������*/
  public void callBankRemittance(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, String recvUserName, String recvBankName, String callDebitNum, int deposit) {
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, callDebitNum));
    int accountBalance = debitData.get(debitUniq).getAccountBalance();
    int CalculateBalance = accountBalance - deposit;

    
    if (!checkNegativeBalance(CalculateBalance)) {
        return;
    }
    
    debitData.get(debitUniq).setAccountBalance(CalculateBalance);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "���� "
    		+ recvDebitNum + "�Կ��� " + deposit + "���� �۱��Ͽ��� �ܾ��� "
            + debitData.get(debitUniq).getAccountBalance() + " ���Դϴ�.");
 
    
    recvNcallRemittanceHisController(debitData, bankData, debitUniq, recvUserName, recvBankName, callDebitNum, deposit, bd.CALL_REMITTANCE);
    
  }

  public String serchUserDebit(ArrayList<DebitData> debitData, int serchTyp, String serchData) {
    System.out.println("���� �˻��� �����մϴ�.");
    for (int i = 0; i < debitData.size(); i++) {
      switch (serchTyp) {
        case 1: /*����ȣ -> ��ǥ���� �˻�*/
          if (debitData.get(i).getDebitPhone().equals(serchData)) {
            System.out.println("����ȣ�� ��ǥ���¸� ã�ҽ��ϴ�.");
            return debitData.get(i).getDebitNum();
          }
          break;
        case 2: /*���¹�ȣ -> ���¹�ȣ����*/
          if (debitData.get(i).getDebitNum().equals(serchData)) {
            System.out.println("���¹�ȣ�� ���¹�ȣ ����ũ ��ȣ�� ã�ҽ��ϴ�.");
            return i + "";
          }
          break;
        default:
          break;
      }
    }
    System.out.println("����ȣ�� �˻������� ���°� �������� �ʽ��ϴ�.");
    return null;
  }

  /*�Ա� �����丮 INSERT*/
  public void depsitHisInsert(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      int deposit, int debitUniq) {

    BankData tempBankData = new BankData(debitUniq + ""
        , depsWithdHisCount(debitData, bankData, debitUniq) + ""
        , debitData.get(debitUniq).getDebitNum()
        , bd.DEPOSIT
        , debitData.get(debitUniq).getDebitUserName()
        , debitData.get(debitUniq).getDebitNum()
        , debitData.get(debitUniq).getBankNo()
        , dateReturnToString()
        , ""
        , ""
        , ""
        , deposit
        , debitData.get(debitUniq).getAccountBalance());

    bankData.add(tempBankData);
  }


  /*��� �����丮 INSERT*/
  public void withdrawalHisInsert(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      int deposit, int debitUniq) {

    BankData tempBankData = new BankData(debitUniq + ""
        , depsWithdHisCount(debitData, bankData, debitUniq) + ""
        , debitData.get(debitUniq).getDebitNum()
        , bd.WITHDRAWAL
        , ""
        , ""
        , ""
        , dateReturnToString()
        , debitData.get(debitUniq).getDebitUserName()
        , debitData.get(debitUniq).getDebitNum()
        , debitData.get(debitUniq).getBankNo()
        , deposit
        , debitData.get(debitUniq).getAccountBalance());

    bankData.add(tempBankData);
  }
  
  /*�۱��ϱ� �����丮 INSERT*/
  public void callBankRemittanceHisInsert(ArrayList<DebitData> debitData, ArrayList<BankData> bankData
	      , int debitUniq, String recvUserName, String recvBankName, String recvDebitNum, int deposit) {

	  BankData tempBankData = new BankData(debitUniq + ""
        , depsWithdHisCount(debitData, bankData, debitUniq) + ""
        , debitData.get(debitUniq).getDebitNum()
        , bd.CALL_REMITTANCE
        , recvUserName
        , recvDebitNum
        , recvBankName
        , dateReturnToString()
        , debitData.get(debitUniq).getDebitUserName()
        , debitData.get(debitUniq).getDebitNum()
        , debitData.get(debitUniq).getBankNo()
        , deposit
        , debitData.get(debitUniq).getAccountBalance());

    bankData.add(tempBankData);
  }
  
  /*�۱ݹޱ� �����丮 INSERT*/
  public void recvBankRemittanceHisInsert(ArrayList<DebitData> debitData, ArrayList<BankData> bankData
	      , int debitUniq, String callUserName, String callBankName, String callDebitNum, int deposit) {

	  BankData tempBankData = new BankData(debitUniq + ""
        , depsWithdHisCount(debitData, bankData, debitUniq) + ""
        , debitData.get(debitUniq).getDebitNum()
        , bd.RECV_REMITTANCE
        , debitData.get(debitUniq).getDebitUserName()
        , debitData.get(debitUniq).getDebitNum()
        , debitData.get(debitUniq).getBankNo()
        , dateReturnToString()
        , callUserName
        , callDebitNum
        , callBankName
        , deposit
        , debitData.get(debitUniq).getAccountBalance());

    bankData.add(tempBankData);
  }

  public int depsWithdHisCount(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      int debitUniq) {
    int bankCnt = 0;
    for (int i = 0; i < bankData.size(); i++) {
      if (bankData.get(i).getUserDebitNum().equals(debitData.get(debitUniq).getDebitNum())) {
        bankCnt++;
      }
    }
    return bankCnt;
  }

  /*���糯¥ �ð� ����*/
  public String dateReturnToString() {
    Date date = new Date();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        .withZone(ZoneId.systemDefault());
    String dateToStr = format.format(date.toInstant());

    return dateToStr;
  }

  public void depsWithHisPrint(BankData bankData, String bankCodeName){
	  System.out.println(bankData.getTrHisNo() + " / " + bankData.getRecvDebitNum() + " / " + bankData
		        .getUserDebitNum() + " / "
		        + bankCodeName + " / " + bankData.getRecvUserName() + " / "
		        + " / " + bankData.getRecvBankName() + " / " + bankData.getCallUserName() + " / " + bankData
		        .getCallDebitNum()
		        + " / " + bankData.getCallBankName() + " / " + bankData.getCallRemittance() + " / "
		        + bankData.getAccountBalance());
  }
  
 
  public boolean checkNegativeBalance(int cash) {
    if (cash < 0) {
      System.out.println("******�ܾ��� �����մϴ�.*******");
      return false;
    }
    return true;
  }
}
