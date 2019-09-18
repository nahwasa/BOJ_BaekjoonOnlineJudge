import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

import javax.script.ScriptException;

public class Main {
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		String s = br.readLine();
		HashSet<String> chk = new HashSet<String>();
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i <= s.length() - len; i++) {				
				chk.add(s.substring(i, i+len));
			}
		}
		bw.write(chk.size() + "\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}
