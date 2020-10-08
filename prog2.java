import java.io.*;
import java.util.*;

class prog2 {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int []q=s.readArray(n);
            int curr=0,c=0;
            for(int i=0;i<n;i++){
                curr+=q[i];
                s.p.println(curr);
                if(curr<k){
                    s.p.println(i+1);
                    ++c;
                    break;
                }
                curr-=k;
            }
            if(c==1)
            s.p.println(curr);
        }
        s.close();
    }

    static class MyStack {
        BufferedReader br;
        StringTokenizer st;
        PrintWriter p;

        public MyStack() {
            br = new BufferedReader(new InputStreamReader(System.in));
            p=new PrintWriter(System.out);
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
        int [][] read2DArray(int n, int m) {
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
        void close(){
            p.close();
        }
    }
}