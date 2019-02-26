import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int case_size;
	int w;
	int h;
	String field[][];
	String cmd[];
	Tank tank;

	public static void main(String[] args) {

		new Solution();

	}

	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());

			for (int i = 1; i <= case_size; i++) {

				String s[] = reader.readLine().split(" ");
				h = Integer.parseInt(s[0]);
				w = Integer.parseInt(s[1]);

				field = new String[h][w];

				init();

				System.out.print("#"+i+" ");
				view();

			}

		} catch (Exception e) {
		}
	}

	public void init() {

		try {
			for (int i = 0; i < h; i++) {
				String s[] = reader.readLine().split("");

				for (int j = 0; j < s.length; j++) {
					switch (s[j]) {
					case "<":
						tank = new Tank(j, i, "L");
						break;
					case ">":
						tank = new Tank(j, i, "R");
						break;
					case "^":
						tank = new Tank(j, i, "U");
						break;
					case "v":
						tank = new Tank(j, i, "D");
						break;
					default:
						break;

					}
					field[i][j] = s[j];
				}
			}

			int cmd_size = Integer.parseInt(reader.readLine());
			cmd = reader.readLine().split("");

			calc();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void calc() {
		try {
		for (int i = 0; i < cmd.length; i++) {

			switch (cmd[i]) {

			case "S":
				shooter();
				break;
				default:
					move(cmd[i]);
					break;
			}
			/*
			 * System.out.println((i+1)+"번째 : " + cmd[i]);
			view();
			System.out.println();*/
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void shooter() {
		try {
			int x = tank.getX();
			int y = tank.getY();

			switch (tank.getState()) {

			case "U":
				while (y > 0) {
					if(field[--y][x].equals("#")) {
						break;
					}
					else if (field[y][x].equals("*")) {
						field[y][x] = ".";
						break;
					}
				}
				break;
			case "D":
				while (y < h-1) {
					if(field[++y][x].equals("#")) {
						break;
					}
					else if (field[y][x].equals("*")) {
						field[y][x] = ".";
						break;
					}
				}
				break;
			case "L":
				while (x > 0) {
					if(field[y][--x].equals("#")) {
						break;
					}
					else if (field[y][x].equals("*")) {
						field[y][x] = ".";
						break;
					}
				}
				break;
			case "R":
				
				while (x < w-1) {
					if(field[y][++x].equals("#")) {
						break;
					}
					else if (field[y][x].equals("*")) {
						field[y][x] = ".";
						break;
					}
				}
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void move(String s) {
		try {
			int x = tank.getX();
			int y = tank.getY();
			
			switch (s) {

			case "U":
				tank.setState("U");
				if( (y==0) ) {
					field[y][x] = "^"; 		// 전차가 있던자리
				}
				else if (y > 0) {
					if (field[--y][x].equals(".")) {
						
						tank.setY(y);
						tank.setX(x);
						
						field[y][x] = "^";			// 전차가 이동한자리
						field[y+1][x] = "."; 		// 전차가 있던자리
						break;
					}else {
						field[y+1][x] = "^";
					}
				}

				break;
			case "D":
				tank.setState("D");
				if( y==(h-1) ) {
					field[y][x] = "v"; 		// 전차가 있던자리
				}
				else if (y < h-1) {
					if (field[++y][x].equals(".")) {
						
						tank.setY(y);
						tank.setX(x);
						
						field[y][x] = "v";			// 전차가 이동한자리
						field[y-1][x] = "."; 		// 전차가 있던자리
						break;
					}
					else {
						field[y-1][x] = "v"; 		// 전차가 있던자리
					}
				}
				break;
			case "L":
				tank.setState("L");
				if( x==0 ) {
					field[y][x] = "<"; 		// 전차가 있던자리
				}
				else if (x > 0) {
					if (field[y][--x].equals(".")) {
						
						tank.setY(y);
						tank.setX(x);
						
						field[y][x] = "<";			// 전차가 이동한자리
						field[y][x+1] = "."; 		// 전차가 있던자리
						break;
					}else {
						field[y][x+1] = "<"; 		// 전차가 있던자리
					}
				}
				break;
			case "R":
				tank.setState("R");
				if( x==(w-1) ) {
					field[y][x] = ">"; 		// 전차가 있던자리
				}
				else if (x < w-1) {
					if (field[y][++x].equals(".")) {
						
						tank.setY(y);
						tank.setX(x);
						
						field[y][x-1] = "."; 		// 전차가 있던자리
						field[y][x] = ">";			// 전차가 이동한자리
						
						break;
					}else {
						field[y][x-1] = ">";			// 전차가 이동한자리
					}
				}
				break;
			default:
				System.out.println("들어와야지" + s);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void view() {
		for (int i = 0; i < h; i++) {

			for (int j = 0; j < w; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}

	class Tank {
		int x;
		int y;
		String state;

		public Tank(int x, int y, String state) {
			this.x = x;
			this.y = y;
			this.state = state;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

	}
}
