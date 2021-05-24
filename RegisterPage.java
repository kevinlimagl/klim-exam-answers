package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class RegisterPage extends BasePage{

    public static String signIn_xpath = "//a[@title='Log in to your customer account']";
    public static String email_id = "email_create";
    public static String createAccount_xpath = "//form[@id='create-account_form']//span[1]";
    public static String email_error = "create_account_error";
    
    public static String dresses_xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
    public static String summerDresses_xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a";
    public static String printedSummerDressText_xpath = "//*[@id=\"center_column\"]/h1/span[1]";
    
    public static String quickviewDress1_xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img";
    public static String quickviewButton_xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[2]/span";
    public static String quickviewBlueVariant_id = "//*[@id=\"color_14\"]";
    public static String quickviewAddToCart_id = "//*[@id=\"add_to_cart\"]/button/span";
    public static String cartSummaryProductName_id = "layer_cart_product_title";
    public static String cartSummaryProductColourAndSize_id = "layer_cart_product_attributes";
    public static String cartSummaryProductQuantity_id = "layer_cart_product_quantity";
    
    public RegisterPage(BrowserDriver driver) {
        super(driver);
    }

    public static void openApplicaiton() {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    public static void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
    }

    public static void createAccount(String emailid) {
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }
    
    public static void verifyInvalidErrorExist() {
        driver.findElement(By.id(email_error));
    }
    
    public static void navigateToSummerDresses() throws InterruptedException {
        WebElement megaMenuDresses = driver.findElement(By.xpath(dresses_xpath));
        
        Actions action = new Actions(driver);
        action.moveToElement(megaMenuDresses).perform();
        //allowance for animation
        Thread.sleep(5000);
        driver.findElement(By.xpath(summerDresses_xpath)).click();
    }
    
    public static void verifyPrintedSummerDressTextExist() {
        driver.findElement(By.xpath(printedSummerDressText_xpath));
    }
    
    public static void addBlueSummerDressToCart() throws InterruptedException {
        WebElement quickView = driver.findElement(By.xpath(quickviewDress1_xpath));
        
        Actions action = new Actions(driver);
        action.moveToElement(quickView).perform();
        //allowance for animation
        Thread.sleep(5000);
        driver.findElement(By.xpath(quickviewButton_xpath)).click();
        Thread.sleep(5000);       
        driver.switchTo().frame(0);
        driver.findElement(By.xpath(quickviewBlueVariant_id)).click();
        driver.findElement(By.xpath(quickviewAddToCart_id)).click();;    
    }
    
    public static void verifyCartItems() {
        driver.findElement(By.id(cartSummaryProductName_id));
        driver.findElement(By.id(cartSummaryProductColourAndSize_id));
        driver.findElement(By.id(cartSummaryProductQuantity_id));
    }
}
