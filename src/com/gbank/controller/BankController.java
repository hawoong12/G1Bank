package com.gbank.controller;

import java.util.ArrayList;

import com.gbank.data.BankData;
import com.gbank.data.DebitData;
import com.gbank.data.UserData;

public class BankController {
	BankData bd = new BankData();

	public void depositAtm(ArrayList<DebitData> debitData, String recvDebitNum, int deposit) {
		int debitUniq = Integer.parseInt(serchUserDebit(debitData,2,recvDebitNum));
		int debitBalance = debitData.get(debitUniq).getDebitBalance();
		
		debitData.get(debitUniq).setDebitBalance(debitBalance + deposit);
		System.out.println(debitData.get(debitUniq).getDebitPhone() + "���� ���� �ܰ�� " 
					+ debitData.get(debitUniq).getDebitBalance() + " ���Դϴ�.");
		
		/*����� ���� ��� �޼��� ���� �ؾ���*/
	}
	
	public String serchUserDebit(ArrayList<DebitData> debitData, int serchTyp, String serchData) {
		System.out.println("���� �˻��� �����մϴ�.");
		for (int i = 0; i < debitData.size(); i++) {
			switch (serchTyp) {
				case 1: /*����ȣ -> ��ǥ���� �˻�*/
					if (debitData.get(i).getDebitPhone().equals(serchData)) {
						System.out.println("����ȣ�� ��ǥ���¸� ã�ҽ��ϴ�.");
						return debitData.get(i).getDebitNum();
					}
					break; 
				case 2: /*���¹�ȣ -> ���¹�ȣ����*/
					if (debitData.get(i).getDebitNum().equals(serchData)) {
						System.out.println("���¹�ȣ�� ���¹�ȣ ����ũ ��ȣ�� ã�ҽ��ϴ�.");
						return i+"";
					}
					break;
				default:
					break;
			}
		}
		System.out.println("����ȣ�� �˻������� ���°� �������� �ʽ��ϴ�.");
		return null;
	}

}
