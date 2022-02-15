package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("0")) {
                break;
            }

            StringBuffer sbf = new StringBuffer(str);
            String reverse = String.valueOf(sbf.reverse());

//            String reverse = "";
//            for(int i = str.length()-1; i >= 0; i--) {
//                reverse += str.charAt(i);
//            }



//            char[] arr = str.toCharArray();
//            String reverse = "";
//            for(int i = str.length()-1; i >= 0; i--) {
//                reverse += String.valueOf(arr[i]);
//            }


            if(str.equals(reverse)) {
                sb.append("yes").append('\n');
            }
            else {
                sb.append("no").append('\n');
            }

        }

        System.out.println(sb);

    }
}
