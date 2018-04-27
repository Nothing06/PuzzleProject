//******************************************************************************
// File Name	: PathFinder.java
// Description	: 메인 애플릿 클래스
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
	// AStar 객체
	AStar	pfAStar;
	
	// 경로 노드
	Node	nodePath;
	int		iPath[][];
	int		iCurrentPath;
	int		iMaxPath;
	
	// 몬스터 이동 타이머 객체
	MonsterMoveTimerTask ttaskMonsterMove;
	Timer	timerMonsterMove;
	
	// 이미지 객체
	Image	ImageBackground;
	Image	ImageMonster1;
	Image	ImageMonster2;
	Image	ImageGround;
	Image	ImageWall;

	// 더블버퍼링 이미지, 그래픽 객체
	Image	ImageBackBuffer;
	Graphics	gBackBuffer;
	
	// 맵 배열
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
	
	// 몬스터의 위치
	int		iMonsterX, iMonsterY;
	
	// 몬스터 움직임 플래그
	int		iMonsterMove;
	
	
	
		
		
	//*************************************************************************
	// Name : init()
	// Desc : 애플릿 초기화
	//*************************************************************************
	public void init()
	{
		// AStar 객체 생성
		pfAStar = new AStar(iMap);
		
		// 이미지 로드
		ImageBackground = getImage(getDocumentBase(), "background.gif");
		ImageMonster1 = getImage(getDocumentBase(), "monster1.gif");
		ImageMonster2 = getImage(getDocumentBase(), "monster2.gif");
		ImageGround = getImage(getDocumentBase(), "ground.gif");
		ImageWall = getImage(getDocumentBase(), "wall.gif");
		
		// 버블버퍼링 초기화
		ImageBackBuffer = createImage(600, 400);
		gBackBuffer = ImageBackBuffer.getGraphics();
		
		// 변수 설정
		iMonsterX = 4; iMonsterY = 4;
		iMonsterMove = 0;
		iPath = new int[100][2];
		iCurrentPath = -1;
		
		// 마우스 리스너 등록
		addMouseListener(this);

		// 몬스터 이동 타이머 생성
		ttaskMonsterMove = new MonsterMoveTimerTask();
		timerMonsterMove = new Timer();
		timerMonsterMove.schedule(ttaskMonsterMove, 500, 500);
		
		
		
	}





	//*************************************************************************
	// Name : update()
	// Desc : 더블퍼버링을 위해 오버라이드 -> 배경색으로 리페인트 하지않음
	//*************************************************************************
	public void update(Graphics g)
	{
		// 배경색을 다시 칠하지 않고 그냥 paint()만 호출
		paint(g);
	}





	//*************************************************************************
	// Name : paint()
	// Desc : 화면 출력
	//*************************************************************************
	public void paint(Graphics g)
	{
		Color	c;
		Node	nodeTemp;
		
		
		
		// 배경화면 출력
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
		
		
		// 그라운드, 벽 출력
		for( int j = 0; j < 10; j++ )
		{
			for( int i = 0; i < 10; i++ )
			{
				// 그라운드
				gBackBuffer.drawImage(ImageGround, 32 + i*32, 30 + j*32, this);
				
				// 벽
				if( iMap[j*10 + i] == 1 )
					gBackBuffer.drawImage(ImageWall, 32 + i*32, 30 + j*32, this);
			}
		}
		
		// 경로정보 출력
		if( iCurrentPath != -1 )
		{
			// 열린노드
			c = new Color(130, 130, 130);
			gBackBuffer.setColor(c);
			nodeTemp = pfAStar.OpenNode;
			while( nodeTemp != null )
			{
				gBackBuffer.drawRect(32 + nodeTemp.x*32, 30 + nodeTemp.y*32, 31, 31);
				nodeTemp = nodeTemp.next;
			}

			// 닫힌노드
			c = new Color(0, 0, 255);
			gBackBuffer.setColor(c);
			nodeTemp = pfAStar.ClosedNode;
			while( nodeTemp != null )
			{
				gBackBuffer.drawRect(32 + nodeTemp.x*32, 30 + nodeTemp.y*32, 31, 31);
				nodeTemp = nodeTemp.next;
			}

			// 경로
			c = new Color(255, 0, 0);
			gBackBuffer.setColor(c);
			for( int i = 0; i < iMaxPath; i++ )
			{
				gBackBuffer.drawRect(32 + iPath[i][0]*32, 30 + iPath[i][1]*32, 31, 31);
			}
			

			
		}
				
		

		// 몬스터 출력
		if( iMonsterMove == 0 )
			gBackBuffer.drawImage(ImageMonster1, 32 + iMonsterX*32, 30 + iMonsterY*32, this);
		else
			gBackBuffer.drawImage(ImageMonster2, 32 + iMonsterX*32, 30 + iMonsterY*32, this);

		
		
		// 백버퍼를 실제화면에 출력
		g.drawImage(ImageBackBuffer, 0, 0, this);
	}





	//*************************************************************************
	// Name : Mouse Interface Methods
	// Desc : 마우스 관련 함수들
	//*************************************************************************
	public void mouseClicked(MouseEvent e)
	{
		int	iX, iY;
		
		
		
		// 마우스의 좌표를 구함
		iX = e.getX();
		iY = e.getY();

		// 현재 클릭된 맵상의 좌표를 구함
		iX = iX - 32;
		iY = iY - 30;
		
		if( iX < 0 || iY < 0 ) return;
		
		iX = iX / 32;
		iY = iY / 32;
		
		// 맵 범위 안에 있거나 벽이 아니고 현재 위치가 아니며 이동중이 아니라면 경로 구함
		if( iX >= 0 && iX <= 9 && iY >=0 && iY <=9 && iCurrentPath == -1 &&
			!(iX == iMonsterX && iY == iMonsterY ) && iMap[iY*10 + iX] == 0 )
		{
			nodePath = pfAStar.FindPath(iMonsterX, iMonsterY, iX, iY);
			
			// 경로를 순서대로 배열에 저장
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
	// Desc : 몬스터 이동 타이머태스크 
	//*************************************************************************
	class MonsterMoveTimerTask extends TimerTask
	{
		public void run()
		{
			// 현재 움직일 경로가 존재한다면 몬스터를 움직임
			if( iCurrentPath != -1 )
			{
				iMonsterX = iPath[iCurrentPath-1][0];
				iMonsterY = iPath[iCurrentPath-1][1];
				
				iCurrentPath--;
				
				// 모든 경로를 움직였다면 경로 초기화
				if( iCurrentPath <= 0 )
				{
					pfAStar.ResetPath();
					iCurrentPath = -1;
				}
			}


			
			// 몬스터 움직임 변환
			iMonsterMove++;
			if( iMonsterMove > 1 ) iMonsterMove = 0;
			
			
			
			// 화면 갱신
			repaint();
		}
	}
}	
	
	
	
	
