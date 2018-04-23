package designandpatternTest;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class VisitorPatternTest {
	
	private interface IconPicker
	{
		String pickIcon(D2IconMode im);
		String pickIcon(D3IconMode im);
	}
	
	private static class SmartGasIconPicker implements IconPicker
	{

		@Override
		public String pickIcon(D2IconMode im) {
			return "smart gas 2d icon";
		}

		@Override
		public String pickIcon(D3IconMode im) {
			return "smart gas 3d icon";
		}
		
	}
	
	private static class SmartParking implements IconPicker
	{

		@Override
		public String pickIcon(D2IconMode im) {
			return "smart parking 2d icon";
		}

		@Override
		public String pickIcon(D3IconMode im) {
			return "smart parking 3d icon";
		}
		
	}
	
	private interface IconMode
	{
		String accept(IconPicker ip);
	}
	
	private static class D2IconMode implements IconMode
	{
		@Override
		public String accept(IconPicker ip) {
			return ip.pickIcon(this);
		}

	}
	
	private static class D3IconMode implements IconMode
	{
		@Override
		public String accept(IconPicker ip) {
			return ip.pickIcon(this);
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<IconMode> imsList = new ArrayList<>();
		
		imsList.add(new D2IconMode());
		imsList.add(new D3IconMode());
		
		IconPicker ip = new SmartGasIconPicker();
		
		for(IconMode im : imsList)
		{
			im.accept(ip);
		}
		
		ip = new SmartParking();		
		
		for(IconMode im : imsList)
		{
			im.accept(ip);
		}
		
	}
	

}
