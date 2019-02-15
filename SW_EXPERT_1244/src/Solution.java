import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int array[];
	int max;
	int case_size;
	
	String n;
	int chance_count;
	
	String result;
	
	public static void main(String[] args) {
	
		new Solution();
	}
	
	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			for(int i=0; i<case_size; i++) {
				String s[] = reader.readLine().split(" ");
				n = s[0];
				chance_count = Integer.parseInt(s[1]);
				result = "";
				max = 0;
				init();
				writer.write("#" + (i+1) + " " + max + "\n");
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			
		}
	}
	
	public void init() {
		try {
			String s[] = n.split("");
			array = new int[s.length];
			
			
			
			for(int i=0; i<s.length; i++) {
				array[i] = Integer.parseInt(s[i]);
			}
	
			
			if(chance_count == 1) {
				if(array.length == 2) {
					int temp = array[1];
					array[1] = array[0];
					array[0] = temp;
				}
				else {
				int temp_max=0;
				int temp_index=0;
				for (int i = 0; i < array.length; i++) {
					if(temp_max <= array[i]) {
						temp_max = array[i];
						temp_index = i;
					}
				}
				
				int temp = array[temp_index];
				array[temp_index] = array[0];
				array[0] = temp;
				
			
			}
				for(int i=0; i<array.length; i++) {
					max += ( array[i] * (int)Math.pow(10, array.length-i-1)); 
				}
			}
			
			else if(chance_count >= array.length) {
				Arrays.sort(array);
				if(chance_count%2 ==0) {
					int temp = array[0];
					array[0] = array[1];
					array[1] = temp;
				}
				for(int j=array.length-1; j>=0; j--) {
					result += array[j];
				}
				max = Integer.parseInt(result);
			}
			
			else {
				
				int temp_array[] = new int[array.length];
				for(int k=0; k<array.length; k++) {
					temp_array[k] = array[k];
				}
				
				int temp_max=0;
				int temp_index=0;
				
				int t=0;
				while(t<array.length) {
					for (int i = t; i < temp_array.length; i++) {
						if (temp_max < temp_array[i]) {
							temp_max = temp_array[i];
							temp_index = i;
							if( (temp_index == t)) {
								chance_count++;
								break;
							}
						}
					}
					
					int temp = temp_array[temp_index];
					temp_array[temp_index] = temp_array[t];
					temp_array[t] = temp;
					

					t++;
				}
				
				
				
				
				perm(array.length ,0);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void perm(int n, int k) {
		//System.out.println("들어옴 n : " + n + " k : " + k );
		if(k==chance_count) {
			//System.out.println(Arrays.toString(array));
			int temp_num = 0;
			
			for(int i=0; i<n; i++) {
				temp_num += ( array[i] * (int)Math.pow(10, n-i-1)); 
			}
			
			if(max < temp_num) {
				max = temp_num;
			}
			
		}
		else {
			for(int i=n-1; i>=k; i--) {
				swap(k, i);
				perm(n, k+1);
				swap(k, i);
			}
		}
	}
	
	public void swap(int a, int b) {
		
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		
	}

}
