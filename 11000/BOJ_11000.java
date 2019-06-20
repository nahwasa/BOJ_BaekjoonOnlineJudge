import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Room[] arr = new Room[N];
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[N] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);	
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(arr[0].end);
		for (int i = 1; i < arr.length; i++) {
			if (pq.peek()<=arr[i].start) pq.poll();
			pq.add(arr[i].end);
		}
		bw.write(pq.size() + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}

class Room implements Comparable<Room>{
	int start;
	int end;
	public Room(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Room o) {
		if (this.start == o.start)
			return this.end-o.end;
		return this.start-o.start;
	}
	
}
