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
		System.out.println("----1. ���� ����                ----");
		System.out.println("----2. ���� ��ȸ                ----");
		System.out.println("----3. �Ա�                    ----");
		System.out.println("----4. ���                    ----");
		System.out.println("----5. ����                    ----");
		System.out.println("----------------------------------");
	}
	
	private static void printTyping() {
		System.out.println("----------------------------------");
		System.out.println("--- �Է� : ");
	}
	
	private static void printReTyping() {
		System.out.println("----------------------------------");
		System.out.println("--- �߸��� �Է��Դϴ�. �ٽ� �Է����ּ���---");
		System.out.println("--- �Է� : ");
	}
}
