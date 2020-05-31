package Erase;

import java.io.*;
import java.util.*;

class Erase {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int N = fio.nextInt();
        String str1 = fio.nextLine();
        String str2 = fio.nextLine();

        if (N % 2 == 0) {
            if (str1.equals(str2)) {
                fio.println("Deletion succeeded");
            } else {
                fio.println("Deletion failed");
            }
        } else {
            if (isInverse(str1, str2)) {
                fio.println("Deletion succeeded");
            } else {
                fio.println("Deletion failed");
            }
        }
        fio.close();
    }

    private static boolean isInverse(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '0') {
                if (str2.charAt(i) != '1') {
                    return false;
                }
            } else {
                if (str2.charAt(i) != '0') {
                    return false;
                }
            }
        }
        return true;
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

