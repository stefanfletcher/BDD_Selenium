package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.reporters.EmailableReporter;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import utilities.DataReader;

public class steps {

    public ResourceBundle config;// to read config.properties
    public Logger logger;// for Logging
    String Browser;
    LoginPage Login;
    Homepage Home;
    WebDriver driver;
    List<HashMap<String, String>> datamap; //Data driven



    @Before
    public void setup() {
        config = ResourceBundle.getBundle("config");// Load config.properties
        logger = LogManager.getLogger(this.getClass());// for Logger
        Browser = config.getString("Browser");
    }

    @After
        public void tearDown(Scenario scenario) {
            System.out.println("Scenario status ======>"+scenario.getStatus());
            if(scenario.isFailed()) {
                TakesScreenshot ts=(TakesScreenshot) driver;
                byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png",scenario.getName());
            }
            driver.quit();
        }


        @Given("User Launches Browser")
    public void user_launches_browser() {
        if (Browser.equals("Chrome")) {;
            driver = new ChromeDriver();
        } else if (Browser.equals("Edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    @Given("opens URL {string}")
    public void opens_url(String url) throws InterruptedException {
        driver.get(url); // get url from config.properties file
        driver.manage().window().maximize();
        logger.info("Opened Webpage");
        Thread.sleep(2000);
    }

    @When("The user enters a valid username as {string} and password as {string}")
    public void the_user_enters_a_valid_username_as_and_password_as(String Username, String Password) {
        Login = new LoginPage(driver);
        Login.EnterUsername(Username);
        Login.EnterPassword(Password);
        logger.info("Entered Username & Password");
    }

    @When("Clicks on the Login button")
    public void clicks_on_the_login_button() throws InterruptedException {
        Login.ClickLoginSubmit();
        logger.info("Clicked Submit");
        Thread.sleep(2000);
    }

    @Then("User is navigated to MyAccount Page")
    public void user_is_navigated_to_my_account_page() throws InterruptedException {
        Thread.sleep(2000);
        Home = new Homepage(driver);
        boolean Dashboarddisplayed = Home.Userdisplayed();

        if (Dashboarddisplayed) {
            Assert.assertTrue(true);
            logger.info("Verified we hit Dashboard");
        } else {
            Assert.assertTrue(false);
            logger.info("Failed to hit Dashboard");
        }

    }
        @When("The user enters an Invalid username as {string} and password as {string}")
        public void the_user_enters_an_invalid_username_as_and_password_as(String Username, String Password) {
            Login = new LoginPage(driver);
            Login.EnterUsername(Username);
            Login.EnterPassword(Password);
            logger.info("Entered Username & Password");
        }

        @Then("User is shown invalid details message and page remains the same")
        public void user_is_shown_invalid_details_message() {
            boolean loginFailed = Login.FailedLoginError();
            if (loginFailed && driver.getPageSource() == Login.getLoginPageSource()) {
                logger.info("Login Failed & Validation Shown");
            } else {
                logger.info("Login Passed");
            }
        }

    @When("The user enters a valid username and password with excel row {string}")
    public void the_user_enters_a_valid_username_and_password_with_excel_row(String rows) {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\TestData.xlsx", "Sheet1");
        int index=Integer.parseInt(rows)-1;
        String Email = datamap.get(index).get("Email");
        String Password = datamap.get(index).get("Password");
        Login = new LoginPage(driver);
        Login.EnterUsername(Email);
        Login.EnterPassword(Password);

    }


        }
