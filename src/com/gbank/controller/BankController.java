package com.gbank.controller;

import com.gbank.data.BankData;
import com.gbank.data.DebitData;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BankController {

  BankData bd = new BankData();

  /*계좌 입금*/
  public void depositAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, int deposit) {
    //변수명은 길더라도 주석이 없이 이해할수 있게 debitBalance 이런거 변수명보면 무슨뜻인지 이해가 안되니까
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, recvDebitNum));
    int debitBalance = debitData.get(debitUniq).getDebitBalance();

    debitData.get(debitUniq).setDebitBalance(debitBalance + deposit);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "님의 계좌 잔고는 "
        + debitData.get(debitUniq).getDebitBalance() + " 원입니다.");

    depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.DEPOSIT);
  }

  /*계좌 출금*/
  public void WithdrawalAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String callDebitNum, int deposit) {
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, callDebitNum));
    int debitBalance = debitData.get(debitUniq).getDebitBalance();

    if (!checkBalance(debitBalance - deposit)) {
      return;
    }
    debitData.get(debitUniq).setDebitBalance(debitBalance - deposit);
    System.out.println(debitData.get(debitUniq).getDebitPhone() + "님의 계좌 잔고는 "
        + debitData.get(debitUniq).getDebitBalance() + " 원입니다.");

    depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.WITHDRAWAL);
  }

  /*송금 받기*/
  public void recvBanking(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, String callDebitNum, int deposit) {

  }

  /*송금 보내기*/
  public void callBanking(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      String recvDebitNum, String callDebitNum, int deposit) {
    int debitUniq = Integer.parseInt(serchUserDebit(debitData, 2, callDebitNum));
    int debitBalance = debitData.get(debitUniq).getDebitBalance();
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

  public void depsitNWithdrawalHisController(ArrayList<DebitData> debitData,
      ArrayList<BankData> bankData, int deposit, int debitUniq, String hisType) {
    if (hisType == bd.DEPOSIT) {
      depsitHisInsert(debitData, bankData, deposit, debitUniq);
    } else if (hisType == bd.WITHDRAWAL) {
      withdrawalHisInsert(debitData, bankData, deposit, debitUniq);
    } else if (hisType == bd.RECV_REMITTANCE) {

    } else if (hisType == bd.CALL_REMITTANCE) {

    }
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
        , debitData.get(debitUniq).getDebitBalance());

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
        , debitData.get(debitUniq).getDebitBalance());

    bankData.add(tempBankData);
  }

  public int depsWithdHisCount(ArrayList<DebitData> debitData, ArrayList<BankData> bankData,
      int debitUniq) {
    int bankCnt = 0;
    for (int i = 0; i < bankData.size(); i++) {
      if (bankData.get(i).getRecvDebitNum().equals(debitData.get(debitUniq).getDebitNum())) {
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

  /*입출금 내역 출력 컨트롤러*/
  public void depsWithHisPrintController(ArrayList<BankData> bankData, String debitNum) {
    //System.out.println("번호 / 계좌번호 / 거래유형 / 수신자명 / 수신자 계좌번호 / 수신자 은행코드 / ");
    for (int i = 0; i < bankData.size(); i++) {
      if (bankData.get(i).getUserDebitNum().equals(debitNum)) {
        BankData tempBD = bankData.get(i);
        if (tempBD.getTrState().equals(bd.DEPOSIT)) {
          depositHisPrint(tempBD);
        } else if (tempBD.getTrState().equals(bd.WITHDRAWAL)) {
          withdrawalHisPrint(tempBD);
        } else if (tempBD.getTrState().equals(bd.RECV_REMITTANCE)) {

        } else if (tempBD.getTrState().equals(bd.CALL_REMITTANCE)) {

        }
      }
    }
  }

  /*입금 내역 출력*/
  public void depositHisPrint(BankData bankData) {
    System.out.println(bankData.getTrHisNo() + " / " + bankData.getRecvDebitNum() + " / " + bankData
        .getUserDebitNum() + " / "
        + "입금" + " / " + bankData.getRecvUserName() + " / "
        + " / " + bankData.getRecvBankName() + " / " + bankData.getCallUserName() + " / " + bankData
        .getCallDebitNum()
        + " / " + bankData.getCallBankName() + " / " + bankData.getCallRemittance() + " / "
        + bankData.getDebitBalance());

  }

  /*입금 내역 출력*/
  public void withdrawalHisPrint(BankData bankData) {
    System.out.println(bankData.getTrHisNo() + " / " + bankData.getRecvDebitNum() + " / " + bankData
        .getUserDebitNum() + " / "
        + "출금" + " / " + bankData.getRecvUserName() + " / "
        + " / " + bankData.getRecvBankName() + " / " + bankData.getCallUserName() + " / " + bankData
        .getCallDebitNum()
        + " / " + bankData.getCallBankName() + " / " + bankData.getCallRemittance() + " / "
        + bankData.getDebitBalance());

  }

  public boolean checkBalance(int cash) {
    if (cash < 0) {
      System.out.println("******잔액이 부족합니다.*******");
      return false;
    }
    return true;
  }
}
