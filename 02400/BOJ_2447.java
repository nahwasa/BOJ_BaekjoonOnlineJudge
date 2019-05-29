import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		arr = new String[3];
		arr[0] = "***";
		arr[1] = "* *";
		arr[2] = "***";

		int input = Integer.parseInt(br.readLine());
		
		int n = 1;
		int tmp = 1;
		while(input != tmp) {			
			tmp *= 3;
			n++;
		}
		
		while (--n != 1)
			makeMoreStars();
		
		printStars(bw);
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static void printStars(BufferedWriter bw) throws IOException {
		for (int i = 0; i < arr.length; i++)
			bw.write(arr[i] + "\n");
	}

	private static void makeMoreStars() {
		String[] tmp = new String[arr.length * 3];
		StringBuilder sb;
		
		for (int i = 0; i < arr.length; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < 3; j++) {
				sb.append(arr[i]);
			}			
			tmp[i] = sb.toString();
		}
		
		for (int i = 0; i < arr.length; i++) {
			sb = new StringBuilder();
			sb.append(arr[i]);
			for(int j = 0; j < arr.length; j++)
				sb.append(" ");
			sb.append(arr[i]);
			tmp[i + arr.length] = sb.toString();
		}
		
		for (int i = 0; i < arr.length; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < 3; j++) {
				sb.append(arr[i]);
			}			
			tmp[i + arr.length * 2] = sb.toString();
		}
		
		arr = tmp;
	}

	
}
