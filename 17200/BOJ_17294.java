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
		boolean isCute = true;
		int gap = str.length()>1?str.charAt(1)-str.charAt(0):0;
		for (int i = 2; i < str.length(); i++)
			if (gap != str.charAt(i)-str.charAt(i-1)) {isCute=false; break;}
		if (isCute)			
			bw.write("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
		else	
			bw.write("흥칫뿡!! <(￣ ﹌ ￣)>");
		bw.flush();
		bw.close();
		br.close();
	}	
}
