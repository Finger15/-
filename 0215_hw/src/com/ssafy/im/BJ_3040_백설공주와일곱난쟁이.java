package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_3040_백설공주와일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[9];
		int sum =0;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9;j++) {
				if(sum - arr[i] - arr[j] == 100) {
					arr[i] =0;
					arr[j] =0;
					break;
				}
			}
			if(arr[i]==0) {
				break;
			}
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i] == 0) continue;
			sb.append(arr[i]).append("\n");
		}
		sb.setLength(sb.length() -1);
		System.out.print(sb.toString());
	}

}
