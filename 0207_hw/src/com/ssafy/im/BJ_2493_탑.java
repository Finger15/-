package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_BJ_2493_탑.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<int[]>();	// int형 배열을 갖는 스택
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<size; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek()[0] < number) {
					stack.pop();
				}
				else {
					System.out.print(stack.peek()[1]+" ");
					break;
				}
			}
				if(stack.empty()) {
					System.out.print("0 ");
				}
				stack.push(new int[] {number,i+1});		//int형 배열 0번쨰 요소는 탑의높이 1번째 요소는 탑의 인덱스
		}
	
	}

}
