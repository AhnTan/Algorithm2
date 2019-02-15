import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	double my_stat;
	int case_size;
	int video_size;
	int choice_size;
	
	int array[];
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		init();
	}
	
	public void init() {
		try {
			
			case_size = Integer.parseInt(reader.readLine());
			for(int i=0; i<case_size; i++) {
				my_stat = 0;
				String s = reader.readLine();
				StringTokenizer token = new StringTokenizer(s, " ");
				video_size = Integer.parseInt(token.nextToken());		
				choice_size = Integer.parseInt(token.nextToken());

				// 강의 들
				String s2 = reader.readLine();
				StringTokenizer token2 = new StringTokenizer(s2, " ");
				array = new int[token2.countTokens()];
				
				for(int j=0; j<array.length; j++) {
					array[j] = Integer.parseInt(token2.nextToken());
				}
				
				calc();
				
				writer.write("#" + (i+1) + " " + my_stat + "\n");
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {}
		
	}
	
	public void calc() {
		try {
			Arrays.sort(array);
			for(int i=array.length-choice_size; i<array.length; i++) {
				my_stat = (my_stat + array[i])/2;
			}
		}catch(Exception e) {}
	}
	
}
