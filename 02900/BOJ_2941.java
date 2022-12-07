import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] wd = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String s = new Scanner(System.in).next();
        for (String w : wd) s = s.replaceAll(w, ",");
        System.out.print(s.length());
    }
}
