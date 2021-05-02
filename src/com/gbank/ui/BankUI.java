package com.gbank.ui;

import com.gbank.data.*;

public class BankUI {
	public final static int THIS_MENU = 0;
	public final static int MAIN_MENU = 1;
	public final static int DEBIT_CREATE_MENU = 2;
	public final static int DEBIT_CONFIRM_MENU = 3;
	public final static int DEBIT_DEPOSIT_MENU = 4;
	public final static int DEBIT_WITHDRAW_MENU = 5;
	public final static int INPUT_MENU = 6;
	public final static int EXIT_PROGRAM = 7;

	
	protected static void printMainMenuUI() {
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
	
	protected static void printDebitCreateMenuUI() {
		System.out.println("----------------------------------");
		System.out.println("----------계좌 개설 작성항목-----------");
		System.out.println("----------------------------------");
		System.out.println("----1. 이름                    ---");
		System.out.println("----2. 폰 번호                  ---");
		System.out.println("----3. 생년월일('YYYYMMDD')      ---");
		System.out.println("- 메인 메뉴로 가려면 [main]을 입력하세요 -");
		System.out.println("----------------------------------");
	}
	
	
	protected static void printDebitConfirmMenuUI() {
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
	
	protected static void printDebitDepositMenuUI() {
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
	
	protected static void printDebitWithdrawMenuUI() {
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
	
	
	protected static void printTyping() {
		System.out.println("----------------------------------");
		System.out.print  ("--- 입력 : ");
	}
	
	protected static void printReTyping() {
		System.out.println("----------------------------------");
		System.out.println("--- 잘못된 입력입니다. 다시 입력해주세요---");
		System.out.println("--- 입력 : ");
	}
	
}
