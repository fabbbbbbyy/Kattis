package Pivot;

import java.io.*;
import java.util.*;

class Pivot {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int numElements = fio.nextInt();
        int[] array = new int[numElements];

        for (int i = 0; i < numElements; i++) {
            array[i] = fio.nextInt();
        }

        int[] maxLeft = new int[numElements];
        maxLeft[0] = Integer.MIN_VALUE;
        int[] minRight = new int[numElements];
        minRight[numElements - 1] = Integer.MAX_VALUE;

        int currMax = array[0];
        for (int i = 1; i < numElements; i++) {
            currMax = Math.max(currMax, array[i - 1]);
            maxLeft[i] = currMax;
        }

        int currMin = array[numElements - 1];
        for (int i = numElements - 2; i >= 0; i--) {
            currMin = Math.min(currMin, array[i + 1]);
            minRight[i] = currMin;
        }

        int numPossiblePivots = 0;
        for (int i = 0; i < numElements; i++) {
            if (array[i] >= maxLeft[i] && array[i] < minRight[i]) {
                numPossiblePivots++;
            }
        }

        fio.println(numPossiblePivots);
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

