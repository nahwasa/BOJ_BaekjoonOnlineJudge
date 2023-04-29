import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        
        double bmi = weight / (height*height);

        System.out.println(bmi<18.5?"Underweight" : bmi>25.0?"Overweight" : "Normal weight");
    }
}
