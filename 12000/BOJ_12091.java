import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Random rd = new Random(System.currentTimeMillis());
		br.readLine();
		switch(Math.abs(rd.nextInt()) % 3) {
		case 0 : bw.write("Vaporeon\n"); break;
		case 1 : bw.write("Jolteon\n"); break;
		case 2 : bw.write("Flareon\n"); break;
		}
		bw.flush();
		br.close();
		bw.close();	
	}
}
