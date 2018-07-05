package test.com.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.entity.User.identityType;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
@WebAppConfiguration("WebContent")
public class testUserService {
	@Autowired
	private UserService userService;
	@Test
	@Transactional
	public void getUser_success() {
		Assert.assertNotNull(userService.getUser("bo","1234"));
	}
	@Test
	@Transactional
	public void getUser_false() {
		Assert.assertNull(userService.getUser("bo", "1"));
	}
	/*@Test
	@Transactional
	public void listUser_success() {
		Assert.assertNotNull(userService.listUser());
	}
	@Test
	@Transactional
	public void listUser_false() {
		Assert.assertNull(userService.listUser());
	}*/
	/*@Test
	@Transactional
	public void updateUserInfo_success() {
		User user = userService.getUser("bo", "1234");
		user.setName("mm");
		userService.updateUserInfo(user);
		Assert.assertEquals("mm", user.getName());
	}
	@Test
	@Transactional
	public void adminUpdateInfo_success() {
		User user = userService.getUser("bo", "1234");
		user.setName("mm");
		userService.adminUpdateInfo(user);
		Assert.assertEquals("mm", user.getName());
	}*/
	@Test
	@Transactional
	public void deleteAdmin_success() {
		User user = userService.getUser("bo", "1234");
		userService.deleteAdmin(user);
		Assert.assertEquals(identityType.USER, user.getIdentity());
	}
	@Test
	@Transactional
	public void addAdmin_success() {
		User user = userService.getUser("bb", "1234");
		userService.addAdmin(user);
		Assert.assertEquals(identityType.ADMIN, user.getIdentity());
	}
	@Test
	@Transactional
	public void addUser_success() {
		User user = new User();
		user.setUserName("vv");
		user.setPassword("1234");
		user.setDetail("1");
		user.setName("vvvv");
		user.setIdentity(identityType.ADMIN);
		userService.addUser(user);
		Assert.assertNotNull(user.getId());
	}
}
