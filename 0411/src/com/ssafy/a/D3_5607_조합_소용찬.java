package com.ssafy.a;

import java.util.*;
import java.io.*;

public class D3_5607_조합_소용찬 {
	static int p = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] factorial = new long[1000000+1];
		factorial[0] = 1;
		
		for(int i=1; i<=1000000 ; i++) {
			factorial[i] = (factorial[i-1]*i) % p;
		}

		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
		
			// nCr mod p = n! mod p * ((n-r)! * r!) **p-2 mod p
			
			long top = factorial[N] % p;
	        long bottom = ((factorial[N-R] % p ) * (factorial[R] % p)) % p;
			long bottom_power = power(bottom, p-2);
			
			sb.append((top * bottom_power) % p);
		    System.out.println(sb);
		}
		
	}
	
	static long power(long a, long b) {
		if(b == 0) {
			return 1;
		}
		
		long result = power(a, b/2);
		
		if(b % 2 ==0) {
			return ((result % p) * (result % p)) % p;
		}
		else {
			return (((result * a) %p) * (result %p)) % p;
		}
	}
}
