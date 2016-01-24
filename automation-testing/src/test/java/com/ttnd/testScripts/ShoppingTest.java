/*package com.ttnd.testScripts;

//import org.junit.Test;
import org.testng.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ttnd.Android.as.HomeScreen.HomePage;
import com.ttnd.objectRepository.ArtsCulture_ComedyVideodetailPage;
import com.ttnd.utilities.FrameworkException;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ShoppingTest extends TestBase{

	// Test case 1 Launch the app and verify error message on account creation for already created account
	@Test
	@Parameters("SmokeTest") 
	public void Test_01() throws InterruptedException {

		try{

			Thread.sleep(10000);
			driver.findElement(By.id("com.americanswan:id/app_logo")).click();
			reportTestStep(true, "Clicked on App Logo");
			driver.findElement(By.id("com.americanswan:id/btn_sign_out")).click();

			
			driver.findElement(By.id("com.americanswan:id/signupNow")).click();
			reportTestStep(true, "Clicked on Sign up button");
			driver.findElement(By.id("com.americanswan:id/editTextEmail")).sendKeys("vaibhav.singhal@tothenew.com");
			driver.hideKeyboard();
			reportTestStep(true, "Entered email id");

			driver.findElement(By.id("com.americanswan:id/editTextPassword")).sendKeys("password");
			driver.hideKeyboard();
			reportTestStep(true, "Entered passsword");

			driver.findElement(By.id("com.americanswan:id/editTextMobile")).sendKeys("8750050183");

			 List<MobileElement> list = driver.findElements(By.id("com.americanswan:id/editTextMobile"));

			System.out.println("----------" + list.size());

			for(MobileElement element : list){
				System.out.println(element.getText());

				if(element.getText().equals("MOBILE"))
					element.sendKeys("8750050183");
			}

			//String value = "com.americanswan:id/editTextMobile";
			//driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"" + value + "\")").sendKeys("8750050183");
			driver.findElement(By.id("com.americanswan:id/editTextMobile")).sendKeys("8750050183");
			driver.hideKeyboard();
			reportTestStep(true, "Entered mobile Number");
			driver.hideKeyboard();

			Thread.sleep(5000);

			//driver.findElement(By.id("com.americanswan:id/btnMen")).click();
			//reportTestStep(true, "Clicked on Men Sign Up button");
			driver.findElement(By.id("com.americanswan:id/btnRegister")).click();

			

			String existingAccountMessage = driver.findElement(By.id("com.americanswan:id/snackbar_text")).getText();

			if(existingAccountMessage.equals("You have an existing account using this email id."))
				reportTestStep(true, "Verified account already exists");
			else
				reportTestStep(false, "No error message 'Verified account already exists' for already created acount");
		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;
		}
		catch (Exception e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;
		}}
	//		super.endTest(test); 

	// Test case 2: Finding "Kearny Black Brogues" froms Mens-->Footwear-->Shoes category
	@Test
	@Parameters("SmokeTest")
	public void Test_02() throws InterruptedException {

		try{


			driver.findElement(By.id("com.americanswan:id/skip")).click();
			
			Thread.sleep(5000);

			driver.findElement(By.id("com.americanswan:id/imageView_darwer")).click();
			Thread.sleep(10000);


			List<MobileElement> list = driver.findElements(By.id("com.americanswan:id/title"));

			for(MobileElement element : list){

				if(element.getText().equals("Footwear")){
					element.click();
					reportTestStep(true, "Selected footwear under mens category");
					break;
				}

			}


			for(MobileElement element : list){

				if(element.getText().equals("Shoes")){
					element.click();
					reportTestStep(true, "Selected Shoes subcategory under footwear");
					break;
				}

			}

			Thread.sleep(5000);


			list  = driver.findElements(By.id("com.americanswan:id/item_name"));
			boolean scrollable = true;

			while(scrollable){
				for(MobileElement element : list){

					if(element.getText().equals("Avon Brown Derby shoes")){
						element.click();
						scrollable = false;
						reportTestStep(true, "Selected Avon Brown Derby shoes");
					}

				}



				driver.swipe(driver.manage().window().getSize().getWidth()/2,
						driver.manage().window().getSize().getHeight()*8/10,
						driver.manage().window().getSize().getWidth()/2,
						(driver.manage().window().getSize().getHeight()/10),
						1000);
			}

			
			

		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;
		}} 

	// Test case 3 Verify shoe is successfully added into cart
	@Test
	@Parameters("SmokeTest")
	public void Test_03() throws InterruptedException {
	
		try{
			
			driver.findElement(By.id("com.americanswan:id/button_cart")).click();

			//driver.findElement(By.id("com.americanswan:id/buttonSizes")).click();

			Thread.sleep(5000);

			List<MobileElement> list  = driver.findElements(By.className("android.widget.TextView"));
			for(MobileElement element : list){

				if(element.getText().equals("9")){
					element.click();
					reportTestStep(true, "Selected Shoes size 9");
					break;
				}

			}

			driver.findElement(By.id("com.americanswan:id/button_cart")).click();
			reportTestStep(true, "Added shoe to cart");

			Thread.sleep(5000);

			driver.findElement(By.id("com.americanswan:id/icon_cart")).click();
			reportTestStep(true, "Open my bag");

			
			list  = driver.findElements(By.id("com.americanswan:id/title"));
			for(MobileElement element : list){

				if(element.getText().equals("Avon Brown Derby shoes")){
					reportTestStep(true, "Avon Brown Derby shoes is successfully added into cart");
					break;
				}

			}
			

		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;
		}} 




	//  Test case 4 Apply coupon code

	@Test
	@Parameters("SmokeTest")
	public void Test_04() throws InterruptedException {
		
		try{
			
		//	driver.findElement(By.id("com.americanswan:id/button_coupon1"));
			
		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;
		}}



	 // Test case 5 Tap on  Art & Culture >> Entertainment
	@Test
	@Parameters("SmokeTest")
	public void Test_05() throws InterruptedException {
		//super.startTest("AppLaunch", "Verify App Launch successfully", "Sanity");
        //reportTestStep(true, "App Launch");
		try{
			Thread.sleep(15000);
			System.out.println("---------");
			new HomePage(driver).tapNavigationBar().tapArtsCulture().tapAllEntertainment();
			//driver.navigate().back();
			//reportTestStep(true, "App Launch");
		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;

		}}

		// Test case 6 Tap on  Art & Culture >> Music
	@Test
	@Parameters("SmokeTest")
	public void Test_06() throws InterruptedException {
		//super.startTest("AppLaunch", "Verify App Launch successfully", "Sanity");
        //reportTestStep(true, "App Launch");
		try{
			Thread.sleep(15000);
			System.out.println("---------");
			new HomePage(driver).tapNavigationBar().tapArtsCulture().tapMusic();
			//driver.navigate().back();tapMusic
			//reportTestStep(true, "App Launch");
		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;

		}}

	// Test case 6 Tap on  Art & Culture >> Arts
	@Test
	@Parameters("SmokeTest")
	public void Test_07() throws InterruptedException {
		//super.startTest("AppLaunch", "Verify App Launch successfully", "Sanity");
        //reportTestStep(true, "App Launch");
		try{
			Thread.sleep(15000);
			System.out.println("---------");
			new HomePage(driver).tapNavigationBar().tapArtsCulture().tapArts();
			//driver.navigate().back();
			//reportTestStep(true, "App Launch");
		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");

			throw e;
		}}

	// Test case  Tap on  Art & Culture >> Chat
		@Test
		@Parameters("SmokeTest")
		public void Test_08() throws InterruptedException {
			//super.startTest("AppLaunch", "Verify App Launch successfully", "Sanity");
	        //reportTestStep(true, "App Launch");
			try{
				Thread.sleep(15000);
				System.out.println("---------");
				new HomePage(driver).tapNavigationBar().tapArtsCulture().tapChat();
				//driver.navigate().back();
				//reportTestStep(true, "App Launch");
			}catch (NoSuchElementException e){
				reportTestStep(false, "<pre>" + e.toString() + "</pre>");

				throw e;
			}}

		// Test case 6 Tap on  Art & Culture >> Arts
		@Test
		@Parameters("SmokeTest")
		public void Test_09() throws InterruptedException {
			//super.startTest("AppLaunch", "Verify App Launch successfully", "Sanity");
	        //reportTestStep(true, "App Launch");
			try{
				Thread.sleep(15000);
				System.out.println("---------");
				new HomePage(driver).tapNavigationBar().tapArtsCulture().tapMusic();
				//driver.navigate().back();
				//reportTestStep(true, "App Launch");
			}catch (NoSuchElementException e){
				reportTestStep(false, "<pre>" + e.toString() + "</pre>");

				throw e;
			}}

		// Test case 09 Tap on  Art & Culture >> Chat
		@Test
		@Parameters("SmokeTest")
		public void Test_10() throws InterruptedException {
			//super.startTest("AppLaunch", "Verify App Launch successfully", "Sanity");
	        //reportTestStep(true, "App Launch");
			try{
				Thread.sleep(15000);
				System.out.println("---------");
				new HomePage(driver).tapNavigationBar().tapArtsCulture().tapTheatre();
				//driver.navigate().back();
				//reportTestStep(true, "App Launch");
			}catch (NoSuchElementException e){
				reportTestStep(false, "<pre>" + e.toString() + "</pre>");

				throw e;
			}}

	public void Login() {
		//		super.startTest("Login", "Verify Login", "Sanity");
		//Partial done	"- Unable to do login if FB, G+ apps are not installed.

		RegistrationPage regPage = new RegistrationPage(driver);

		regPage.tapFacebook()
		.enterUsername("mayuri.dhane@tothenew.com")
		.enterPassword("Discovery@1")
		.tapLogin();
		reportTestStep(true, "Login");
		// Login Alternatively as FB login is NOT working. 
		//		regPage.tapSkipForNow();

		//super.endTest(test);
	}

	public void Registration() {
		//		super.startTest("Registration", "Verify Registration", "Sanity");
		//Partial done	"- Unable to do login if app is not installed.

		//Pre condition - Logout first

		//		super.endTest(test);
	}





	public void SkipLogin() {
		//		super.startTest("SkipLogin", "Verify SkipLogin", "Sanity");

		//		Test
		new RegistrationPage(driver).tapSkipForNow();
		reportTestStep(true, "SkipLogin successful");

		System.out.println(driver.getPageSource());

		//		super.endTest(test);

	}

	public void HomePageUI() {
		//		super.startTest("HomePageUI", "Verify HomePageUI", "Sanity");

		//Partial Done
		//	- For few UI buttons and links Id has not been declared so unable to verify and tap on these buttons"
		new HomePage(driver).verifyPageUI();

		//		new HomePage(driver).tapLiveButton().tapLivePlay();
		//		  driver.navigate().back(); //Return to Live Page

		//super.endTest(test);

	}

	public void HomePage_LiveEvent() {
		//		super.startTest("HomePage_LiveEvent", "Verify HomePage_LiveEvent is successful", "Sanity");

		//		Test Steps
		LivePage livePage = new HomePage(driver).tapLiveButton();
		if (livePage.verifyButtonLivePlay()){
			reportTestStep(true, "Live event is going on");
			//			report pass
		}else{
			//			report fail
			reportTestStep(true, "No Live event");
		}


		//			super.endTest(test);
	}

	public void HomePage_EventStatus() {
		//			super.startTest("HomePage_LiveEvent", "Verify HomePage_LiveEvent is successful", "Sanity");

		//		Test Steps
		try{
			new HomePage(driver).tapLiveButton().tapLivePlay();
			//Report Pass
			//reportTestStep(true,"Video Played");
			//Wait for 40 sec for Video to load and finish playback
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reportTestStep(true,"Video Played");
			//Report Pass

			//Navigate Back
			driver.navigate().back();
		}catch(NoSuchElementException ex){
			//Report Step fail
		}

		//			super.endTest(test);
	}

	public void HomePage_PlayVideo() {
		//			super.startTest("HomePage_LiveEvent", "Verify HomePage_LiveEvent is successful", "Sanity");


		//			Test

		//			super.endTest(test);
	}

	public void HomePage_BottomTabBar() {
		//			super.startTest("HomePage_LiveEvent", "Verify HomePage_LiveEvent is successful", "Sanity");
		driver.findElement(By.id("com.mediafoundry.SevenTennis:id/button_register")).isDisplayed();
		reportTestStep(true,"Live Tab is there on the home page");


		//Test


		//			super.endTest(test);
	}

	public void HomePage_BottomLiveTabBar() {
		//			super.startTest("HomePage_LiveEvent", "Verify HomePage_LiveEvent is successful", "Sanity");

		new HomePage(driver)
		.tapLiveButton();

		//			super.endTest(test);
	}

	public void HomePage_Social() {
		//super.startTest("HomePage_LiveEvent", "Verify HomePage_LiveEvent is successful", "Sanity");

		new HomePage(driver)
		.tapsocialButton();
		reportTestStep(true,"Social tab is working");


		//super.endTest(test);
	}

	public void HomePage_Share() {
		//			super.startTest("HomePage_Share", "Verify HomePage_Share is successful", "Sanity");

		new HomePage(driver)
		.tapShareButton()
		.GoBack();
		reportTestStep(true,"Share tab is working");
		//		super.endTest(test);
	}

	public void HomePage_More() {
		//	super.startTest("HomePage_More", "Verify HomePage_More is successful", "Sanity");

		//			Test
		MoreButtonPage morePage = new HomePage(driver).tapMoreButton();
		morePage.tapLink1().goBack();
		reportTestStep(true,"Yahoo link is working");

		morePage.tapLink2().goBack();
		reportTestStep(true,"The Best Australian link is working");

		morePage.tapLink3().goBack();
		reportTestStep(true,"Plus 7 link is working");

		morePage.tapLink4().goBack();
		reportTestStep(true,"Seven Sport is working");

		morePage.tapLink5().goBack();
		reportTestStep(true,"Presto link is working");

		LoginPage loginPage = morePage.tapLogout();
		if (loginPage == null){
			//fail
			reportTestStep(false,"User cant be logged out");
		}else{
			//pass
			reportTestStep(true,"User has been logged out");
		}
		//	morePage.tapLogin();
		//	reportTestStep(true,"More links are working");

		//super.endTest(test);
	}

	public void HomePage_Logout() {
		//super.startTest("Logout", "Verify Logout is successful", "Sanity");

		new HomePage(driver).tapMoreButton().verifyUserLoggedIn().tapLogout();

		//super.endTest(test);
	}
	 

	public void HomePage_LivePage_EventStatus() {
		//	super.startTest("LivePage_EventStatus", "Verify LivePage_EventStatus is successful", "Sanity");

		//		Not Done 	
		//		Unable to verify upcoming past events

		//			super.endTest(test);
	}
	public void Chromecast_Airplay() {
		//			super.startTest("Chromecast_Airplay", "Verify Chromecast_Airplay is successful", "Sanity");

		//		Not Done 	
		//		Unable to connect devices to chromecast / airplay

		//			super.endTest(test);

	}
	

	 //	@Test
	public void TestCase1() {
		//Application Component

		startTest("TestCase1", "Verify test X", "Sanity");
		try{
			reportTestStep(true, "Launching browser");

			driver.findElement(By.id("com.mediafoundry.SevenTennis:id/button_register")).click();

			String actualText = driver.findElement(By.id("com.mediafoundry.SevenTennis:id/button_register")).getText();
			reportTestStep(true, "Launched browser");
			//		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.mediafoundry.SevenTennis:id/button_register\")").click();
		}catch (NoSuchElementException e){
			reportTestStep(false, "<pre>" + e.toString() + "</pre>");
			throw e;
		}

	} 

	public void TestCase2() {
		//Application Component
		System.out.println("TestCase2");
		super.startTest("TestCase2", "Verify test X", "Sanity");
		try{
			test.log(LogStatus.PASS, "Launching browser");

			//			driver.findElement(By.id("com.mediafoundry.SevenTennis:id/button_register")).click();
			//			driver.navigate().back();
			test.log(LogStatus.PASS, "Launched browser");
			//		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.mediafoundry.SevenTennis:id/button_register\")").click();
		}catch (NoSuchElementException e)
		{
			System.out.println("NoSuchElementException");
			test.log(LogStatus.FAIL, "<pre>" + e.toString() + "</pre>");
			throw e;
		}

		extent.endTest(test);
		extent.flush();
	}

	@Test
	public void Testcase3_() {
		System.out.println("Testcase3_");
		new HomePage(driver).tapMoreButton()
//		.tapLink1().goBack()
//		.tapLink2().goBack()
//		.tapLink3().goBack()
//	.tapLink4().goBack()
//		.tapLink5().goBack()
//		.taplogin();
//		System.out.println("User is in more section.");
	}

	public void Testcase4_()
	{
//		System.out.println("Testcase4_");
//		new RegistrationPage(driver).tapSkipForNow().tapsocialButton();
//		System.out.println("User is on home page.");
	}

	public void Testcase5_()
	{
//		System.out.println("Testcase5_");
//		new HomePage(driver).tapShareButton().GoBack();
//		System.out.println("social page");
	} 

	public void Testcase6_()
	{
		System.out.println("Testcase6_");
		new HomePage(driver).tapLiveButton().tapPromoUrl().goBack();
		System.out.println("Top url working");
	} 

	public void Testcase7_()
	{
		System.out.println("Testcase7_");
		new HomePage(driver).tapLiveButton().tapPromoUrl().goBack();
		System.out.println("Bottom Url working");
	} 
	 


}
*/