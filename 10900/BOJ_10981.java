import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.script.ScriptException;

public class Main {
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Tmp[] arr = new Tmp[N];
		while (N-->0)
			arr[N] = new Tmp(new StringTokenizer(br.readLine()));
		Arrays.sort(arr);
		for (Tmp t : arr) {
			if (Tmp.isContain(t)) {
				bw.write(t.team + "\n");
				K--;
			}
			if (K == 0)
				break;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class Tmp implements Comparable<Tmp>{
	static HashMap<String, Tmp> chk = new HashMap<String, Tmp>();
	String col, team;
	int cnt, penalty;
	public Tmp(StringTokenizer st) {
		this.col = st.nextToken();
		this.team = st.nextToken();
		this.cnt = Integer.parseInt(st.nextToken());
		this.penalty = Integer.parseInt(st.nextToken());
		checkDuplication();
	}
	
	public static boolean isContain(Tmp t) {
		return chk.containsKey(t.col) && chk.get(t.col).team.equals(t.team);
	}
	
	private void checkDuplication() {
		if (!chk.containsKey(col)) {
			chk.put(col, this);
			return;
		}
		if (chk.get(col).compareTo(this) < 0)
			return;
		else
			chk.replace(col, this);
	}

	@Override
	public int compareTo(Tmp t) {
		if (this.cnt == t.cnt)
			return this.penalty - t.penalty;
		return t.cnt - this.cnt;
	}
}
