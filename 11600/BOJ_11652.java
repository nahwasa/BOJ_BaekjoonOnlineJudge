import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>(n);
		
		for (int i = 0; i < n; i++) {
			long tmp = Long.parseLong(br.readLine());
			if (hm.containsKey(tmp))
				hm.replace(tmp, hm.get(tmp) + 1);
			else
				hm.put(tmp, 1);
		}
		
		int max = 0;
		long maxNum = Long.MAX_VALUE;
		
		Iterator<Entry<Long, Integer>> it = hm.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Long, Integer> e = it.next();
			
			if (e.getValue().equals(max) && e.getKey().longValue() < maxNum) {
				maxNum = e.getKey();
			} else if (e.getValue() > max) {
				max = e.getValue();
				maxNum = e.getKey();
			}
		}
		
		bw.write(maxNum + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
