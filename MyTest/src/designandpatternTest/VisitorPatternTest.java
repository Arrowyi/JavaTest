package designandpatternTest;

import java.util.ArrayList;
import java.util.List;


public class VisitorPatternTest {
	
	//Visitor, visit different elements
	private interface IconPicker
	{
		//method overwrite, so the element could call the same method name to dispatch the different class
		//you could also make different method to handle different element.
		void pickIcon(D2IconMode im);
		void pickIcon(D3IconMode im);
	}
	
	private static class SmartGasIconPicker implements IconPicker
	{

		@Override
		public void pickIcon(D2IconMode im) {
			System.out.print("smart gas 2d icon");
		}

		@Override
		public void pickIcon(D3IconMode im) {
			System.out.print("smart gas 3d icon");
		}
		
	}
	
	private static class SmartParking implements IconPicker
	{

		@Override
		public void pickIcon(D2IconMode im) {
			System.out.print("smart parking 2d icon");
		}

		@Override
		public void pickIcon(D3IconMode im) {
			System.out.print("smart parking 3d icon");
		}
		
	}
	

	private interface IconMode
	{
		//the client call this method to dispatch different visitor to visit the element.
		void accept(IconPicker ip);
	}
	
	private static class D2IconMode implements IconMode
	{
		@Override
		public void accept(IconPicker ip) {
			ip.pickIcon(this);
		}

	}
	
	private static class D3IconMode implements IconMode
	{
		@Override
		public void accept(IconPicker ip) {
			ip.pickIcon(this);
		}
		
	}
	
	public static void main(String[] args) {
		
		List<IconMode> imsList = new ArrayList<>();
		
		imsList.add(new D2IconMode());
		imsList.add(new D3IconMode());
		
		IconPicker ip = new SmartGasIconPicker();
		
		for(IconMode im : imsList)
		{
			im.accept(ip);
			System.out.println();
		}
		
		ip = new SmartParking();		
		
		for(IconMode im : imsList)
		{
			im.accept(ip);
			System.out.println();
		}
		
	}
	

}
