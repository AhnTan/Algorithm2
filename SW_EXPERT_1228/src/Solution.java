import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int total_case_size = 10;
		ArrayList<Integer> array;
		
		try {
			for(int k=0; k<total_case_size; k++) {
				array = new ArrayList<Integer>();
				
				int init_size = Integer.parseInt(reader.readLine());
				
				String str = reader.readLine();
				StringTokenizer tok = new StringTokenizer(str, " ");
				for(int i=0; i<init_size; i++)
					array.add(Integer.parseInt(tok.nextToken()));
				
				init_size = Integer.parseInt(reader.readLine());
				str = reader.readLine();
				tok = new StringTokenizer(str, " ");
				
				for(int i=0; i<init_size; i++) {
					tok.nextToken();
					int input_index = Integer.parseInt(tok.nextToken());
					int input_size = Integer.parseInt(tok.nextToken());
					for (int t = 0; t < input_size; t++) {
						array.add(input_index++, Integer.parseInt(tok.nextToken()));
					}
				}
				
				writer.write("#" + (k+1) + " ");
				for(int j=0; j<10; j++)
					writer.write(array.get(j) + " ");
				
				writer.write("\n");
			}
			writer.flush();
			writer.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
