package com.ssafy.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream("input_D3_1289_원재의메모리복구하기.txt"));
		
		int tc = in.nextInt();
	
		for(int i =0; i < tc; i ++) {
			int cnt = 0;
			String tmp = in.next();
			
			for(int k = 0; k < tmp.length(); k++) {
				if(k==0) {	
					if(tmp.charAt(k)=='1') {	// 이 부분은 startsWith로 판별해도 좋음
						cnt++;
					}
				}
				else {
					if(tmp.charAt(k) != tmp.charAt(k-1)) {
						cnt++;
					}
				}
			}
			
			System.out.println("#"+(i+1)+" "+cnt);
			
		}
	}

}
