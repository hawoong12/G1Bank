package com.gbank.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.gbank.controller.BankController;
import com.gbank.controller.DebitController;
import com.gbank.data.*;

public class DoMain {

	static Scanner sc = new Scanner(System.in);
	static DebitController dbC = new DebitController();
	static BankController bkC = new BankController();


	static ArrayList<UserData> userData = new ArrayList<UserData>();
	static ArrayList<DebitData> debitData = new ArrayList<DebitData>();
	static ArrayList<BankData> bankData = new ArrayList<BankData>();

	public static void main(String[] args) {
		UserData tempUser = new UserData();
		tempUser = userSetting("±èÁö¿ø", "01040151727", "1990-03-29");
		dbC.debitCreate(debitData, userData, tempUser);
		UI();
		tempUser = userSetting("±èÁö¿ø", "01040151727", "1990-03-29");
		dbC.debitCreate(debitData, userData, tempUser);
		UI();
		bkC.depositAtm(debitData,bankData,bkC.serchUserDebit(debitData,1,"01040151727"),1000000);
		UI();
		bkC.depositAtm(debitData,bankData,bkC.serchUserDebit(debitData,1,"01040151727"),2000000);
		UI();
		bkC.depositAtm(debitData,bankData,bkC.serchUserDebit(debitData,1,"01040151727"),3000000);

	}

	public static UserData userSetting(String name, String phone, String birth) {
		UserData tempUser = new UserData();

		tempUser.setUserNo(userData.size() + 1);
		tempUser.setUserName(name);
		tempUser.setUserPhone(phone);
		tempUser.setUserBirth(birth);

		return tempUser;
	}
	
	public static void UI() {
		System.out.println("--------------------");
	}
}
