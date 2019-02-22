import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	ArrayList<Dto> list;
	int array[];
	
	
	int case_size;
	long sum;
	int v;		// 정점의 개수
	int e;		// 간선의 개수
	
	
	public static void main(String[] args) {

		new Solution();
		
	}

	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			for(int i=1; i<=case_size; i++) {
				sum = 0;
				list =  new ArrayList<Dto>();
				String s[] = reader.readLine().split(" ");
				v = Integer.parseInt(s[0]);
				e = Integer.parseInt(s[1]);
				
				init();
				writer.write("#"+i+ " " + sum + "\n");
			}
			writer.flush();
			writer.close();
			
			
		}catch(Exception e) {}
	}
	
	public void init() {
		try {

			for(int i=0; i<e; i++) {
				String s[] = reader.readLine().split(" "); 
			
				list.add(new Dto(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])));
			}
			
			my_sort();
			
			array = new int[v+2];
			for(int i=1; i<=v; i++) {
				array[i] = i;
			}
			
			
			calc();
			
		}catch(Exception e) {
			//e.printStackTrace();
		}
	}
	
	public void my_sort() {

		Collections.sort(list, new Comparator<Dto>() {

			@Override
			public int compare(Dto o1, Dto o2) {
				if (o1.getValue() > o2.getValue()) {
					return 1;
				} else if (o1.getValue() == o2.getValue()) {
					return 0;
				} else {
					return -1;
				}
			}
		});

	}
	
	
	public void calc() {
		try {
			for(int i=0; i<list.size(); i++) {
				/** 
				 1 2 1
				 2 3 2
				 1 3 3  기준으로
				
				 맨처음 check(1정점과 2정점을 넣어서 연결되어있는 것이 있는지 확인함) -> 1,2는 다른 점과 연결되지않음을 확인, false를 리턴받음 
				새로운 간선임이 확인되었으므로 간선값을 sum에 넣고, 1정점과 2정점을 union하여 연결함
				2정점과 1정점이 연결됨
				array[] = [ 0번배열은 비어있음, 1, 1, 3 ] 
				
				check(2정점과 3정점을 넣어 연결되어있는지 확인) -> 2,3은 연결되지않음을 확인, false를 리턴받음
				2정점과 3정점을 연결됨 -> 2에연결되있는것은 '1' 3은 그대로 '3' , 1과3을 비교한것임
				array[] = [ 0번배열은 비어있음, 1, 1, 2 ]
				
				마지막 check(1정점과 3정점을 넣어 연결되어있는지 확인)
				find(1) => 1이 리턴되고
				find(3) => find(2) = > 1이 리턴됨
				find(1)과 find(3)이 같음이 확인됨 true를 반환 받음
				
				if문이 돌지 않고 끝남
				
				
				**/
				if(!check(list.get(i).getA(), list.get(i).getB())) {
					sum += list.get(i).getValue();
					union(list.get(i).getA(), list.get(i).getB());
				}
			}
			
		}catch(Exception e) {
			//e.printStackTrace();
		}
	}
	
	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			array[y] = x;
		}
	}
	
	public int find(int x) {
		if(array[x] == x) {
			return x;
		}
		return array[x] = find(array[x]);
	}
	
	public boolean check(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

private class Dto{
	
	int A;
	int B;
	long value;
	
	public Dto() {
		
	}
	
	public Dto(int A, int B, long value) {
		this.A = A;
		this.B = B;
		this.value = value;
	}

	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
	
}

