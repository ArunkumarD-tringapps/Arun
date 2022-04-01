package tic;
import java.util.*;
public class TicTacToeBoard {
	String str;
  public TicTacToeBoard(String Board) {
	str=Board.toLowerCase();
  }
  public static boolean checkwinner(char check,String str)
  { 
	// checking at row
	  for(int i=0;i<7;i+=3) {
		  if((str.charAt(i)==check)&&(str.charAt(i+1)==check)&&(str.charAt(i+2)==check))
		  	{
		  			return true;
		  	}
	  }
	 // checking at column
	 for(int i=0;i<3;i++)
	 {
		  	if((str.charAt(i)==check)&&(str.charAt(i+3)==check)&&(str.charAt(i+6)==check))
		  	{
		  		return true;
		  	}
	 }
	 // checking at diagonal
	if((str.charAt(0)==check)&&(str.charAt(4)==check)&&(str.charAt(8)==check))
		{
		  		return true;
	}
	 if((str.charAt(2)==check)&&(str.charAt(4)==check)&&(str.charAt(6)==check))
	  	{
	  		return true;
	  	}
	 return false;
  }
  // Checks the state of the str (unreachable, no winner, X wins, or O wins)
  //@return an enum value corresponding to the str evaluation

  public Evaluation evaluate() {
	  if(str.length()!=9) {
		  return Evaluation.InvalidInput;
	  }
	  int countx=0;
	  int counto=0;
	  int xwin=0;
	  int owin=0;
	  for (int i=0;i<str.length();i++){
		  if(str.charAt(i)=='x') {
			  countx++;
		  }
		  if(str.charAt(i)=='o') {
			  counto++;
		  }
	  }
	  if(Math.abs(counto-countx)>1) {
		  return Evaluation.UnreachableState;
	  }
	  if(checkwinner('x',str)) {
		  xwin=1;
	  }
	  if(checkwinner('o',str)) {
		  owin=1;
		  
	  }
	  if(xwin==1 && owin==1)
		  return Evaluation.UnreachableState;
	  if(xwin==1)
		  return Evaluation.Xwins;
	  if(owin==1)
		  return Evaluation.Owins;
	 return Evaluation.NoWinner;
   }
public static void main(String[] args)
{
	Scanner s1=new Scanner(System.in);
	String input=s1.nextLine();
	TicTacToeBoard s=new TicTacToeBoard(input);
	System.out.println(s.evaluate());
}
}


