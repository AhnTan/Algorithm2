import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	String s[][] = new String[100][100];
	int array[][] = new int[100][100];
	int case_size = 10;
	int result = 0;
	
	public static void main(String[] args) throws IOException{
		new Solution();
	}
	
	public Solution() throws IOException {
		
		for(int i=0; i<case_size; i++) {
			init();
			calc(1,1);
			writer.write("#" + (i+1) + " " + result + "\n");	
		}
		writer.flush();
		writer.close();
		
	}
	
	public void init() throws IOException {
		int trash = Integer.parseInt(reader.readLine());
		result = 0;
		
		for(int i=0; i<100; i++) {
			s[i] = reader.readLine().split("");
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				array[i][j] = Integer.parseInt(s[i][j]);
			}
		}
	}
	
	
	public void calc(int y, int x) throws IOException{
		
		// 지나온길은 다른값을 넣어서 막아버림
		array[y][x] = 4;
		
		// 우선순위 1. 오른쪽
		if(array[y][x+1] == 0 || array[y][x+1] == 3) {
			if(array[y][x+1] == 3) {
				result = 1;
			}
			calc(y, x+1);
		}
		// 우선순위 2. 아래쪽
		if(array[y+1][x] == 0 || array[y+1][x] == 3) {
			if(array[y+1][x] == 3) {
				result = 1;
			}
			calc(y+1, x);
		}
		// 우선순위 3. 왼쪽
		if(array[y][x-1] == 0 || array[y][x-1] == 3) {
			if(array[y][x-1] == 3) {
				result = 1;
			}
			calc(y, x-1);
		}
		// 우선순위 4. 위쪽
		if(array[y-1][x] == 0 || array[y-1][x] == 3) {
			if(array[y-1][x] == 3) {
				result = 1;
			}
			calc(y-1, x);
		}	
		
	}
}
