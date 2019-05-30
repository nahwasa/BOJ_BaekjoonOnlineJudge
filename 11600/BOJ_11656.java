import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		LinkedList<String> ll = new LinkedList<String>();
		for (int i = 0; i < input.length(); i++) {
			ll.add(input.substring(i));
		}
		
		Collections.sort(ll);
		Iterator<String> it = ll.iterator();
		while (it.hasNext())
			bw.write(it.next() + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
