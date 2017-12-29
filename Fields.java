import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Fields {

	private static int getMaxFenceLength(int[][] ff, int R, int C) {
		int maxFenceLen = -1;

		ArrayList<Node> paths = new ArrayList<>();

		ArrayList<Integer> fenceMem = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if (ff[i][j] == 1) {
					ff[i][j] = -1; //mark visited
					int fenceLen = 0;
					LinkedList<Node> q = new LinkedList<>();
					q.add(new Node(i,j,null));
					Node curr = null;
					while (!q.isEmpty()) {
						curr = q.removeFirst();
						
						fenceLen += 4;
						int x = curr.x;
						int y = curr.y;
						ff[x][y] = -1; //mark visited

						//Check Up
						if(x-1>= 0){
							if(ff[x-1][y] == -1){
								fenceLen -= 1;
							}
							if(ff[x-1][y] == 1){
								q.addLast(new Node(x-1, y,curr));
								ff[x-1][y] = -1;
								fenceLen -= 1;
							}
						}

						//Check down
						if(x+1<R){
							if(ff[x+1][y] == -1){
								fenceLen -= 1;
							}
							if(ff[x+1][y] == 1){
								q.addLast(new Node(x+1,y,curr));
								ff[x+1][y] = -1;
								fenceLen -= 1;
							}
						}
						
						//Check left
						if(y-1>=0){
							if(ff[x][y-1] == -1){
								fenceLen -= 1;
							}
							
							if(ff[x][y-1] == 1){
								q.addLast(new Node(x,y-1,curr));
								ff[x][y-1] = -1;
								fenceLen -= 1;
							}
						}
						
						//Check right
						if(y+1<C){
							if(ff[x][y+1] == -1){
								fenceLen -= 1;
							}
							if(ff[x][y+1] == 1){
								q.addLast(new Node(x,y+1,curr));
								ff[x][y+1] = -1;
								fenceLen -= 1;
							}
						}
					}
					fenceMem.add(fenceLen);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(fenceMem.toArray()));
		maxFenceLen = Collections.max(fenceMem);

		return maxFenceLen;
	}

	static class Node {
		int x;
		int y;
		Node parent;

		public Node(int x, int y, Node par) {
			this.x = x;
			this.y = y;
			this.parent = par;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+","+y;
		}
	}

	public static void main(String[] args) {

		int R = 4;
		int C = 4;
		int N = 9;
		int[][] ff = new int[R][C];
		int[][] cc = { { 1, 4 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 4, 3 }, { 4, 1 }, { 4, 2 }, { 3, 1 }, { 3, 3 } };

		// init with zeros
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ff[i][j] = 0;
			}
		}

		// place cultivated fields as 1
		for (int i = 0; i < N; i++) {
			int[] aa = cc[i];
			ff[aa[0] - 1][aa[1] - 1] = 1;
		}

		System.out.println(Arrays.deepToString(ff));

		System.out.println(getMaxFenceLength(ff, R, C));

	}

}
