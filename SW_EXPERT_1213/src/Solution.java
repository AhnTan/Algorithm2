import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int case_size = 10;
		
		for(int i=0; i<case_size; i++) {
			
			int v = Integer.parseInt(reader.readLine());
		
			String p = reader.readLine();
			
			String str = reader.readLine();
			
			str = str + "@";		// p 문자열이 str 맨뒤에있으면 갯수가 1개 부족하므로 임의로 '@'을 넣어줌
			
			String s[] = str.split(p);
			
			System.out.println("#" + v + " " + (s.length - 1));
			
			
		}
		
		
	}

}
