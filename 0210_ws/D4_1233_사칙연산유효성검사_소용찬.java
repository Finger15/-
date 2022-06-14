package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_D4_1233_사칙연산유효성검사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
		
			int size = Integer.parseInt(br.readLine());
			int operator = 0;
			int numbers = 0;
			int result = -1;
			
			for(int i=1; i<=size/2; i++) {
				String str = br.readLine();
				
				if(i<=9) {	
					char tmp = str.charAt(2);
						
					if(tmp == '-' || tmp == '/' || tmp == '+'|| tmp == '*') operator++;											
					else numbers++;
				}
				else {
					
					char tmp = str.charAt(3);
					
					if(tmp == '-' || tmp == '/' || tmp == '+'|| tmp == '*') operator++;															
					else numbers++;											
				}			
			}
			
			for(int i=size/2+1; i<=size; i++) {
				String str = br.readLine();
				char tmp = str.charAt(3);
				
				if(tmp == '-' || tmp == '/' || tmp == '+'|| tmp == '*') result = 0;												
				else numbers++;					
				
			}
			
			if(result == 0) {
				sb.append(result);
			}
			else {
				if(operator + 1 == numbers) result = 1;
				else result = 0;
				sb.append(result);
			}
			System.out.println(sb.toString());
		}

	}

}
