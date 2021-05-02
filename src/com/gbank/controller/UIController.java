package com.gbank.controller;

import com.gbank.ui.BankUI;


public class UIController extends BankUI{
	
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.01
	 * @tags			:	@param nowPageNo	- 현재페이지 번호
	 * @tags			:	@param movePageNo   - 이동할 페이지 번호
	 * @todo			:	UI변경 중앙 컨트롤 
	 */
	public int bankUIController(int nowPageNo, int movePageNo) {
		if(MAIN_MENU == nowPageNo) {					/*메인메뉴 화면제어*/
			return mainMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_CREATE_MENU == nowPageNo) {		/*계좌개설 화면제어*/
			return debitCreateMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_CONFIRM_MENU == nowPageNo) { 	/*계좌조회 화면제어*/
			return debitConfirmMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_DEPOSIT_MENU == nowPageNo) {		/*입금 화면제어*/
			return debitDepositMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_WITHDRAW_MENU == nowPageNo) {	/*출금 화면제어*/
			return debitWithdrawMenuController(nowPageNo,movePageNo);
		}else if(INPUT_MENU == nowPageNo) {
			printTyping();
		 	return 0;
		}
		return 0;
	}
	
	
	
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param movePageNo
	 * @todo			:	메인메뉴내 메뉴 선택시 해당 메뉴로 이동
	 */
	public int mainMenuController(int nowPageNo, int movePageNo) {
		if(movePageNo == 0) {
			printMainMenuUI();
			return MAIN_MENU;
		}else if(movePageNo == 1) {
			bankUIController(DEBIT_CREATE_MENU,THIS_MENU);
			return DEBIT_CREATE_MENU;
		}else if(movePageNo == 2) {
			bankUIController(DEBIT_CONFIRM_MENU,THIS_MENU);
			return DEBIT_CONFIRM_MENU;
		}else if(movePageNo == 3) {
			bankUIController(DEBIT_DEPOSIT_MENU,THIS_MENU);
			return DEBIT_DEPOSIT_MENU;
		}else if(movePageNo == 4) {
			bankUIController(DEBIT_WITHDRAW_MENU,THIS_MENU);
			return DEBIT_WITHDRAW_MENU;
		}else if(movePageNo == 5) {
			return EXIT_PROGRAM;
		}else {
			return 0;
		}
	}
	
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param movePageNo
	 * @todo			:	TODO
	 */
	public int debitCreateMenuController(int nowPageNo, int movePageNo) {
		if(movePageNo == 0) {
			printDebitCreateMenuUI();
			return DEBIT_CREATE_MENU;
		}
		return 0;
	}
	
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param movePageNo
	 * @todo			:	TODO
	 */
	public int debitConfirmMenuController(int nowPageNo, int movePageNo) {
		return 0;
	}
	
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param movePageNo
	 * @todo			:	TODO
	 */
	public int debitDepositMenuController(int nowPageNo, int movePageNo) {
		return 0;
	}
	
	

	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param nowPageNo
	 * @tags			:	@param movePageNo
	 * @todo			:	TODO
	 */
	public int debitWithdrawMenuController(int nowPageNo, int movePageNo) {
		return 0;
	}
	
}
