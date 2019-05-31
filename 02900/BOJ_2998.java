import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String str = br.readLine();
		while(str.length()%3 != 0)
			str = "0" + str;
		
		for (int i = 0; i < str.length()/3; i++) {
			String tmp = str.substring(i*3, i*3 + 3);
			switch (tmp) {
			case "000" :
				bw.write("0");
				break;
			case "001" :
				bw.write("1");
				break;
			case "010" :
				bw.write("2");
				break;
			case "011" :
				bw.write("3");
				break;
			case "100" :
				bw.write("4");
				break;
			case "101" :
				bw.write("5");
				break;
			case "110" :
				bw.write("6");
				break;
			case "111" :
				bw.write("7");
				break;
			}
		}
		bw.newLine();
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
