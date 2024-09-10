import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(findShortestPath(5,4,5,1,1,4));
    }

    private static int findShortestPath(int n,int m,int sa1,int sa2,int sg1,int sg2){
        List<Integer>list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        find(list,0,sa1-1,sa2-1,sg1-1,sg2-1,n-1,m-1,visited);
        int min=-1;
        for(int i:list){
            min=Math.min(min,i);
        }
        return min;
    }

    private static void find(List<Integer> list, int count, int i, int j, int ans1, int ans2, int end1, int end2,boolean[][] visited) {
        boolean b1 = (i < 0 || i > ans1) || (j < 0 || j > ans2);
        if(b1 && (i<end1-1 || j<end2-1) && visited[i][j]){
            count=0;
            return;
        }
        if(i==ans1 && j==ans2){
            list.add(count);
            count=0;
            for(boolean[] b : visited)
                Arrays.fill(b,false);
            return;
        }
        if(b1) {
            if ((i<end1-1 || j<end2-1) && !visited[i][j]) {
                visited[i][j] = true;
            }
        }

        find(list, count+1, i+1, j, ans1, ans2, end1, end2,visited);
        find(list, count+1, i-1, j, ans1, ans2, end1, end2,visited);
        find(list, count+1, i, j+1, ans1, ans2, end1, end2,visited);
        find(list, count+1, i, j-1, ans1, ans2, end1, end2,visited);

    }

}