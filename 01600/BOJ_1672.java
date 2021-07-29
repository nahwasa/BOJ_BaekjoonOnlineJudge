import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] str = br.readLine().toCharArray();
        char[][] base = new char['T'+1]['T'+1];
        char[] tmp;
        tmp=base['T']; tmp['A']='G'; tmp['G']='A'; tmp['C']='G'; tmp['T']='T';
        tmp=base['C']; tmp['A']='A'; tmp['G']='T'; tmp['C']='C'; tmp['T']='G';
        tmp=base['G']; tmp['A']='C'; tmp['G']='G'; tmp['C']='T'; tmp['T']='A';
        tmp=base['A']; tmp['A']='A'; tmp['G']='C'; tmp['C']='A'; tmp['T']='G';

        for (int i = str.length-1; i >= 1; i--) str[i-1] = base[str[i]][str[i-1]];
        System.out.println(str[0]);
    }
}
