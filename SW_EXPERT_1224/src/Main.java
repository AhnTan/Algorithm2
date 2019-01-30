import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	int sum;
	int case_size = 10;

	String s_stack[];
	String temp[];
	int temp_index;
	int n_stack[];

	int top;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		try {
			for (int i = 0; i < case_size; i++) {
				init();
				calc();
				writer.write("#" + (i + 1) + " " + sum + "\n");
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
		}
	}

	// 2+3*4/5
	// (6+5*(2-8)/2)

	public void init() {
		sum = 0;
		temp_index = -1;

		top = -1;
		
		try {

			int calc_size = Integer.parseInt(reader.readLine());

			String s[] = reader.readLine().split("");

			s_stack = new String[s.length];
			temp = new String[s.length];
			n_stack = new int[s.length];

			for (int i = 0; i < s.length; i++) {

				switch (s[i]) {
				case "(":
					s_stack[++top] = s[i];
					break;
				case "*":
				case "/":
					while (top >= 0 && (s_stack[top].equals("*") || s_stack[top].equals("/"))) {
						temp[++temp_index] = s_stack[top--];
					}
					s_stack[++top] = s[i];
					break;
				case "+":
				case "-":
					while (top >= 0 && (s_stack[top].equals("*") || s_stack[top].equals("/") || s_stack[top].equals("+")
							|| s_stack[top].equals("-"))) {
						temp[++temp_index] = s_stack[top--];
					}
					s_stack[++top] = s[i];
					break;
				case ")":
					while (top >= 0 && !s_stack[top].equals("(")) {
						temp[++temp_index] = s_stack[top--];
					}
					if (top >= 0 && s_stack[top].equals("(")) {
						top--; // 여는 괄호는 버려라
					}
					break;
				default:
					temp[++temp_index] = s[i];
					break;
				}
			}
			while (top >= 0) {
				temp[++temp_index] = s_stack[top--];
			}
			// System.out.println(Arrays.toString(temp));

		} catch (Exception e) {
		}
	}

	public void calc() {

		int[] stackNum = new int[temp.length];
		int top = -1;
		for (int i = 0; i < temp.length; i++) {
			int num1, num2;
			if (temp[i] != null) {
				char c = temp[i].charAt(0);
				switch (c) {
				case '+':
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 + num2;
					break;
				case '-':
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 - num2;
					break;
				case '*':
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 * num2;
					break;
				case '/':
					num2 = stackNum[top--];
					num1 = stackNum[top--];
					stackNum[++top] = num1 / num2;
					break;

				default:
					stackNum[++top] = Integer.parseInt(temp[i]);
					break;

				}
			}
		}
		sum = stackNum[top];
	}
}
