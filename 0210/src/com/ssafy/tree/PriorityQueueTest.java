package com.ssafy.tree;

import java.util.*;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(4);
		// 최소 힙으로 동작
		
		pq.offer(1);
		pq.offer(7);
		pq.offer(5);
		pq.offer(3);
		pq.offer(9);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}

}
