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
   * @todo : ���°���
   */
  public void debitCreate(ArrayList<DebitData> debitData, ArrayList<UserData> userData,
      UserData newUser) {

    newUser = userValidation(newUser); /* ����ȣ�� ������� '-' ���� */

    if (!userDuplicateCheck(userData, newUser)) {
      System.out.println("�ű԰������Դϴ�. ������ �����մϴ�.");
      signUp(userData, newUser);
    } else {
      System.out.println("�������Դϴ�. �ű� ���¸� �����մϴ�.");
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
   * @todo : �������� ����
   */
  public void debitIssuance(ArrayList<DebitData> debitData, UserData newUser) {
    boolean chkDebitNum = true;
    DebitData tempDebitData = new DebitData();

    tempDebitData.setDebitPhone(newUser.getUserPhone());
    tempDebitData.setDebitUserName(newUser.getUserName());
    tempDebitData.setAccountBalance(0);
    tempDebitData.setBankNo(dd.G1_BANK);
    tempDebitData.setDebitName("����� ����");
    tempDebitData.setDebitStatus("U");
    while (chkDebitNum) {
      tempDebitData.setDebitNum(dd.G1_BANK + debitNumRandCreate());
      chkDebitNum = debitNumDuplicateCheck(tempDebitData, debitData);
    }
    System.out.println(newUser.getUserName() + " ���� �ű� ���¹�ȣ : " + tempDebitData.getDebitNum());
    debitData.add(tempDebitData);
    System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
  }

  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param debitData
   * @tags : @return
   * @todo : �������¹�ȣ����
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
   * @todo : ȸ������
   */
  public void signUp(ArrayList<UserData> userData, UserData newUser) {
    newUser.setUserStatus("P");
    userData.add(newUser);
    System.out.println("�ű԰��� �Ϸ�");
  }

  //�̷��� �Է¹��������� �׳� ���ְ� �ϴ°ɷ� �ؿ�
  /**
   * @packageName : com.gbank.controller
   * @fileName : DebitController.java
   * @author : JIWONKIM
   * @date : 2021.05.02
   * @tags : @param userType
   * @tags : @param data
   * @tags : @return
   * @todo : ���� �Է� ���� ����
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
   * @todo : ���� ���� �ߺ����� �˻�
   */
  public boolean userDuplicateCheck(ArrayList<UserData> userData, UserData newUser) {
    System.out.println("���� �ߺ��˻� ����");

 /*   for (int i = 0; i < userData.size(); i++) {
      if (userData.get(i).getUserPhone().equals(newUser.getUserPhone())) {
        return true; *//* �ߺ��� ��� true���� *//*
      }

    }*/
    //newUser���� ��ü ��� �����°� X
    //for���� �ٸ��ɷ� ����ϴ¹� ������
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
   * @todo : ���¹�ȣ �ߺ����� �˻�
   */
  public boolean debitNumDuplicateCheck(DebitData tempDebitData, ArrayList<DebitData> debitData) {
    for (int i = 0; i < debitData.size(); i++) {
      if (debitData.get(i).getDebitNum().equals(tempDebitData.getDebitNum())) {
        return true;
      }
    }
    System.out.println("���� �ߺ����� �˻�Ϸ�");
    return false;
  }

  public String returnRepAccount(ArrayList<DebitData> debitData, String userPhonNum) {
    for (int i = 0; i < debitData.size(); i++) {
      if (debitData.get(i).getDebitPhone().equals(userPhonNum)) {
        System.out.println("������� ��ǥ ���¹�ȣ�� ã�ҽ��ϴ�.");
        return debitData.get(i).getDebitNum();
      }
    }
    System.out.println("�������� �ʴ� ������Դϴ�.");
    return null;
  }
}
