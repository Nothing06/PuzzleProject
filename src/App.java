/*
 * File: Application.java
 이 소스를 열고 실행해야 시작이 된다.
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


