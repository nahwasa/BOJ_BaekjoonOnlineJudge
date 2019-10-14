import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(br.readLine());  
        bw.write(new String(decode, "UTF-8") + "\n"); 

		bw.flush();
		bw.close();
		br.close();
	}
}
