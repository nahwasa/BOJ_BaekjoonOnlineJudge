import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	final static int LIMIT = 80;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<String> ll = new LinkedList<String>();
		
		while (true) {
			StringTokenizer st = null;
			try {
				st = new StringTokenizer(br.readLine());
			} catch (NullPointerException e) {
				break;
			}
			
			while (st.hasMoreTokens())
				ll.add(st.nextToken());			
		}
		
		int cIdx = 0;
		StringBuilder sb = new StringBuilder();
		while (!ll.isEmpty()) {
			String s = ll.pop();		
			switch (s) {
			case "<br>" :
				sb.append("\n");
				cIdx = 0;
				break;
			case "<hr>" :
				if (cIdx != 0)
					sb.append("\n");
				for (int i = 0; i < 80; i++)
					sb.append("-");
				sb.append("\n");
				cIdx = 0;
				break;
			default :				
				if (cIdx + s.length() > 80) {
					sb.append("\n");
					cIdx = 0;
				}
				if (cIdx != 0) {
					sb.append(" ");
					cIdx += 1;
				}
				
				sb.append(s);
				cIdx += s.length();				
				
				break;
			}
		}
		
		bw.write(sb.toString() + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
