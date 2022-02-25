package Study.Week2;

import java.io.*;

public class Main2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == 'c' && i < n - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }
            else if (ch == 'd' && i < n - 1) {
                if (str.charAt(i + 1) == '-' && i < n - 1) {
                    i++;
                }
                else if (str.charAt(i + 1) == 'z' && i < n - 2) {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }
            else if ((ch == 'l' || ch == 'n') && i < n - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }
            else if ((ch == 's' || ch == 'z') && i < n - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
