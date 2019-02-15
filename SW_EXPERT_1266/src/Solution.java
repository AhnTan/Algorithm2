import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static double A;
	public static double B;
	

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double result = 0;
		double result_A = 0;
		double result_B = 0;
		double result_And = 0;
		double result_And_A = 0;
		double result_And_B = 0;
		
		int prime[] = { 2, 3, 5, 7, 11, 13, 17 };
		int case_size = Integer.parseInt(reader.readLine());
		
		for(int i=1; i<=case_size; i++) {
			
			result_A = 0;
			result_B = 0;
			
			result_And_A = 0;
			result_And_B = 0;
			result_And = 0;
			
			String s[] = reader.readLine().split(" ");
			A = Double.parseDouble(s[0])/100;
			B = Double.parseDouble(s[1])/100;
			
			//System.out.println(A + " " + B);
			
			for(int j=0; j<prime.length; j++) {
				result_A += (com_p(prime[j]) * p(prime[j], 0) * q(prime[j], 0));
				result_B += (com_p(prime[j]) * p(prime[j], 1) * q(prime[j], 1));
			}
			
			for(int j=0; j<prime.length; j++) {
				result_And_A = (com_p(prime[j]) * p(prime[j], 0) * q(prime[j], 0));
				for(int k=0; k<prime.length; k++) {
					result_And_B = (com_p(prime[k]) * p(prime[k], 1) * q(prime[k], 1));
					result_And += result_And_A * result_And_B;
				}
			}

			/*System.out.println(result_A);
			System.out.println(result_B);
			
			System.out.println(result_A + result_B);
			System.out.println(result_And);
			
			*/
			//System.out.println((result_A + result_B)-result_And);
			result = (result_A + result_B)-result_And;
			writer.write("#"+i+" "+String.format("%.6f", result) + "\n");
		}
		writer.flush();
		writer.close();
		

		

	}
	public static long com_p(int n) {
		
		long val = 1;
		for(int i=18; i>18-n; i--) {
			val *= i; 
		}
		
		for(int i=1; i<=n; i++) {
			val /= i;
		}
		//System.out.println(n+"번째 : "+val);
		return val;
	}
	
	public static double p(int n, int name) {
		
		double val = 1;
		double temp = 0;
		
		if(name==0) {
			temp = A;
		}
		else if(name==1) {
			temp = B;
		}
		
		for(int i=0; i<n; i++) {
			val *= temp;
		}
		
		//System.out.println(val);
		
		return val;
	}


	public static double q(int n, int name) {
		
		double val = 1;
		double temp = 0;
		
		if(name==0) {
			temp = A;
		}
		else if(name==1) {
			temp = B;
		}
		
		
		for(int i=0; i<18-n; i++) {
			val *= (1-temp);
		}
		//System.out.println(val);
		
		return val;
	}

}
