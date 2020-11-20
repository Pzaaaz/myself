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
	Image heroDownImg[] = new Image[3];
	Image heroUpImg[] = new Image[3];
	Image heroLeftImg[] = new Image[3];
	Image heroRightImg[] = new Image[3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<3;i++){
				heroDownImg[i] = Image.createImage("/sayo"+i+"0.png");
			}
			/*
			向下
			img = Image.createImage("/sayo10.png");
			imgdown1 = Image.createImage("/sayo00.png");
			imgdown2 = Image.createImage("/sayo20.png");
            */

			for(int i=0;i<3;i++){
				heroLeftImg[i] = Image.createImage("/sayo"+i+"2.png");
			}
			/*
			向左
			img1 = Image.createImage("/sayo12.png");
			imgleft1 = Image.createImage("/sayo02.png");
			imgleft2 = Image.createImage("/sayo22.png");
			*/

			for(int i=0;i<3;i++){
				heroUpImg[i] = Image.createImage("/sayo"+i+"4.png");
			}

			/*
			上
			img2 = Image.createImage("/sayo14.png");
			imgup1 = Image.createImage("/sayo04.png");
            imgup2 = Image.createImage("/sayo24.png");
            */

			for(int i=0;i<3;i++){
				heroRightImg[i] = Image.createImage("/sayo"+i+"6.png");
			}
			/*
			右
			img3 = Image.createImage("/sayo16.png");
			imgright1 = Image.createImage("/sayo06.png");
			imgright2 = Image.createImage("/sayo26.png");
            */


			currentImg = heroDownImg[1];

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
				currentImg = heroLeftImg[0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroLeftImg[2];
		    }
			System.out.println("向左转");
			x-=1;
			repaint();
		}
		else if(action ==UP){
			if (counnt==0){
				counnt=1;
				currentImg = heroUpImg[0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroUpImg[2];
		    }
			System.out.println("向上转");
			y-=1;
			repaint();
		}
		else if(action == DOWN){
			if (counnt==0){
				counnt=1;
				currentImg = heroDownImg[0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroDownImg[2];
		    }
			System.out.println("向下转");
			y+=1;
			repaint();
		}
		else if(action ==RIGHT){
			if (counnt==0){
				counnt=1;
				currentImg = heroRightImg[0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroRightImg[2];
		    }
			System.out.println("向右转");
			x+=1;
			repaint();
		}
	}
}