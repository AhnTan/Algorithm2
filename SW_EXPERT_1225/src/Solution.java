import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int case_size = 10;
	
	int index = 0;
	int sub=1;

	int q[] = new int[8];

	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			for (int i = 0; i < case_size; i++) {
				writer.write("#" + (i + 1) + " ");
				init();
				calc();
			}
			writer.flush();
			writer.close();
		}catch(Exception e) {}
	}
	
	public void init() {
		try {
			int trash = Integer.parseInt(reader.readLine());
			String s2[] = reader.readLine().split(" ");
			sub =1;
			index= 0;
			for(int i=0; i<q.length; i++) {
				q[i] = Integer.parseInt(s2[i]);
			}
		}catch(Exception e) {}
	}
	
	public void calc() {
		
		while(true) {	
			q[index++] -= sub++; 
			
			if(q[index-1]<=0) {
				q[index-1] = 0;
				index--;
				break;
			}
			if(index == q.length) {
				index = 0;
			}
			if(sub==6) {
				sub=1;
			}		
		}
		
		try {
			for (int i = index+1; i < q.length; i++) {
				writer.write(q[i] + " ");
			}
			for (int i = 0; i < index+1; i++) {
				writer.write(q[i] + " ");
			}
			writer.write("\n");
		}catch(Exception e) {}
		
	}
}
