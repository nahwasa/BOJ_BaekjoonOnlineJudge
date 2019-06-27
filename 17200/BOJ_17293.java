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
		for (int i = N; i >= 0; i--) {
			if (i==0) {
				bw.write("No more bottles of beer on the wall, no more bottles of beer.");
				bw.newLine();
				bw.write(String.format("Go to the store and buy some more, %s of beer on the wall.\n", getNumStr(N)));
				break;
			}
			bw.write(String.format("%s of beer on the wall, %s of beer.\n", getNumStr(i), getNumStr(i)));
			if (i == 1)
				bw.write("Take one down and pass it around, no more bottles of beer on the wall.\n");
			else
				bw.write(String.format("Take one down and pass it around, %s of beer on the wall.\n", getNumStr(i-1)));
			bw.newLine();			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static String getNumStr(int n) {
		switch(n) {
		case 0 :
			return "No more bottles";
		case 1 :
			return "1 bottle";
		default:
			return n + " bottles";
		
		}
	}
}
