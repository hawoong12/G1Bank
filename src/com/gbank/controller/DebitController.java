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
	 * @tags			:	@param nowPageNo	- 	현 페이지 넘버
	 * @tags			:	@param userData 	-	유저데이터 
	 * @tags			:	@param debitData	-	계좌 데이터
	 * @todo			:	기능 메뉴들 중앙제어
	 */
	public boolean debitController(int nowPageNo,ArrayList<UserData> userData, ArrayList<DebitData> debitData) {
		if(MAIN_MENU == nowPageNo) {					/*메인메뉴 화면제어*/
			return false;
		}else if(DEBIT_CREATE_MENU == nowPageNo) {		/*계좌개설 화면제어*/
			return debitCreate(userData, debitData);
		}else if(DEBIT_CONFIRM_MENU == nowPageNo) { 	/*계좌조회 화면제어*/
			
		}else if(DEBIT_DEPOSIT_MENU == nowPageNo) {		/*입금 화면제어*/
			
		}else if(DEBIT_WITHDRAW_MENU == nowPageNo) {	/*출금 화면제어*/
			
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
	 * @todo			:	계좌개설 
	 */
	public boolean debitCreate(ArrayList<UserData> userData, ArrayList<DebitData> debitData) {

		UserData tempUser = new UserData();
		String	userPhoneNum;
		
		System.out.print("폰번호를 입력하세요 : ");
		userPhoneNum = userValidation(ud.USER_PHONE,sc.next());
		if(!userPhoneNum.isBlank()) {
			if(userDuplicateCheck(ud.USER_PHONE,userPhoneNum,userData).getUserPhone() == null) {
				tempUser.setUserPhone(userPhoneNum);
				System.out.println("신규가입자입니다. 기본정보를 입력받겠습니다.");
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
	 * @todo			:	계좌정보 생성
	 */
	public boolean debitIssuance(ArrayList<DebitData> debitData, String userPhoneNum) {
		boolean chkDebitNum = true;
		DebitData tempDebitData = new DebitData();
		
		tempDebitData.setDebitPhone(userPhoneNum);
		tempDebitData.setDebitBalance(0);
		tempDebitData.setBankNo(dd.G1_BANK);
		tempDebitData.setDebitName("입출금 통장");
		tempDebitData.setDebitStatus("U");
		while(chkDebitNum) {
			tempDebitData.setDebitNum(dd.G1_BANK+debitNumRandCreate(debitData));
			chkDebitNum = debitNumDuplicateCheck(tempDebitData,debitData);
		}
		System.out.println("계좌 생성이 완료되었습니다.");
		return true;

	}
	
	/**
	 * @packageName		:	com.gbank.controller
	 * @fileName		:	DebitController.java
	 * @author 			:	JIWONKIM
	 * @date			:	2021.05.02
	 * @tags			:	@param debitData
	 * @tags			:	@return
	 * @todo			:	랜덤계좌번호생성
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
	 * @todo			:	회원가입
	 */
	public void signUp(ArrayList<UserData> userData, UserData tempUser) {
		System.out.print("이름을 입력하세요    : ");
		tempUser.setUserName(sc.next());
		System.out.print("생년월일을 입력하세요 : ");
		tempUser.setUserBirth(userValidation(ud.USER_BIRTH,sc.next()));
		tempUser.setUserStatus("P");
		userData.add(tempUser);
		System.out.println("신규 사용자 정보 생성을 완료했습니다.");
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
	 * @todo			:	계좌번호 중복여부 검사
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
