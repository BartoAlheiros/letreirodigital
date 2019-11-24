package letreiro;

import java.util.concurrent.*;

public class Main3 {
	
	public static Semaphore sem = new Semaphore(1);
	public static Semaphore sem2 = new Semaphore(0);

	private static void nap(int millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	private static synchronized void addProc(HighLevelDisplay d) {

	/*	try {
			sem.acquire();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		
		d.addRow("AAAAAAAAAAAAAAAAA");
		nap(1500);
		
	/*	try {
			sem2.acquire();
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		sem.release();
		
		try {
			sem.acquire();
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		d.addRow("CCCCCCCCCCCCCCCCC");
		nap(1500);
		/*sem.release();
		sem2.release();
		
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		d.addRow("JJJJJJJJJJJJJJJJJ");
		nap(1500);
		/*sem.release();
		
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		d.addRow("YYYYYYYYYYYYYYYYY");
		nap(1500);
		//sem2.release();
	
	
		
	}

	private static synchronized void deleteProc(HighLevelDisplay d) {

		d.deleteRow(0);
		nap(5000);
		//sem2.release();
		
		
		d.deleteRow(0);
		nap(5000);
		//sem2.release();
		
		/*try {
			sem2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		d.deleteRow(0);
		nap(10000);
		//sem2.release();
		
		
		d.deleteRow(0);
		nap(1500);
		//sem2.release();
		
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