import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String str = br.readLine();
        String result = "";
        switch (str) {
            case "NLCS": result = "North London Collegiate School"; break;
            case "BHA": result = "Branksome Hall Asia"; break;
            case "KIS": result = "Korea International School"; break;
            case "SJA": result = "St. Johnsbury Academy"; break;
        }

        System.out.println(result);
    }
}
