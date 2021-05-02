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
	 * @tags			:	@param nowPageNo	- 	현 페이지 넘버
	 * @tags			:	@param userData 	-	유저데이터 
	 * @tags			:	@param debitData	-	계좌 데이터
	 * @todo			:	기능 메뉴들 중앙제어
	 */
	public void debitController(int nowPageNo,ArrayList<UserData> userData, ArrayList<DebitData> debitData) {
		if(MAIN_MENU == nowPageNo) {					/*메인메뉴 화면제어*/

		}else if(DEBIT_CREATE_MENU == nowPageNo) {		/*계좌개설 화면제어*/
			debitCreate(userData, debitData);
		}else if(DEBIT_CONFIRM_MENU == nowPageNo) { 	/*계좌조회 화면제어*/
			
		}else if(DEBIT_DEPOSIT_MENU == nowPageNo) {		/*입금 화면제어*/
			
		}else if(DEBIT_WITHDRAW_MENU == nowPageNo) {	/*출금 화면제어*/
			
		}else if(INPUT_MENU == nowPageNo) {
			
		}
	}
	
	public void debitCreate(ArrayList<UserData> userData, ArrayList<DebitData> debitData) {

		UserData tempUser = new UserData();
		String	userPhoneNum;
		
		System.out.println("폰번호를 입력하세요 : ");
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
	 * @todo			:	회원가입
	 */
	public void signUp(ArrayList<UserData> userData, UserData tempUser) {
		System.out.println("폰번호를 입력하세요 : ");
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
	 * @todo			:	유저 입력 정보 보정
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
	 * @todo			:	유저 정보 중복여부 검사
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
