package com.ttnd.testScripts;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ttnd.utilities.GlobalVar;
import com.ttnd.android.americanswan.HomeScreen.AccountOverviewScreen;
import com.ttnd.android.americanswan.HomeScreen.HomeScreen;
import com.ttnd.android.americanswan.Login.SignInScreen;
import com.ttnd.utilities.Keywords;
import com.ttnd.utilities.TestBase;

public class LoginTest extends TestBase {

	//Login into Account with Username and Password
	@Test(groups = { "Sanity" }) 
	public void loginwithEmail() {


		HomeScreen homePage = new HomeScreen(dr);
		AccountOverviewScreen accountOverviewScreen = homePage.clickAccountOverview();


		if (accountOverviewScreen.getSignInStatus()){
			reportTestStep(true, "Accout is already logged in ", false, dr);
			accountOverviewScreen = accountOverviewScreen.clickSignOutButton().clickAccountOverview();
		}

		SignInScreen signInScreen = accountOverviewScreen.clickSignInButton();
		signInScreen.sendKeysEmail(GlobalVar.LOGIN_EMAIL);
		signInScreen.sendKeysPassword(GlobalVar.LOGIN_PASSWORD);
		if(signInScreen.clickSignIn().clickAccountOverview().VerifyAccountName(GlobalVar.LOGIN_EMAIL)){
			reportTestStep(true, "Accout is already logged in ", false, dr);
		}
		else{
			reportTestStep(true, "Accout is NOT logged in ", true, dr);
		}

	}

	//Logout From App
	//@Test(groups = { "Sanity" }) 
	public void ProductNavigation() {

		HomeScreen homePage = new HomeScreen(dr);
		//homePage.clickAccountOverview().clickSignIn().LoginwithEmail(GlobalVar.LOGIN_EMAIL, GlobalVar.LOGIN_PASSWORD);
	}
}