package JollyJumpers;

import java.io.*;
import java.util.*;

class JollyJumpers {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        while (true) {
            try {
                int n = fio.nextInt();
                boolean[] hasNumber = new boolean[n + 1]; // For 1 indexing.
                int currNum = fio.nextInt();
                for (int i = 1; i < n; i++) {
                    int nextNum = fio.nextInt();
                    int absDiff = Math.abs(currNum - nextNum);
                    if (absDiff <= n - 1) {
                        hasNumber[absDiff] = true;
                    }
                    currNum = nextNum;
                }

                boolean isJolly = true;
                for (int i = 1; i < n; i++) {
                    if (!hasNumber[i]) {
                        isJolly = false;
                    }
                }

                if (isJolly) {
                    fio.println("Jolly");
                } else {
                    fio.println("Not jolly");
                }
            }
            catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter
{
    BufferedReader br;
    StringTokenizer st;

    public FastIO()
    {
        super(new BufferedOutputStream(System.out));
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}

