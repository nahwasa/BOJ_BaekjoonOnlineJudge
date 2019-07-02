import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine())+1;
		if (N == 2) {
			bw.write("1\n");
			bw.flush();
			return;
		}
		LinkedList<Integer> ll = new LinkedList<Integer>();
		while(N-->1)
			ll.addFirst(N);
		while (true) {
			ll.pollFirst();
			if (ll.size() == 1)
				break;
			ll.addLast(ll.pollFirst());
		}
		bw.write(ll.poll() + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
