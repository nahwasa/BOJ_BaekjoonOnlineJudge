import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int qty = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			LinkedList<Integer> ll = new LinkedList<Integer>();
			while (n-->0) {
				st = new StringTokenizer(br.readLine());
				ll.push(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
			}
			Collections.sort(ll, Collections.reverseOrder());
			int cnt = 0;
			while (qty > 0) {
				cnt++;
				qty -= ll.pop();
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
