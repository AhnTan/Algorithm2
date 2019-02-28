import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size;
	long array[] = new long[1000001];
	long result_array[] = new long[1000001];
	long temp=0;
	long result;

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		try {
			init();
			case_size = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= case_size; i++) {
				result = 0;

				String s[] = reader.readLine().split(" ");
				int num1 = Integer.parseInt(s[0]);
				int num2 = Integer.parseInt(s[1]);
			
				result = result_array[num2] - result_array[num1-1];
				
				writer.write("#" + i + " " + result + "\n");
			}
			writer.flush();
			writer.close();

		} catch (Exception e) {	}
	}

	public void init() {

		Arrays.fill(array, 1);

		for (int i = 2; i < array.length; i++) {
			if (i % 2 != 0) {
				for (int j = i; j < array.length; j += i) {
					if (j % i == 0) { // i가 j에 대한 약수라면
						if (i % 2 == 1) { // i가 홀수라면
							array[j] += i;
						}
					}

				}
			}
		}
		
		// 시그마 f(x) 까지의 합들을 저장해놓는곳
		for(int i=0; i<array.length; i++) {
			result_array[i] = temp + array[i];
			temp = result_array[i];
		}	
	}
	
}
