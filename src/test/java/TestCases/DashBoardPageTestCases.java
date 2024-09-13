package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Pages.DashboardPage;

public class DashBoardPageTestCases extends BasePage {

	public DashBoardPageTestCases() {

		super();
	}

	private DashboardPage dashboardPage;

	@BeforeMethod(groups = { "Sanity" })
	public void setUp() {

		intilizeConfiguration();
		dashboardPage = new DashboardPage();
		driver.get(prop.getProperty("extensionActionsTestUrl"));
	}

	@AfterMethod(groups = { "Sanity" })
	public void tearDown() {

		closeConfiguration();
	}

	@Test(groups = { "Sanity" })
	public void searchTest() {

		test.get().info("Starting search test: entering input in the search field.");
		dashboardPage.enterInputInSearchFiled("Hello");
		test.get().info("Input 'Hello' entered in the search field.");

		test.get().info("Clicking on the Define button.");
		dashboardPage.clickOnDefineButton();
		test.get().info("Define button clicked.");

		assertTrue(dashboardPage.isheadWordVisible(), "Head word is not visible after searching the word.");
		test.get().info("Head word is visible after searching the word.");

		test.get().info("Search test completed successfully.");

	}

}
