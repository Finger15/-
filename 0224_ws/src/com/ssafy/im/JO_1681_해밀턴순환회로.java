package com.ssafy.im;

import java.util.*;
import java.io.*;

public class JO_1681_해밀턴순환회로 {
	static int n;
	static int cost[][];
	static boolean vis[];
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		cost=new int[n][n];
		for (int i = 0; i < n; i++) {
			String str=br.readLine();
			StringTokenizer st=new StringTokenizer(str);
			for (int j = 0; j < n; j++) {
				cost[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 출발지점은 1이다.
		vis=new boolean[n];
		vis[0]=true;
		go(1,0,0);
		System.out.println(answer);
	}
	private static void go(int cnt, int cur,int sum) {
		if(sum>answer)return;//시간 초과 통과하는 방법
		if(cnt==n) {
			//시작지점으로 돌아가는 방법이 있을 때
			if(cost[cur][0]!=0 && answer>sum+cost[cur][0]) {
				answer=sum+cost[cur][0];
			}
			return;
		}
		for (int i = 1; i < n; i++) {
			if(cost[cur][i]==0 || vis[i])continue;
			vis[i]=true;
			go(cnt+1,i,sum+cost[cur][i]);
			vis[i]=false;
		}
	}
}