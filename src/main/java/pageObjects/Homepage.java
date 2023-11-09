package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends Base_Class {

    // Instantiate
    public Homepage(WebDriver driver) {
        super(driver);
    }

    //Elements
    private final By Userdisplayed = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By MyAccount = By.xpath("//span[normalize-space()='My Account']");
    private final By Register = By.xpath("//a[normalize-space()='Register']");
    private final By Login = By.xpath("//a[normalize-space()='Login']");
    private final By Currency = By.xpath("//span[normalize-space()='Currency']");
    private final By Logo = By.xpath("//img[@title='Your Store']");
    private final By Macwishlist = By.xpath("//div[@id='content']//div[1]//form[1]//div[1]//div[2]//div[2]//button[2]");
    private final By WishlistNotloggedin = By.xpath("//*[@id=\"alert\"]/div/a[4]");
    private final By MacAddtoCart = By.xpath("//div[@id='content']//div[1]//form[1]//div[1]//div[2]//div[2]//button[1]");
    private final By MacFeaturedProductPrice = By.xpath("/html/body/main/div[2]/div/div/div[2]/div[1]/form/div/div[2]/div[1]/div/span[1]");
    private final By MacinBasketPrice = By.xpath("//html[1]/body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/button[1]");
    private final By BasketCheckout = By.xpath("//strong[normalize-space()='Checkout']");


    public void AddMactoCart() {
        driver.findElement(MacFeaturedProductPrice).click();
    }
    public void SelectCart() {
        driver.findElement(MacinBasketPrice).click();
    }
    public void ClickBasketCheckout() {
        driver.findElement(BasketCheckout).click();
    }

    public String MacFeaturedProductPrice() {
        String featuredProductPriceText = driver.findElement(MacFeaturedProductPrice).getText();
        int index = featuredProductPriceText.indexOf('$');
        String MacFeaturedProductPrice$ = featuredProductPriceText.substring(index + 1);
        return MacFeaturedProductPrice$;

    }

    public String MacinBasketPrice() {
        String inBasketPriceText = driver.findElement(MacinBasketPrice).getText();
        int index2 = inBasketPriceText.indexOf('$');
        String Macpriceafter$ = inBasketPriceText.substring(index2 + 1);
        return Macpriceafter$;
    }


    public void ClickMyAccount() {
        driver.findElement(MyAccount).click();
    }
    public void RegisterAccount() {
        driver.findElement(Register).click();
    }
    public void LogintoAccount() {
        driver.findElement(Login).click();
    }
    public void SelectCurrency() {
        driver.findElement(Currency).click();
    }
    public void ClickLogo() {
        driver.findElement(Logo).click();
    }
    public void ClickMacWishlist() {
        driver.findElement(Macwishlist).click();
    }
    public void ClickWishlistnotloggedin() {
        driver.findElement(WishlistNotloggedin).click();

    }


    public Boolean Userdisplayed() {
        Boolean Userdisplayedvisable = driver.findElement(Userdisplayed).isDisplayed();
        return Userdisplayedvisable;
    }

}

