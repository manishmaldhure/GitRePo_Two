package tests;

import org.testng.annotations.Test;

public class PS1 extends PS{
	
	@Test
	public void testRun()
	{
		doThis();
		PS2 p2=new PS2(7);
		p2.multiplication();
		p2.substraction();
		p2.addition();
		//p2.multiplication();
	//	p2.division();
	}

}
