package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 배열로 구현
 */
public class CompleteBinaryTree {

	private char[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		nodes = new char[size+1];  // 1인덱스부터 사용하므로 +1크기로 잡기
		SIZE = size;
	}
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	public void add(char e) {
		if(isFull()) return;
		
		nodes[++lastIndex] =e;
	}
	
	public void bfs() {
		
		// 이진트리의 탐색 순서
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		while(!queue.isEmpty()) {
			int current = queue.poll();  // 탐색 순서에 맞는 인덱스
			
			System.out.println(nodes[current]);
			
			// 현재 노드의 자식노드들의 인덱스를 다음에 순서가 되었을 때 탐색되도록 큐에 넣어준다
			// 왼쪽 자식노드
			if(current*2 <= lastIndex) queue.offer(current*2);
			// 오른쪽 자식노드
			if(current*2+1 <= lastIndex) queue.offer(current*2+1);
		}
	}
	
	public void bfs2() {
		
		// 이진트리의 탐색 순서
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		int level=0;
		while(!queue.isEmpty()) {
			System.out.print("level "+level+" : ");
			// 해당 너비의 노드들 모두 탐색, 같은 행에 출력
			int size = queue.size();
			while(--size >= 0) {
				int current = queue.poll();  // 탐색 순서에 맞는 인덱스
				
				System.out.print(nodes[current]+"\t");
				
				// 현재 노드의 자식노드들의 인덱스를 다음에 순서가 되었을 때 탐색되도록 큐에 넣어준다
				// 왼쪽 자식노드
				if(current*2 <= lastIndex) queue.offer(current*2);
				// 오른쪽 자식노드
				if(current*2+1 <= lastIndex) queue.offer(current*2+1);
			}
			
			System.out.println();
			level++;
		}
	}
	
	public void dfsbyPreOrder() {
		System.out.println("dfsbyPreOrder");
		dfsbyPreOrder(1);
		System.out.println();
	}
	
	private void dfsbyPreOrder(int current) {	// 완전탐색을 구현하기 위해 private
		
		// 현재 노드 방문 : 현재 노드가 계속 바뀌어야한다
		System.out.print(nodes[current]+"\t");
		// 현재 노드의 자식 노드들 방문
		
		if(current*2 <=lastIndex) dfsbyPreOrder(current*2);		//기저조건이자 구현부
		if(current*2+1 <=lastIndex) dfsbyPreOrder(current*2+1);
	}
	
	public void dfsbyInOrder() {
		System.out.println("dfsbyInOrder");
		dfsbyInOrder(1);
		System.out.println();
	}
	
	private void dfsbyInOrder(int current) {	// 완전탐색을 구현하기 위해 private
		
		
		// 현재 노드의 자식 노드들 방문
		
		if(current*2 <=lastIndex) dfsbyInOrder(current*2);		//기저조건이자 구현부
		// 현재 노드 방문 : 현재 노드가 계속 바뀌어야한다
				System.out.print(nodes[current]+"\t");
		if(current*2+1 <=lastIndex) dfsbyInOrder(current*2+1);
	}
	

	public void dfsbyPostOrder() {
		System.out.println("dfsbyPostOrder");
		dfsbyPostOrder(1);
		System.out.println();
	}
	
	private void dfsbyPostOrder(int current) {	// 완전탐색을 구현하기 위해 private
		
		// 현재 노드의 자식 노드들 방문
		
		if(current*2 <=lastIndex) dfsbyPostOrder(current*2);		//기저조건이자 구현부
		if(current*2+1 <=lastIndex) dfsbyPostOrder(current*2+1);
		// 현재 노드 방문 : 현재 노드가 계속 바뀌어야한다
		System.out.print(nodes[current]+"\t");
	}

}
