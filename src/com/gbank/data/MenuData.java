package com.gbank.data;

import java.util.Stack;

public class MenuData {
	private Stack<Integer> menuSelect	= new Stack<Integer>();
	private Stack<Integer> menuNo 		= new Stack<Integer>();
	
	public void popMenuSelect() {
		this.menuSelect.pop();
	}
	public void pushMenuSelect(int menuSelect) {
		this.menuSelect.push(menuSelect);
	}
	public int peekhMenuSelect() {
		return this.menuSelect.peek();
	}
	public boolean emptyhMenuSelect() {
		return this.menuSelect.empty();
	}
	
	public void popMenuNo() {
		this.menuNo.pop();
	}
	public void pushMenuNo(int menuNo) {
		this.menuNo.push(menuNo);
	}
	public int peekhMenuNo() {
		return this.menuNo.peek();
	}
	public boolean emptyhMenuNot() {
		return this.menuNo.empty();
	}
	
	
}
