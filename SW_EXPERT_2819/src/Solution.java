import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size;
	int array[][];

	HashSet<String> hs;

	public static void main(String[] args) {

		new Solution();

	}

	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());

			for (int i = 1; i <= case_size; i++) {

				array = new int[4][4];
				hs = new HashSet<>();

				init();
				writer.write("#" + i + " " + hs.size() + "\n");
			}
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {
		try {
			for (int i = 0; i < 4; i++) {
				String s[] = reader.readLine().split(" ");
				for (int j = 0; j < 4; j++) {
					array[i][j] = Integer.parseInt(s[j]);
				}
			}
			for (int y = 0; y < array.length; y++) {
				for (int x = 0; x < array.length; x++) {
					calc(y, x, "");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void calc(int y, int x, String s) {

		// 영역을 벗어날때는 바로 종료
		if (x < 0 || y < 0 || x == array.length || y == array.length) {
			return;
		}
		
		else if(s.length()==7) {
			if(hs.contains(s)) {
				return;
			}
			hs.add(s);
		}
		
		else {
			s += array[y][x];
			
			calc(y-1,x,s);
			calc(y+1,x,s);
			calc(y,x-1,s);
			calc(y,x+1,s);
		}
	}
}
