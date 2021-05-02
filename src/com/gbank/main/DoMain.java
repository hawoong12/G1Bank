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
		
		int nowPage = 1;
		int movePage = 0;
		menuData.pushMenuNo(nowPage);
		menuData.pushMenuMoveNo(movePage);

		
		/*
		 * menuData.pushMenuNo(uiC.bankUIController(MAIN_MENU,THIS_MENU));
		 * uiC.bankUIController(INPUT_MENU,THIS_MENU);
		 */
		 
		//uiC.bankUIController(menuData);					//초기화면 불러오기

		while(true) {
			nowPage = menuData.peekhMenuNo();
			menuData.pushMenuNo(uiC.bankUIController(nowPage,movePage));
			uiC.bankUIController(INPUT_MENU,THIS_MENU);
			movePage = sc.nextInt();
			menuData.pushMenuMoveNo(movePage);
			
			if(dbC.debitController(menuData.peekhMenuNo(),userData,debitData)) {
				menuData.popMenuNo();
			}

			//menuData = uiC.bankUIController(menuData);
			if(menuData.peekhMenuNo() == EXIT_PROGRAM) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}// menu선택 스택에 값이 없으면 종료
		}	
	}	
}
