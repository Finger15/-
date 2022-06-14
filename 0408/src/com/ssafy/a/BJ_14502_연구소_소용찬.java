package com.ssafy.a;

import java.util.*;
import java.io.*;

public class BJ_14502_연구소_소용찬 {
    static int R;
    static int C;
    static int[][] map;
    static int ans = Integer.MIN_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++){
                int item = Integer.parseInt(st.nextToken());
                map[i][j] = item;
            }
        }
        dfs(0);
        System.out.println(ans);
    }
    
    public static void dfs(int depth){
    	
        if (depth == 3){
            int[][] forCopy = new int[R][C];
            arrCopy(forCopy, map);
            bfs();
            arrCopy(map, forCopy);
            return;
        }
        
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void bfs(){
    	
        Queue<Dot> q = new LinkedList<>();
        
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] == 2) q.add(new Dot(i, j));
            }
        }
        
        while (!q.isEmpty()) {
        	
            Dot item = q.poll();
            
            for (int i = 0; i < 4; i++){
                int newR = item.r + dr[i];
                int newC = item.c + dc[i];
                if (0 <= newR && newR < R && 0 <= newC && newC < C && map[newR][newC] == 0){
                    map[newR][newC] = 2;
                    q.add(new Dot(newR, newC));
                }
            }
        }
        calc();
    }
    
    public static class Dot{
        int r, c;
        public Dot(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public static void arrCopy(int[][] target, int[][] org){
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                target[i][j] = org[i][j];
            }
        }
    }
    
    public static void calc(){
        int sum = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] == 0) sum++;
            }
        }
        ans = Math.max(sum, ans);
    }
}
