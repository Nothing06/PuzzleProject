/*
 * File: Application.java
 �� �ҽ��� ���� �����ؾ� ������ �ȴ�.
 */

public class App {

   
    /**
     * Main method.
     * Creates an instance of the application.
     */
    public static void main(final String[] args) {
    	Puzzle.pktmon_name = new String[Puzzle.pktmon_cnt];
    	Puzzle.set_pktmon_name();
    	
        new GUI(null);
    } 
}


