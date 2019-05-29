import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		List<Integer> l = new LinkedList<Integer>();
		
		
		for (int i = 1; i <= 20; i++) {
			l.add(i);
		}
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			
			List<Integer> tmp = l.subList(si-1, ei);
			Collections.reverse(tmp);			
		}
		
		Iterator<Integer> it = l.iterator();
		while (it.hasNext()) {
			bw.write(it.next() + " ");
		}
		bw.write("\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
