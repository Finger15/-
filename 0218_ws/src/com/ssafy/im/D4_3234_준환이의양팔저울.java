package com.ssafy.im;

import java.util.*;
import java.io.*;

public class D4_3234_준환이의양팔저울 {
	
	static int ans, N;
	static int[] numbers;
	static int[] result;
	static boolean[] isSelceted;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = new int[N];
			result = new int[N];
			isSelceted = new boolean[N];
			ans = 0;
			
			for(int i=0; i<N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			sb.append(ans);
			System.out.println(sb);
		}
	}
	
	public static void permutation(int n) {
		if(n==N) {
			setWeight(0,0,0);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelceted[i]) continue;
			result[n] = numbers[i];
			isSelceted[i] = true;
			permutation(n+1);
			isSelceted[i] = false;
		}
	}
	
	public static void setWeight(int No, int leftsum, int rightsum) {	// 추를 올리는 번호

		if(No == N) {
			ans++;
			return;
		}
		
		setWeight(No+1, leftsum + result[No], rightsum);
		
		if(leftsum >= rightsum+result[No]) {
			setWeight(No+1,leftsum, rightsum+result[No]);
		}
					
	}
}
