import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 

 
public class Solution {
    static dao home;
    static dao company;
    static dao[] cus;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int TC = Integer.parseInt(read.readLine());
 
        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(read.readLine()); // 고객 수
            StringTokenizer st = new StringTokenizer(read.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            int[] arr = new int[N];
            company = new dao(y, x);
 
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            home = new dao(y, x);
 
            cus = new dao[N];
            for (int i = 0; i < N; i++) {
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                cus[i] = new dao(y, x);
            }
 
            for (int i = 0; i < N; i++) {
                arr[i] = i;
            }
 
            perm(arr, 0, N, N);
            
            writer.write("#" + tc + " " + min + "\n");
 
        }
        writer.flush();
        writer.close();
    }
    
    public static int calc(dao p1, dao p2) {
        return (int)Math.abs(p1.x - p2.x) + (int)Math.abs(p1.y - p2.y);
    }
 
    public static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
    
    
    static int process_solution(int[] arr) {
        int sum=0;
        sum += calc(company, cus[arr[0]]);
        for(int i=0;i<arr.length-1;i++) {
            int idx = arr[i];
            int next = arr[i+1];
            sum+= calc(cus[idx], cus[next]);
        }
        sum+=calc(cus[arr[arr.length-1]], home);
        
        return sum;
    }
    
 
    
    public static void perm(int[] arr, int size, int n, int k) {
        if (size == k) { //종료조건
            int s = process_solution(arr);
 
            if(min > s) {
            	min = s;
            }
           
            return;
        }
 
        for (int i = size; i < n; i++) {
            swap(arr, i, size);
            perm(arr, size + 1, n, k);
            swap(arr, i, size);
        }
    }
 
}

class dao {
    int y;
    int x;
 
    public dao(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
 