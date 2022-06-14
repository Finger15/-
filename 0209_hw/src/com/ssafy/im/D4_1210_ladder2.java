package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1210_ladder2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 System.setIn(new FileInputStream("input_D4_1210_Ladder1.txt"));
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 
		 int SIZE = 100;
		 int TC = 10;
	        StringBuilder sb = new StringBuilder();
	        for (int tc = 1; tc <= TC; tc++) { // test case 반복문.
	            int t = Integer.parseInt(in.readLine()); // 테스트 케이스의 번호.
	            sb.append("#").append(t).append(" ");
	 
	            StringTokenizer st;
	            int[][] map = new int[SIZE][SIZE];
	            int[] dest = new int[2];
	            for (int row = 0; row < SIZE; row++) {
	                st = new StringTokenizer(in.readLine(), " ");
	                for (int col = 0; col < SIZE; col++) {
	                    map[row][col] = Integer.parseInt(st.nextToken());
	                    if (map[row][col] == 2) {
	                        dest[0] = row;
	                        dest[1] = col;
	                    }
	                }
	            }
	 
	            int row = dest[0], col = dest[1];
	            boolean isMove = false;
	            while (row >= 0) { // 목적지부터 시작하기 때문에 row는 감소(위로 올라감)
	 
	                while (col - 1 >= 0 && map[row][col - 1] == 1) {
	                    col--;
	                    isMove = true;
	                }
	 
	                if (isMove) {
	                    row--;
	                    isMove = false;
	                    continue;
	                }
	 
	                while (col + 1 < SIZE && map[row][col + 1] == 1) {
	                    col++;
	                }
	 
	                row--;
	            }
	 
	            sb.append(col);
	            sb.append("\n");
	        } // test case 반복문.
	 
	        System.out.println(sb.toString());

	}

}
