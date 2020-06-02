package BasicProgramming2;

import java.io.*;
import java.util.*;

class BasicProgramming2 {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int N = fio.nextInt();

        /*
         t1 uses HashSet w complements,
         t2 uses HashSet one pass,
         t3 uses HashMap pre-computation followed by one pass,
         t4 uses sorting,
         t5 uses sorting followed by one pass
         */
        int t = fio.nextInt();

        if (t == 1) {
            HashSet<Integer> numbers = new HashSet<>();
            for (int i = 0; i < N; i++) {
                numbers.add(fio.nextInt());
            }
            boolean isCaseOne = false;
            for (Integer number : numbers) {
                int complement = 7777 - number;
                if (complement != number && numbers.contains(complement)) {
                    isCaseOne = true;
                    break;
                }
            }
            if (isCaseOne) {
                fio.println("Yes");
            } else {
                fio.println("No");
            }
        } else if (t == 2) {
            HashSet<Integer> numbers = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < N; i++) {
                int nextInt = fio.nextInt();
                if (!numbers.contains(nextInt)) {
                    numbers.add(nextInt);
                } else {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                fio.println("Contains duplicate");
            } else {
                fio.println("Unique");
            }
        } else if (t == 3) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int nextInt = fio.nextInt();
                if (map.containsKey(nextInt)) {
                    int count = map.get(nextInt);
                    map.put(nextInt, count + 1);
                } else {
                    map.put(nextInt, 1);
                }
            }
            int result = -1;
            int halfN = N / 2;
            for (Integer number : map.keySet()) {
                if (map.get(number) > halfN) {
                    result = number;
                    break;
                }
            }
            fio.println(result);
        } else if (t == 4) {
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = fio.nextInt();
            }
            Arrays.sort(array);
            if (N % 2 != 0) { // is odd
                fio.println(array[N / 2]);
            } else {
                fio.print(array[(N/2) - 1]);
                fio.print(" ");
                fio.println(array[N / 2]);
            }
        } else { // as per question specification, this should be 5 and nothing else.
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int nextInt = fio.nextInt();
                if (nextInt >= 100 && nextInt <= 999) {
                    arrayList.add(nextInt);
                }
            }
            Collections.sort(arrayList);
            fio.print(arrayList.get(0));
            for (int i = 1; i < arrayList.size(); i++) {
                fio.print(" " + arrayList.get(i));
            }
            fio.println();
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

