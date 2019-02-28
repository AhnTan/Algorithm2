import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Solution {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size;
	int find_num;
	String s,result;
	List<String> array;
	HashSet<String> hashset;

	public static void main(String[] args) {
		new Solution();
	}

	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= case_size; i++) {
				find_num = Integer.parseInt(reader.readLine());
				s = reader.readLine();
				init();
				writer.write("#" + i + " " + result + "\n");
			}
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void init() {
		try {

			hashset = new HashSet<>();
			array = new ArrayList<String>();

			for (int i = 0; i < s.length(); i++) {
				for (int j = i+1; j <= s.length(); j++) {
					String temp = s.substring(i, j);
					if (!(hashset.contains(temp))) {
						array.add(temp);
						hashset.add(temp);
					}
				}
			}
			
			//Collections.sort(array);
			Collections.sort(array, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			
			if((find_num) > array.size()) {
				result = "none";
			}else {
				result = array.get(find_num-1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
