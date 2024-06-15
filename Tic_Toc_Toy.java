package tic_toc_toy;
import java.util.Scanner;

public class Tic_Toc_Toy {
	
	boolean isGameOver=false;
	char turn='X';
	
	public void printBoard(char Board[][])
	{
		System.out.println("***************The Tic Toc Toy Board**************");
		int count=1;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print((count++)+"|");
			}
			System.out.println();
		}
	}
	
	public void print(char board[][])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
		}
	}
	
	public void play(char board[][])
	{
		Scanner scan=new Scanner(System.in);
		while(!isGameOver==true)
		{
			System.out.println("\nTurn for:-"+turn);	
			 System.out.print("Enter position(from 1 to 9):-");
			 int pos=scan.nextInt();
			 int row,col;
			 if(pos==3 || pos==6 || pos==9)
			 {
				 row=(pos/3)-1;
				 col=2;
			 }
			 else
			 {
				 row=pos/3;
				 col=(pos%3)-1; 
			 }
			 
			 if(board[row][col]==' ')
		        {
		        	board[row][col]=turn;
		        	isGameOver=isWon(board);
		        	if(isGameOver==true)
		        	{
		        		print(board);
		        		System.out.println("\nPlayer "+turn+" Won the Match.");
		        		System.out.print("\nDo you want to Replay(0/1):-");
		        		int choice=scan.nextInt();
		        		if(choice==1)
		        		{
		        			clear(board);
		        		}
		        		else
		        		{
		        			System.out.println("************************************ Thank you for playing ********************************************");
		        			System.exit(0);
		        		}
		        		
		        	}
		        	else
		        	{
		        		boolean rel=isDraw(board);
		        		if(rel==true)
		        		{
		        			System.out.println("\nThe Match is DRAW.");
		        			System.out.print("\nDo you want to Replay(0/1):-");
		        			int choice=scan.nextInt();
			        		if(choice==1)
			        		{
			        			clear(board);
			        		}
			        		else
			        		{
			        			System.out.println("************************************ Thank you for playing ********************************************");
			        			System.exit(0);
			        		}
		        		}
		        		
		        	}
		        	print(board);
		        	turn=(turn=='X')?'O':'X';
		        }
		        else
		        {
		        	System.out.println("Invalid Position.Plez enter the valid Postion.");
		        }
		}	
	}
	public boolean isWon(char board[][])
	{
		  for (int row = 0; row < 3; row++) {
	            if (board[row][0] == turn && board[row][1] == turn && board[row][2] == turn) {
	                return true;
	            }
	        }
	        for (int col = 0; col < 3; col++) {
	            if (board[0][col] == turn && board[1][col] == turn && board[2][col] == turn) {
	                return true;
	            }
	        }
	        if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
	            return true;
	        }
	        if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
	            return true;
	        }
	        return false;
	    }
	
	public boolean isDraw(char board[][])
	{
		boolean rel;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]==' ')
				{
					return false;
				}
			}
		}
		return true;
	}

	public void clear(char board[][])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]=' ';
			}
		}
		printBoard(board);
		play(board);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		Tic_Toc_Toy obj=new Tic_Toc_Toy();
		
		char[][] board=new char[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]=' ';
			}
		}
		
		obj.printBoard(board);
		obj.play(board);
		

	}

}
