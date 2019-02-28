import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size;
	int find_num;
	String s;
	String array[];
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			case_size  = Integer.parseInt(reader.readLine());
			for(int i=1; i<=case_size; i++) {
				find_num = Integer.parseInt(reader.readLine());
				s = reader.readLine();
				array = new String[s.length()];
				init();
				writer.write("#"+i+" "+array[find_num-1]+"\n");
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {}
	}
	
	public void init() {
		for(int i=0; i<s.length(); i++) {
			String temp = s.substring(i, s.length());
			array[i] = temp;		
		}
		
		Arrays.sort(array);
	}
	
}
