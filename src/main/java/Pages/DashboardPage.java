package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Utils.TestUtils;

public class DashboardPage extends BasePage {

	public DashboardPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "query-field")
	WebElement searchField;

	@FindBy(id = "define-btn")
	WebElement defineButton;

	@FindBy(xpath = "//span[@class=\"headword\"]")
	WebElement headWord;

	public void enterInputInSearchFiled(String inputValue) {

		TestUtils.waitUntilVisibilityOfElement(searchField, 10);

		try {

			searchField.sendKeys(inputValue);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickOnDefineButton() {

		TestUtils.waitUntilElementToBeClickable(defineButton, 10);

		try {

			defineButton.click();

		} catch (Exception e) {

			TestUtils.JavascriptClick(defineButton);
		}

	}

	public boolean isheadWordVisible() {

		TestUtils.waitUntilVisibilityOfElement(headWord, 10);
		return headWord.isDisplayed();
	}

}
