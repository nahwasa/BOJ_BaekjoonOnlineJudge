import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bw.write(st.nextToken() + " ");
			int n = Integer.parseInt(st.nextToken());
			String grade = "";
			if (n>=97)
				grade = "A+";
			else if (n>=90)
				grade = "A";
			else if (n>=87)
				grade = "B+";
			else if (n>=80)
				grade = "B";
			else if (n>=77)
				grade = "C+";
			else if (n>=70)
				grade = "C";
			else if (n>=67)
				grade = "D+";
			else if (n>=60)
				grade = "D";
			else
				grade = "F";
			bw.write(grade + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
