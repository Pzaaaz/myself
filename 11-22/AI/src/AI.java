import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y,counnt;
	Image heroImg [][] = new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			
			for(int i = 0;i<heroImg.length;i++){//令0上方向，1为下方向，2为左方向，3为右方向
				for (int j = 0;j<heroImg[i].length ;j++ ){
					heroImg[i][j] = Image.createImage("/sayo"+i+j+".png");
					}
				}

			currentImg = heroImg[1][1];

			x = 120;
			y = 100;
			counnt=0;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == LEFT){
			if (counnt==0){
				counnt=1;
				currentImg = heroImg[2][0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroImg[2][2];
		    }
			System.out.println("向左转");
			x-=1;
			repaint();
		}
		else if(action ==UP){
			if (counnt==0){
				counnt=1;
				currentImg = heroImg[0][0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroImg[0][2];
		    }
			System.out.println("向上转");
			y-=1;
			repaint();
		}
		else if(action == DOWN){
			if (counnt==0){
				counnt=1;
				currentImg = heroImg[1][0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroImg[1][2];
		    }
			System.out.println("向下转");
			y+=1;
			repaint();
		}
		else if(action ==RIGHT){
			if (counnt==0){
				counnt=1;
				currentImg = heroImg[3][0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroImg[3][2];
		    }
			System.out.println("向右转");
			x+=1;
			repaint();
		}
	}
}