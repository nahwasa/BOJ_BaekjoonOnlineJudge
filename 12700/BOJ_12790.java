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

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] stat = new int[8];
			for (int j = 0; j < 8; j++)
				stat[j] = Integer.parseInt(st.nextToken());
					
			int bp = 
					(stat[0]+stat[4]<1?1:stat[0]+stat[4]) +		//HP
					5*(stat[1]+stat[5]<1?1:stat[1]+stat[5]) +	//MP
					2*(stat[2]+stat[6]<0?0:stat[2]+stat[6]) +	//ATK
					2*(stat[3]+stat[7])							//DEF
					;
			
			bw.write(bp + "\n");
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
