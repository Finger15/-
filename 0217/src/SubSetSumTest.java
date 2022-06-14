
import java.util.Scanner;

public class SubSetSumTest {

	static int N, input[], S, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt(); // 집합의 크기
		 S = sc.nextInt(); // 목표 합
		 ans =0;
		 
		 input = new int[N];
		 isSelected = new boolean[N];
		 
		 for(int i=0; i<N; i++) {
				input[i] = sc.nextInt();
			}
		 generateSubset2(0,0);
		 System.out.println(ans); // <<--공집합 포함되어서 나옴 집합을 제외하려면 부분집합의 원소수를 관리하는 변수 선언

	}
	
	public static void generateSubset(int cnt) { // 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		
		if(cnt==N) {
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) sum += input[i];
			}
			
			if(sum == S) {
				++ans;
				for(int i=0; i<N; i++) {
					System.out.print(isSelected[i]?input[i]+" ":"");
				}
				System.out.println();
			}
		
			return;
		}
		
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
	
	public static void generateSubset2(int cnt, int sum) { // 부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
														   // sum : 직전까지 구성된 부분집합의 합
		if(sum == S) {
			++ans;
			for(int i=0; i<cnt; i++) {
				System.out.print(isSelected[i]?input[i]+" ":"");
			}
			System.out.println();
			return;
		}
		
		if(sum>S) return;
		
		
		if(cnt==N) return;	// 마지막 원소까지 부분집합에 다 고려된 상황
		
		
		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset2(cnt+1,sum+input[cnt]);
		
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset2(cnt+1,sum);
	}

}
