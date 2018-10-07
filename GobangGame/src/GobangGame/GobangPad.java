package GobangGame;
/*
 * @author Junlin Wang
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GobangPad extends JPanel implements MouseListener,ActionListener{
	private static final long serialVersionUID = 1L;
	int x=0,y=0;
	ChessPoint[] list=new ChessPoint[19*19];
	int chesscnt;
	int startcnt=0;
	boolean isBlack=true;
	boolean gameover=false;
	boolean startgame=false;
	JButton startbt=new JButton("Start");
	JButton restartbt=new JButton("Restart");
	JButton backbt=new JButton("Goback");
	TextField text=new TextField("");
	
	public  GobangPad() {	
		setSize(920,880);
		setLayout(null); 
		this.setBackground(Color.lightGray);
		addMouseListener(this);
		add(startbt);
		add(restartbt);
		add(backbt);
		startbt.setBounds(790, 300, 100, 70);
		startbt.setVisible(true);
		startbt.addActionListener(this);
		restartbt.setBounds(790, 400, 100, 70);
		restartbt.setVisible(true);
		restartbt.addActionListener(this);
		backbt.setBounds(790, 500, 100, 70);		
		backbt.setVisible(true);
		backbt.addActionListener(this);
		add(text);
		text.setEditable(false);
		text.setFont(new Font("TimesRoman",Font.PLAIN,20));
		text.setBounds(280, 20, 320, 40);
		setVisible(true);
	 }
	
	public boolean findChess(int x,int y) {
		for(ChessPoint c:list) {
			if(c!=null&&c.getA()==x&&c.getB()==y)
				return true;
		}
		return false;
	}
	
	public ChessPoint getChess(int x,int y,Color color) {
		for(ChessPoint c:list) {
			if(c!=null&&c.getA()==x&&c.getB()==y&&c.getColor()==color)
				return c;
		}
		return null;
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getModifiers()==InputEvent.BUTTON1_MASK)  {  
			x=((int)e.getX()+20)/40;y=((int)e.getY()+20)/40;
			if(!startgame) return;
			if(gameover) return;
			if(x<1||y<2||x>19||y>20)return; 
			if(findChess(x,y)) return;		  
			ChessPoint cp=new ChessPoint(x,y,isBlack?Color.black:Color.white);
			list[chesscnt++]=cp;
			repaint();
	  
			if(!isBlack) {
				text.setText("Now it is Black's Turn");
			}
			else{text.setText("Now it is White's Turn");}
			}
			if(isWin()) {
				gameover=true;
				if(isBlack) {
		    	  text.setText("Black Win");
				}
				else{text.setText("White Win");}
			}
		
			isBlack=!isBlack;}
	
  
	  public void mouseReleased(MouseEvent e){} 
	  public void mouseEntered(MouseEvent e){} 
	  public void mouseExited(MouseEvent e){} 
	  public void mouseClicked(MouseEvent e){
	  } 
	  public void actionPerformed(ActionEvent e) {
		   Object obj=e.getSource();
		   if(obj==startbt) {
			   startgame=true;
			   startcnt++;
			   if(startcnt==1)
				   text.setText("Start game, Black First Please");
			   else
				   text.setText("Please click Restart botton to begin a new game");
		   }
		   if(obj==restartbt) {
			   int result = JOptionPane.showConfirmDialog(this, "Are you sure to restart?",
				        "Warning", JOptionPane.OK_CANCEL_OPTION);
				System.out.println(result);
				if (result == 0) {
					isBlack=true;
					gameover=false;
					chesscnt=0;
					repaint();
					text.setText("Restart Game,Black First Please");
					for(int i=0;i<list.length;i++) {
						list[i]=null;
					}
				}
				else return;
				setVisible(true);
		   }
		   else if(obj==backbt) {
			   if(chesscnt==0) return;
			   if(chesscnt>0) {
				   x=list[chesscnt-1].getA();
				   y=list[chesscnt-1].getB();
			   }
			   list[chesscnt-1]=null;
			   chesscnt--;
			   isBlack=!isBlack;
			   repaint();
			   text.setText("Goback Game, Please");
			   gameover=false;
		   }
	  }
	 
	  public boolean isWin() {
		  int continueCount=1;
		  //
		  for(int xi=x-1;xi>0;xi--) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(xi,y,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  for(int xi=x+1;xi<20;xi++) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(xi,y,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  if(continueCount>=5) {
			  return true;}
		  else continueCount=1;
		  //
		  for(int yi=y-1;yi>1;yi--) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(x,yi,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  for(int yi=y+1;yi<21;yi++) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(x,yi,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  if(continueCount>=5) {
			  return true;}
		  else continueCount=1;
		  //
		  for(int xi=x+1,yi=y-1;xi<20&&yi>1;xi++,yi--) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(xi,yi,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  for(int xi=x-1,yi=y+1;xi>0&&yi<21;xi--,yi++) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(xi,yi,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  if(continueCount>=5) {
			  return true;}
		  else continueCount=1;
		  //
		  for(int xi=x+1,yi=y+1;xi<20&&yi<21;xi++,yi++) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(xi,yi,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  for(int xi=x-1,yi=y-1;xi>0&&yi>1;xi--,yi--) {
			  Color c=isBlack?Color.black:Color.white;
			  if(getChess(xi,yi,c)!=null) {
				  continueCount++;}
			  else break;
		  }
		  if(continueCount>=5) {
			  return true;}
		  else continueCount=1;
		  return false;
	  }
	  
	  public void paint(Graphics g){
	    super.paint(g);
		for(int i=80;i<=800;i+=40) {
			g.drawLine(40, i, 760, i);
		}
		for(int j=40;j<=760;j+=40) {
			g.drawLine(j, 80, j, 800);
		}
		g.fillOval(156,196,8,8);g.fillOval(396,196,8,8);g.fillOval(636,196,8,8);
		g.fillOval(156,436,8,8);g.fillOval(396,436,8,8);g.fillOval(636,436,8,8);
		g.fillOval(156,676,8,8);g.fillOval(396,676,8,8);g.fillOval(636,676,8,8);
		for(int i=0;i<chesscnt;i++) {
			int xc=list[i].getA();
			int yc=list[i].getB();
			g.setColor(list[i].getColor());
			g.fillOval(xc*40-20, yc*40-20, 40, 40);
		}
  }
}

