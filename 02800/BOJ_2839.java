import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		final int bag5kg = 5;
		final int bag3kg = 3;
		final int INIT_RESULT = Integer.MAX_VALUE;
		
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		
		int result = INIT_RESULT;		
		
		for (int i = 0; i <= weight / bag5kg; i++) {
			int num = 0;
			int tmp = weight - bag5kg * i;
			num += i;
			
			if (tmp % bag3kg == 0)
				num += tmp / bag3kg;
			else
				continue;
			
		
			if (result > num)
				result = num;
			
		}
		
		if (result == INIT_RESULT)
			result = -1;
		
		System.out.println(result);
	}
}
