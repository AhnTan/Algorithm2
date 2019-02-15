import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size;
	int col; // y축
	int row; // x축
	
	int index_y;
	int index_x;
	
	int array[][];
	
	int sum;
	
	String code[] = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	int result[];
	
	
	public static void main(String[] args) {
		
		new Solution();
		
	}
	
	
	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			
			for(int i=0; i<case_size; i++) {
				String s[] = reader.readLine().split(" ");
				result = new int[10];
				col = Integer.parseInt(s[0]);
				row = Integer.parseInt(s[1]);
				array = new int[col][row];
				init();
				if(sum%10 != 0) {
					writer.write("#" + (i+1) + " " + "0" + "\n");
				}
				else {
					int t=0;
					for(int k=0; k<result.length; k++) {
						t += result[k];
					}
					writer.write("#" + (i+1) + " " + t + "\n");
				}
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void init() {
		try {
			for(int i=0; i<col; i++) {
				String s[] = reader.readLine().split("");
				for(int j=0; j<row; j++) {
					array[i][j] = Integer.parseInt(s[j]);
					if(array[i][j] == 1) {
						index_x = j;
						index_y = i;
					}
				}
			}
			
			calc();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void calc() {
		try {
		String temp[] = new String[8];
		Arrays.fill(temp,"");
		
		int index = index_x - (8*7 - 1);
		//System.out.println("인덱스:" + index);
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<7; j++) {
				temp[i] += array[index_y][index++];
			}
		}
		
		
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<code.length; j++) {
				if(code[j].equals(temp[i])) {
					result[i] = j;
				}
			}
		}
		
		sum = (result[0] + result[2] + result[4] + result[6])*3 + (result[1] + result[3] + result[5]) + result[7];
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
