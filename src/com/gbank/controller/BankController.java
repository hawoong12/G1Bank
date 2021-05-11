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
		System.out.println(debitData.get(debitUniq).getDebitPhone() + "님의 계좌 잔고는 " 
					+ debitData.get(debitUniq).getDebitBalance() + " 원입니다.");
		
		/*입출금 내역 기록 메서드 제작 해야함*/
		depsitNWithdrawalHisController(debitData, bankData, deposit, debitUniq, bd.DEPOSIT);
	}
	
	public String serchUserDebit(ArrayList<DebitData> debitData, int serchTyp, String serchData) {
		System.out.println("계좌 검색을 실행합니다.");
		for (int i = 0; i < debitData.size(); i++) {
			switch (serchTyp) {
				case 1: /*폰번호 -> 대표계좌 검색*/
					if (debitData.get(i).getDebitPhone().equals(serchData)) {
						System.out.println("폰번호로 대표계좌를 찾았습니다.");
						return debitData.get(i).getDebitNum();
					}
					break; 
				case 2: /*계좌번호 -> 계좌번호순서*/
					if (debitData.get(i).getDebitNum().equals(serchData)) {
						System.out.println("계좌번호로 계좌번호 유니크 번호를 찾았습니다.");
						return i+"";
					}
					break;
				default:
					break;
			}
		}
		System.out.println("폰번호로 검색했으나 계좌가 존재하지 않습니다.");
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
	

	public void depsitHisInsert(ArrayList<DebitData> debitData, ArrayList<BankData> bankData, int deposit, int debitUniq) {
		
		BankData tempBankData = new BankData(debitUniq+""
											 , depsWithdHisCount(debitData, bankData, debitUniq) +""
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
	
	/*현재날짜 시간 리턴*/
	public String dateReturnToString() {
		Date date = new Date();        
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.systemDefault());
		String dateToStr = format.format(date.toInstant()); 
		
		return dateToStr;
	}
}
