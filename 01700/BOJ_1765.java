import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<String> ll = new LinkedList<String>();
		HashSet<String> hs = new HashSet<String>();
		
		for (int i = 0; i < n; i++)
			hs.add(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if (hs.contains(input)) {
				cnt++;
				ll.add(input);
			}
		}
		
		bw.write(cnt + "\n");
		Collections.sort(ll);
		Iterator<String> it = ll.iterator();
		while(it.hasNext())
			bw.write(it.next() + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
