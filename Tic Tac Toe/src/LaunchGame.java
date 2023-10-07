import java.util.Scanner;
class TicTacToe1
{
	static char[][] board;
	public TicTacToe1()
	{
		board=new char[3][3];
		initBoard();
	}
	void initBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	static void dispBoard()
	{
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	static void placeMark(int row,int col,char mark)
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			board[row][col]=mark;
		}
		else
		{
			System.out.println("Invalid Position");
		}
	}
	static  boolean checkColWin()
	{
		for(int j=0;j<=2;j++)
		{
			if(board[0][j]!=' '&&board[0][j]==board[1][j]&&board[1][j]==board[2][j])
			{
				return true;
			}
		}
		return false;
	}
	static boolean checkRolWin()
	{
		for(int i=0;i<=2;i++)
		{
			if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	static boolean checkDiagWin()
	{
		if(board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2]
				||board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0])
		{
			return true;
		}
		return false;
	}
}

public class LaunchGame {
	public static void main(String[] args) {
		TicTacToe1 t= new TicTacToe1();
		HumanPlayer p1=new HumanPlayer("Mouni",'X');
		HumanPlayer p2=new HumanPlayer("Shruthi",'O');
		HumanPlayer cp;
		cp=p1;
		while(true)
		{
			System.out.println(cp.name+" turn ");
			cp.makeMove();
			TicTacToe1.dispBoard();
			if(TicTacToe1.checkColWin()||TicTacToe1.checkRolWin()||TicTacToe1.checkDiagWin())
			{
				System.out.println(cp.name+" has Won");
				break;
			}
			else
			{
				if(cp==p1)
				{
					cp=p2;
				}
				else
				{
					cp=p1;
				}
			}

		}
	}
}
class HumanPlayer1
{
	String name;
	char Mark;
	public HumanPlayer1(String name,char Mark)
	{
		this.name=name;
		this.Mark=Mark;
	}
	void makeMove()
	{ 
		int row;
		int col;
		do
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the row and col ");
			row=scan.nextInt();
			col=scan.nextInt();
		}while(!isValidMove(row,col));
		TicTacToe1.placeMark(row,col,Mark);
	}
	boolean isValidMove(int row,int col)
	{
		if(row>=0&&row<=2&&col>=0&&col<=2)
		{
			if(TicTacToe1.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
}
