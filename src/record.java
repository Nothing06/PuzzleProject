import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

class rankInfo{
	static String[] title;
	static String[] pkt_name;
	static int[] img_num;
	static int[] time;
	static int[] movecnt;
	static String[] date;
	static rankInfo ri;
	static int curIdx=0;
	public rankInfo()
	{
	}
	void show_rank()
	{
		
	}
	void init()
	{
		img_num = new int[100];
		ri.pkt_name = new String[Puzzle.pktmon_cnt];
		ri.title = new String[10];
		ri.time  = new int[10];
		ri.movecnt  = new int[10];
		ri.date  = new String[10];
	}
};
public class record extends JDialog implements ActionListener{
	JLabel n;
	JTextField name;
	JLabel  time;
	JLabel move_count;
	String time_str;
	String move_str;
	
	JButton config;
	
	JPanel reg_info;
	JPanel title_p;
	JLabel title;
	Container con;
	
	FileReader reader;
	FileOutputStream writer;
	boolean c = false;
	boolean b=true;
	
	public record()
	{
		
		
			
		
		title_p = new JPanel();
		reg_info = new JPanel();
		reg_info.setLayout(new GridLayout(0,2));
		
		
		title = new JLabel("register rankInfo");
		n = new JLabel("Name: ");
		name = new JTextField(20);
	//	time_str = String.format("Time : %d",Puzzle.sec-1);
	//	time = new JLabel(time_str);
		//move_str = String.format("%d times Moved", Puzzle.movecnt);
	//	move_count = new JLabel(move_str);
		config = new JButton("Config");
		config.addActionListener(this);
		
		title_p.add(title);
		reg_info.add(n);
		reg_info.add(name);
	//	reg_info.add(time);
	//	reg_info.add(move_count);
		reg_info.add(config);

		getContentPane().add(title_p);
		getContentPane().add(reg_info);
		this.setTitle("Register rankInfo");
		this.setSize(500,200);
		//this.setModal(true);
		 setVisible(true);
		
	}
	static void load_rankInfo()
	{
		
	}
	void save_rankInfo()
	{
		try {
			writer = new FileOutputStream("rank.txt", c);
		/*	writer.write(ri.title[ri.curIdx],);
			writer.write(" ");
			writer.write(ri.movecnt[ri.curIdx]);
			writer.write(" ");
			writer.write(ri.time[ri.curIdx]);
			writer.write("\n");
			*/c = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == config)
		{
			int idx = rankInfo.curIdx;
			rankInfo.ri.pkt_name[idx] = Puzzle.pktmon_name[Puzzle.pktmon_idx];//// null pointer exception!!
			//°íÃÄ¾ßµÊ
			rankInfo.ri.title[idx] = name.getText();
			rankInfo.ri.movecnt[idx] = GUI.movecnt;
			int t = Integer.valueOf(GUI.second.getText());
			rankInfo.ri.time[idx] = Integer.valueOf(t);
			Calendar c = Calendar.getInstance();
			rankInfo.ri.date[idx] = c.getTime().toString();
			rankInfo.curIdx += 1;
			if(rankInfo.curIdx==5)
				rankInfo.curIdx=0;
		//	Puzzle.sec=0;
			
			dispose();
		//	save_rankInfo();
		}
		
	}
}
