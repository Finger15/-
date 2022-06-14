package com.ssafy.io;

import java.util.Scanner;


public class IO1_ScannerTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 기? : ");
		System.out.println("==> SSAFY "+sc.nextInt()+"기");
		
		System.out.println("우리 기수를 나타내는 한마디?");
		System.out.println("==>"+sc.nextLine());

	}

}
