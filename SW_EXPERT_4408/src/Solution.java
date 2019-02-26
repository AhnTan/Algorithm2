import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size;
	int std;

	int result;

	int array[];
	int room_array[];

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {

		try {
			case_size = Integer.parseInt(reader.readLine());

			for (int i = 1; i <= case_size; i++) {

				result = 0;
				std = Integer.parseInt(reader.readLine());
				array = new int[std * 2];
				room_array = new int[400+1];

				init();
				writer.write("#" + i + " " + result + "\n");
			}
			writer.flush();
			writer.close();

		} catch (Exception e) {	}

	}

	public void init() {
		try {
			for (int i = 0; i < array.length; i += 2) {
				String s[] = reader.readLine().split(" ");
				int num1 = Integer.parseInt(s[0]);
				int num2 = Integer.parseInt(s[1]);
				if(num2 > num1) {
					array[i] = num1;
					array[i + 1] = num2;
				}else {
					array[i] = num2;
					array[i + 1] = num1;	
				}
				}

			for (int i = 0; i < array.length; i += 2) {
				calc(array[i], array[i + 1]);
			}
			
			
			for(int i=1; i<room_array.length; i++) {
				if(result<room_array[i]) {
					result = room_array[i];
				}
			}
		
		} catch (Exception e) {	}
	}

	public void calc(int start, int finish) {
		for(int i=start; i<=finish; i++) {
			room_array[i]++;
		}
		if(finish%2 == 1) {
			room_array[finish+1]++;
		}
	}
}
