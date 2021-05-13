package com.gbank.main;

import com.gbank.controller.BankController;
import com.gbank.controller.DebitController;
import com.gbank.data.BankData;
import com.gbank.data.DebitData;
import com.gbank.data.UserData;
import java.util.ArrayList;
import java.util.Scanner;

public class G1BankStart {
  DebitController dbC = new DebitController();
  BankController bkC = new BankController();

  ArrayList<UserData> userData = new ArrayList<UserData>();
  ArrayList<DebitData> debitData = new ArrayList<DebitData>();
  ArrayList<BankData> bankData = new ArrayList<BankData>();
  UserData tempUser = new UserData();

  public void start(){

    //이렇게 객체 선언 해주는거야 만약에 입력받아서 해주는거면 이런 느낌으로( 급하게 짜느라 막짬)
    /*String[] personalInfo = new String[3];
    for(int i = 0; i < 3; i ++){
      personalInfo[i] = Scanner();
    }
    tempUser = new UserData(userData.size(),personalInfo[0], personalInfo[1], personalInfo[2]);*/
    tempUser = new UserData(userData.size(),"김지원", "01040151727", "1990-03-29");
    dbC.debitCreate(debitData, userData, tempUser);
    UI();
    tempUser = new UserData(userData.size(),"김지원", "01040151727", "1990-03-29");
    dbC.debitCreate(debitData, userData, tempUser);
    UI();
    bkC.depositAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727"), 1000000);
    UI();
    bkC.depositAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727"), 2000000);
    UI();
    bkC.depositAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727"), 3000000);
    UI();
    bkC.depsWithHisPrintController(bankData, bkC.serchUserDebit(debitData, 1, "01040151727"));
    UI();
    bkC.WithdrawalAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727"),
        2000000);
    UI();
    bkC.WithdrawalAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727"),
        2000000);
    UI();
    bkC.WithdrawalAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727"),
        4000000);
    UI();
    bkC.depsWithHisPrintController(bankData, bkC.serchUserDebit(debitData, 1, "01040151727"));
    UI();
    UI();
    tempUser = new UserData(userData.size(),"김촬스", "01011112222", "1920-05-02");

    dbC.debitCreate(debitData, userData, tempUser);
    UI();
    bkC.depositAtm(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01011112222"), 6000000);
    UI();
    bkC.depsWithHisPrintController(bankData, bkC.serchUserDebit(debitData, 1, "01011112222"));
    UI();
    bkC.callBankRemittance(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727")
    			, "김지원", "000", bkC.serchUserDebit(debitData, 1, "01011112222"), 1500000);
    UI();
    bkC.depsWithHisPrintController(bankData, bkC.serchUserDebit(debitData, 1, "01011112222"));
    UI();
    bkC.recvBankRemittance(debitData, bankData, bkC.serchUserDebit(debitData, 1, "01040151727")
    		, "김촬스", "000", bkC.serchUserDebit(debitData, 1, "01011112222"), 1500000);
    UI();
    bkC.depsWithHisPrintController(bankData, bkC.serchUserDebit(debitData, 1, "01040151727"));

  }


  public void UI() {
    System.out.println("--------------------");
  }

  //입력받기
  public String Scanner(){
    Scanner sc = new Scanner(System.in);
    return String.valueOf(sc);
  }

}
