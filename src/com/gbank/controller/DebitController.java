package com.gbank.controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.gbank.data.DebitData;
import com.gbank.data.UserData;
import com.gbank.ui.BankUI;

public class DebitController extends BankUI{
	
	Scanner  	sc 			= new Scanner(System.in);
	UserData 	ud 			= new UserData();
	DebitData	dd			= new DebitData();

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
	public boolean debitController(int nowPageNo,ArrayList<UserData> userData, ArrayList<DebitData> debitData) {
		if(MAIN_MENU == nowPageNo) {					/*���θ޴� ȭ������*/
			return false;
		}else if(DEBIT_CREATE_MENU == nowPageNo) {		/*���°��� ȭ������*/
			return debitCreate(userData, debitData);
		}else if(DEBIT_CONFIRM_MENU == nowPageNo) { 	/*������ȸ ȭ������*/
			
		}else if(DEBIT_DEPOSIT_MENU == nowPageNo) {		/*�Ա� ȭ������*/
			
		}else if(DEBIT_WITHDRAW_MENU == nowPageNo) {	/*��� ȭ������*/
			
		}else if(INPUT_MENU == nowPageNo) {
			
		}
		return false;
	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param userData
	 * @tags			:	@param debitData
	 * @todo			:	���°��� 
	 */
	public boolean debitCreate(ArrayList<UserData> userData, ArrayList<DebitData> debitData) {

		UserData tempUser = new UserData();
		String	userPhoneNum;
		
		System.out.print("����ȣ�� �Է��ϼ��� : ");
		userPhoneNum = userValidation(ud.USER_PHONE,sc.next());
		if(!userPhoneNum.isBlank()) {
			if(userDuplicateCheck(ud.USER_PHONE,userPhoneNum,userData).getUserPhone() == null) {
				tempUser.setUserPhone(userPhoneNum);
				System.out.println("�ű԰������Դϴ�. �⺻������ �Է¹ްڽ��ϴ�.");
				signUp(userData, tempUser);
			}
			debitIssuance(debitData, userPhoneNum);
		}
		return true;
	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param debitData
	 * @tags			:	@param userPhoneNum
	 * @todo			:	�������� ����
	 */
	public boolean debitIssuance(ArrayList<DebitData> debitData, String userPhoneNum) {
		boolean chkDebitNum = true;
		DebitData tempDebitData = new DebitData();
		
		tempDebitData.setDebitPhone(userPhoneNum);
		tempDebitData.setDebitBalance(0);
		tempDebitData.setBankNo(dd.G1_BANK);
		tempDebitData.setDebitName("����� ����");
		tempDebitData.setDebitStatus("U");
		while(chkDebitNum) {
			tempDebitData.setDebitNum(dd.G1_BANK+debitNumRandCreate(debitData));
			chkDebitNum = debitNumDuplicateCheck(tempDebitData,debitData);
		}
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
		return true;

	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param debitData
	 * @tags			:	@return
	 * @todo			:	�������¹�ȣ����
	 */
	public String debitNumRandCreate(ArrayList<DebitData> debitData) {
		int randLength = 6;
		
		Random random = new Random(System.currentTimeMillis());
		
		int range 	= (int)Math.pow(10, randLength);
		int trim  	= (int)Math.pow(10, randLength-1);
		int result 	= random.nextInt(range)+trim;
		
		if(result > range) {
			result = result - trim;
		}
		return result+"";
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
		System.out.print("�̸��� �Է��ϼ���    : ");
		tempUser.setUserName(sc.next());
		System.out.print("��������� �Է��ϼ��� : ");
		tempUser.setUserBirth(userValidation(ud.USER_BIRTH,sc.next()));
		tempUser.setUserStatus("P");
		userData.add(tempUser);
		System.out.println("�ű� ����� ���� ������ �Ϸ��߽��ϴ�.");
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
	public UserData userDuplicateCheck(int userType, String data, ArrayList<UserData> userData) {
		UserData uD = new UserData();
		
		for(int i = 0; i < userData.size(); i++) {
			if(userType == ud.USER_PHONE) {
				if(userData.get(i).getUserPhone().equals(data)) {
					uD = userData.get(i);
					return uD;
				}
			}
		}
		
		return uD;
	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param userType
	 * @tags			:	@param data
	 * @tags			:	@return
	 * @todo			:	���¹�ȣ �ߺ����� �˻�
	 */
	public boolean debitNumDuplicateCheck(DebitData tempDebitData, ArrayList<DebitData> debitData) {
		for(int i = 0; i < debitData.size(); i++) {
			if(debitData.get(i).getDebitNum().equals(tempDebitData.getDebitNum())) {
				return true;
			}
		}
		return false;
	}
}
