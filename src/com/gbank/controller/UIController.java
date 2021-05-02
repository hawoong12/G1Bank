package com.gbank.controller;

import com.gbank.ui.BankUI;


public class UIController extends BankUI{
	
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	UIController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.01
	 * @tags			:	@param nowPageNo	- ���������� ��ȣ
	 * @tags			:	@param movePageNo   - �̵��� ������ ��ȣ
	 * @todo			:	UI���� �߾� ��Ʈ�� 
	 */
	public int bankUIController(int nowPageNo, int movePageNo) {
		if(MAIN_MENU == nowPageNo) {					/*���θ޴� ȭ������*/
			return mainMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_CREATE_MENU == nowPageNo) {		/*���°��� ȭ������*/
			return debitCreateMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_CONFIRM_MENU == nowPageNo) { 	/*������ȸ ȭ������*/
			return debitConfirmMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_DEPOSIT_MENU == nowPageNo) {		/*�Ա� ȭ������*/
			return debitDepositMenuController(nowPageNo,movePageNo);
		}else if(DEBIT_WITHDRAW_MENU == nowPageNo) {	/*��� ȭ������*/
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
	 * @todo			:	���θ޴��� �޴� ���ý� �ش� �޴��� �̵�
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
