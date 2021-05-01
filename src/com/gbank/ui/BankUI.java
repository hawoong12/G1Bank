package com.gbank.ui;

import com.gbank.data.*;

public class BankUI {
	
	public MenuData bankUIController(MenuData menuData) {
		switch(menuData.peekhMenuSelect()) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		return null;
	}
	
	private static void printMainUI() {
		System.out.println("----------------------------------");
		System.out.println("-------------G1 BANK--------------");
		System.out.println("----------------------------------");
		System.out.println("----1. 계좌 개설                ----");
		System.out.println("----2. 계좌 조회                ----");
		System.out.println("----3. 입금                    ----");
		System.out.println("----4. 출금                    ----");
		System.out.println("----5. 종료                    ----");
		System.out.println("----------------------------------");
	}
	
	private static void printTyping() {
		System.out.println("----------------------------------");
		System.out.println("--- 입력 : ");
	}
	
	private static void printReTyping() {
		System.out.println("----------------------------------");
		System.out.println("--- 잘못된 입력입니다. 다시 입력해주세요---");
		System.out.println("--- 입력 : ");
	}
}
