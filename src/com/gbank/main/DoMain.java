package com.gbank.main;

import java.util.Scanner;
import com.gbank.ui.BankUI;
import com.gbank.data.*;

public class DoMain {
	
	public static void main(String[] args) {
		
		Scanner sc 			= new Scanner(System.in);
		BankUI bUI 			= new BankUI();
		MenuData menuData 	= new MenuData();
		
		bUI.bankUIController(menuData);

		while(true) {
			menuData.pushMenuSelect(sc.nextInt());
			menuData = bUI.bankUIController(menuData);
			
			if(menuData.emptyhMenuSelect()) {
				break;
			}// menu선택 스택에 값이 없으면 종료
		}
	}	
}
