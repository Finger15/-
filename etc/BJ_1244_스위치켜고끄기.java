package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_1244_스위치켜고끄기 {
	
	static int[] switchs;
	static int N,M;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switchs = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i< N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		int[][] students = new int[M][2];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			switch(students[i][0]) {
			case 1 : 
				
				int tmp = students[i][1];
				
				for(int j=0; j<N; j++) {
					if((j+1) % tmp == 0) {
						if(switchs[j]== 0) {
							switchs[j] = 1;
							continue;
						}
						switchs[j] = 0;
					}
				}
				
				break;
				
			case 2 : 
				
				int k = 0;
				int tmp2 = students[i][1];
				
				while(true) {
					if(tmp2-1 - k < 0 || tmp2-1 + k >= N) {
						break;
					}
					
					if(switchs[tmp2-1-k] != switchs[tmp2 -1 +k]) {
						break;
					}
					
					if(switchs[tmp2-1-k] == 0) {
						switchs[tmp2-1-k] = switchs[tmp2-1+k] = 1;
					}
					else {
						switchs[tmp2-1-k] = switchs[tmp2-1+k] = 0;
					}
					
					k++;
				}
				
				break;
			}
		}
		
			for(int i=0; i<N; i++) {
				System.out.print(switchs[i] + " ");
				
				if((i+1) % 20 == 0) {
					System.out.println();
				}
			}
	}

}
