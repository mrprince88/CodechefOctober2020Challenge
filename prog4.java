import java.io.*;
import java.util.*;

class prog4 {

    public static void main(String[] args) {
        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            long x=in.nextLong();
            int p=in.nextInt();
            int k=in.nextInt();
            long []a=in.readLongArray(n);
            Arrays.sort(a);
            int index=minIndex(a,x,n,p);
            int count=0;
            if(a[index]!=x){
                a[k-1]=x;
                Arrays.sort(a);
                count++;
            }
            if(a[p-1]==x){
                pw.println(count);
            }
            else if(p<k && a[p-1]<x){
                pw.println(-1);
            }
            else if(p>k && a[p-1]>x){
                pw.println(-1);
            }
            else{
               index=minIndex(a,x,n,p);
               pw.println(Math.abs(p-index-1)+count);
            }
        }      
     pw.close();
    }

    static int minIndex(long []a,long x,int n,int p){
        int minp = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                if (Math.abs(p - i) < min){
                    min=Math.abs(p-i);
                    minp=i;
                }
            }
        }
        return minp;
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));   
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (final IOException e) {
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
        int[] readArray(int n) {
            int []a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        int[][] read2DArray(int n, int m) {
            final int [][]arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}