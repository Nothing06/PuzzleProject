/*
 * File: GUI.java

 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;


class pop extends JDialog{


   JLabel[] jlb;
  
	 public pop()
	  {
		 this.setLayout(new GridLayout(0,1));
		 if(rankInfo.curIdx == 0)
			 return;
		 	jlb = new JLabel[rankInfo.curIdx];
		 	for(int i=0;i<rankInfo.curIdx;i+=1)
		 	{
		 	String tmp = ( " [" +rankInfo.pkt_name[i] + "] " +
		 					rankInfo.date[i] + "  " +  
		 					 rankInfo.title[i]+ "  " + rankInfo.time[i] + "sec  " + 
		 						rankInfo.movecnt[i] + "회  " 
		 							 );
			jlb[i] = new JLabel(tmp);
			getContentPane().add(jlb[i]);
		 	}
			this.setTitle("Complete!");
			this.setSize(600,500);
			 this.setVisible(true);
	   }
	 
}


public class GUI extends JFrame implements Runnable, ActionListener {
    public static final String APP_NAME = "Funny Puzzle";
    private static final long serialVersionUID = 1L;

    static Timer persons_timer;
    static Timer computer_timer;
    
    static int push_idx;
    static int empty_idx=16;
    static boolean is_complete=false;
    static int movecnt=0;
    
    static Timer t;
    static int persons_sec=0;
    static int computer_sec=0;
    static TimerTask task;
    
    static JLabel time; // timer
    static JLabel second;
    static JLabel strsec;
    static JLabel time2;
    static JLabel second2;
    static JLabel strsec2;
    static JPanel timerPanel;
    static JPanel timerPanel2; // timer
 
    static int s=0;
    static JPanel imagePanel; // img panel
    static JPanel monstername_panel;
    static JLabel monstername;// img panel
    static JLabel move_cnt;
    static JPanel topPanel; 
    
    private final Start_App applicationStarter;
    private final DefaultListModel model;
    private final JButton shuffleButton, randomButton, solveButton, showButton;
    private final JList directionsList;
    private final JTextField 
    						 configurationField,
                             expandedField,
                       //      initialMovesEstimateField,
                         //    initialOrderField,
                             movesField,
                             pathsField,
                             statusField,
                             timeField;
    private final Puzzle puzzle;
    private final Timer statusUpdateTimer;
    static JPanel infoPanel;
    class Button
    {
    	JButton bt;
    	int key;
    };

    static Button[] b;
    static int[] map; // 퍼즐 버튼 숫자들을 저장하고  쉽게 활용하기 위해 만든  퍼즐숫자 배열
    static boolean status=false;
    static byte[] state;
    
    static int pieces = 4; // 조각의 개수를 저장할 공간
	   static int totalPieces = pieces * pieces;
	   static Image[] subImage;
	static ImageIcon[] divImage;
	static int image_cnt = 9;
	static JPanel pimage_panel;
	static ImageIcon pimage;
    static JPanel persons_panel;
    
	 static BufferedImage[] img; // 이미지를 저장할 곳
	 static String[] img_name;
	 static int img_num; // 0~4
	
    private JMenu optionsMenu;
    private JRadioButtonMenuItem aStarItem,
                                 idaStarItem,
                                 speedItem,
                                 speedItem2,
                                 speedItem3,
                                 speedItem4,
                                 hide_true,
                                 hide_false,
                                 singleThreadedItem,
                                 multiThreadedItem;
    static int speed=1500;
    static boolean is_hide=false;
    private GraphicsThread graphicsThread;
    private int puzzleType, algorithmType, heuristicType, stepNumber, tempNum;
    private boolean shouldRun, keepZeroInCorner, useThreads = true;
    private byte[] initState, graphicsState;
    static JButton record;
    
    static void Get_Solvability()
	{
		int i,j;
		int check_cnt=0;
		status = false;
		for(i=1;i<=15;i+=1)
		{
			for(j=i;j<=15;j+=1)
			{
				if(map[i]>map[j])
					check_cnt+=1;
			}
		}
		if(check_cnt%2==0)
			status = true;
	}
    static void shuffle()
	{
		Random rand = new Random();
		int ri;
		String tmp;
		int i;
		String num;
		int temp;
		Icon t;
		
		if(empty_idx!=16 ) // 빈칸이 16번째 버튼이 아닐경우, change버튼 눌렸을 경우 초기화
		{
			b[empty_idx].bt.setEnabled(true);
			b[empty_idx].bt.setBackground(Color.white);
			for( i=1;i<=16;i+=1)
			{
				if(map[i]==0)
				{
					b[i].bt.setText("0");
					//	b[16].bt.setHideActionText(false);
					
						b[i].bt.setIcon(null);
						b[i].bt.setBackground(Color.LIGHT_GRAY);
						b[i].bt.setEnabled(false);
						 empty_idx=i;
					continue;
				}
				num = Integer.toString(i);
				if(is_hide == false)
					b[i].bt.setText(num);
			//	b[i].bt.setHideActionText(false);
				b[i].bt.setIcon(divImage[i-1]);
				b[i].bt.setBackground(Color.white);
				map[i] = i;
			}
			
		}
			for( i=1;i<=15;i+=1) // 15번 섞어줌
			{
				ri = rand.nextInt(15)+1;
				if(ri==empty_idx )
				{
					i-=1; continue;
				}
				if(i==empty_idx)
				{
					continue;
				}
				tmp = b[i].bt.getText();
				b[i].bt.setText(b[ri].bt.getText());
				b[ri].bt.setText(tmp);
				
				temp = map[i];
				map[i] = map[ri];
				map[ri] = temp;
				
				t = b[i].bt.getIcon();
				b[i].bt.setIcon(b[ri].bt.getIcon());
				b[ri].bt.setIcon(t);
			}
		
			
	}
    public GUI(final Start_App appStarter) {
        super(APP_NAME);
        Load_Images();
        getImage(0);
        this.applicationStarter = appStarter;
        puzzleType = Puzzle_Config.PUZZLE_15;
        algorithmType = Puzzle_Config.ALGORITHM_IDASTAR;
        heuristicType = Puzzle_Config.HEURISTIC_PD;
        Puzzle_Config.initialize(
            puzzleType, algorithmType, heuristicType, getNumberOfThreads());

        statusUpdateTimer = new Timer(200, new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                final Algorithm algorithm = Puzzle_Config.getAlgorithm();
                if (Algorithm.running || Algorithm.solved) {
       /*     //        initialMovesEstimateField.setText(
              //          Algorithm.initialMovesEstimate == Algorithm.NOT_APPLICABLE ?
                            "N/A" :
                            Algorithm.initialMovesEstimate == 1 ?
                                Integer.toString(Algorithm.initialMovesEstimate) + " move" :
                                Integer.toString(Algorithm.initialMovesEstimate) + " moves");*/
                    movesField.setText(Long.toString(Algorithm.movesRequired));
                    pathsField.setText(
                        Utility.INT_FORMATTER.format(Algorithm.numberVisited));
                    expandedField.setText(
                        Utility.INT_FORMATTER.format(Algorithm.numberExpanded));
                }
                if (Algorithm.running) {
                    timeField.setText(
                        Utility.DEC_FORMATTER.format(
                            Algorithm.getElapsedTimeInSeconds()) + " s");
                } else {
                    if (Algorithm.solved) {
                        statusField.setText("Solution found");
                        timeField.setText(
                            Utility.DEC_FORMATTER.format(
                                Algorithm.getRunningTimeInSeconds()) + " s");
                        final String[] directions = Utility.getDirections(initState);
                        for (int i = 0; i < directions.length; ++i) {
                            model.add(i, directions[i]);
                        }
                        showButton.setEnabled(true);
                    } else {
                        statusField.setText("Aborted by user");
                    }
                  //  configurationField.setEnabled(true);
                    shuffleButton.setEnabled(true);
                    optionsMenu.setEnabled(true);
                    solveButton.setText("Solve");
                    statusUpdateTimer.stop();
                    // Defer cleaning up until GUI has updated, otherwise a visible lag
                    // is possible.
                    algorithm.cleanup();
                }
            }
        });
        statusUpdateTimer.setInitialDelay(0);

        
        infoPanel = new JPanel();
        makeUI(infoPanel, new GridBagConstraints());
        
        setJMenuBar(getCreatedMenuBar());
        
        timerPanel = new JPanel();
		 timerPanel.add(time);
        timerPanel.add(second);
        timerPanel.add(strsec);
        
   //     persons_panel.add(timerPanel);
        
       // persons_panel.add(move_cnt);
    //    infoPanel.add(persons_panel);
        
        showButton = new JButton("Start!");
        showButton.setMnemonic('M');
        showButton.setPreferredSize(new Dimension(90, 30));
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                computer_sec=0;
                time.setText("   Time : ");
        		second.setText("0");
        		strsec.setText(" sec");
        		timerPanel2.repaint();
                graphicsState = new byte[initState.length];
                System.arraycopy(initState, 0, graphicsState, 0, initState.length);
                stepNumber = 0;
                graphicsThread = new GraphicsThread();
                graphicsThread.start();
                persons_timer.start();
                computer_timer.start();
            }
        });
       // showButton.setEnabled(false);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
       buttonPanel.add(showButton);
        
        solveButton = new JButton("Solve");
        buttonPanel.add(solveButton);
        
        puzzle = new Puzzle(Puzzle_Config.getNumOfTiles());
        final JPanel puzzleBorderPanel = new JPanel();
        puzzleBorderPanel.setLayout(new GridLayout(0,1));
          //topPanel.add(shuffleButton);
        imagePanel = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(img[Puzzle.pktmon_idx],0,0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
			
		};
		monstername = new JLabel("");
		monstername.setFont(new Font("고딕",Font.ROMAN_BASELINE,25));
		monstername.setHorizontalAlignment(0);
		monstername.setText("고오스");
		
		move_cnt.setHorizontalAlignment(0);
		
		record = new JButton("record");
		record.addActionListener(this);
		monstername_panel = new JPanel();
		monstername_panel.setLayout(new GridLayout(0,1));
	//	monstername_panel.add(monstername);
		monstername_panel.add(move_cnt);
		monstername_panel.add(record);
		
		timerPanel2 = new JPanel();
		 timerPanel2.add(time2);
         timerPanel2.add(second2);
         timerPanel2.add(strsec2);
         
         monstername_panel.add(timerPanel2);
         
		puzzleBorderPanel.add(imagePanel);
		puzzleBorderPanel.add(monstername_panel);
	//	puzzleBorderPanel.add(timerPanel2);
		puzzleBorderPanel.add(puzzle);
        //topPanel.add(solveButton);
        
        final GridBagConstraints gbc = new GridBagConstraints();
        final JPanel puzzlePanel = new JPanel();
        puzzlePanel.setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 0;
        gbc.insets = new Insets(0, 5, 5, 5);
       
        puzzlePanel.add(puzzleBorderPanel, gbc);
        puzzlePanel.add(buttonPanel, gbc);
        // changed
       
        
        puzzlePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "PoketMon_Puzzle"));

        statusField = new JTextField(10);
        statusField.setEditable(false);
        statusField.setBackground(Color.white);
    /*    initialMovesEstimateField = new JTextField(10);
        initialMovesEstimateField.setEditable(false);
        initialMovesEstimateField.setBackground(Color.white);
      //  initialOrderField = new JTextField(10);
 //       initialOrderField.setEditable(false);
    //    initialOrderField.setBackground(Color.white);*/
        timeField = new JTextField(10);
        timeField.setEditable(false);
        timeField.setBackground(Color.white);
        movesField = new JTextField(10);
        movesField.setEditable(false);
        movesField.setBackground(Color.white);
        pathsField = new JTextField(10);
        pathsField.setEditable(false);
        pathsField.setBackground(Color.white);
        expandedField = new JTextField(10);
        expandedField.setEditable(false);
        expandedField.setBackground(Color.white);
        model = new DefaultListModel();
        directionsList = new JList(model);
        directionsList.setDoubleBuffered(true);
        directionsList.setPrototypeCellValue("10 - right");
        final JScrollPane scrollPane = new JScrollPane(directionsList);
        scrollPane.setPreferredSize(
            new Dimension(210, directionsList.getFixedCellHeight() * 6 + 3));

        

       
        
       final JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        centerPanel.add(puzzlePanel, gbc);
        gbc.gridx = 1;
        centerPanel.add(infoPanel, gbc);

     /*   statusLabel = new JLabel(PuzzleConfiguration.stringRepresentation(), JLabel.RIGHT);
        final JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridBagLayout());
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        gbc.insets = new Insets(0, 0, 1, 3);
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        statusPanel.add(statusLabel, gbc);*/
        
        configurationField = new JTextField(27);
        configurationField.addKeyListener(new KeyListener() {
             public void keyPressed(final KeyEvent ke) {
                 if (KeyEvent.getKeyText(ke.getKeyCode()).equals("Enter")) {
                     solveButton.requestFocus();
                     solvePuzzle();
                 }
             }
             public void keyReleased(final KeyEvent ke) { }
             public void keyTyped(final KeyEvent ke) { }
         });

        final JLabel configurationLabel =
            new JLabel("Tile order:", JLabel.RIGHT);
       configurationLabel.setDisplayedMnemonic('T');
        configurationLabel.setLabelFor(configurationField);

          
         solveButton.setMnemonic('S');
         solveButton.setPreferredSize(new Dimension(90, 30));
         solveButton.addActionListener(new ActionListener() {
             public void actionPerformed(final ActionEvent e) {
                 if (solveButton.getText().equals("Solve")) {
                	 //persons_timer.stop();
                	 computer_timer.stop();
                	// persons_sec = 0;
                	 computer_sec=0;
                     time2.setText(" Time : ");
             		second2.setText("0");
             		strsec2.setText(" sec");
             		timerPanel2.repaint();
                     solvePuzzle();
                 } else {
                     stop();
                 }
                 showButton.doClick();
             }
         });
       //  JLabel space = new JLabel("                ");
         
         shuffleButton = new JButton("");
         shuffleButton.setFont(new Font("고딕",Font.ROMAN_BASELINE,25));
     //    shuffleButton.setText("shuffle");
         Image s =null;
 		try {
 			s = ImageIO.read(new File("shuffle.jpg"));
 		} catch (IOException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
 		shuffleButton.setIcon(new ImageIcon(s));
         shuffleButton.setMnemonic('u');
         shuffleButton.setPreferredSize(new Dimension(125, 75));
         shuffleButton.addActionListener(new ActionListener() {
             public void actionPerformed(final ActionEvent e) {
                 cancelGraphicsThread();
                 persons_timer.stop();
                 persons_sec = 0;
                 computer_timer.stop();
                 computer_sec=0;
                 movecnt=0;
                 move_cnt.setText("0 Moved");
                 time.setText("   Time : ");
         		second.setText("0");
         		strsec.setText(" sec");
         		 time2.setText(" Time : ");
          		second2.setText("0");
          		strsec2.setText(" sec");
                 showButton.setEnabled(false);
                 /*final byte[]*/ state = Utility.getRandomArray
                     (puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9, keepZeroInCorner);
                configurationField.setText(Utility.byteArrayToString(state));
                 puzzle.setOrder(state);
                 
                 if(empty_idx!=16 ) // 빈칸이 16번째 버튼이 아닐경우, change버튼 눌렸을 경우 초기화
     			{
     				b[empty_idx].bt.setEnabled(true);
     				for(int i=1;i<=15;i+=1)
     				{
     					String num = Integer.toString(i);
     					if(is_hide==false)
     						b[i].bt.setText(num);
     				//	b[i].bt.setHideActionText(false);
     					b[i].bt.setIcon(divImage[i-1]);
     					b[i].bt.setBackground(Color.white);
     					map[i] = i;
     				}
     				b[16].bt.setText("");
     			//	b[16].bt.setHideActionText(false);
     				b[16].bt.setIcon(null);
     				b[16].bt.setBackground(Color.LIGHT_GRAY);
     				b[16].bt.setEnabled(false);
     				map[16]=0; empty_idx=16;
     			}
                 b[16].bt.setBackground(Color.LIGHT_GRAY);
                 for(int i=1;i<=15;i+=1)
                 {
                	 map[i]=state[i-1];
                	 if(map[i]==0)
                		 continue;
                	if(is_hide==false)
                		b[i].bt.setText(String.valueOf(map[i]));
                	 b[i].bt.setIcon(divImage[map[i]-1]);
                 }
             /*    b[16].bt.setIcon(null);
     			b[16].bt.setEnabled(false);
     			
     			status = false;
     			while(status==false)
     			{
     				shuffle();
     				Get_Solvability();
     			}*/
                 infoPanel.repaint();
                 repaint();
             }
         });
         	Puzzle.pktmon_idx=0;
         randomButton = new JButton("");
         randomButton.setFont(new Font("고딕",Font.ROMAN_BASELINE,25));
     //    randomButton.setText("Change");
         Image m=null;
		try {
			m = ImageIO.read(new File("monsterball.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         randomButton.setIcon(new ImageIcon(m));
        randomButton.setPreferredSize(new Dimension(125, 75));
         randomButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(final ActionEvent e) {
        		 persons_timer.stop();
                 persons_sec = 0;
                 computer_timer.stop();
                 computer_sec=0;
                 movecnt=0;
                 move_cnt.setText("0 Moved");
                 time.setText("   Time : ");
         		second.setText("0");
         		strsec.setText(" sec");
         		 time2.setText(" Time : ");
          		second2.setText("0");
          		strsec2.setText(" sec");
          		
          		for(int i=1;i<=16;i+=1)
          		{	
          			if(i==16)
          			{
          				map[i]=0;
          				break;
          			}
          			map[i]=i;
          		}
          		Random r = new Random();
           		 int tmp=Puzzle.pktmon_idx;
           		 while(tmp==Puzzle.pktmon_idx)
           			tmp = r.nextInt(Puzzle.pktmon_cnt);
           		 Puzzle.pktmon_idx = tmp;
           		 imagePanel = new JPanel()
         		{
         			public void paintComponent(Graphics g)
         			{
         				g.drawImage(img[Puzzle.pktmon_idx],0,0, null);
         				setOpaque(false);
         				super.paintComponent(g);
         			}
         			
         		};
         		monstername.setText(Puzzle.pktmon_name[Puzzle.pktmon_idx]);
         		
         		Puzzle.setSpeed(speed);
           		 getImage(Puzzle.pktmon_idx);
           		 
           		
        		  state = Utility.getRandomArray
                         (puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9, keepZeroInCorner);
        		// 빈칸이 16번째 버튼이 아닐경우, change버튼 눌렸을 경우 초기화
        			{
        				b[empty_idx].bt.setEnabled(true);
        				for(int i=1;i<=15;i+=1)
        				{
        					String num = Integer.toString(i);
        					if(is_hide==false)
        						b[i].bt.setText(num);
        				//	b[i].bt.setHideActionText(false);
        					b[i].bt.setIcon(divImage[i-1]);
        					map[i] = i;
        				}
        				b[16].bt.setText("");
        			//	b[16].bt.setHideActionText(false);
        				b[16].bt.setBackground(Color.LIGHT_GRAY);
        				b[16].bt.setIcon(null);
        				b[16].bt.setEnabled(false);
        				map[16]=0; empty_idx=16;
        			}
        		/* for(int i=1;i<=15;i+=1)
                 {
                	 map[i]=state[i-1];
                	 if(map[i]==0)
                		 continue;
                	
                	 b[i].bt.setText(String.valueOf(map[i]));
                	 b[i].bt.setIcon(divImage[map[i]-1]);
                 }*/
                     cancelGraphicsThread();
                     showButton.setEnabled(false);
                     
                     if(puzzleType == Puzzle_Config.PUZZLE_15)
                     	puzzleType = Puzzle_Config.PUZZLE_15;
                     else if(puzzleType == Puzzle_Config.PUZZLE_8)
                    	 puzzleType = Puzzle_Config.PUZZLE_8;
                     
                     if (aStarItem.isSelected()) {
                         idaStarItem.setSelected(true);
                         algorithmType = Puzzle_Config.ALGORITHM_IDASTAR;
                     }
                     aStarItem.setEnabled(false);
                     if (canRunThreads()) {
                         multiThreadedItem.setEnabled(true);
                     }
                     Puzzle_Config.setNumOfThreads(getNumberOfThreads());
                     updatePuzzleConfiguration();
                     
                     
                     puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
                  //   infoPanel.repaint();
                   //  Puzzle.setSpeed(speed);
                     repaint();
                 }
             
         });
          topPanel = new JPanel();
          
          
     //     time = new JLabel("");
  //        time.setFont(new Font("고딕",Font.ITALIC,20));
          //second = new JLabel("");
          //second.setFont(new Font("고딕",Font.ITALIC,20));
     //     strsec = new JLabel("");
     //     strsec.setFont(new Font("고딕",Font.ITALIC,20));
       //   task = new timer();
         
          
           
        		
        topPanel.add(shuffleButton); 
        topPanel.add(randomButton);
       // topPanel.add(time);
        topPanel.add(timerPanel);
        
        
         topPanel.setBorder(BorderFactory.createTitledBorder(
             BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Shuffle"));
        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.SOUTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);
      //  contentPane.add(statusPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new ClosingWindowListener(this));

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void stop() {
        Puzzle_Config.getAlgorithm().stop();
        cancelGraphicsThread();
    }

    public void run() {
        Puzzle_Config.getAlgorithm().solve(
            Utility.arrayToLong(initState), Puzzle_Config.getNumOfThreads());
    }

    private void cancelGraphicsThread() {
        shouldRun = false;
        puzzle.stopAnimation();
        if (graphicsThread != null) {
            try {
                graphicsThread.join();
            } catch (final InterruptedException ie) { }
        }
        directionsList.clearSelection();
    }

    private JMenuBar getCreatedMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
     //   final JMenu fileMenu = new JMenu("File");
   //     fileMenu.setMnemonic('F');

        KeyStroke ks;
        final JMenuItem exitItem = new JMenuItem("Exit");
        ks = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK);
        exitItem.setAccelerator(ks);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitActionListener(this));
     //   fileMenu.add(exitItem);

        optionsMenu = new JMenu("Puzzle");
        optionsMenu.setMnemonic('P');

        final JMenu puzzleTypeMenu = new JMenu("Puzzle Type");
        puzzleTypeMenu.setMnemonic('P');

        final ButtonGroup puzzleTypeGroup = new ButtonGroup();
        JRadioButtonMenuItem eightPuzzleItem =
            new JRadioButtonMenuItem("8-Puzzle",
                                     puzzleType == Puzzle_Config.PUZZLE_8);
        eightPuzzleItem.setMnemonic('8');
        eightPuzzleItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                puzzleType = Puzzle_Config.PUZZLE_8;
                aStarItem.setEnabled(true);
                singleThreadedItem.setSelected(true);
                useThreads = false;
                multiThreadedItem.setEnabled(false);
                Puzzle_Config.setNumOfThreads(getNumberOfThreads());//
                updatePuzzleConfiguration();
               
          /*      Random r = new Random();
       		 int tmp=Puzzle.pktmon_idx;
       		 while(tmp==Puzzle.pktmon_idx)
       			tmp = r.nextInt(2);f
       		 Puzzle.pktmon_idx = tmp;
       		*/ 
                puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
            }
        });
        puzzleTypeGroup.add(eightPuzzleItem);
        final JRadioButtonMenuItem fifteenPuzzleItem =
        	new JRadioButtonMenuItem("15-Puzzle",
                                     puzzleType == Puzzle_Config.PUZZLE_15);
        fifteenPuzzleItem.setMnemonic('1');
        fifteenPuzzleItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                puzzleType = Puzzle_Config.PUZZLE_15;
                if (aStarItem.isSelected()) {
                    idaStarItem.setSelected(true);
                    algorithmType = Puzzle_Config.ALGORITHM_IDASTAR;
                }
                aStarItem.setEnabled(false);
                if (canRunThreads()) {
                    multiThreadedItem.setEnabled(true);
                }
                Puzzle_Config.setNumOfThreads(getNumberOfThreads());
                updatePuzzleConfiguration();
                
            /*    Random r = new Random();
          		 int tmp=Puzzle.pktmon_idx;
          		 while(tmp==Puzzle.pktmon_idx)
          			tmp = r.nextInt(2);
          		 Puzzle.pktmon_idx = tmp;
          		*/ 
                puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
            }
        });
        puzzleTypeGroup.add(fifteenPuzzleItem);

        puzzleTypeMenu.add(eightPuzzleItem);
        puzzleTypeMenu.add(fifteenPuzzleItem);

        final JMenu speedTypeMenu = new JMenu("Speed");
        speedTypeMenu.setMnemonic('S');

        final ButtonGroup speedTypeGroup = new ButtonGroup();
        speedItem = new JRadioButtonMenuItem(
        	"Level 1", true);
        speedItem.setMnemonic('R');
        speedItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
            	
            //	cancelGraphicsThread();
            //    showButton.setEnabled(false);
            	 Puzzle.setSpeed(1500);
           //     Puzzle_Config.setNumOfThreads(getNumberOfThreads());
           //    updatePuzzleConfiguration();
           //     Puzzle.getSpeed(300);
            //    puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
            }
        });
        speedTypeGroup.add(speedItem);
        speedItem2 = new JRadioButtonMenuItem(
            	"Level 2", false);
            speedItem2.setMnemonic('T');
            speedItem2.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                	
                //	cancelGraphicsThread();
             //       showButton.setEnabled(false);
                	 Puzzle.setSpeed(1000);
             //       Puzzle_Config.setNumOfThreads(getNumberOfThreads());
               //     updatePuzzleConfiguration();
            //        Puzzle.getSpeed(200);
              //     puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
                }
            });
            speedTypeGroup.add(speedItem2);
            
            speedItem3 = new JRadioButtonMenuItem(
                	"Level 3", true);
                speedItem3.setMnemonic('R');
                speedItem3.addActionListener(new ActionListener() {
                    public void actionPerformed(final ActionEvent e) {
                    	
                    //	cancelGraphicsThread();
                 //       showButton.setEnabled(false);
                           Puzzle.setSpeed(500);
               //         Puzzle_Config.setNumOfThreads(getNumberOfThreads());
               //         updatePuzzleConfiguration();
                   //     Puzzle.getSpeed(300);
                 //       puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
                    }
                });
                speedTypeGroup.add(speedItem3);
                
                speedItem4 = new JRadioButtonMenuItem(
                    	"Level 4", true);
                    speedItem4.setMnemonic('R');
                    speedItem4.addActionListener(new ActionListener() {
                        public void actionPerformed(final ActionEvent e) {
                        	
                        //	cancelGraphicsThread();
                   //         showButton.setEnabled(false);
                            Puzzle.setSpeed(100);
                            
                   //         Puzzle_Config.setNumOfThreads(getNumberOfThreads());
                     //       updatePuzzleConfiguration();
                       //     Puzzle.getSpeed(300);
                     //       puzzle.setNumOfTiles(puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9);
                        }
                    });
                    speedTypeGroup.add(speedItem4);    
             

        speedTypeMenu.add(speedItem);
        speedTypeMenu.add(speedItem2);
        speedTypeMenu.add(speedItem3);
        speedTypeMenu.add(speedItem4);
       
        final JMenu hideTextMenu = new JMenu("Hide_Text");
        hideTextMenu.setMnemonic('H');
        final ButtonGroup HideGroup = new ButtonGroup();
        
        hide_true = new JRadioButtonMenuItem(
            	"hide", false);
        hide_true.setMnemonic('T');
        hide_true.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
            	is_hide = true;
            	for(int i=1;i<=16;i+=1)
            	{
            		if(map[i]==0)
            			continue;
            		b[i].bt.setText("");
            	} 
            	infoPanel.repaint();
            //	repaint();
            }
        });
        HideGroup.add(hide_true);
        
        hide_false = new JRadioButtonMenuItem(
            	"show", true);
        hide_false.setMnemonic('T');
        hide_false.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
            	is_hide = false;
            	for(int i=1;i<=16;i+=1)
            	{
            		if(map[i]==0) 
            			continue;
            		b[i].bt.setText(String.valueOf(map[i]));
            	}
            	infoPanel.repaint();
            }
        });
        HideGroup.add(hide_false);
        
        hideTextMenu.add(hide_true);
        hideTextMenu.add(hide_false);
        
        final JMenu algorithmTypeMenu = new JMenu("Algorithm");
        algorithmTypeMenu.setMnemonic('A');

        final ButtonGroup algorithmTypeGroup = new ButtonGroup();
        idaStarItem = new JRadioButtonMenuItem(
        	"IDA*", algorithmType == Puzzle_Config.ALGORITHM_IDASTAR);
        idaStarItem.setMnemonic('I');
        idaStarItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                algorithmType = Puzzle_Config.ALGORITHM_IDASTAR;
                updatePuzzleConfiguration();
            }
        });
        algorithmTypeGroup.add(idaStarItem);
        aStarItem = new JRadioButtonMenuItem(
        	"A*", algorithmType == Puzzle_Config.ALGORITHM_ASTAR);
        aStarItem.setMnemonic('A');
        aStarItem.setEnabled(false);
        aStarItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                algorithmType = Puzzle_Config.ALGORITHM_ASTAR;
                updatePuzzleConfiguration();
            }
        });
        algorithmTypeGroup.add(aStarItem);
        algorithmTypeMenu.add(idaStarItem);
        algorithmTypeMenu.add(aStarItem);

        final JMenu heuristicTypeMenu = new JMenu("Heuristic");
        heuristicTypeMenu.setMnemonic('H');

        final ButtonGroup heuristicTypeGroup = new ButtonGroup();
        final JRadioButtonMenuItem patternDatabaseItem =
            new JRadioButtonMenuItem(
            	"Pattern Database", heuristicType == Puzzle_Config.HEURISTIC_PD);
        patternDatabaseItem.setMnemonic('P');
        patternDatabaseItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                heuristicType = Puzzle_Config.HEURISTIC_PD;
                updatePuzzleConfiguration();
            }
        });
        heuristicTypeGroup.add(patternDatabaseItem);
        final JRadioButtonMenuItem linearConflictItem =
            new JRadioButtonMenuItem("Manhattan Distance + Linear Conflict",
            	heuristicType == Puzzle_Config.HEURISTIC_LC);
        linearConflictItem.setMnemonic('L');
        linearConflictItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                heuristicType = Puzzle_Config.HEURISTIC_LC;
                updatePuzzleConfiguration();
            }
        });
        heuristicTypeGroup.add(linearConflictItem);
        final JRadioButtonMenuItem manhattanDistanceItem =
            new JRadioButtonMenuItem("Manhattan Distance",
                heuristicType == Puzzle_Config.HEURISTIC_MD);
        manhattanDistanceItem.setMnemonic('M');
        manhattanDistanceItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cancelGraphicsThread();
                showButton.setEnabled(false);
                heuristicType = Puzzle_Config.HEURISTIC_MD;
                updatePuzzleConfiguration();
            }
        });
        heuristicTypeGroup.add(manhattanDistanceItem);

        heuristicTypeMenu.add(patternDatabaseItem);
        heuristicTypeMenu.add(linearConflictItem);
        heuristicTypeMenu.add(manhattanDistanceItem);

       final JMenu threadingTypeMenu = new JMenu("Threading Model");
        threadingTypeMenu.setMnemonic('T');
        final ButtonGroup threadingTypeGroup = new ButtonGroup();
        singleThreadedItem = new JRadioButtonMenuItem("Single-threaded", false);
        singleThreadedItem.setMnemonic('S');
        singleThreadedItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                useThreads = false;
                Puzzle_Config.setNumOfThreads(getNumberOfThreads());
         //       statusLabel.setText(PuzzleConfiguration.stringRepresentation());
            }
        });
        multiThreadedItem = new JRadioButtonMenuItem("Multi-threaded", true);
        multiThreadedItem.setMnemonic('M');
        multiThreadedItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                useThreads = true;
                Puzzle_Config.setNumOfThreads(getNumberOfThreads());
           //     statusLabel.setText(PuzzleConfiguration.stringRepresentation());
            }
        });
        if (!canRunThreads()) {
            multiThreadedItem.setEnabled(false);
            singleThreadedItem.setSelected(true);
        }

        threadingTypeGroup.add(singleThreadedItem);
        threadingTypeGroup.add(multiThreadedItem);

        threadingTypeMenu.add(singleThreadedItem);
        threadingTypeMenu.add(multiThreadedItem);

        final JMenu shuffleTypeMenu = new JMenu("Shuffling Method");
        shuffleTypeMenu.setMnemonic('S');

        final ButtonGroup shuffleTypeGroup = new ButtonGroup();
        
        final JRadioButtonMenuItem shuffleExcludeSpaceItem =
            new JRadioButtonMenuItem("Keep space in bottom right corner", true);
        shuffleExcludeSpaceItem.setMnemonic('K');
        shuffleExcludeSpaceItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                keepZeroInCorner = true;
            }
        });
        
       
        shuffleTypeGroup.add(shuffleExcludeSpaceItem);

      
        shuffleTypeMenu.add(shuffleExcludeSpaceItem);
        shuffleExcludeSpaceItem.doClick();
        
    //    optionsMenu.add(puzzleTypeMenu);
        optionsMenu.add(speedTypeMenu);
        optionsMenu.add(hideTextMenu);
   //     optionsMenu.add(algorithmTypeMenu);
   //     optionsMenu.add(heuristicTypeMenu);
      //  optionsMenu.add(threadingTypeMenu);
   /*     optionsMenu.add(new JSeparator());
        optionsMenu.add(shuffleTypeMenu);

        final JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('A');
        aboutItem.addActionListener(new AboutActionListener(this));

        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        helpMenu.add(aboutItem);*/

  //      menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
      //  menuBar.add(helpMenu);

        return menuBar;
    }

    private void updatePuzzleConfiguration() {
        Puzzle_Config.initialize(
            puzzleType, algorithmType, heuristicType, getNumberOfThreads());
    //    statusLabel.setText(PuzzleConfiguration.stringRepresentation());
        
    }

    private void highlightInput() {
        configurationField.requestFocus();
        configurationField.selectAll();
    }

    private void solvePuzzle() {
        try {
            cancelGraphicsThread();
            showButton.setEnabled(false);
            final int numOfTiles = puzzleType == Puzzle_Config.PUZZLE_15 ? 16 : 9;
            initState = Utility.getArray(configurationField.getText(), numOfTiles);
            final String initialOrder = Utility.byteArrayToString(initState);
            configurationField.setText(initialOrder);
            puzzle.setOrder(initState);
            if (!Utility.isValidPermutation(initState)) {
                clearFields();
                new MessageBox(
                    this, "Information", "Puzzle configuration is unsolvable.",
                    MessageBox.INFORM);
               highlightInput();
                return;
            }
            configurationField.setEnabled(false);
            shuffleButton.setEnabled(false);
            optionsMenu.setEnabled(false);
            clearFields();
            solveButton.setText("Stop");
            statusField.setText("Searching for solution...");
    //        initialOrderField.setText(initialOrder);
     //       initialOrderField.setCaretPosition(0);
            Puzzle_Config.getAlgorithm().start();
            final Thread t = new Thread(this);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
           statusUpdateTimer.restart();
        } catch (final IllegalArgumentException iae) {
            new MessageBox(this, "Error", iae.getMessage(), MessageBox.EXCLAIM);
           highlightInput();
        }
    }

    private void clearFields() {
        statusField.setText("");
    //    initialOrderField.setText("");
   //     initialMovesEstimateField.setText("");
        timeField.setText("");
        movesField.setText("");
        pathsField.setText("");
        expandedField.setText("");
        model.clear();
    }

    private void doApplicationClosing(final JFrame parent) {
        if (applicationStarter != null) {
            applicationStarter.close();
        } else {
            System.exit(0);
        }
    }

    private boolean canRunThreads() {
        if (applicationStarter != null && Utility.getHasFullPermission() ||
            applicationStarter == null) {
            return true;
        }
        return false;
    }

    private int getNumberOfThreads() {
        if (algorithmType == Puzzle_Config.ALGORITHM_IDASTAR) {
            if (puzzleType == Puzzle_Config.PUZZLE_8) {
                return 1;
            } else {
                if (canRunThreads() && useThreads) {
                    return Utility.getDefaultNumOfThreads();
                } else {
                    return 1;
                }
            }
        }
        return 1;
    }

    class GraphicsThread extends Thread {
        public void run() {
            puzzle.setOrder(initState);
            shouldRun = true;
            while (shouldRun && stepNumber < Algorithm.shortestPath.length()) {
                Utility.generateNextState(
                    Algorithm.shortestPath.charAt(stepNumber), graphicsState);
             /*   directionsList.setSelectedIndex(stepNumber);
                directionsList.ensureIndexIsVisible(stepNumber);
                directionsList.repaint();
               */ puzzle.animatePuzzleTo(graphicsState);
                ++stepNumber;
            }
            directionsList.clearSelection();
           computer_timer.stop();
        }
    }

    class ExitActionListener implements ActionListener {
        private final JFrame parent;

        public ExitActionListener(final JFrame parent) {
            this.parent = parent;
        }

        public void actionPerformed(final ActionEvent e) {
            doApplicationClosing(parent);
        }
    }

    class AboutActionListener implements ActionListener {
        private final JFrame parent;

        public AboutActionListener(final JFrame parent) {
            this.parent = parent;
        }

        public void actionPerformed(final ActionEvent e) {
            final String[] data = { "Version 2.4.0",
                    "\u00a9 2000-2002, 2011-2013 Brian S. Borowski",
                    "All Rights Reserved.",
                    "Build: March 17, 2013" };
            new Dialogs(parent, APP_NAME, data,
                "images/icon.png");
        }
    }

    class ClosingWindowListener implements WindowListener {
        private final JFrame parent;

        public ClosingWindowListener(final JFrame parent) {
            this.parent = parent;
        }

        public void windowClosing(final WindowEvent e) {
            doApplicationClosing(parent);
        }

        public void windowDeactivated(final WindowEvent e) { }

        public void windowActivated(final WindowEvent e) { }

        public void windowDeiconified(final WindowEvent e) { }

        public void windowIconified(final WindowEvent e) { }

        public void windowClosed(final WindowEvent e) { }

        public void windowOpened(final WindowEvent e) { }
    }
    int check_4way(int id)
    {
       tempNum = Puzzle_Config.getNumOfTiles();   
       if(tempNum == 16)
       {
          if(id==1)
          {
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id+4].bt.isEnabled()==false)
                return id+4;
             else 
                return -1; // -1 : 이웃한 퍼즐중에 빈칸이없다는 뜻.
          }
          else if(id>=2 && id<=3)
          {
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id-1].bt.isEnabled()==false)
                   return id-1;
             else if(b[id+4].bt.isEnabled()==false)
                return id+4;
             else
                return -1;
          }
          else if(id>=14 && id<=15)
          {
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id-1].bt.isEnabled()==false)
                return id-1;
               else if(b[id-4].bt.isEnabled()==false)
                  return id-4;
               else
                  return -1;
          }
            else if(id==4)
            {
               if(b[id-1].bt.isEnabled()==false)
                  return id-1;
               else if(b[id+4].bt.isEnabled()==false)
                  return id+4;
               else 
                   return -1;
            }
            else if(id==5 || id==9)
            {
               if(b[id+1].bt.isEnabled()==false)
                  return id+1;
               else if(b[id+4].bt.isEnabled()==false)
                  return id+4;
               else if(b[id-4].bt.isEnabled()==false)
                  return id-4;
               else 
                  return -1;
            }
            else if((id>=6 && id<=7) || (id>=10 && id<=11))
            {   
               if(b[id+1].bt.isEnabled()==false)
                  return id+1;
               else if(b[id-1].bt.isEnabled()==false)
                  return id-1;
               else if(b[id+4].bt.isEnabled()==false)
                  return id+4;
               else if(b[id-4].bt.isEnabled()==false)
                  return id-4;
               else 
                  return -1;
            }
            else if(id==8 || id==12)
            {
               if(b[id-1].bt.isEnabled()==false)
                  return id-1;
               else if(b[id+4].bt.isEnabled()==false)
                  return id+4;
               else if(b[id-4].bt.isEnabled()==false)
                  return id-4;
            }
            else if(id==13)
            {
               if(b[id+1].bt.isEnabled()==false)
                  return id+1;
               else if(b[id-4].bt.isEnabled()==false)
                  return id-4;
               else 
                  return -1;
            }
            else if(id==16)
            {
               if(b[id-1].bt.isEnabled()==false)
                  return id-1;
               else if(b[id-4].bt.isEnabled()==false)
                  return id-4;
               else 
                  return -1;
            }
       }
       else if(tempNum == 9)
       {
          if(id==1)
          {
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id+3].bt.isEnabled()==false)
                return id+3;
             else 
                return -1; // -1 : 이웃한 퍼즐중에 빈칸이없다는 뜻.
          }
          else if(id==2)
          {
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id-1].bt.isEnabled()==false)
                   return id-1;
             else if(b[id+3].bt.isEnabled()==false)
                return id+3;
             else
                return -1;
          }
          else if(id==3)
          {
             if(b[id-1].bt.isEnabled()==false)
                return id-1;
             else if(b[id+3].bt.isEnabled()==false)
                return id+3;
             else 
                return -1;
          }
          else if(id==4)
          {
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id+3].bt.isEnabled()==false)
                return id+3;
             else if(b[id-3].bt.isEnabled()==false)
                return id-3;
             else 
                return -1;
          }
          else if(id==5)
          {   
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id-1].bt.isEnabled()==false)
                return id-1;
             else if(b[id+3].bt.isEnabled()==false)
                return id+3;
             else if(b[id-3].bt.isEnabled()==false)
                return id-3;
             else 
                return -1;
          } 
          else if(id==6)
          {   
             if(b[id-1].bt.isEnabled()==false)
                return id-1;
             else if(b[id+3].bt.isEnabled()==false)
                return id+3;
             else if(b[id-3].bt.isEnabled()==false)
                return id-3;
             else 
                return -1;
          }
          else if(id==7)
          {   
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id-3].bt.isEnabled()==false)
                return id-3;
             else 
                return -1;
          }
          else if(id==8)
          {   
             if(b[id+1].bt.isEnabled()==false)
                return id+1;
             else if(b[id-1].bt.isEnabled()==false)
                return id-1;
             else if(b[id-3].bt.isEnabled()==false)
                return id-3;
             else 
                return -1;
          }
          else if(id==9)
          {   
             if(b[id-1].bt.isEnabled()==false)
                return id-1;
             else if(b[id-3].bt.isEnabled()==false)
                return id-3;
             else 
                return -1;
          }
       }
       return -1;
    }
 
    
    private void makeUI(final JPanel infoPanel, final GridBagConstraints gbc)
    {
       infoPanel.removeAll();
       repaint();
       //remove(infoPanel);
     //  persons_panel = new JPanel();
   //    persons_panel.setLayout(new FlowLayout());
       infoPanel.setLayout(new GridBagLayout());
       move_cnt = new JLabel("0 Moved");
      
       
     //  infoPanel.add(persons_panel);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 0;
        gbc.insets = new Insets(0, 5, 5, 5);
        infoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Person's"));
        
        
       int i;
        int n;
        String s;
        tempNum = Puzzle_Config.getNumOfTiles();  
        time = new JLabel("");
        
        rankInfo.ri = new rankInfo();
		rankInfo.ri.init();
		
        if(tempNum == 16)
        {
           infoPanel.setLayout(new GridLayout(5,5));
           b = new Button[tempNum+1];
           map = new int[tempNum+1];
           for(i=1;i<=tempNum;i+=1)
           {
             b[i] = new Button();
           
             if(i==tempNum)
             {
                b[i].bt = new JButton("");
             
                b[i].bt.setFont(new Font("고딕",Font.ROMAN_BASELINE,17));
                b[i].bt.setIcon(null);
                b[i].bt.setBackground(Color.LIGHT_GRAY);
                b[i].bt.setHorizontalTextPosition(SwingConstants.LEFT);
                b[i].bt.setVerticalTextPosition(SwingConstants.TOP);
                b[i].bt.setIconTextGap(-20);
                b[i].bt.setMargin(new Insets(0,0,0,0));
                b[i].bt.setToolTipText(""+i+"");
                b[i].bt.addActionListener(this);
                b[i].bt.setEnabled(false);
                map[i] = 0;
              
                infoPanel.add(b[i].bt);   
                break;
             }
             n = i;
             s = Integer.toString(n);
           
             b[i].bt = new JButton("");
             b[i].bt.setFont(new Font("고딕",Font.ROMAN_BASELINE,17));
             b[i].bt.setBackground(Color.white);
             b[i].bt.setIcon(divImage[i-1]);
             b[i].bt.setHideActionText(true);
             b[i].bt.setText(s); 
             
             b[i].bt.setHorizontalTextPosition(SwingConstants.LEFT);
             b[i].bt.setVerticalTextPosition(SwingConstants.TOP);
             b[i].bt.setIconTextGap(-20);
             b[i].bt.setMargin(new Insets(0,0,0,0));
             b[i].bt.setToolTipText(""+i+"");
             
             b[i].bt.addActionListener(this);
             map[i]=i;
             
             infoPanel.add(b[i].bt);  
             
           }
        }
        else if(tempNum == 9)
        {
           infoPanel.setLayout(new GridLayout(3,3));
           b = new Button[tempNum+1];
           map = new int[tempNum+1];
           for(i=1;i<=tempNum;i+=1)
           {
             b[i] = new Button();
           
             if(i==tempNum)
             {
                b[i].bt = new JButton("");
                b[i].bt.setFont(new Font("고딕",Font.ITALIC,10));
                b[i].bt.addActionListener(this);
                b[i].bt.setEnabled(false);
                map[i] = 0;
              
                infoPanel.add(b[i].bt);   
                break;
             }
             n = i;
             s = Integer.toString(n);
           
             b[i].bt = new JButton("");
             b[i].bt.setFont(new Font("고딕",Font.ITALIC,10));
             b[i].bt.setText(s);
             b[i].bt.addActionListener(this);
             map[i]=i;
             
             infoPanel.add(b[i].bt);   
           }
        }
    //    infoPanel.add(time);
     /*   t = new Timer(true);
		task = new timer();
		t.schedule(task,new Date(),1000);*/
        
        persons_sec=0;	
        time = new JLabel("");
        second = new JLabel(""); 
        strsec = new JLabel("");
        
        time.setFont(new Font("고딕",Font.BOLD,25));
        second.setFont(new Font("고딕",Font.ROMAN_BASELINE,25));
        strsec.setFont(new Font("고딕",Font.BOLD,25));
       
        second.setForeground(Color.RED);
        
        
        
        time.setText("   Time : ");
		second.setText("0");
		strsec.setText(" sec");
        
        
        persons_timer = new Timer(1000, new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						persons_sec+=1;
						time.setText("   Time : ");
						second.setText(Integer.toString(persons_sec));
						strsec.setText(" sec");
						
						timerPanel.repaint();
					}
        	
        		});
        
        
        computer_sec=0;	
        time2 = new JLabel("");
        second2 = new JLabel(""); 
        strsec2 = new JLabel("");
        
        time2.setFont(new Font("고딕",Font.BOLD,20));
        second2.setFont(new Font("고딕",Font.ROMAN_BASELINE,20));
        strsec2.setFont(new Font("고딕",Font.BOLD,20));
       
        second2.setForeground(Color.RED);
        
        time2.setText(" Time : ");
		second2.setText("0");
		strsec2.setText(" sec");
        
        
       computer_timer = new Timer(1000, new ActionListener()
        		{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						computer_sec+=1;
						time2.setText(" Time : ");
						second2.setText(Integer.toString(computer_sec));
						strsec2.setText(" sec");
						
						timerPanel2.repaint();
					}
        	
        		});
      // infoPanel.add(time);	
		
        repaint();  
    }
    
    static void Load_Images()
	{
		 
		 int i=0;
		 img = new BufferedImage[image_cnt];
		img_name = new String[image_cnt];
	
		img_name[0] = "고오스.png";//
		img_name[1] = "레어코일.png";
		img_name[2] = "루기아.jpg";
		img_name[3] = "eve.png";
		img_name[4] = "fire.png";
		img_name[5] = "freezer.jpg";
		img_name[6] = "갸라도스.jpg";
		img_name[7] = "토게피.jpg";
		img_name[8]= "독침봉.jpg";
	//	img_name[]	= "피카츄.png";
    //	img_name[7] = "pigeon.png";
    	
		 while(i<image_cnt)
		  {
			 try{
		  	         img[i] = ImageIO.read(new File(img_name[i]));
			 }
			 catch(IOException e){
	            System.out.println(e.getMessage());
		            System.out.println(i+"DF");
		            System.exit(0);
	         }
			 i+=1;
		  }
	}
    public void getImage(int i){
		 int x=0;
		 int y=0;
		 int sx;
		 int sy;
		int cnt = 0;
	      int pieceHeight = img[i].getHeight(null) / pieces;
	      int pieceWidth = img[i].getWidth(null) / pieces;
	      
	     subImage = new Image[totalPieces];
	      divImage = new ImageIcon[totalPieces];
	   
	      for(y = 0; y<4;y+=1)
	      {
	    	  sy = y *pieceHeight;
	    	  for(x=0;x<4;x+=1)
	    	  {
	    		  sx = x * pieceWidth; 
	    		 subImage[cnt] = img[i].getSubimage(sx,sy,pieceWidth,pieceHeight);
	    	 divImage[cnt] = new ImageIcon( subImage[cnt].getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
	             cnt++;  
	    	  }
	      }
	     }
    boolean check_finished()
	{
		int i;
	//	boolean t=false;
		
		for( i=1;i<=15;i+=1)
		{
			if(map[i]!=i)
			{
				return false;
			}
		}
		return true;
	}
	public void actionPerformed(ActionEvent e) {
	      // TODO Auto-generated method stub
	      JButton act, inact;
	      String act_str = null;
	      String inact_str;
	      String check_str;
	      int check_num=0;
	      int push_num=0;
	      int tmp_idx=0; // 빈칸 idx
	      int idx=0;  // pushed_button's idx
	      int i=0;
	      JButton pushed;
	      int tmp;
	      Icon pushed_icon;
	     
	      
	      if(is_complete==true)
			{
				return;
			}
	      
	      if(e.getSource() == record)
			{
				// here to write code about ranking info
				pop c = new pop();
				
				return;
			}
			
			
	      pushed = (JButton)e.getSource();
	      pushed_icon = pushed.getIcon();
	      if(is_hide==true)
	      {
	    	  for(int x=1;x<=16;x+=1)
	    		  if(pushed == b[x].bt)
	    		  {
	    			  act_str = String.valueOf(map[x]);
	    			  break;
	    		  }
	      }
	      else // is_hide == true
	    	  act_str = pushed.getText();
	      
	      push_num = Integer.parseInt(act_str);
	      
	      
	      for(i=1;i<=tempNum;i+=1)
	      {
	         check_str = String.valueOf(map[i]);
	         if(check_str=="0")
	            continue;
	         check_num = Integer.parseInt(check_str);  
	         if(check_num==push_num)
	         {
	            idx = i; push_idx = i;
	            break;
	         }
	      }
	      tmp_idx = check_4way(idx);
	      if(tmp_idx==-1)
	         return;
	      
	      empty_idx= idx; //empty_idx는 누르면 비는 공간
			b[tmp_idx].bt.setEnabled(true);
	  //       b[tmp_idx].bt.setFont(new Font("고딕",Font.ROMAN_BASELINE,15));
	         if(is_hide==false)
			b[tmp_idx].bt.setText(act_str); 
	         
		     b[tmp_idx].bt.setIcon(pushed_icon);
		     b[tmp_idx].bt.setBackground(Color.white);
		  //   b[tmp_idx].bt.set(pushed_icon); 여기서부터 계속해야됨 :: 버튼에 이미지 풀로 채우는 문제, 글씨 숨기기?등등
		     b[idx].bt.setText("");
		     b[idx].bt.setIcon(null);
		     b[idx].bt.setBackground(Color.LIGHT_GRAY);
			b[idx].bt.setEnabled(false);
			
			tmp = map[idx];
			map[idx] = map[tmp_idx];
			map[tmp_idx] = tmp;
	      
			movecnt+=1;
			String move_str = String.format("%d Moved",movecnt);
			move_cnt.setText(move_str);
			
			is_complete = check_finished();
			BufferedImage image= null;
		//	ranking ra = new ranking();
			
			if(is_complete == true) //퍼즐완료시
			{
				//t.cancel();
				persons_timer.stop();
               //  sec = 0;
            //     time.setText("   Time : ");
         	//	second.setText("0");
         	//	strsec.setText(" sec");
         		
				b[16].bt.setIcon((divImage[15]));
				b[16].bt.setEnabled(true);
				
				//setSize(850,750);
				
				try
				{
					image = ImageIO.read(new File("exclaim.png"));
				}
				catch(IOException e1)
				{
					System.out.println("Img read error!");
					System.exit(1);
				}
			//	
				record r = new record();
				
				is_complete = false;
				persons_sec=0;
				computer_sec=0;
				b[16].bt.setIcon(null);
				b[16].bt.setEnabled(false);
				return;
			}
			infoPanel.repaint();
			
	}
}

