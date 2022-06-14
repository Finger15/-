package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr =  new int[N+1];
		arr[0] = 0;

		for(int i=1; i<=N; i++){
		
			int min = Integer.MAX_VALUE;
			
			if(i>3) {
				if(i>=1 && arr[i-1]+1 < min) min = arr[i-1] +1;
				if(i % 2 == 0 && arr[i/2]+1 < min) min = arr[i/2] +1;
				if(i % 3 == 0 && arr[i/3]+1 < min) min = arr[i/3] +1;
			}
			
			else if (i>1 && i<=3){
				min = 1;
			} else {
				min = 0;
			}
			
			arr[i] = min;
		}
		
		System.out.println(arr[N]);

	}

}
