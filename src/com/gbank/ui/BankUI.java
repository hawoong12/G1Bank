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
		System.out.println("----1. ���� ����                ----");
		System.out.println("----2. ���� ��ȸ                ----");
		System.out.println("----3. �Ա�                    ----");
		System.out.println("----4. ���                    ----");
		System.out.println("----5. ����                    ----");
		System.out.println("----------------------------------");
	}
	
	protected static void printDebitCreateMenuUI() {
		System.out.println("----------------------------------");
		System.out.println("----------���� ���� �ۼ��׸�-----------");
		System.out.println("----------------------------------");
		System.out.println("----1. �̸�                    ---");
		System.out.println("----2. �� ��ȣ                  ---");
		System.out.println("----3. �������('YYYYMMDD')      ---");
		System.out.println("- ���� �޴��� ������ [main]�� �Է��ϼ��� -");
		System.out.println("----------------------------------");
	}
	
	
	protected static void printDebitConfirmMenuUI() {
		System.out.println("----------------------------------");
		System.out.println("-------------G1 BANK--------------");
		System.out.println("----------------------------------");
		System.out.println("----1. ���� ����                ----");
		System.out.println("----2. ���� ��ȸ                ----");
		System.out.println("----3. �Ա�                    ----");
		System.out.println("----4. ���                    ----");
		System.out.println("----5. ����                    ----");
		System.out.println("----------------------------------");
	}
	
	protected static void printDebitDepositMenuUI() {
		System.out.println("----------------------------------");
		System.out.println("-------------G1 BANK--------------");
		System.out.println("----------------------------------");
		System.out.println("----1. ���� ����                ----");
		System.out.println("----2. ���� ��ȸ                ----");
		System.out.println("----3. �Ա�                    ----");
		System.out.println("----4. ���                    ----");
		System.out.println("----5. ����                    ----");
		System.out.println("----------------------------------");
	}
	
	protected static void printDebitWithdrawMenuUI() {
		System.out.println("----------------------------------");
		System.out.println("-------------G1 BANK--------------");
		System.out.println("----------------------------------");
		System.out.println("----1. ���� ����                ----");
		System.out.println("----2. ���� ��ȸ                ----");
		System.out.println("----3. �Ա�                    ----");
		System.out.println("----4. ���                    ----");
		System.out.println("----5. ����                    ----");
		System.out.println("----------------------------------");
	}
	
	
	protected static void printTyping() {
		System.out.println("----------------------------------");
		System.out.print  ("--- �Է� : ");
	}
	
	protected static void printReTyping() {
		System.out.println("----------------------------------");
		System.out.println("--- �߸��� �Է��Դϴ�. �ٽ� �Է����ּ���---");
		System.out.println("--- �Է� : ");
	}
	
}
