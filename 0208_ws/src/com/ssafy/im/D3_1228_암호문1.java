package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		System.setIn(new FileInputStream("input_D3_1228_암호문1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=10;	// 테스트케이스 10개
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			LinkedList<Integer> lk = new LinkedList<Integer>();
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<size; i++) {
				lk.add(Integer.parseInt(st.nextToken()));	// 값 입력
			}
			
			int size2 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i< size2; i++) {
				String mod = st.nextToken();	// I값 받기
				int index = Integer.parseInt(st.nextToken());  // 값을 넣어줄 인덱스
				int size3 = Integer.parseInt(st.nextToken());  // 반복문의 횟수
				
				
				for(int j =index; j<index+size3; j++) {
					lk.add(j, Integer.parseInt(st.nextToken()));	// 값 수정
				}	
			}
			
			for(int i=0; i<10; i++) {
				sb.append(lk.get(i)).append(" ");
			}
			System.out.println(sb);
			
		}

	}

}
