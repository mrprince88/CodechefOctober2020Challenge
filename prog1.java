import java.io.*;
import java.util.*;

class prog1 {


    public static void main(final String[] args) {
        InputReader in = new InputReader();
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int x=in.nextInt();
            int y=in.nextInt();
            int k=in.nextInt();
            int c=0;
            for(int i=1;i<=n;i++){
                if((x+k*i)%n==y){
                    System.out.println("YES");
                    c++;
                    break;
                }
            }
            if(c==0)
            System.out.println("NO");
        }

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
            final int []a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        int [][] read2dArray(int n, int m) {
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