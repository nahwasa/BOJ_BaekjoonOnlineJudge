import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
	private static final String REGEX = "^(100+1+|01)+$";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Pattern.matches(REGEX, br.readLine()) ? "SUBMARINE" : "NOISE");
	}
}
