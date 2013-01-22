package com.examples.RealApps;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class DrawingView extends View{
	private float [] xPos = new float[10000];
	private float [] yPos = new float[10000];
	private Paint p1 = new Paint();
	//private Point [] ptPos = new Point[10000];
	private int pointCount = 0;
	private String msgStr = "";
	private EditText editText1;
	private String str = "";
	private String uniStr;
	private Point [] p = new Point[10000];
	private int top = Integer.MAX_VALUE;
	private int left = Integer.MAX_VALUE;
	private int bot = 0;
	private int rit = 0;
	private Rect r;
	private boolean isFinished = false;
	private boolean [][] bitMat;
	
	private Boolean [] segArr = new Boolean[7];
	
	private String digIs = " The Digit Is : ";
	private int digit,digit2;
	
	private BengDigitRecognizer digRecog = new BengDigitRecognizer(this);
	/*public DrawingView(Context c1)
	{
		super(c1);
	}*/
	public DrawingView(Context c1, AttributeSet attr)
	{
		super(c1,attr);
	}
	
	private void doIt()
	{
		digRecog.setBounds(top, left, bot, rit);
		digRecog.setPoints(xPos, yPos, pointCount);
		digit2 = digRecog.recogDigit();
		r = new Rect(left, top, rit, bot);
		/*for(int i = 0; i < 7; i++)
			segArr[i] = false;
		
		r = new Rect(left, top, rit, bot);
		bitMat = new boolean[rit-left+2][bot-top+2];
		for(int i = 0; i < (rit-left+2); i++)
		{
			for(int j = 0; j < (bot-top+2); j++)
			{
				bitMat[i][j] = false;
			}
		}
		
		for(int i = 0; i < pointCount; i++)
		{
			bitMat[(int) (xPos[i]-left)][(int) (yPos[i]-top)] = true;
		}
		
		findSeg_0();
		findSeg_1();
		findSeg_2();
		findSeg_3();
		findSeg_4();
		findSeg_5();
		findSeg_6();
		whatIsTheDigit();*/
	}
	
	/*private void findSeg_0()
	{
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		for(int i = 0; i < (rit-left)*0.4; i++)
		{
			for(int j = 0; j < (bot-top)*0.25; j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
						break;
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
						break;
				if(got3 = (bitMat[i][j] & got1 & got2))
					break;
			}
			if(got1 & got2 & got3)
			{
				segArr[0] = true;
				return;
			}
		}
	}
	
	private void findSeg_1()
	{
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		for(int i = (int) ((rit-left)*0.6); i < (rit-left+2); i++)
		{
			for(int j = (int) ((bot-top)*0.05); j < (bot-top)*0.4; j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
						continue;
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
						continue;
				if(got3 = (bitMat[i][j] & got1 & got2))
					break;
			}
			if(got1 & got2 & got3)
			{
				segArr[1] = true;
				return;
			}
		}
	}
	
	private void findSeg_2()
	{
		if((rit-left) > (bot-top+1))
		{
			segArr[2] = false;
			return;
		}
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		for(int i = (int) ((rit-left)*0.6); i < (rit-left+2); i++)
		{
			for(int j = (int) ((bot-top)*0.55); j < (bot-top)*0.90; j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
						continue;
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
						continue;
				if(got3 = (bitMat[i][j] & got1 & got2))
					break;
			}
			if(got1 & got2 & got3)
			{
				segArr[2] = true;
				return;
			}
		}
	}
	
	private void findSeg_3()
	{
		if((rit-left) > (bot-top+1))
		{
			segArr[3] = false;
			return;
		}
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		for(int i = (int) ((rit-left)*0.1); i < (rit-left+2)*0.85; i++)
		{
			for(int j = (int) ((bot-top)*0.75); j < (bot-top+2); j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
						break;
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
						break;
				if(got3 = (bitMat[i][j] & got1 & got2))
					break;
			}
			if(got1 & got2 & got3)
			{
				segArr[3] = true;
				return;
			}
		}
	}
	
	private void findSeg_4()
	{
		if((rit-left) > (bot-top+1))
		{
			segArr[4] = false;
			return;
		}
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		boolean got4 = false;
		boolean got5 = false;
		for(int i = 0; i < (rit-left+2)*0.4; i++)
		{
			for(int j = (int) ((bot-top)*0.6); j < (bot-top+2)*0.9; j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
						continue;
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
						continue;
				if(!got3)
					if(got3 = (bitMat[i][j] & got1 & got2))
						continue;
				if(!got4)
					if(got4 = (bitMat[i][j] & got1 & got2 & got3))
						continue;
				if(got5 = (bitMat[i][j] & got1 & got2 & got3 & got4))
					break;
			}
			if(got1 & got2 & got3 )
			{
				segArr[4] = true;
				return;
			}
		}
	}
	
	private void findSeg_5()
	{
		if((rit-left) > (bot-top+1))
		{
			segArr[5] = false;
		}
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		for(int i = 0; i < (rit-left+2)*0.3; i++)
		{
			for(int j = 0; j < (bot-top+2)*0.4; j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
					{
						continue;
					}
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
					{
						continue;
					}
				if(got3 = (bitMat[i][j] & got1 & got2))
					break;
			}
			if(got1 & got2 & got3)
			{
				segArr[5] = true;
				return;
			}
		}
	}
	
	private void findSeg_6()
	{
		if((rit-left) > (bot-top+1))
		{
			segArr[6] = true;
			return;
		}
		boolean got1 = false;
		boolean got2 = false;
		boolean got3 = false;
		for(int i = (int) ((rit-left+2)*0.15); i < (rit-left+2)*0.85; i++)
		{
			for(int j = (int) ((bot-top+2)*0.25); j < (bot-top+2)*0.75; j++)
			{
				if(!got1)
					if(got1 = bitMat[i][j])
						break;
				if(!got2)
					if(got2 = (bitMat[i][j] & got1))
						break;
				if(got3 = (bitMat[i][j] & got1 & got2))
					break;
			}
			if(got1 & got2 & got3)
			{
				segArr[6] = true;
				return;
			}
		}
	}
	
	private void whatIsTheDigit()
	{
		if(segArr[0] && segArr[1] && segArr[2] && segArr[3] && segArr[4] && segArr[5] && segArr[6])
			digit = 4;
		else if(segArr[0] && segArr[1] && segArr[2] && segArr[3] && segArr[4] && segArr[5])
			digit = 0;
		else if(segArr[0] && segArr[1] && segArr[2] && segArr[3] && segArr[4] && segArr[6])
			digit = 1;
		else if(segArr[0] && segArr[1] && segArr[2] && segArr[3] && segArr[6])
			digit = 9;
		else if(segArr[0] && segArr[1] && segArr[2] && segArr[5] && segArr[6])
			digit = 7;
		else if(segArr[6] && segArr[3] && segArr[4] && segArr[5])
			digit = 8;
		else if(segArr[0] && segArr[1] && segArr[6] && segArr[3])
			digit = 2;
		else if(segArr[2] && segArr[3] && segArr[4])
			digit = 6;
		else if(segArr[1] && segArr[6] && segArr[5])
			digit = 3;
		else if(segArr[5] & segArr[4] && segArr[3])
			digit = 5;
		else
			digit = -1;
	}*/
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		xPos[pointCount] = event.getX();
    	yPos[pointCount] = event.getY();
    	//p[pointCount].x = (int) event.getX();
    	//p[pointCount].y = (int) event.getY();
    	
    	left = (int) ((left < xPos[pointCount])?left:xPos[pointCount]);
    	top = (int) ((top < yPos[pointCount])?top:yPos[pointCount]);
    	rit = (int) ((rit > xPos[pointCount]) ? rit : xPos[pointCount]);
    	bot = (int) ((bot > yPos[pointCount]) ? bot : yPos[pointCount]);
    	
    	//ptPos[pointCount].x = xPos;
    	//ptPos[pointCount].y = yPos;
    	pointCount++;
    	
    	str = "" + event.getX() + " , " + event.getY();
    	int action = event.getAction();
    	if(action == MotionEvent.ACTION_UP)
    	{
    		doIt();
    		isFinished = true;
    	}
    	
		return true;
	}
	@Override
	public void draw(Canvas c)
	{
		super.onDraw(c);
		c.drawColor(Color.WHITE);
		
		p1.setColor(Color.RED);
		msgStr = "";
		msgStr += pointCount;
		msgStr += "  ";
		msgStr += segArr[0];
		msgStr += "  ";
		msgStr += segArr[1];
		msgStr += "  ";
		msgStr += segArr[2];
		msgStr += "  ";
		msgStr += segArr[3];
		msgStr += "  ";
		msgStr += segArr[4];
		msgStr += "  ";
		msgStr += segArr[5];
		msgStr += "  ";
		msgStr += segArr[6];
		
		c.drawText(msgStr + str, 5, 10, p1);
		
		if(isFinished)
		{
			digIs = "The Digit Is : " + digit2;
			c.drawText(digIs, 5, 20, p1);
		}
		
		p1.setColor(Color.BLUE);
		if(isFinished && left >= 0 && rit <= getWidth() && top >= 0 && bot <= getHeight())
			c.drawRect(r, p1);
		/*if(isFinished)
		{
			for(int i = 0; i < (rit-left+2); i++)
			{
				for(int j = 0; j < (bot-top+2); j++)
				{
					if(bitMat[i][j] == true)
						c.drawCircle(i, j, 2, p1);
				}
			}
		}*/
		p1.setColor(Color.RED);
		for(int i = 0 ;i < pointCount; i++)
			c.drawCircle(xPos[i], yPos[i], 2, p1);
		
		
		
		invalidate();
	}
	public void setEditText(EditText et)
	{
		editText1 = et;
	}

}
