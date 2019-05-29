import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<String> l = new LinkedList<String>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String tg1 = st.nextToken();
		String tg2 = st.nextToken();
		
		int round = 1;
		for (int i = 0; i < n; i++)
			l.add("" + (i+1));
		
		LinkedList<String> tmp = new LinkedList<String>();
		while (true) {			
			String p1 = l.pollFirst();
			String p2 = l.pollFirst();
		
			
			if (p1 == null) {
				l = tmp;
				tmp = new LinkedList<String>();
				round++;
			} else if (p2 == null) {	// 부전승
				tmp.add(p1);
				l = tmp;
				tmp = new LinkedList<String>();
				round++;
			} else if ( (p1.equals(tg1) && p2.equals(tg2)) || (p1.equals(tg2) && p2.equals(tg1))) {	// 둘이 만남
				bw.write(round+"\n");
				break;
			} else if (p1.equals(tg1)) {
				tmp.add(p1);
			} else if (p2.equals(tg1)) {
				tmp.add(p2);
			} else if (p1.equals(tg2)) {
				tmp.add(p1);
			} else if (p2.equals(tg2)) {
				tmp.add(p2);
			} else {
				tmp.add(p2);
			}			
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
