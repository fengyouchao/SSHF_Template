package TestContest;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.example.model.User;
import com.example.service.UserService;

@ContextConfiguration
@TransactionConfiguration//(defaultRollback=false)默认为true
public class TestUserManager extends AbstractTransactionalJUnit4SpringContextTests{
	
    @Autowired
    private UserService userManager;
    
    @BeforeTransaction
    public void beforeTransactionMethod(){
    	System.out.println("before");
    }
    
    @AfterTransaction
    public void afterTransactionMethod(){
    	System.out.println("after");
    }
    
    

//    @Rollback(true) //这个配置可以覆盖TransactionConfiguration中的配置
    @Test
    public void testAdd() throws Exception {
    	User user = new User();
    	user.setUsername("testtesttest");
    	user.setPassword("testtesttest");
    	userManager.add(user);
    	boolean bl = userManager.exist(user);
    	Assert.isTrue(bl);
    }



	public UserService getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserService userManager) {
		this.userManager = userManager;
	}

	
	

}
