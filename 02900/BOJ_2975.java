import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.swing.tree.TreeNode;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		while (true) {
			String s = br.readLine();
			if (s.equals("0 W 0"))
				break;
			StringTokenizer st = new StringTokenizer(s);
			int balance = Integer.parseInt(st.nextToken());
			switch (st.nextToken()) {
			case "W" :
				balance -= Integer.parseInt(st.nextToken());
				break;
			case "D" :
				balance += Integer.parseInt(st.nextToken());
				break;
			}
			if (balance < -200)
				bw.write("Not allowed\n");
			else
				bw.write(balance + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
