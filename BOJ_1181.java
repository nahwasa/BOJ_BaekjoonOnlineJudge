import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<String> l = new LinkedList<String>();
		
		for (int i = 0; i < n; i++) {
			l.add(br.readLine());
		}
		
		Collections.sort(l, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				else if (o1.length() < o2.length())
					return -1;
				else {
					
					if (o1.compareTo(o2) < 0)
						return -1;
					else if (o1.compareTo(o2) > 0)
						return 1;
					else
						return 0;
					
				}
			}			
		});
		
		Iterator<String> it = l.iterator();
		
		String prevStr = "";
		while(it.hasNext()) {
			String str = it.next();
			if (!prevStr.equals(str)) {
				bw.write(str + "\n");
				prevStr = str;
			}
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
