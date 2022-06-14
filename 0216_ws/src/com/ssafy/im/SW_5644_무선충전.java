package com.ssafy.im;

import java.util.*;
import java.io.*;

public class SW_5644_무선충전 {
	
	static class BC{
		public int x;	// col
		public int y;	// row
		public int C;	// 범위
		public int P;	// 성능
		
		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}

		public int getD(int col, int row) {
			return Math.abs(this.x-col)+ Math.abs(this.y - row);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());  // 명령어수
			int bc_Number =  Integer.parseInt(st.nextToken()); // 배터리수
			int[][] commands = new int [2][size];
			BC[] bcs = new BC[bc_Number];
			int[] al = new int[2];
			int[] bl = {9,9};
			boolean[] ab = new boolean[bc_Number];
			boolean[] bb = new boolean[bc_Number];
			int sum = 0;
	
			for(int j=0; j<2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<size; i++) {
					commands[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i<bc_Number; i++) {
				st = new StringTokenizer(br.readLine());
				bcs[i] = new BC(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				
			}
			
			sum += getCharge(al, bl, bcs, ab, bb);
			
			for(int i=0; i<size; i++) {
				movingMan(al,commands[0][i]);
				movingMan(bl,commands[1][i]);
				sum += getCharge(al, bl, bcs, ab, bb);

				Arrays.fill(ab, false);
				Arrays.fill(bb, false);
			}
			sb.append(sum);
			System.out.println(sb);
		}
		
	}
	
	public static void movingMan(int[] arr, int cmd) {
		if(cmd == 1) {
			arr[0] -= 1;	// 상
		}
		else if(cmd == 2) {
			arr[1] += 1;	// 우
		}
		else if (cmd == 3) {
			arr[0] += 1;	// 하
		}
		else if(cmd == 4) {
			arr[1] -= 1;	// 좌
		}
	}
	
	public static int check(int[] arr, BC[] bcs, boolean[] arr2) {
		int cnt =0;
		
		for(int i=0; i<bcs.length; i++) {
			if(bcs[i].C >= bcs[i].getD(arr[1], arr[0])) {
				cnt++;
				arr2[i] = true;
			}
		}
		
		return cnt;
	}
	
	public static int getCharge(int[] al, int[] bl, BC[] bcs, boolean[] ab, boolean[] bb) {
		int acharge = 0;
		int bcharge = 0;
		int sum =0;
		
		if(check(al,bcs,ab) == 0 && check(bl,bcs,bb) == 0) {
			return 0;
		}
		
		else if(check(al,bcs,ab) == 0 || check(bl,bcs,bb) == 0) {
			if(check(al,bcs,ab) == 0) {
				
				for(int i=0; i<bb.length; i++) {
					if(bb[i]) {
						bcharge = Math.max(bcharge, bcs[i].P);
						
					}
				}
				
				return bcharge;
			}
			
			else {
				for(int i=0; i<ab.length; i++) {
					if(ab[i]) {
						acharge = Math.max(acharge, bcs[i].P);
					}
				}
				
				return acharge;
			}
		}
		
		else {
			for(int i =0; i<ab.length; i++) {
				for(int j=0; j<bb.length; j++) {
					if(ab[i] && bb[j] && i==j) {
						acharge = bcs[i].P/2;
						bcharge = bcs[i].P/2;
						sum = Math.max(sum, acharge+bcharge);
						
					}
					else if(ab[i] && bb[j] && i!=j) {
						acharge = bcs[i].P;
						bcharge = bcs[j].P;
						sum = Math.max(sum, acharge+bcharge);
						
					}
					else if(ab[i] && !bb[j]) {
						acharge = bcs[i].P;
						sum = Math.max(sum, acharge+bcharge);
						
					}
					else if(!ab[i] && bb[j]) {
						bcharge = bcs[j].P;
						sum = Math.max(sum, acharge+bcharge);
						
					}
					
					acharge = 0;
					bcharge = 0;
				}
			}
			
			return sum;
		}
		
	}
	
}