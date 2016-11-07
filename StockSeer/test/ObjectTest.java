
public class ObjectTest {
	public static String getString(){
		return new String("hello");
	}
	
	public static void assignString(String a){
		a = " hello ";
	}
	
	public static void main(String[] args) {
		String a = null;
		assignString(a);
		
		System.out.println(a);
	}
}
