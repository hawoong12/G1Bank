package com.gbank.controller;

import com.gbank.data.BankData;
import com.gbank.data.DebitData;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BankController {

  BankData bd = new BankData();
  /*입금 출금 내역입력 컨트롤러*/
  public void depsitNWithdrawalHisController(ArrayList<DebitData> debitData,
      ArrayList<BankData> bankData, int deposit, int debitUniq, String hisType) {
    if (hisType == bd.DEPOSIT) {
      depsitHisInsert(debitData, bankData, deposit, debitUniq);
    } else if (hisType == bd.WITHDRAWAL) {
      withdrawalHisInsert(debitData, bankData, deposit, debitUniq);
    }
  }
  
  /*송금하기, 송금받기 내역입력 컨트롤러*/
  public void recvNcallRemittanceHisController(ArrayList<DebitData> debitData,
      ArrayList<BankData> bankData, int debitUniq, String userName, String bankName, String debitNum, int deposit, String hisType) {
    if (hisType == bd.RECV_REMITTANCE) {
        recvBankRemittanceHisInsert(debitData, bankData, debitUniq, userName, bankName, debitNum, deposit);

    } else if (hisType == bd.CALL_REMITTANCE) {
        callBankRemittanceHisInsert(debitData, bankData, debitUniq, userName, bankName, debitNum, deposit);
    }
  }
  
  /*입출금 내역 출력 컨트롤러*/
  public void depsWithHisPrintController(ArrayList<BankData> bankData, String debitNum) {
    //System.out.println("번호 / 계좌번호 / 거래유형 / 수신자명 / 수신자 계좌번호 / 수신자 은행코드 / ");
	String bankCodeName = null;
    for (int i = 0; i < bankData.size(); i++) {
      if (bankData.get(i).getUserDebitNum().equals(debitNum)) {
        BankData tempBD = bankData.get(i);
        if(tempBD.getTrState() != null) {
        	if (tempBD.getTrState().equals(bd.DEPOSIT)) {
        		bankCodeName = "입금";
            } else if (tempBD.getTrState().equals(bd.WITHDRAWAL)) {
            	bankCodeName = "출금";
            } else if (tempBD.getTrState().equals(bd.RECV_REMITTANCE)) {
            	bankCodeName = "송금받기";
            } else if (tempBD.getTrState().equals(bd.CALL_REMITTANCE)) {
            	bankCodeName = "송금하기";
            }
        	depsWithHisPrint(tempBD, bankCodeName);
        }
      }
    }
  }


  /*계좌 입금*/
  public void depositAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, int deposit) {
    //변수명은 길더라도 주석이 없이 이해할수 있게 AccountBalance 이런거 변수명보면 무슨뜻인지 이해가 안되니까
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, recvDebitNum));
    int accountBalance = debitData.get(debitUniq).getAccountBalance();
    int CalculateBalance = accountBalance + deposit;


    debitData.get(debitUniq).setAccountBalance(CalculateBalance);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "님의 계좌 잔고는 "
        + debitData.get(debitUniq).getAccountBalance() + " 원입니다.");

    depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.DEPOSIT);
  }

  /*계좌 출금*/
  public void WithdrawalAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String callDebitNum, int deposit) {
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, callDebitNum));
    int accountBalance = debitData.get(debitUniq).getAccountBalance();
    int CalculateBalance = accountBalance - deposit;


    if (!checkNegativeBalance(CalculateBalance)) {
      return;
    }
    debitData.get(debitUniq).setAccountBalance(accountBalance - deposit);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "님의 계좌 잔고는 "
        + debitData.get(debitUniq).getAccountBalance() + " 원입니다.");

    depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.WITHDRAWAL);
  }

  /*송금 받기*/
  public void recvBankRemittance(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, String callUserName, String callBankName, String callDebitNum, int deposit) {
	  int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, recvDebitNum));
      int accountBalance = debitData.get(debitUniq).getAccountBalance();
      int CalculateBalance = accountBalance + deposit;
      
      debitData.get(debitUniq).setAccountBalance(CalculateBalance);

      System.out.println(recvDebitNum + "님이 "
      		+ debitData.get(debitUniq).getDebitPhone() + "님에게 " + deposit + "원을 송금하였고 잔액은 "
              + debitData.get(debitUniq).getAccountBalance() + " 원입니다.");
      
      recvNcallRemittanceHisController(debitData, bankData, debitUniq, callUserName, callBankName, callDebitNum, deposit, bd.RECV_REMITTANCE);

  }

  /*송금 보내기*/
  public void callBankRemittance(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, String recvUserName, String recvBankName, String callDebitNum, int deposit) {
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, callDebitNum));
    int accountBalance = debitData.get(debitUniq).getAccountBalance();
    int CalculateBalance = accountBalance - deposit;

    
    if (!checkNegativeBalance(CalculateBalance)) {
        return;
    }
    
    debitData.get(debitUniq).setAccountBalance(CalculateBalance);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "님이 "
    		+ recvDebitNum + "님에게 " + deposit + "원을 송금하였고 잔액은 "
            + debitData.get(debitUniq).getAccountBalance() + " 원입니다.");
 
    
    recvNcallRemittanceHisController(debitData, bankData, debitUniq, recvUserName, recvBankName, callDebitNum, deposit, bd.CALL_REMITTANCE);
    
  }

  public String serchUserDebit(ArrayList<DebitData> debitData, int serchTyp, String serchData) {
    System.out.println("계좌 검색을 실행합니다.");
    for (int i = 0; i < debitData.size(); i++) {
      switch (serchTyp) {
        case 1: /*폰번호 -> 대표계좌 검색*/
          if (debitData.get(i).getDebitPhone().equals(serchData)) {
            System.out.println("폰번호로 대표계좌를 찾았습니다.");
            return debitData.get(i).getDebitNum();
          }
          break;
        case 2: /*계좌번호 -> 계좌번호순서*/
          if (debitData.get(i).getDebitNum().equals(serchData)) {
            System.out.println("계좌번호로 계좌번호 유니크 번호를 찾았습니다.");
            return i + "";
          }
          break;
        default:
          break;
      }
    }
    System.out.println("폰번호로 검색했으나 계좌가 존재하지 않습니다.");
    return null;
  }

  /*입금 히스토리 INSERT*/
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


  /*출금 히스토리 INSERT*/
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
  
  /*송금하기 히스토리 INSERT*/
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
  
  /*송금받기 히스토리 INSERT*/
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

  /*현재날짜 시간 리턴*/
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
      System.out.println("******잔액이 부족합니다.*******");
      return false;
    }
    return true;
  }
}
