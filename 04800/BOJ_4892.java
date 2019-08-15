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
		int i = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			if ((n&1)==1)
				bw.write(i + ". odd " + ((n-1)/2));
			else
				bw.write(i + ". even " + (n/2));
			bw.newLine();
			i++;
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
