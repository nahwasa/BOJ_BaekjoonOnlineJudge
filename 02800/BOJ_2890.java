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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[n];
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine();
		
		int[] rank = new int[n];
		int rankTmp = 1;
		for (int i = arr[0].length()-2; i >=1; i--) {	// 우측부터 검사
			boolean chk = false;	// 하나라도 랭크매긴애가 존재한다면 등수숫자를 증가시키지않음.
			
			for (int j = 0; j < n; j++) {	// 각 라인 순회
				if (arr[j].charAt(i) != '.' && rank[arr[j].charAt(i) - '0' - 1] == 0) {	// 이미 등수매긴라인이 아니고, 카약이 있는 부분이라면
					chk = true;	// 등수가 매겨졌음
					rank[arr[j].charAt(i) - '0' - 1] = rankTmp;
				}
			}
			if (chk)
				rankTmp++;
		}
		
		for (int i = 0; i < n; i++)
			if (rank[i] != 0)
				bw.write(rank[i] + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}
