import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader 입력 = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter 출력 = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer 스트링토크나이저 = new StringTokenizer(입력.readLine());
		int 입력받은격자모양칸의가로와세로길이= Integer.parseInt(스트링토크나이저.nextToken());
		int 처음당근위치체크할라고놓음 = Integer.parseInt(스트링토크나이저.nextToken()) + Integer.parseInt(스트링토크나이저.nextToken());			
		for (int 아이 = 0; 아이 < 입력받은격자모양칸의가로와세로길이; 아이++) {			
			for (int 제이 = 0; 제이 < 입력받은격자모양칸의가로와세로길이; 제이++) {
				if (((처음당근위치체크할라고놓음+아이+제이)&1)==0) 출력.write('v');
				else 출력.write('.');					
			}
			출력.newLine();
		}
		출력.flush();
		입력.close();
		출력.close();		
	}
}
