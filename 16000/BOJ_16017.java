import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int num3 = Integer.parseInt(br.readLine());		
		int num4 = Integer.parseInt(br.readLine());
		boolean isTM = true;
		if (num1!=8 && num1!=9) isTM=false;
		if (num4!=8 && num4!=9) isTM=false;
		if(num2!=num3) isTM=false;
		if(isTM) bw.write("ignore\n");
		else bw.write("answer\n");
		bw.flush();
		br.close();
		bw.close();
	}	
}
