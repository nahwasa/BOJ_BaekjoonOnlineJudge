import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while (T-->0) {
			long N = Long.parseLong(br.readLine());
			long l = 1;
			long tmp = 1;
			while (tmp < N) {
				l+=2;
				tmp = l*l;
			}
			int pos = 1;
			for (; pos <= 3; pos++) {
				if (N >= tmp - (l-1)*pos)
					break;
			}
			long x = 0,y = 0;
			switch(pos) {
			case 1 :
				x = -((l-1)/2);
				y = (l-1)/2;
				y -= (tmp-N);
				break;
			case 2 :
				x = -((l-1)/2);
				y = -((l-1)/2);
				tmp = tmp - (l-1);
				x += (tmp-N);				
				break;
			case 3 :
				x = (l-1)/2;
				y = -((l-1)/2);
				tmp = tmp - (l-1)*2;
				y += (tmp-N);
				break;
			case 4 :
				x = (l-1)/2;
				y = (l-1)/2;
				tmp = tmp - (l-1)*3;
				x -= (tmp-N);	
				break;
			}
			bw.write(String.format("(%d,%d)\n", x, y));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
