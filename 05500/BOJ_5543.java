import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int minBurger = Integer.parseInt(br.readLine());
		int tmp = Integer.parseInt(br.readLine());
		minBurger = minBurger < tmp ? minBurger : tmp;
		tmp = Integer.parseInt(br.readLine());
		minBurger = minBurger < tmp ? minBurger : tmp;
		
		int minW = Integer.parseInt(br.readLine());
		tmp = Integer.parseInt(br.readLine());
		
		bw.write(minBurger + (minW < tmp ? minW : tmp) - 50 + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
