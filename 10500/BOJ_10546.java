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
	
		int tc = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i = 0; i < tc; i++) {
			String s = br.readLine();
			if (hm.containsKey(s))
				hm.replace(s, hm.get(s) + 1);
			else
				hm.put(s, 1);
		}
		
		for (int i = 0; i < tc-1; i++) {
			String s = br.readLine();

			int tmp = hm.get(s);
			if (tmp == 1)
				hm.remove(s);
			else
				hm.replace(s, tmp-1);
		}
		
		bw.write(hm.keySet().iterator().next() + "\n");	
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}	
