import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int[] num = new int[26];
			boolean[] exist = new boolean[26];
			String s = br.readLine();
			bw.write(String.format("Expression: %s\n", s));
			s = s.replaceAll(" ", "");			
			for (int i = 0; i < 26; i++) {
				num[i] = i+1;
				String tmp = (char)(i+'a') + "";
				if (s.contains(tmp)) {
					exist[i] = true;
					if (s.contains("--"+tmp)) {
						num[i]--;
						s = s.substring(0, s.indexOf(tmp)-2) + num[i] + s.substring(s.indexOf(tmp)+1);	
					} else if (s.contains("++"+tmp)) {
						num[i]++;
						s = s.substring(0, s.indexOf(tmp)-2) + num[i] + s.substring(s.indexOf(tmp)+1);						
					} else if (s.contains(tmp+"--")) {
						s = s.substring(0, s.indexOf(tmp)) + num[i] + s.substring(s.indexOf(tmp)+3);
						num[i]--;
					} else if (s.contains(tmp+"++")) {
						s = s.substring(0, s.indexOf(tmp)) + num[i] + s.substring(s.indexOf(tmp)+3);
						num[i]++;
					} else {
						s = s.substring(0, s.indexOf(tmp)) + num[i] + s.substring(s.indexOf(tmp)+1);
					}
				}
			}			 
			ScriptEngineManager sem = new ScriptEngineManager(); 
			ScriptEngine se = sem.getEngineByName("JavaScript");
			bw.write(String.format("value = " + se.eval(s) + "\n"));
			for (int i = 0; i < 26; i++) {
				if (exist[i])
					bw.write((char)(i+'a')+ " = " + num[i] + "\n");
			}
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}
