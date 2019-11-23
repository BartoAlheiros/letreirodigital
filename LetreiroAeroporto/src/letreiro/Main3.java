package letreiro;

import java.util.concurrent.*;

public class Main3 {
	
	static final int BUFF_LEN = 4;
	public static Semaphore sem = new Semaphore(1);
	public static Semaphore sem2 = new Semaphore(0);

	private static void nap(int millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void addProc(HighLevelDisplay d) {

		try {
			sem.acquire();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.addRow("AAAAAAAAAAAAAAAAA");
		nap(1500);
		sem.release();
		sem2.release();
		d.addRow("CCCCCCCCCCCCCCCCC");
		nap(1500);
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sem2.release();
		
		d.addRow("JJJJJJJJJJJJJJJJJ");
		nap(1500);
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.addRow("YYYYYYYYYYYYYYYYY");
		nap(1500);
		
		
	
		
	}

	private static void deleteProc(HighLevelDisplay d) {

		try {

			sem2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		d.deleteRow(0);
		nap(1500);
		
		try {
			sem.acquire(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		d.deleteRow(0);
		
		try {
			sem.acquire(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.deleteRow(0);
		nap(1500);
		
		try {
			sem.acquire(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		d.deleteRow(0);
		nap(1500);
		
		sem.release(4);



	}

	public static void main(String [] args) {
		final HighLevelDisplay d = new JDisplay2();

		new Thread () {
			public void run() {
				addProc(d);
			}
		}.start();


		new Thread () {
			public void run() {
				deleteProc(d);
			}
		}.start();

	}
}