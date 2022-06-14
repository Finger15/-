import java.util.Scanner;

public class SubSetBinaryCountingTest {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] input = new int[N];
		 
		 for(int i=0; i<N; i++) {
				input[i] = sc.nextInt();
			}
		 generateSubset(input);

	}

	private static void generateSubset(int[] input) {
		int N = input.length;
		// N이 어차피 30이 넘을수가 없으니 오버플로우가 안남 32비트까지 비트연산 제공
		for (int flag = 0, caseCount= 1<<N; flag < caseCount; flag++) {
			// flag = 원소들의 선택상태의 비트열
			for (int i = 0; i < N; i++) {	// 각 비트열의 상태를 확인
				if((flag & 1<<i) != 0) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
		}
		
	}

}
