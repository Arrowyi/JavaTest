package FeatrueTest;
/**
 * 
 */

/**
 * @author GBD_PC
 *
 */

class Base
{
	
	static String sMsg = InitString("Base static string");
	
	static {
		System.out.println("Base static block");
	}
	
	private Member member = new Member("Base");
	
	static StaticMember sMember = new StaticMember("Base");
	
	Base()
	{
		System.out.println("Base construct");
	}
	
	static String InitString(String msg)
	{
		System.out.println(msg);
		return msg;
	}
}

class Super extends Base
{
	static String sSuperMsg = Base.InitString("super static string");
	
	static {
		Base.InitString("super static block");
	}
	
	static StaticMember member = new StaticMember("Super");
	
	private Member testMember = new Member("Super");
	
	Super()
	{
		Base.InitString("Super construct");
	}
	
	
}

class StaticMember
{
	static String sMemeberMsg = Base.InitString("static member static string");
	
	static {
		Base.InitString("static member static block");
	}
	
	private String msg;
	
	StaticMember(String msg)
	{
		Base.InitString("static member construct in " + msg);
		this.msg = msg;
	}
	
	private Member testMember = new Member("static member with " + msg);
	
}

class Member
{
	Member(String msg)
	{
		Base.InitString("member construct in " + msg);
	}
}

public class InheritInitTest {
	
	public static void main(String[] args)
	{
		Super superTest = new Super();
	}
}

