package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2477_참외밭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = 6;
		StringTokenizer st = null;
		int[][] arr = new int[N][2];
		int max_x = Integer.MIN_VALUE;
		int max_y = Integer.MIN_VALUE;
		int sum = 0;
		int tmp = 0;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			if(arr[i][0] == 1 || arr[i][0] == 2 ) {
				max_x = Math.max(max_x, arr[i][1]);
			}
			else if(arr[i][0] == 3 || arr[i][0] == 4 ) {
				max_y = Math.max(max_y, arr[i][1]);
			}
		}
		
		for(int i=0; i<N; i++) {
			
			if(i== N-1) {
				tmp += arr[i][1] * arr[0][1];
				break;
			}
			
			tmp += arr[i][1] * arr[i+1][1];
			
		}
	
		sum = max_x * max_y - (max_x*max_y*3 - tmp);
		sum *= M;
		
		System.out.println(sum);
		
	}

}
