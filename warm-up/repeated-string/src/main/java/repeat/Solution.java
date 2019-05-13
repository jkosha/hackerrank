package repeat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static long repeatedString(String s, long n) {
        long numOfS = n/s.length();
        long rest = n % s.length();

        if(!s.contains("a")) return 0;
        return s.length()>n? aCounter(s, rest)
                : numOfS*aCounter(s, s.length()) + aCounter(s, rest);
    }

    private static long aCounter(String s, long end) {
        int a=0;
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == 'a') a++;
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
