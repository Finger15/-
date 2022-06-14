package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_1223_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 계산기3을 먼저 풀었기 때문에 계산기2는 계산기3과 소스코드가 동일하다.
//		System.setIn(new FileInputStream("input_D4_1223_계산기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10; 	// 총 10개의 테스트 케이스
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			Stack<Character> st = new Stack<Character>();
			
			for(int i =0; i < size; i++) {
				int p = setPriority(str.charAt(i));
				char c = str.charAt(i);
					
				switch(c) {		// 연산자를 우선순위를 고려해 후위표기식으로 바꾼다
				case '+':
				case '-':
				case '*':
				case '/':
					while(!st.isEmpty() && setPriority(st.peek()) >= p) {
						sb.append(st.pop());
					}
					st.push(c);
					break;
				case '(':
					st.push(c);
					break;
				case ')':	// 괄호는 우선적으로 처리해야 하기 때문에 괄호가 닫히면 이전 괄호까지 pop
					while(!st.isEmpty() && st.peek() != '(') {
						sb.append(st.pop());
					}
					st.pop();
					break;
					
				default:
					sb.append(c);
				}	
				
			}
			
			while(!st.isEmpty()) {			
				sb.append(st.pop());
			}
			
			str = sb.toString();
			int sum = getInfixResult(str);
			
			System.out.println("#"+tc+" "+sum);
			
		}
		
	}
	
	public static int setPriority(char ch) {		// 연산자간의 우선순위 설정 메서드
	    switch (ch) {
	        case '*':
	        case '/':
	            return 2;
	        case '+':
	        case '-':
	            return 1;
	        case '(':
	        case ')':
	            return 0;
	    }
	    return -1;
	}
	
	public static int getInfixResult(String postfix) {		// 후위 수식으로 변환된 수식을 계산하는 메서드
        int sum = 0;
        String[] op = {"+", "-", "*", "/"};
        Stack<Integer> st = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Arrays.asList(op).contains(c +"")) {
                int two = st.pop();
                int one = st.pop();

                switch (c) {
                    case '+':
                        st.push(one + two);
                        break;
                    case '-':
                        st.push(one - two);
                        break;
                    case '*':
                        st.push(one * two);
                        break;
                    case '/':
                        st.push(one / two);
                        break;
                }
            } else {
                st.push(c-'0');		//  char형 c를 int로 
            }
        }
        sum = st.pop();
        return sum;
    }

}
