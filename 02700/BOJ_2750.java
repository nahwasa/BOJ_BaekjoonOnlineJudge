import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));			
		
		int count, num;
		count = Integer.parseInt(br.readLine());
		
		if(count>1000 || count<1)
			return;
		
		int[] intList = new int[count];
		
		for(int i=0;i<count;i++) {
			num = Integer.parseInt(br.readLine());
			intList[i] = num;
		}
		
		
		int temp;
		for(int i=0;i<count;i++) {
			
			for(int j=i+1;j<count;j++) {
				if(intList[i]>intList[j]) {
					temp = intList[i];
					intList[i] = intList[j]; 
					intList[j] = temp;
				}
			}
		}
		
		for(int number:intList)
			bw.write(number + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
