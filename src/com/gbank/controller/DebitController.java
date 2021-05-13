package com.gbank.controller;

import com.gbank.data.DebitData;
import com.gbank.data.UserData;
import java.util.ArrayList;
import java.util.Random;

public class DebitController {

  DebitData dd = new DebitData();

  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param userData
   * @tags : @param debitData
   * @todo : 계좌개설
   */
  public void debitCreate(ArrayList<DebitData> debitData, ArrayList<UserData> userData,
      UserData newUser) {

    newUser = userValidation(newUser); /* 폰번호와 생년월일 '-' 제거 */

    if (!userDuplicateCheck(userData, newUser)) {
      System.out.println("신규가입자입니다. 가입을 진행합니다.");
      signUp(userData, newUser);
    } else {
      System.out.println("기존고객입니다. 신규 계좌를 개설합니다.");
    }
    debitIssuance(debitData, newUser);
  }

  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param debitData
   * @tags : @param userPhoneNum
   * @todo : 계좌정보 생성
   */
  public void debitIssuance(ArrayList<DebitData> debitData, UserData newUser) {
    boolean chkDebitNum = true;
    DebitData tempDebitData = new DebitData();

    tempDebitData.setDebitPhone(newUser.getUserPhone());
    tempDebitData.setDebitUserName(newUser.getUserName());
    tempDebitData.setAccountBalance(0);
    tempDebitData.setBankNo(dd.G1_BANK);
    tempDebitData.setDebitName("입출금 통장");
    tempDebitData.setDebitStatus("U");
    while (chkDebitNum) {
      tempDebitData.setDebitNum(dd.G1_BANK + debitNumRandCreate());
      chkDebitNum = debitNumDuplicateCheck(tempDebitData, debitData);
    }
    System.out.println(newUser.getUserName() + " 님의 신규 계좌번호 : " + tempDebitData.getDebitNum());
    debitData.add(tempDebitData);
    System.out.println("계좌 생성이 완료되었습니다.");
  }

  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param debitData
   * @tags : @return
   * @todo : 랜덤계좌번호생성
   */
  public String debitNumRandCreate() {
    int randLength = 6;

    Random random = new Random(System.currentTimeMillis());

    int range = (int) Math.pow(10, randLength);
    int trim = (int) Math.pow(10, randLength - 1);
    int result = random.nextInt(range) + trim;

    if (result > range) {
      result = result - trim;
    }
    return result + "";
  }


  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param userData
   * @tags : @param tempUser
   * @todo : 회원가입
   */
  public void signUp(ArrayList<UserData> userData, UserData newUser) {
    newUser.setUserStatus("P");
    userData.add(newUser);
    System.out.println("신규가입 완료");
  }

  //이런건 입력받을때부터 그냥 없애고 하는걸로 해요
  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param userType
   * @tags : @param data
   * @tags : @return
   * @todo : 유저 입력 정보 보정
   */
  public UserData userValidation(UserData createUser) {

    createUser.setUserPhone(createUser.getUserPhone().replaceAll("-", ""));
    createUser.setUserBirth(createUser.getUserBirth().replaceAll("-", ""));

    return createUser;

  }

  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param userType
   * @tags : @param data
   * @tags : @return
   * @todo : 유저 정보 중복여부 검사
   */
  public boolean userDuplicateCheck(ArrayList<UserData> userData, UserData newUser) {
    System.out.println("유저 중복검사 실행");

 /*   for (int i = 0; i < userData.size(); i++) {
      if (userData.get(i).getUserPhone().equals(newUser.getUserPhone())) {
        return true; *//* 중복일 경우 true리턴 *//*
      }

    }*/
    //newUser에서 객체 계속 꺼내는건 X
    //for문도 다른걸로 사용하는법 익히기
    int newUserPhone = Integer.parseInt(newUser.getUserPhone());
    for(UserData u : userData){
      if(Integer.parseInt(u.getUserPhone()) == (newUserPhone)){
        return true;
      }
    }

    return false;
  }

  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param userType
   * @tags : @param data
   * @tags : @return
   * @todo : 계좌번호 중복여부 검사
   */
  public boolean debitNumDuplicateCheck(DebitData tempDebitData, ArrayList<DebitData> debitData) {
    for (int i = 0; i < debitData.size(); i++) {
      if (debitData.get(i).getDebitNum().equals(tempDebitData.getDebitNum())) {
        return true;
      }
    }
    System.out.println("계좌 중복여부 검사완료");
    return false;
  }

  public String returnRepAccount(ArrayList<DebitData> debitData, String userPhonNum) {
    for (int i = 0; i < debitData.size(); i++) {
      if (debitData.get(i).getDebitPhone().equals(userPhonNum)) {
        System.out.println("사용자의 대표 계좌번호를 찾았습니다.");
        return debitData.get(i).getDebitNum();
      }
    }
    System.out.println("존재하지 않는 사용자입니다.");
    return null;
  }
}
