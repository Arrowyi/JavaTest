package FeatrueTest.ioTest;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
		ScannerTest tester = new ScannerTest();
		tester.scanTest();

	}
	
	void scanTest()
	{
		System.out.println("please input int :");
		
		Scanner sanner = new Scanner(System.in);
		
		while(sanner.hasNext())
		{
			int inputInt = sanner.nextInt();//if the next is not int, the exception will be throwed.
			System.out.println("you int int is : " + inputInt);
		}
	}

}
