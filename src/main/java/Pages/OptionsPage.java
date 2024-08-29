package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Utils.TestUtils;

public class OptionsPage extends BasePage {

	public OptionsPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\"Google Dictionary\"]")
	WebElement logoImage;

	@FindBy(xpath = "//div[@id=\"title\"]//div[text()=\"Extension Options\"]")
	WebElement optionPageText;

	@FindBy(id = "language-selector")
	WebElement languageSelector;

	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	List<WebElement> allCheckBoxes;

	@FindBy(id = "save-btn-")
	WebElement saveButton;

	@FindBy(id = "save-status")
	WebElement saveStatus;

	@FindBy(xpath = "//select[@id=\"language-selector\"]//option")
	List<WebElement> laguageList;

	@FindBy(xpath = "//div[@class=\"option-value\"]")
	WebElement openLanguageSelectorDropdown;

	public boolean isLogoVisible() {

		TestUtils.waitUntilVisibilityOfElement(logoImage, 10);
		return logoImage.isDisplayed();
	}

	public String getOptionPageTitleText() {

		TestUtils.waitUntilVisibilityOfElement(optionPageText, 10);
		return optionPageText.getText();

	}

	public void selectAllCheckBoxes() {

		try {

			for (WebElement checkboxes : allCheckBoxes) {

				if (!checkboxes.isSelected()) {

					TestUtils.waitUntilVisibilityOfElement(checkboxes, 10);
					checkboxes.click();

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void clickOnSaveButton() {

		TestUtils.waitUntilVisibilityOfElement(saveButton, 10);

		try {

			saveButton.click();

		} catch (Exception e) {

			TestUtils.JavascriptClick(saveButton);
		}

	}

	public boolean isSaveStatusVisible() {

		TestUtils.waitUntilVisibilityOfElement(saveStatus, 10);
		return saveStatus.isDisplayed();
	}

	public void selectLanguageOptions(String value) {

		openLanguageSelectorDropdown.click();

		for (WebElement language : laguageList) {

			if (language.getText().contains(value)) {

				language.click();
				break;
			}
		}
	}
}
