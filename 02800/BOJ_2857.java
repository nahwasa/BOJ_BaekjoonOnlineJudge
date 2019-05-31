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
		
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for (int i = 0; i < 5; i++) {			
			if (br.readLine().contains("FBI"))
				ll.add(i+1);
		}
		
		Collections.sort(ll);
		Iterator<Integer> it = ll.iterator();
		while (it.hasNext()) {
			bw.write(String.valueOf(it.next()));
			if (it.hasNext())
				bw.write(" ");
			else
				bw.write("\n");
		}
		
		if (ll.isEmpty())
			bw.write("HE GOT AWAY!\n");
		
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
