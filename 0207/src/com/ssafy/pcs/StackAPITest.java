package com.ssafy.pcs;

import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		System.out.println(st.size()+"//"+st.isEmpty());
		
		st.push("이진규");
		st.push("이진규2");
		st.push("이진규3");
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.peek());
		st.pop();
		st.pop();
		System.out.println(st.size()+"//"+st.isEmpty());
		
		

	}

}
