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
	
	int case_size;
	int v_size;
	int cnt = 0;
	long sum = 0;
	
	double E;
	
	ArrayList<V_dto> dto_list;
	ArrayList<Dto> list;
	
	int array[];
	
	public static void main(String[] args) {
		new Solution();
	}
	
	public Solution() {
		try {
			case_size = Integer.parseInt(reader.readLine());
			
			for(int i=1; i<=case_size; i++) {
				cnt = 0;
				sum = 0;
				dto_list = new ArrayList<V_dto>();
				list = new ArrayList<Dto>();
				
				v_size = Integer.parseInt(reader.readLine());
				
				
				String x[] = reader.readLine().split(" ");
				String y[] = reader.readLine().split(" ");
				
				for(int k=0; k<v_size; k++) {
					dto_list.add(new V_dto(++cnt, Integer.parseInt(x[k]), Integer.parseInt(y[k])));
				}
				
				
				// 환경부담금
				E = Double.parseDouble(reader.readLine());
				
				// union-find를 위한 준비
				array = new int[cnt+1];
				for(int k=1; k<=cnt; k++) {
					array[k] = k;
				}
				
				
				for(int j=0; j<dto_list.size()-1; j++) {
					for(int t=j+1; t<dto_list.size(); t++) {
						
						long length = (long)Math.pow(dto_list.get(j).getX() - dto_list.get(t).getX(), 2) + (long)Math.pow(dto_list.get(j).getY() - dto_list.get(t).getY(), 2);
						
						list.add( new Dto(dto_list.get(j).getV_num(), dto_list.get(t).getV_num(), length ) );
					}
				}
				
				my_sort();
				
				
				calc();
				
				writer.write("#"+i+" "+String.format("%.0f", (sum*E)) + "\n");
				//writer.write("#"+i+ " " + String.format("%.0f", (sum*E)) + "\n");
			}
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
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
	
	
	
	private class Dto{
		
		int A;
		int B;
		long value;
		
		public Dto(int a, int b, long value) {
			this.A = a;
			this.B = b;
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
	
	private class V_dto{
		int v_num;
		int x;
		int y;
		
		public V_dto() {
			
		}
		
		public V_dto(int v_num, int x, int y) {
			this.v_num = v_num;
			this.x = x;
			this.y = y;
		}

		public int getV_num() {
			return v_num;
		}

		public void setV_num(int v_num) {
			this.v_num = v_num;
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
		
		
		
	}
}
