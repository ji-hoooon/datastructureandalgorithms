package org.algorithms.graph.topological.topological_base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//ACM Craft
public class BackJoon_1005_solved {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    static void input() {
        // Testcase 가 존재하는 문제이므로 "배열 초기화"에 유의하자
        N= scan.nextInt();
        M= scan.nextInt();
        indeg= new int[N+1];
        T_done=new int[N+1];
        T=new int[N+1];
        adj=new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            T[i]= scan.nextInt();
        }
        for(int i=1;i<=N;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1; i<=M;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for(int i=1;i<=N;i++){
            if(indeg[i]==0) queue.offer(i);
        }

        // 위상 정렬 순서대로 T_done 계산을 함께 해주기
        while(!queue.isEmpty()){
            //1
            int x=queue.poll();
            T_done[x]=Math.max(T_done[x], T[x]);
            for(int y:adj[x]){
                indeg[y]--;
                //max(T_Done[Y의 선행작업], T_Done[X의 선행작업]+T[Y])
                T_done[y]=Math.max(T_done[y], T_done[x]+T[y]);

                if(indeg[y]==0) {
                    queue.offer(y);
                }
            }
        }
        sb.append(T_done[scan.nextInt()]).append("\n");
    }

    public static void main(String[] args) {
        int Q = scan.nextInt();
        while (Q > 0) {
            Q--;
            input();
            pro();
        }
        System.out.println(sb);
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