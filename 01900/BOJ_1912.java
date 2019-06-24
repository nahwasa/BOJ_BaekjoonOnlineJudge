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
		int max = Integer.MIN_VALUE;
		int sum = 0;
		while(N-->0) {
			int tmp = Integer.parseInt(st.nextToken());
			max=tmp>max?tmp:max;
			sum+=tmp;			
			if (sum>0) {max=sum>max?sum:max;}
			else sum=0;		
		}
		bw.write(max + "\n");		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
