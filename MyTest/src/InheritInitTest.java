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
	
	static String sMsg = InitTestString("Base static member");
	
	static {
		System.out.println("Base static block");
	}
	
	private TestMember testMember = new TestMember("Base");
	
	static Member member = new Member("Base");
	
	Base()
	{
		System.out.println("Base construct");
	}
	
	static String InitTestString(String msg)
	{
		System.out.println(msg);
		return msg;
	}
}

class Super extends Base
{
	static String sSuperMsg = Base.InitTestString("super static memeber");
	
	static {
		Base.InitTestString("super static block");
	}
	
	static Member member = new Member("Super");
	
	private TestMember testMember = new TestMember("Super");
	
	Super()
	{
		Base.InitTestString("Super construct");
	}
	
	
}

class Member
{
	static String sMemeberMsg = Base.InitTestString("member static member");
	
	static {
		Base.InitTestString("member static block");
	}
	
	
	
	private String msg;
	
	Member(String msg)
	{
		Base.InitTestString("member construct " + msg);
		this.msg = msg;
	}
	
	private TestMember testMember = new TestMember("Member in the " + msg);
	
}

class TestMember
{
	TestMember(String msg)
	{
		Base.InitTestString("no static member construct in " + msg);
	}
}

