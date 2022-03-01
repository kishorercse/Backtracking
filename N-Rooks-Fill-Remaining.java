/*
In a N*N square chessboard, certain number of rooks are placed. The program must accept the positions of R rooks (marked by 1). The empty squares are marked by the value 0. The 
program must fill in the remaining N-R rooks with the condition that only one rook must be in a row and one rook must be in a column so that the rooks do not attack each other.
The program must finally print the arrangement of the rooks in the chessboard (if multiple arrangements are possible print the possibility which occurs with the left most column
filled starting from the top row).
Note: In Chess, a rook can move along a row or a column. The movement can happen till the end of the board is reached or another piece (like Rook, Knight, Bishop, Pawn etc is
encountered). But in this program only the N rooks are placed and no other pieces will be present on the board.

Boundary Condition(s):
2 <= N <= 20
0 <= R <= N-1

Input Format:
The first line contains N.
The next N lines contain N values (0 or 1) each separated by a space.

Output Format:
The first N lines contain N values (0 or 1) each separated by a space.

Example Input/Output 1:
Input:
4
1 0 0 0
0 0 0 0
0 0 0 1
0 1 0 0

Output:
1 0 0 0
0 0 1 0
0 0 0 1
0 1 0 0

Example Input/Output 2:
Input:
3
0 0 0
0 0 0
0 0 0

Output:
1 0 0
0 1 0
0 0 1

Explanation:
Here multiple arrangements are possible. But starting from the top row, we consider the possibility once the left most column is filled.
*/
import java.util.*;
public class Hello {

    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int N=sc.nextInt();
	    byte board[][]=new byte[N][N];
	    boolean rookRows[]=new boolean[N], rookCols[]=new boolean[N];
	    for(int row=0;row<N;row++) {
	        for(int col=0;col<N;col++) {
	            board[row][col]=sc.nextByte();
	            if (board[row][col]==1) {
    	            rookRows[row]=true;
    	            rookCols[col]=true;
	            }
	        }
	    }
	    if (canPlace(N, 0, board, rookRows, rookCols)) {
	        for(int row=0;row<N;row++) {
	            for(int col=0;col<N;col++) {
	                System.out.print(board[row][col]+" ");
	            }
	            System.out.println();
	        }
	    }

	}
	private static boolean canPlace(int N , int row, byte[][] board, boolean[] rookRows, boolean[] rookCols) {
	    if (row==N) {
	        return true;
	    }
	    if (rookRows[row]) {
	        return canPlace(N, row+1, board, rookRows, rookCols);
	    }
	    for(int col=0;col<N;col++)
	    {
	        if (rookRows[row]==false && rookCols[col]==false) {
    	        board[row][col]=1;
    	        rookRows[row]=true;
    	        rookCols[col]=true;
    	        if (canPlace(N, row+1, board, rookRows, rookCols)) {
    	            return true;
    	        }
    	        else {
    	            board[row][col]=0;
    	            rookRows[row]=false;
    	            rookCols[col]=false;
    	        }
	        }
	    }
	    return false;
	}
}
