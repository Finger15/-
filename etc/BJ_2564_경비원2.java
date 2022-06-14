package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2564_경비원2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int M = Integer.parseInt(line[0]);
		int N = Integer.parseInt(line[1]);
		int S = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		int totalLength = (N+M) *2;
		
		for(int tc = 0; tc < S+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			
			if(dir ==1) {
				list.add(pos);
			} else if (dir == 2) {
				list.add(M + N+(M-pos));
			} else if (dir == 3) {
				list.add(2*M + N +(N-pos));
			} else {
				list.add(M + pos);
			}
		}
		
		int leng = list.get(list.size() -1);
		int ans = 0;
		
		for(int i=0; i<S; i++) {
			int tmp = Math.abs(list.get(i) - leng);
			ans += Math.min(tmp, totalLength - tmp);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		System.out.println(sb);
		br.close();
	}

}
