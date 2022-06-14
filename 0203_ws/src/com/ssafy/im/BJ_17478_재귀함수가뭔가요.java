package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_17478_재귀함수가뭔가요 {
	
	private static String a;
	private static String b;
	private static String c;
	private static String d;
	private static String back;
	private static String front;
	private static int tc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		a = "\"재귀함수가 뭔가요?\"";
		b = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		c = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		d = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		front = "____";
		back = "라고 답변하였지.";
		
		whatisRecursion(0);
		
	}
	
	public static void whatisRecursion(int n) {
		
		if(n == 0) {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			whatisRecursion(n+1);
			System.out.println(back);
		}
		
		else if( n == tc) {
			String st = "";
			

			for(int i =0; i<n; i++) {
				st += front;
			}
			System.out.println(st+a);
			System.out.println(st+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(st+back);
			return;
		}
		
		else {
			String st = "";
			
			for(int i =0; i<n; i++) {
				st += front;
			}
			
			System.out.println(st+a);
			System.out.println(st+b);
			System.out.println(st+c);
			System.out.println(st+d);
			whatisRecursion(n+1);
			System.out.println(st+back);
		}
	}
}
