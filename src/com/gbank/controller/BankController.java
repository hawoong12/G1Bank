package com.gbank.controller;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.gbank.data.BankData;
import com.gbank.data.DebitData;
import com.gbank.data.UserData;

public class BankController {
	BankData bd = new BankData();

	public void depositAtm(ArrayList<DebitData> debitData, ArrayList<BankData> bankData, String recvDebitNum, int deposit) {
		int debitUniq = Integer.parseInt(serchUserDebit(debitData,2,recvDebitNum));
		int debitBalance = debitData.get(debitUniq).getDebitBalance();
		
		debitData.get(debitUniq).setDebitBalance(debitBalance + deposit);
		System.out.println(debitData.get(debitUniq).getDebitPhone() + "���� ���� �ܰ�� " 
					+ debitData.get(debitUniq).getDebitBalance() + " ���Դϴ�.");
		
		/*����� ���� ��� �޼��� ���� �ؾ���*/
		depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.DEPOSIT);
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
	
	public void depsitNWithdrawalHisController(ArrayList<DebitData> debitData, ArrayList<BankData> bankData, int deposit, int debitUniq, String hisType) {
		if(hisType == bd.DEPOSIT) {
			depsitHisInsert(debitData, bankData, deposit, debitUniq);
		}else if(hisType == bd.WITHDRAWAL) {
			
		}else if(hisType == bd.RECV_REMITTANCE) {
			
		}else if(hisType == bd.CALL_REMITTANCE) {
			
		}
	}
	
	/*�Ա� �����丮 INSERT*/
	public void depsitHisInsert(ArrayList<DebitData> debitData, ArrayList<BankData> bankData, int deposit, int debitUniq) {
		
		BankData tempBankData = new BankData(debitUniq+""
											 , depsWithdHisCount(debitData, bankData, debitUniq) +""
											 , debitData.get(debitUniq).getDebitNum()
											 , bd.DEPOSIT
											 , debitData.get(debitUniq).getDebitUserName()
											 , debitData.get(debitUniq).getDebitNum()
											 , debitData.get(debitUniq).getDebitName()
											 , dateReturnToString()
											 , ""
											 , ""
											 , ""
											 , deposit
											 , debitData.get(debitUniq).getDebitBalance());
		
		bankData.add(tempBankData);
	}
	
	public int depsWithdHisCount(ArrayList<DebitData> debitData, ArrayList<BankData> bankData, int debitUniq) {
		int bankCnt = 0;
		for(int i = 0 ; i < bankData.size() ; i++) {
			if(bankData.get(i).getRecvDebitNum().equals(debitData.get(debitUniq).getDebitNum())) {
				bankCnt++;
			}
		}
		return bankCnt;
	}
	
	/*���糯¥ �ð� ����*/
	public String dateReturnToString() {
		Date date = new Date();        
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.systemDefault());
		String dateToStr = format.format(date.toInstant()); 
		
		return dateToStr;
	}
	
	/*����� ���� ��� ��Ʈ�ѷ�*/
	public void depsWithHisPrintController(ArrayList<BankData> bankData, String debitNum) {
		//System.out.println("��ȣ / ���¹�ȣ / �ŷ����� / �����ڸ� / ������ ���¹�ȣ / ������ �����ڵ� / ");
		for(int i = 0 ; i < bankData.size() ; i++) {
			if(bankData.get(i).getUserDebitNum().equals(debitNum)) {
				BankData tempBD = bankData.get(i);
				if(tempBD.getTrState().equals(bd.DEPOSIT)) {
					depositHisPrint(tempBD);
				}else if(tempBD.getTrState().equals(bd.WITHDRAWAL)) {
					
				}else if(tempBD.getTrState().equals(bd.RECV_REMITTANCE)) {
					
				}else if(tempBD.getTrState().equals(bd.CALL_REMITTANCE)) {
						
				}
			}
		}
	}
	
	/*�Ա� ���� ���*/
	public void depositHisPrint(BankData bankData) {
		System.out.println(bankData.getTrHisNo() + " / " + bankData.getRecvDebitNum() + " / " + bankData.getUserDebitNum() + " / " 
				+ "�Ա�" + " / " + bankData.getRecvUserName() + "/" + bankData.getRecvDebitNum() + " / "
				+ " / " + bankData.getRecvBankName() + " / " + bankData.getCallUserName() + " / " + bankData.getCallDebitNum()
				+ " / " + bankData.getCallBankName() + " / " + bankData.getCallRemittance() + " / " + bankData.getDebitBalance());
		
	}
}
