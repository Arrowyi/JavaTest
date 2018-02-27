/**
 * 
 */

/**
 * @author GBD_PC
 *
 */
public class InheritInitTest {
	
	public static void main(String[] args)
	{
		Super superTest = new Super();
	}
}

class Base
{
	
	static String sMsg = InitTestString("Base");
	
	static {
		System.out.println("static block of Base");
	}
	
	private TestMember testMember = new TestMember("Base");
	
	static StaticMember member = new StaticMember("Base");
	
	Base()
	{
		System.out.println("Base construct");
	}
	
	static String InitTestString(String msg)
	{
		System.out.println("static local memeber of " + msg);
		return msg;
	}
}

class Super extends Base
{
	static String sSuperMsg = Base.InitTestString("super");
	
	static {
		System.out.println("static block of Super");
	}
	
	static StaticMember member = new StaticMember("Super");
	
	private TestMember testMember = new TestMember("Super");
	
	Super()
	{
		System.out.println("Super construct");
	}
	
	
}

class StaticMember
{
	static String sMemeberMsg = Base.InitTestString("Static Member");
	
	static {
		System.out.println("Static Member static block");
	}
	
	
	
	private String msg;
	
	StaticMember(String msg)
	{
		System.out.println("Static Member construct of " + msg);
		this.msg = msg;
	}
	
	private TestMember testMember = new TestMember("no static member in the static memeber of " + msg);
	
}

class TestMember
{
	TestMember(String msg)
	{
		System.out.println("no static member construct in " + msg);
	}
}

