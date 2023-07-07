import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        switch (br.readLine()) {
            case "fdsajkl;" : case "jkl;fdsa" : System.out.println("in-out"); break;
            case "asdf;lkj" : case ";lkjasdf" : System.out.println("out-in"); break;
            case "asdfjkl;" : System.out.println("stairs"); break;
            case ";lkjfdsa" : System.out.println("reverse"); break;
            default : System.out.println("molu");
        }
    }
}
