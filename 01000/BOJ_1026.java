import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		List<Integer> a  = new LinkedList<Integer>();
		List<Integer> b  = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			a.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			b.add(Integer.parseInt(st.nextToken()));		
		
		Collections.sort(a, Collections.reverseOrder());
		Collections.sort(b);
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			result += a.get(i) * b.get(i);
		}
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
