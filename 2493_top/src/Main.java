import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	StringBuilder builder = new StringBuilder();
	
	int case_size;
	int tower_size;
	int stack[], tower[];
	
	int top = 1;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		try {
			tower_size = Integer.parseInt(reader.readLine());
			init();
			writer.flush();
			writer.close();
		}catch(Exception e) {}
	}
	
	public void init() {
		try {
			tower = new int[tower_size];
			String s[] = reader.readLine().split(" ");
			for (int i = 0; i < tower_size; i++) {
				top = 0;
				tower[i] = Integer.parseInt(s[i]);
				int temp = tower[i];
				
				for(int j=i-1; j>=0; j--) {
					if(temp<tower[j]) {
						writer.write((j+1) + " ");
						top = 1;
						break;
					}
				}
				
				if(top == 0) {
					writer.write(0 + " ");
				}
			}
		}catch(Exception e) {}
	}
}
