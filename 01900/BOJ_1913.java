import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] dirX = new int[] {1,0,-1,0};
		int[] dirY = new int[] {0,1,0,-1};
		int[][] arr = new int[N][N];
		int idx = N*N;
		int dirPos = 0;
		int x=0, y=0;
		int kX=0, kY=0;
		while (idx > 0) {
			if(idx==K) {
				kX=x+1;
				kY=y+1;
			}
			arr[x][y] = idx--;
			if (x+dirX[dirPos]>N-1 || x+dirX[dirPos]<0 || y+dirY[dirPos]>N-1 || y+dirY[dirPos]<0 || arr[x+dirX[dirPos]][y+dirY[dirPos]]!=0)
				dirPos++;
			if (dirPos==4) dirPos=0;
			x += dirX[dirPos];
			y += dirY[dirPos];
			
		}
		for (x=0; x<N; x++) {
			for (y=0; y<N; y++) {
				bw.write(arr[x][y] + " ");
			}
			bw.newLine();
		}
		bw.write(kX + " " + kY+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
