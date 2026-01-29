package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test
	public void verify_account_registration() {
		

		HomePage hp = new HomePage(driver);
		     hp.clickMyAccount();
		     hp.clickRegister();
		          
	     AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	     
	     regpage.setFirstName (randomeString().toUpperCase());
	     regpage.setLastName (randomeString().toUpperCase());
	     regpage.setEmail(randomeString()+"@gmail.com"); // randomly generated the email
	   	 regpage.setTelephone (randomeNumber());

	     String password=randomeAlphaNumberic();
	     regpage.setPassword (password);
	     regpage.setConfirmPassword (password);
	     
	     regpage.setPrivacyPolicy();
	     regpage.clickContinue();
	     String confmsg=regpage.getConfirmationMsg();

	     //Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}

	public String randomeString() {
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	return generatedstring;

	}

	public String randomeNumber(){
    String generatednumber=RandomStringUtils.randomNumeric(10);
    return generatednumber;
	}

	public String randomeAlphaNumberic() {

	String generatedstring=RandomStringUtils.randomAlphabetic(3);

	String generatednumber=RandomStringUtils.randomNumeric(3);

	return (generatedstring+"@"+generatednumber);

	}
	
}
