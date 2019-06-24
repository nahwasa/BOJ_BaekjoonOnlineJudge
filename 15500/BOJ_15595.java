import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
	private static final String ADMIN_ID = "megalusion";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String,Ppl> hm = new HashMap<String, Ppl>();
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			String[] info = br.readLine().split(" ");
			String id = info[1];
			int result = Integer.parseInt(info[2]);
			if (id.equals(ADMIN_ID)) continue;	// 관리자
			if (!hm.containsKey(id)) hm.put(id, new Ppl(result==4?true:false, result==4?0:1));
			else if (result == 4) hm.replace(id, new Ppl(true, hm.get(id).wrongCnt));
			else {
				Ppl tmp = hm.get(id);
				if (!tmp.isCorrect)	// 이미 맞은문제라면 이후로 틀리는건 의미가 없음
					hm.replace(id, new Ppl(tmp.isCorrect, tmp.wrongCnt+1));
			}																					
		}
		Iterator<Entry<String,Ppl>> it = hm.entrySet().iterator();
		int correctPplCnt = 0;
		int wrongCnt = 0;
		while (it.hasNext()) {
 			Ppl tmp = it.next().getValue();			
			if (tmp.isCorrect) {correctPplCnt++; wrongCnt+=tmp.wrongCnt;}
		}
		if (correctPplCnt == 0)
			bw.write("0\n");
		else			
			bw.write(String.format("%.15f\n", (double)correctPplCnt/(correctPplCnt + wrongCnt) * 100));
		bw.flush();
		br.close();
		bw.close();		
	}	
}

class Ppl {
	boolean isCorrect;
	int wrongCnt;
	public Ppl(boolean isCorrect, int wrongCnt) {
		this.isCorrect = isCorrect;
		this.wrongCnt = wrongCnt;
	}
}
