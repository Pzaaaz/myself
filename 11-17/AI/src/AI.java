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
	Image img,img1,imgleft1,imgleft2,img2,img3,currentImg;
	public MainCanvas(){
		try
		{
			img = Image.createImage("/sayo10.png");
			img1 = Image.createImage("/sayo12.png");
			imgleft1 = Image.createImage("/sayo02.png");
			imgleft2 = Image.createImage("/sayo22.png");
			img2 = Image.createImage("/sayo14.png");
			img3 = Image.createImage("/sayo16.png");
			currentImg = img;
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
			currentImg = img1;
			System.out.println("����ת");
			if (counnt==0){
				counnt=1;
				currentImg = imgleft1;
				}
			else if(counnt==1){
				counnt=2;
				currentImg = imgleft2;
		    }
		    else if (counnt==2)
		    {
				counnt=0;
				
		    }
			x-=1;
			repaint();
		}
		else if(action ==UP){
			currentImg = img2;
			System.out.println("����ת");
			y-=1;
			repaint();
		}
		else if(action == DOWN){
			currentImg = img;
			System.out.println("����ת");
			y+=1;
			repaint();
		}
		else if(action ==RIGHT){
			currentImg = img3;
			System.out.println("����ת");
			x+=1;
			repaint();
		}
	}
}