package com.examples.RealApps;

import android.R.string;
import android.graphics.Rect;
import android.view.View;

public class BengDigitRecognizer {
	
	private float [] xPos = new float[10000];
	private float [] yPos = new float[10000];
	private int pointCount = 0;
	private View drawingView;
	private int top = Integer.MAX_VALUE;
	private int left = Integer.MAX_VALUE;
	private int bot = 0;
	private int rit = 0;
	private Rect r;
	private boolean isFinished = false;
	private boolean [][] bitMat;
	
	private Boolean [] segArr = new Boolean[7];
	
	private String digIs = " The Digit Is : ";
	private int digit;
	private DisplayInSegments segments = new DisplayInSegments();
	public BengDigitRecognizer(View v)
	{
		drawingView = v;
	}
	public void setBounds(int t, int l, int b, int r)
	{
		top = t;
		left = l;
		bot = b;
		rit = r;
	}
	public void setPoints(float []x, float []y, int pC)
	{
		pointCount = pC;
		for(int i = 0; i < pC; i++)
		{
			xPos[i] = x[i];
			yPos[i] = y[i];
		}
	}
	public int recogDigit()
	{
		for(int i = 0; i < 7; i++)
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
		whatIsTheDigit();
		
		return digit;
	}
	
	private void findSeg_0()
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
	}

}
