package com.ssaafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_D4_1218_괄호짝짓기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int size = Integer.parseInt(br.readLine());
			
			sb.append("#").append(tc).append(" ");
			Stack<Character> st = new Stack<Character>();
			
			String pare = br.readLine();
			
			
			for(int i=0; i<size; i++) {
				
				if(st.isEmpty()) {
					st.push(pare.charAt(i));
				}
				
				else {
					if(st.peek() == '{' && pare.charAt(i) == '}' || st.peek() == '(' && pare.charAt(i) == ')'
							|| st.peek() == '<' && pare.charAt(i) == '>' || st.peek() == '[' && pare.charAt(i) == ']') {
						st.pop();
					}
					else {
						st.push(pare.charAt(i));
					}
					
				}
				
			}
			
			int result = 0;
			
			if(st.isEmpty()) {
				result = 1;
			}
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
