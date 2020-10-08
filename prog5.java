import java.io.*;
import java.util.*;

class prog5 {

    static class Edge {
        int src;
        int dest;
        long weight;

        Edge(int src, int dest, long weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt();
        int d = in.nextInt();
        int[][] a = in.read2DArray(n, d);
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long weight = diff(a[i], a[j]);
                Edge curr = new Edge(i, j, weight);
                edges.add(curr);
            }
        }

        long[][] graph = new long[n][n];

        for (Edge i : edges) {
            graph[i.src][i.dest] = i.weight;
            graph[i.dest][i.src] = i.weight;
        }

        int parent[] = new int[n];
        long[] key = new long[n];
        boolean mstSet[] = new boolean[n];
        Arrays.fill(key, -1);
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < n - 1; count++) {
            long u = maxKey(key, mstSet, n);
            mstSet[(int) u] = true;
            for (int j = 0; j < n; j++) {
                if (graph[(int) u][j] != 0 && mstSet[j] == false && graph[(int) u][j] > key[j]) {
                    parent[j] = (int) u;
                    key[j] = graph[(int) u][j];
                }
            }
        }
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += graph[parent[i]][i];
        }
        pw.println(sum);

        pw.close();
    }

    static long diff(int[] a, int[] b) {
        long diff = 0;
        for (int i = 0; i < a.length; i++) {
            diff += Math.abs(a[i] - b[i]);
        }
        return diff;
    }

    static long maxKey(long[] key, boolean[] mstSet, int v) {
        long max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < v; i++) {
            if (mstSet[i] == false && key[i] > max) {
                max = key[i];
                index = i;
            }
        }
        return index;
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
            int[] a = new int[n];
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
            final int[][] arr = new int[n][m];
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