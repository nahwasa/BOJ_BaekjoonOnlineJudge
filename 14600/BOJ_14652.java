import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		bw.write(Integer.parseInt(input[2]) / Integer.parseInt(input[1]) + " ");
		bw.write(Integer.parseInt(input[2]) % Integer.parseInt(input[1]) + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
