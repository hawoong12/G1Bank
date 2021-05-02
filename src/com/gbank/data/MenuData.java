package com.gbank.data;

import java.util.Stack;

/**
 * @author JIWONKIM
 *
 */
public class MenuData {
	private Stack<Integer> menuNo 		= new Stack<Integer>();
	
	public void popMenuNo() {
		this.menuNo.pop();
	}
	public void pushMenuNo(int menuNo) {
		this.menuNo.push(menuNo);
	}
	public int peekhMenuNo() {
		return this.menuNo.peek();
	}
	public boolean emptyhMenuNo() {
		return this.menuNo.empty();
	}
}
