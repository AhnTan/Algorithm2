import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int bus_array[];
	int case_size;
	int N, num1, num2;
	String result;
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			for(int i=1; i<=case_size; i++) {
				N = Integer.parseInt(reader.readLine());
				bus_array =  new int[5001];
				result = "#"+i+" ";
				init();
				writer.write(result+"\n");
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
	}
	
	public void init() {
		try {
			for(int i=0; i<N; i++) {
				String s[] = reader.readLine().split(" ");
				calc(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			}
			
			int P = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<P; i++) {
				int find_num = Integer.parseInt(reader.readLine());
				result += bus_array[find_num] + " ";
			}
			
		}catch(Exception e) {}
	}

	public void calc(int num1, int num2) {
		for(int i=num1; i<=num2; i++) {
			bus_array[i]++;
		}
	}
}
