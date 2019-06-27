import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Ppl> pq = new PriorityQueue<Ppl>();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String age = st.nextToken();
			String name = st.nextToken();			
			if (hm.containsKey(age)) {
				hm.replace(age, hm.get(age)+1);
				pq.add(new Ppl(Integer.parseInt(age), hm.get(age), name));				
			} else {
				hm.put(age, 1);
				pq.add(new Ppl(Integer.parseInt(age), hm.get(age), name));
			}
		}
		while(!pq.isEmpty())
			bw.write(pq.poll().toString());
		bw.flush();
		bw.close();
		br.close();
	}	
}

class Ppl implements Comparable<Ppl> {
	int age;
	int order;
	String name;
	public Ppl(int age, int order, String name) {
		super();
		this.age = age;
		this.order = order;
		this.name = name;
	}
	@Override
	public int compareTo(Ppl o) {
		if (this.age == o.age)
			return this.order-o.order;
		return this.age-o.age;
	}
	@Override
	public String toString() {
		return age + " " + name + "\n";
	}
	
}
