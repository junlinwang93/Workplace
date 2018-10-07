package GobangGame;
/*
 * @author Junlin Wang
 */
import java.awt.*;

public class ChessPoint extends Canvas{
	private int a,b;
	private Color color;
	public ChessPoint(int x,int y,Color color) {    		
   	 a=x;b=y;this.color=color;
}
	public int getA() {
		return a;}
	public int getB() {
		return b;}
	public Color getColor() {
		return color;}
	
	}
	