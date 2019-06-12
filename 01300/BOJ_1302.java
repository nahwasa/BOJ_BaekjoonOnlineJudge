import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int maxNum = 0;
		String maxBook = "";
		while(N-->0) {
			String s = br.readLine();
			if (!hm.containsKey(s)) {
				hm.put(s, 1);
			} else {
				hm.replace(s, hm.get(s)+1);
			}
			if (hm.get(s) > maxNum) {
				maxNum = hm.get(s);
				maxBook = s;
			} else if (hm.get(s) == maxNum && maxBook.compareTo(s)>0) {
				maxBook = s;
			}
		}
		bw.write(maxBook + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
