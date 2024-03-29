package org.algorithms.search.sortsearch.sort_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//단어 정렬
public class BackJoon_1181_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            // TODO
            // lhs 와 rhs 를 비교해서 lhs 가 앞에 와야 하는 조건
            // 1. 길이가 짧은 게 우선
            if(lhs.length()<rhs.length()) return -1;
            else if(lhs.length()>rhs.length()) return 1;
            // 2. 길이가 같으면 사전순으로
            else return lhs.compareTo(rhs);
        }
    }

    static int N;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.next();
        }
    }

    static void pro() {
        // 정렬 조건에 맞게 단어를 정렬하기
//        Arrays.sort(a, new MyComparator());
        Arrays.sort(a, (o1, o2)-> o1.length()!=o2.length()?o1.length()-o2.length():o1.compareTo(o2));

        // 출력하기
        String s="";
        for (String str: a) {
            if(!s.equals(str)) {
                sb.append(str).append('\n');
                s=str;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
