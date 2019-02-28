import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size, count;
	int N;
	int array[] = new int[999];

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		try {
			init();
			case_size = Integer.parseInt(reader.readLine());

			for (int i = 1; i <= case_size; i++) {
				N = Integer.parseInt(reader.readLine());
				calc();
				writer.write("#" + i + " " + count + "\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
		}
	}

	public void init() {
		for (int i = 2; i < array.length; i++) {
			array[i] = i;
		}
		for (int i = 2; i < array.length; i++) {
			for (int j = i * 2; j < array.length; j += i) {
				if (j % i == 0) {
					array[j] = 0;
				}
			}
		}
	}

	public void calc() {
		count = 0;
		for (int i = 2; i < N; i++) {
			if (array[i] != 0) {
				for (int j = i; j < N - i; j++) {
					if (array[j] != 0) {
						for (int k = j; k < N - j; k++) {
							if (array[k] != 0 && (N == (array[i] + array[j] + array[k]))) {
								count++;
								// System.out.println("N = " + "i : " + i + " j : " + j + " k : " + k);
							}
						}
					}
				}
			}
		}
	}
}
