import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<Integer> l = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			l.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(l);
		Iterator<Integer> it = l.iterator();
		
		while(it.hasNext()) {
			bw.write(it.next() + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
