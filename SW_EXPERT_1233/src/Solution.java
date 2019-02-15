import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	// 후위 연산식으로 계산해야됨
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	String arr[];

	int case_size = 10;
	int result = 1;
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {

		try {
			for (int i = 0; i < case_size; i++) {
				init();
				writer.write("#" + (i + 1) + " " + result + "\n");
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
		
	}
	
	public void init() {
		try {
			arr = new String[Integer.parseInt(reader.readLine())+1];
			result = 1;
		
			for(int i=0; i<arr.length-1; i++) {
				String s[] = reader.readLine().split(" ");
				if(s.length == 4) {
					if(s[1].equals("*") || s[1].equals("-") || s[1].equals("+") || s[1].equals("/")) {
					}
					else {
						result = 0;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
