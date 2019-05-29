import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] in = new int[3];
		
		in[0] = Integer.parseInt(st.nextToken());
		in[1] = Integer.parseInt(st.nextToken());
		in[2] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(in);
		for(int i = 0; i < 3; i++)
			if (i == 2)
				bw.write( in[i] + "\n" );
			else
				bw.write( in[i] + " " );
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
