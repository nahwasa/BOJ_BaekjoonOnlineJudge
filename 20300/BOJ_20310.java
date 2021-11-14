import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = new char[s.length()];
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
            if (arr[i] == '0') cnt0++;
            else cnt1++;
        }
        cnt0/=2;
        cnt1/=2;

        for (int i = 0; i < s.length() && cnt1!=0; i++) {
            if (arr[i] == '1') {
                cnt1--;
                arr[i] = 0;
            }
        }

        for (int i = s.length()-1; i >= 0 && cnt0!=0; i--) {
            if (arr[i] == '0') {
                cnt0--;
                arr[i] = 0;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] != 0)
                answer.append(arr[i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
