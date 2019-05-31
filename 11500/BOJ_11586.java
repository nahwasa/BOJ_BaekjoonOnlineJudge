import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		LinkedList<StringBuilder> ll = new LinkedList<StringBuilder>();
		
		for (int i = 0; i < n; i++) {
			ll.add(new StringBuilder(br.readLine()));
		}
		
		int state = Integer.parseInt(br.readLine());
		if (state == 1) {
			Iterator<StringBuilder> it = ll.iterator();
			while (it.hasNext())
				bw.write(it.next().toString() + "\n");
		} else if (state == 2) {
			Iterator<StringBuilder> it = ll.iterator();
			while (it.hasNext())
				bw.write(it.next().reverse().toString() + "\n");
		} else if (state == 3) {
			Iterator<StringBuilder> it = ll.descendingIterator();
			while (it.hasNext())
				bw.write(it.next().toString() + "\n");
		}
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
