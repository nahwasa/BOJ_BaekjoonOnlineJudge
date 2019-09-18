import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.script.ScriptException;

public class Main {
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		while (true) {
			double d = Double.parseDouble(br.readLine());
			if (d < 0) break;
			bw.write(String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", d, d*0.167));
		}
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}
}
