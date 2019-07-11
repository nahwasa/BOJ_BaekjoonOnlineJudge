import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		switch(a+b+c) {	
		case 180 :
			if (a==b&&b==c&&c==a)
				bw.write("Equilateral\n");
			else if (a==b||b==c||c==a)
				bw.write("Isosceles\n");
			else
				bw.write("Scalene\n");
			break;
		default : bw.write("Error\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
