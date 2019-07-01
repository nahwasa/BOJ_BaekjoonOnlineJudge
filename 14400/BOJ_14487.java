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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		while (N-->0) {
			int tmp = Integer.parseInt(st.nextToken());
			sum+=tmp;
			if(tmp>max)max=tmp;
		}
		bw.write((sum-max)+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
