/*
In a N*N square chessboard, certain number of bishops are placed. The program must accept the positions of B bishops(marked by 1). The empty squares are marked by the value 0. 
The program must fill in the remaining N-B bishops with the condition that only one bishop must be in a row and one bishop must be in a column so that the bishops do not attack
each other. The program must finally print the arrangement of the bishops in the chessboard (if multiple arrangements are possible print the possibility which occurs with the 
left most column filled starting from the top row). If such an arrangement is not possible, then the program must print NotPossible as the output.
Note: In Chess, a bishop can move diagonally. The movement can happen till the end of the board is reached or another piece (like Rook, Knight, Bishop, Pawn etc is encountered). But in this program only the N bishops are placed and no other pieces will be present on the board.

Boundary Condition(s):
2 <= N <= 20
0 <= B <= N-1

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
1 0 0 0
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
1 0 0
1 0 0

Explanation:
Here multiple arrangements are possible. But starting from the top row, we consider the possibility once the left most column is filled.

Example Input/Output 3:
Input:
4
1 0 0 0
0 0 0 0
0 1 0 0
0 0 0 0

Output:
NotPossible
*/
import java.util.*;
public class Hello {

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		byte board[][]=new byte[N][N];
		boolean swDiagonals[]=new boolean[2*N-1], nwDiagonals[]=new boolean[2*N-1], bishopRows[]=new boolean[N];
		for(int row=0;row<N;row++)
		{
		    for(int col=0;col<N;col++)
		    {
		        board[row][col]=sc.nextByte();
		        if (board[row][col]==1)
		        {
		            nwDiagonals[row+col]=true;
		            swDiagonals[col-row+N-1]=true;
		            bishopRows[row]=true;
		        }
		    }
		}
		if (canPlace(N, 0, board, nwDiagonals, swDiagonals,bishopRows))
		{
		    for(int row=0;row<N;row++)
		    {
		        for(int col=0;col<N;col++)
		        {
		            System.out.print(board[row][col]+" ");
		        }
		        System.out.println();
		    }
		}
		else
		{
		    System.out.print("NotPossible");
		}
	}
	
	private static boolean canPlace(int N , int row, byte[][] board, boolean[] nwDiagonals, boolean[] swDiagonals, boolean[] bishopRows)
	{
	    if (row==N)
	    {
	        return true;
	    }
	    if (bishopRows[row])
	    {
	        return canPlace(N, row+1, board, nwDiagonals, swDiagonals, bishopRows);
	    }
	    for(int col=0;col<N;col++)
	    {
	        if (nwDiagonals[row+col]==false && swDiagonals[col-row+N-1]==false)
	        {
	            board[row][col]=1;
	            nwDiagonals[row+col]=true;
	            swDiagonals[col-row+N-1]=true;
	            bishopRows[row]=true;
	            if (canPlace(N, row+1,board,nwDiagonals,swDiagonals,bishopRows))
	            {
	                return true;
	            }
	            else {
	                board[row][col]=0;
	                nwDiagonals[row+col]=false;
	                swDiagonals[col-row+N-1]=false;
	                bishopRows[row]=false;
	            }
	        }
	    }
	    return false;
	}
	
}
