package com.ttnd.android.americanswan.HomeScreen;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ttnd.utilities.TestBase;
import org.openqa.selenium.By;

import com.ttnd.android.americanswan.BaseScreens.BaseScreen;
import com.ttnd.android.americanswan.Login.SignInScreen;
import com.ttnd.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AccountOverviewScreen extends BaseScreen {
	public AccountOverviewScreen(AppiumDriver<MobileElement> driver) {
		super(driver, MyAcountlocator);

	}

	public boolean VerifyAccountName(String Email){
		String AccountName = Email.split("@")[0];
		String LoggedInAccountName = Keywords.GetElementText(driver, GetAccountName);
		System.out.println("Value = " +AccountName.contains(LoggedInAccountName.split(" ")[1]));
		if(AccountName.contains(LoggedInAccountName.split(" ")[1])){
			Keywords.reportTestStep(true, "Sucessfully Login to American Swan Account with Account : " + AccountName , false, driver);
			return true;
		}
		else{
			Keywords.reportTestStep(false, "Not Login to American Swan Account with Account : " + AccountName , true, driver);
			return false;
		}	
	}

	/*public MyAcountScreen clickMyAcount(){
		Keywords.clickElementByID(driver, MyAcountlocator);
		//TestBase.reportTestStep(true, "Clicked on Hamburger icon on Home Screen", false, driver);

		return new MyAcountScreen(driver);
	}*/

	public HomeScreen clickSignOutButton(){

		TestBase.reportTestStep(true, "Clicked on Sign In / Out Button of Account Overview Screen", false, driver);
		Keywords.clickElement(driver, SignInlocator);

		return new HomeScreen(driver);
	}

	public SignInScreen clickSignInButton(){

		TestBase.reportTestStep(true, "Clicked on Sign In / Out Button of Account Overview Screen", false, driver);
		Keywords.clickElement(driver, SignInlocator);

		return new SignInScreen(driver);
	}



	public boolean getSignInStatus(){

		if(Keywords.GetElementText(driver, SignInlocator).equalsIgnoreCase("Sign out"))
			return true;
		return false;

	}

	/*public WalletAndMoneyScreen clickWalletAndMoney(){
		Keywords.clickElementByID(driver, WalletAndMoneylocator);
		//TestBase.reportTestStep(true, "Clicked on My Account on Home Screen", false, driver);

		return new WalletAndMoneyScreen(driver);
	}
	public ReportAnIssueScreen clickReportAnIssue(){
		Keywords.clickElementByID(driver, ReportAnIssuelocator);
		//TestBase.reportTestStep(true, "Clicked on My Account on Home Screen", false, driver);

		return new ReportAnIssueScreen(driver);
	}*/
	static By MyAcountlocator = By.id("com.americanswan:id/btn_account");
	By WalletAndMoneylocator = By.id("com.americanswan:id/btn_wallet");
	By SignInlocator = By.id("com.americanswan:id/btn_sign_out");
	By ReportAnIssuelocator = By.id("com.americanswan:id/pager_indicator_layout");
	By GetAccountName = By.id("com.americanswan:id/textViewMyaccount");





}
