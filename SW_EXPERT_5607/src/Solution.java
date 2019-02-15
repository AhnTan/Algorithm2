import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	int case_size ;
	long array[];
	int p = 1234567891;	 // 소수
	
	int n,r;
	long result;
	
	
	// 페르마의 소정리를 이용한 풀이가 필요함
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
		
			for(int i=0; i<case_size; i++) {
				init();
				writer.write("#" + (i+1) + " " + result + "\n");
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {}
	}
	
	public void init() {
		try {
			String s[] = reader.readLine().split(" ");
			n = Integer.parseInt(s[0]);		// 1 <= N <= 1000000
			r = Integer.parseInt(s[1]);     // 0 <= R <= N
			
			array = new long[n+1];		// 팩토리얼값을 %p 한 값을 저장할 배열
			
			fact(n);
			
			
		}catch(Exception e) {}
	}
	
	public void fact(int n) {
		
		array[0] = 1;
		for(int i=1; i<array.length; i++) {
			array[i] = ( i * array[i-1] ) % p;
		}
		
		result = array[n] * power(array[n-r] * array[r] % p, p-2) % p ;		// ★페르마의 소정리★ 이용, nCr 한 결과값    n! / ((n-r)! * (r)!)
		
	}
	
	
	public long power(long base, long ex) {				// 재귀함수, base ^ ex(제곱) 을 리턴하는 함수
		if(ex == 0) {			// 종료파트
			return 1;
		}
		else if(ex == 1){			// 종료파트
			return base;
		}
		else {
			
			if(ex % 2 == 0) {		// 짝수파트
				long result = power(base, ex/2);
				return result * result % p;
			}
			else if(ex % 1 == 0){	// 홀수파트
				long result = power(base, (ex-1)/2);
				return (result * result) % p * base % p;		// 중간에 (result * result) 뒤에 %p 한것은 long형을 넘어갈수있으므로
			}
			
			return ex;
		}
		
	}
}
