package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Pages.OptionsPage;

public class OptionPageTestCases extends BasePage {

	public OptionPageTestCases() {

		super();
	}

	private OptionsPage optionsPage;

	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp() {

		intilizeConfiguration();
		optionsPage = new OptionsPage();
		driver.get(prop.getProperty("extensionOptionsTestUrl"));

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {

		closeConfiguration();
	}

	@Test(priority = 1, groups = { "Smoke" })
	public void optionsPageLogoVerifcationTest() {

		test.get().info("Verifying the logo image of the Options page.");
		assertTrue(optionsPage.isLogoVisible(), "Logo is not present on the Options page.");
		test.get().info("Logo verification successful.");

	}

	@Test(priority = 2, groups = { "Smoke" })
	public void optionPageHeaderTitleVerifcationTest() {

		test.get().info("Verifying the header title of the Options page.");
		String expectedTitleText = optionsPage.getOptionPageTitleText();
		String actualTitleText = "Extension Options";
		assertEquals(expectedTitleText, actualTitleText, "Header title does not match the expected value.");
		test.get().info("Header title verification successful.");

	}

	@Test(priority = 3, groups = { "Sanity" })
	public void allCheckBoxFunctioanlityTest() {

		test.get().info("Selecting all checkboxes on the Options page.");
		optionsPage.selectAllCheckBoxes();
		test.get().info("All checkboxes have been selected successfully.");

	}

	@Test(priority = 4, groups = { "Sanity", "Regression" })
	public void changeDectionaryLanguageTest() {

		test.get().info("Changing the dictionary language.");
		optionsPage.selectLanguageOptions("Hindi");
		test.get().info("Language option selected successfully.");
		optionsPage.clickOnSaveButton();
		test.get().info("Save button clicked.");
		assertTrue(optionsPage.isSaveStatusVisible(), "Save status is not visible after changing the language.");
		test.get().info("Language change and save verification successful.");

	}

}
