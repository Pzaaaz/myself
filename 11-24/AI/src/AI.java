import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;
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
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY,bossX,bossY,counnt;
	Image bossImg;
	Image heroImg [][] = new Image[4][3];
	Image currentImg;
	Random random = new Random();
	public MainCanvas(){
		try
		{
			
			for(int i = 0;i<heroImg.length;i++){//��0�Ϸ���1Ϊ�·���2Ϊ����3Ϊ�ҷ���
				for (int j = 0;j<heroImg[i].length ;j++ ){
					heroImg[i][j] = Image.createImage("/sayo"+i+j+".png");
					}
				}
            bossImg = Image.createImage("/zuzu000.png");
			currentImg = heroImg[1][1];

			bossX = 0;
			bossY = 0;

			heroX = 120;
			heroY = 100;

			counnt=0;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true)
		{
			int a = random.nextInt(10);
			System.out.println(a);
			try
			{
				Thread.sleep(200);//FPS:��Ļˢ����
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
            if(a%2==0){
				if (bossX<heroX)
				{
				bossX++;
				}
				else{
				bossX--;
				}
				if (bossY<heroY)
				{
				bossY++;
				}
				else{
				bossY--;
				}
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);
		if(action == LEFT){
			changeImg(2);
			System.out.println("����ת");
			heroX-=1;
		}
		else if(action ==UP){
			changeImg(0);
			System.out.println("����ת");
			heroY-=1;
		}
		else if(action == DOWN){
		    changeImg(1);
			System.out.println("����ת");
			heroY+=1;
		}
		else if(action ==RIGHT){
			changeImg(3);
			System.out.println("����ת");
			heroX+=1;
		}
		
	}
    void changeImg(int direction){
            if (counnt==0){
				counnt=1;
				currentImg = heroImg[direction][0];
				}
			else if(counnt==1){
				counnt=0;
				currentImg = heroImg[direction][2];
		    }
		}
		}