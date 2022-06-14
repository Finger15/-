package com.ssafy.im;

import java.util.*;
import java.io.*;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<Student> q = new PriorityQueue<>();
		q.add(new Student("a",100,100,100));
		q.add(new Student("b",100,100,90));
		q.add(new Student("c",100,80,50));
		q.add(new Student("d",70,100,100));
		q.add(new Student("e",50,30,100));
		q.add(new Student("f",50,45,100));
		
		for(int i=0; i<6; i++) {
			System.out.println(q.poll());
		}
	}

	public static void main1(String[] args) {
		// 정렬
		// Array.sort(arr)
		// Collection.sort(collection)
		
		// 정렬 변경 : 내림차순, 정렬 항목이 여러개
		// 도메인 클래스 적용설계, inner-class Array.sort(arr, arg), Collections.sort(collection, arg)
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(2);
		q.add(5);
		q.add(1);
		q.add(4);
		q.add(3);
		
		for(int i=0; i<5; i++) {
			System.out.println(q.poll());
		}
		
		q = new PriorityQueue<>(Collections.reverseOrder());
		q.add(2);
		q.add(5);
		q.add(1);
		q.add(4);
		q.add(3);
		
		for(int i=0; i<5; i++) {
			System.out.println(q.poll());
		}
	}

}

class Student implements Comparable<Student>{
	String name;
	int java;	// 1순위
	int algo;	// 2순위
	int web;	// 3순위
	
	public Student(String name, int java, int algo, int web) {
		this.name = name;
		this.java = java;
		this.algo = algo;
		this.web = web;
	}

	@Override
	public String toString() {
		return  name + ", " + java + ", " + algo + "," + web ;
	}
	
	
	// 1 순위 java, 2순위 algo, 3순위 web
	@Override
	public int compareTo(Student o) {
		if (this.java == o.java){
			if(this.algo == o.algo) {
				return Integer.compare(this.web, o.web);
			}
			else {
				return Integer.compare(this.algo, this.algo);
			}
		}
		else {
			return Integer.compare(this.java, o.java);
		}
		
	}

}
