package com.gbank.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.gbank.data.DebitData;
import com.gbank.data.UserData;
import com.gbank.ui.BankUI;

public class DebitController extends BankUI{
	
	Scanner  sc 			= new Scanner(System.in);
	UserData ud 			= new UserData();

	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param nowPageNo	- 	�� ������ �ѹ�
	 * @tags			:	@param userData 	-	���������� 
	 * @tags			:	@param debitData	-	���� ������
	 * @todo			:	��� �޴��� �߾�����
	 */
	public void debitController(int nowPageNo,ArrayList<UserData> userData, ArrayList<DebitData> debitData) {
		if(MAIN_MENU == nowPageNo) {					/*���θ޴� ȭ������*/

		}else if(DEBIT_CREATE_MENU == nowPageNo) {		/*���°��� ȭ������*/
			debitCreate(userData, debitData);
		}else if(DEBIT_CONFIRM_MENU == nowPageNo) { 	/*������ȸ ȭ������*/
			
		}else if(DEBIT_DEPOSIT_MENU == nowPageNo) {		/*�Ա� ȭ������*/
			
		}else if(DEBIT_WITHDRAW_MENU == nowPageNo) {	/*��� ȭ������*/
			
		}else if(INPUT_MENU == nowPageNo) {
			
		}
	}
	
	public void debitCreate(ArrayList<UserData> userData, ArrayList<DebitData> debitData) {

		UserData tempUser = new UserData();
		String	userPhoneNum;
		
		System.out.println("����ȣ�� �Է��ϼ��� : ");
		userPhoneNum = userValidation(ud.USER_PHONE,sc.next());
		if(!userPhoneNum.isBlank()) {
			userDuplicateCheck(ud.USER_PHONE,userPhoneNum,userData);
		}
		
		
		if(userData.isEmpty()) {
			signUp(userData, tempUser);
		}
	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param userData
	 * @tags			:	@param tempUser
	 * @todo			:	ȸ������
	 */
	public void signUp(ArrayList<UserData> userData, UserData tempUser) {
		System.out.println("����ȣ�� �Է��ϼ��� : ");
		if(!userValidation(ud.USER_PHONE,sc.next()).isBlank()){
			
		}
		
	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param userType
	 * @tags			:	@param data
	 * @tags			:	@return
	 * @todo			:	���� �Է� ���� ����
	 */
	public String userValidation(int userType, String data) {
		if(userType == ud.USER_PHONE) {
			data.replaceAll("-", "");
			return data;
		}else if(userType == ud.USER_BIRTH) {
			data.replaceAll("-", "");
			return data;
		}else {
			return null;
		}
	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param userType
	 * @tags			:	@param data
	 * @tags			:	@return
	 * @todo			:	���� ���� �ߺ����� �˻�
	 */
	public boolean userDuplicateCheck(int userType, String data, ArrayList<UserData> userData) {
		for(int i = 0; i < userData.size(); i++) {
			if(userType == ud.USER_PHONE) {
				if(userData.get(i).getUserPhone().equals(data)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
