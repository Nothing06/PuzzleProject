//******************************************************************************
// File Name	: PathFinder.java
// Description	: ���� ���ø� Ŭ����
// Create		: 2003/04/01 JongHa Woo
// Update		:
//******************************************************************************


import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.lang.*;


public class PathFinder extends Applet implements MouseListener
{
	// AStar ��ü
	AStar	pfAStar;
	
	// ��� ���
	Node	nodePath;
	int		iPath[][];
	int		iCurrentPath;
	int		iMaxPath;
	
	// ���� �̵� Ÿ�̸� ��ü
	MonsterMoveTimerTask ttaskMonsterMove;
	Timer	timerMonsterMove;
	
	// �̹��� ��ü
	Image	ImageBackground;
	Image	ImageMonster1;
	Image	ImageMonster2;
	Image	ImageGround;
	Image	ImageWall;

	// ������۸� �̹���, �׷��� ��ü
	Image	ImageBackBuffer;
	Graphics	gBackBuffer;
	
	// �� �迭
	int	iMap[] = {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
		0, 0, 1, 1, 1, 1, 1, 0, 1, 0,
		0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
		0, 0, 0, 0, 0, 0, 1, 1, 1, 0,
		0, 1, 0, 1, 0, 0, 0, 0, 0, 0,
		0, 1, 1, 1, 1, 0, 1, 1, 0, 0,
		0, 0, 1, 0, 0, 0, 1, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	
	// ������ ��ġ
	int		iMonsterX, iMonsterY;
	
	// ���� ������ �÷���
	int		iMonsterMove;
	
	
	
		
		
	//*************************************************************************
	// Name : init()
	// Desc : ���ø� �ʱ�ȭ
	//*************************************************************************
	public void init()
	{
		// AStar ��ü ����
		pfAStar = new AStar(iMap);
		
		// �̹��� �ε�
		ImageBackground = getImage(getDocumentBase(), "background.gif");
		ImageMonster1 = getImage(getDocumentBase(), "monster1.gif");
		ImageMonster2 = getImage(getDocumentBase(), "monster2.gif");
		ImageGround = getImage(getDocumentBase(), "ground.gif");
		ImageWall = getImage(getDocumentBase(), "wall.gif");
		
		// ������۸� �ʱ�ȭ
		ImageBackBuffer = createImage(600, 400);
		gBackBuffer = ImageBackBuffer.getGraphics();
		
		// ���� ����
		iMonsterX = 4; iMonsterY = 4;
		iMonsterMove = 0;
		iPath = new int[100][2];
		iCurrentPath = -1;
		
		// ���콺 ������ ���
		addMouseListener(this);

		// ���� �̵� Ÿ�̸� ����
		ttaskMonsterMove = new MonsterMoveTimerTask();
		timerMonsterMove = new Timer();
		timerMonsterMove.schedule(ttaskMonsterMove, 500, 500);
		
		
		
	}





	//*************************************************************************
	// Name : update()
	// Desc : �����۹����� ���� �������̵� -> �������� ������Ʈ ��������
	//*************************************************************************
	public void update(Graphics g)
	{
		// ������ �ٽ� ĥ���� �ʰ� �׳� paint()�� ȣ��
		paint(g);
	}





	//*************************************************************************
	// Name : paint()
	// Desc : ȭ�� ���
	//*************************************************************************
	public void paint(Graphics g)
	{
		Color	c;
		Node	nodeTemp;
		
		
		
		// ���ȭ�� ���
		gBackBuffer.drawImage(ImageBackground, 0, 0, this);
		c = new Color(255, 0, 0);
		gBackBuffer.setColor(c);
		gBackBuffer.drawRect(427, 200, 31, 31);
		c = new Color(130, 130, 130);
		gBackBuffer.setColor(c);
		gBackBuffer.drawRect(427, 243, 31, 31);
		c = new Color(0, 0, 255);
		gBackBuffer.setColor(c);
		gBackBuffer.drawRect(427, 286, 31, 31);
		
		
		// �׶���, �� ���
		for( int j = 0; j < 10; j++ )
		{
			for( int i = 0; i < 10; i++ )
			{
				// �׶���
				gBackBuffer.drawImage(ImageGround, 32 + i*32, 30 + j*32, this);
				
				// ��
				if( iMap[j*10 + i] == 1 )
					gBackBuffer.drawImage(ImageWall, 32 + i*32, 30 + j*32, this);
			}
		}
		
		// ������� ���
		if( iCurrentPath != -1 )
		{
			// �������
			c = new Color(130, 130, 130);
			gBackBuffer.setColor(c);
			nodeTemp = pfAStar.OpenNode;
			while( nodeTemp != null )
			{
				gBackBuffer.drawRect(32 + nodeTemp.x*32, 30 + nodeTemp.y*32, 31, 31);
				nodeTemp = nodeTemp.next;
			}

			// �������
			c = new Color(0, 0, 255);
			gBackBuffer.setColor(c);
			nodeTemp = pfAStar.ClosedNode;
			while( nodeTemp != null )
			{
				gBackBuffer.drawRect(32 + nodeTemp.x*32, 30 + nodeTemp.y*32, 31, 31);
				nodeTemp = nodeTemp.next;
			}

			// ���
			c = new Color(255, 0, 0);
			gBackBuffer.setColor(c);
			for( int i = 0; i < iMaxPath; i++ )
			{
				gBackBuffer.drawRect(32 + iPath[i][0]*32, 30 + iPath[i][1]*32, 31, 31);
			}
			

			
		}
				
		

		// ���� ���
		if( iMonsterMove == 0 )
			gBackBuffer.drawImage(ImageMonster1, 32 + iMonsterX*32, 30 + iMonsterY*32, this);
		else
			gBackBuffer.drawImage(ImageMonster2, 32 + iMonsterX*32, 30 + iMonsterY*32, this);

		
		
		// ����۸� ����ȭ�鿡 ���
		g.drawImage(ImageBackBuffer, 0, 0, this);
	}





	//*************************************************************************
	// Name : Mouse Interface Methods
	// Desc : ���콺 ���� �Լ���
	//*************************************************************************
	public void mouseClicked(MouseEvent e)
	{
		int	iX, iY;
		
		
		
		// ���콺�� ��ǥ�� ����
		iX = e.getX();
		iY = e.getY();

		// ���� Ŭ���� �ʻ��� ��ǥ�� ����
		iX = iX - 32;
		iY = iY - 30;
		
		if( iX < 0 || iY < 0 ) return;
		
		iX = iX / 32;
		iY = iY / 32;
		
		// �� ���� �ȿ� �ְų� ���� �ƴϰ� ���� ��ġ�� �ƴϸ� �̵����� �ƴ϶�� ��� ����
		if( iX >= 0 && iX <= 9 && iY >=0 && iY <=9 && iCurrentPath == -1 &&
			!(iX == iMonsterX && iY == iMonsterY ) && iMap[iY*10 + iX] == 0 )
		{
			nodePath = pfAStar.FindPath(iMonsterX, iMonsterY, iX, iY);
			
			// ��θ� ������� �迭�� ����
			iCurrentPath = 0;
			while( nodePath != null )
			{
				iPath[iCurrentPath][0] = nodePath.x;
				iPath[iCurrentPath][1] = nodePath.y;
				iCurrentPath++;
				nodePath = nodePath.prev;
			}
			iMaxPath = iCurrentPath;
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}





	//*************************************************************************
	// Name : MonsterMoveTimerTask()
	// Desc : ���� �̵� Ÿ�̸��½�ũ 
	//*************************************************************************
	class MonsterMoveTimerTask extends TimerTask
	{
		public void run()
		{
			// ���� ������ ��ΰ� �����Ѵٸ� ���͸� ������
			if( iCurrentPath != -1 )
			{
				iMonsterX = iPath[iCurrentPath-1][0];
				iMonsterY = iPath[iCurrentPath-1][1];
				
				iCurrentPath--;
				
				// ��� ��θ� �������ٸ� ��� �ʱ�ȭ
				if( iCurrentPath <= 0 )
				{
					pfAStar.ResetPath();
					iCurrentPath = -1;
				}
			}


			
			// ���� ������ ��ȯ
			iMonsterMove++;
			if( iMonsterMove > 1 ) iMonsterMove = 0;
			
			
			
			// ȭ�� ����
			repaint();
		}
	}
}	
	
	
	
	
