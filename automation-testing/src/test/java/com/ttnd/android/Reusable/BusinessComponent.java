/*package com.ttnd.android.Reusable;


import com.ttnd.utilities.GlobalVar;
import com.ttnd.utilities.TestBase;

public class BusinessComponent{


	public HomeLiveScreen loginWithEmail(MobileWebDriver driver){
		SignInWithEmail signInWithEmail = new CLJScreen(driver).clickLoginWithEmail();
		signInWithEmail.sendKeysEmail(GlobalVar.LOGIN_EMAIL);
		signInWithEmail.sendKeysPassword(GlobalVar.LOGIN_PASSWORD);
		signInWithEmail.clickLetMeIn();

		return new HomeLiveScreen(driver);
	}
	
	public HomeLiveScreen loginWithEmail(MobileWebDriver driver, String Password){
		SignInWithEmail signInWithEmail = new CLJScreen(driver).clickLoginWithEmail();
		signInWithEmail.sendKeysEmail("parkash.goswami@tothenew.com");
		signInWithEmail.sendKeysPassword(Password);
		signInWithEmail.clickLetMeIn();

		return new HomeLiveScreen(driver);
	}
	
	public HomeLiveScreen logOutfromHomeLiveScreen(HomeLiveScreen homeLiveScreen, MobileWebDriver driver){
		Object object = homeLiveScreen.clickProfileAsLogIn().clickSettings().clickToConfirmLogout().clickProfileAsNotLogIn();

		if (object instanceof CommonLoginScreen) {
			TestBase.reportTestStep(true, "User has successfully logout from App", false, driver);
			return ((CommonLoginScreen) object).clickSkipTab();
		}
		else{
			TestBase.reportTestStep(true, "User NOT successfully logout from App", false, driver);
			return null;
		}

	}
}
*/