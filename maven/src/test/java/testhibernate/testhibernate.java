package testhibernate;

import org.junit.Test;

public class testhibernate {
	@Test
	public void test1() throws Exception{
		Utils.parsexml();
		User user = new User();
		user.setAge("18");
		user.setName("test");
		Utils.save(user);
	}
}
