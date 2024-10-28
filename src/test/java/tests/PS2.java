package tests;

public class PS2 extends PS3 {
	
	int a;
	public PS2(int a) {
		super(a);
		this.a=a;

	}
	public void addition() {
		a=a+1;
		System.out.println(a);	
		
	}
	public void substraction()
	{
		a=a-1;
		System.out.println(a);
	}

}
