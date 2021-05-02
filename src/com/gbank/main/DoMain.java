package com.gbank.main;

import java.util.ArrayList;
import java.util.Scanner;
import com.gbank.ui.BankUI;
import com.gbank.controller.DebitController;
import com.gbank.controller.UIController;
import com.gbank.data.*;

public class DoMain extends BankUI{

	
	static Scanner sc 			= new Scanner(System.in);
	static UIController uiC 	= new UIController();
	static DebitController dbC	= new DebitController();
	static MenuData menuData 	= new MenuData();
	
	static ArrayList<UserData> userData = new ArrayList<UserData>();
	static ArrayList<DebitData> debitData = new ArrayList<DebitData>();


	public static void main(String[] args) {
		
		int nowPage;
		
		menuData.pushMenuNo(uiC.bankUIController(MAIN_MENU,THIS_MENU));
		//uiC.bankUIController(menuData);					//�ʱ�ȭ�� �ҷ�����

		while(true) {
			uiC.bankUIController(INPUT_MENU,THIS_MENU);
			nowPage = menuData.peekhMenuNo();
			menuData.pushMenuNo(uiC.bankUIController(nowPage,sc.nextInt()));
			
			dbC.debitController(menuData.peekhMenuNo(),userData,debitData);

			//menuData = uiC.bankUIController(menuData);
			if(menuData.peekhMenuNo() == EXIT_PROGRAM) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}// menu���� ���ÿ� ���� ������ ����
		}	
	}	
}
