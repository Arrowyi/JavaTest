package FeatrueTest;

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {

		public void run() {
			System.out.println(number);
			while (!ready) {
				 Thread.yield();

				System.out.println(number);
			}

		}

	}

	public static void main(String[] args) {
		ReaderThread rt = new ReaderThread();

		rt.start();

		for (int i = 0; i < 100; i++) {
			number = i;	
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ready = true;

	}

}
