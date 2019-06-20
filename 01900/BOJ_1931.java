import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		int idx = 0;
		int cnt = 0;
		for (Room r : arr) {
			if (r.start>=idx) {
				cnt++;
				idx = r.end;
			}
		}
		bw.write(cnt + "\n");
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
		if (this.end == o.end)
			return this.start-o.start;
		return this.end-o.end;
	}
	
}
