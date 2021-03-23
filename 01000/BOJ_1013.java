import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
	private static final String REGEX = "^(100+1+|01)+$";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (tc-->0)	sb.append(Pattern.matches(REGEX, br.readLine()) ? "YES\n" : "NO\n");
		System.out.println(sb);
	}
}
