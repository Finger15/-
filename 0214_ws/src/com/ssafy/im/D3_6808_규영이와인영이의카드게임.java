package com.ssafy.im;

import java.io.*;
import java.util.*;

public class D3_6808_규영이와인영이의카드게임 {
	
	static int size = 9;
	static int[] arr;
	static int[] arr2;
	static int[] tmp;
	static boolean[] check;
	static int gwin;
	static int iwin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("input_D3_6808_규영이와인영이의카드게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[size];			// 변수 초기화
			arr2 = new int[size];
			tmp = new int[size];
			check = new boolean[2*size +1];
			gwin = 0;
			iwin =0;
			
			for(int i=0; i<size; i++) {		// 규영이 카드
				arr[i] = Integer.parseInt(st.nextToken());
				check[arr[i]] = true;
			}
			
			int cnt=0;
			
			for(int i=1; i<check.length; i++) {	// 인영이 카드
				if(!check[i]) tmp[cnt++] = i;
			}
			
			perm(0,0);
			
			System.out.println("#"+tc+" "+gwin+" "+iwin);
		}
	}

	public static void perm(int num, int j) {
		if(num == size) {		// 9자리를 다 뽑았으면
			whoisWin();
		}
		
		for( int i=0; i<size; i++) {
			if((j & 1<<i)!=0) continue;	
			arr2[num] = tmp[i];
			perm(num+1, j|1<<i);
		}
		
	}
	
	public static void whoisWin() {		// 게임
		int gscore = 0;
		int iscore = 0;
		
		for(int i=0; i<size; i++) {	// 이긴 사람이 서로의 카드의 합을 점수로 얻음
			if(arr[i]>arr2[i]) gscore += arr[i]+arr2[i];
			else if(arr[i]<arr2[i]) iscore += arr[i]+arr2[i];
		}
		
		if(gscore > iscore) gwin++;	// 최종 점수가 높은 쪽이 이김
		else if(gscore < iscore) iwin++;
	}

}
