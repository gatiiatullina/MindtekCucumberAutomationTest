package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;


public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();
    EtsyHomePage etsyHomePage = new EtsyHomePage();
    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
       driver.get(ConfigReader.getProperty("EtsyURL"));
    }

    @When("User searches for {string}")
    public void user_searches_for(String itemName) {
        etsyHomePage.searchBar.sendKeys(itemName + Keys.ENTER);
    }
    @Then("User validates search result contains {string}")

    public void user_validates_search_result_contains(DataTable data) { //( use DataBase (carpet, rug, turkish, persian) instead of String f you need to check different names)
       List<String> keywords = data.asList();
        for (WebElement item : etsyHomePage.items){
           String itemDescription = item.getText();
           boolean isFound=false;
           String wordNotFound="";
           for(int i=0; i<keywords.size(); i++){
               if(itemDescription.toLowerCase().contains(keywords.get(i))){
                   isFound=true;
               }else{
                   wordNotFound= keywords.get(i);
               }
           }
           Assert.assertTrue("["+itemDescription+"] doesn't contain keyword: "+wordNotFound+"]", isFound);
       }
//        List<String> itemNames = dataTable.asList();
//        System.out.println(itemNames.get(0)); // 0 takes first name from data, 1 takes second
    }
    @When("User selects price range over {int}")
    public void user_selects_price_range_over(Integer priceRange) {
        etsyHomePage.allFiltersBtn.click();
//        BrowserUtils.scrollDownBy(1000);
//        BrowserUtils.waitForElementToBeClickable(etsyHomePage.over1000Btn);
        etsyHomePage.over1000Btn.click();
        etsyHomePage.applyBtn.click();
    }

    @Then("User validates price range for items over {double}")
    public void user_validates_price_range_for_items_over(Double priceRange) {
        driver.navigate().refresh();
        for (WebElement price : etsyHomePage.prices) {
            System.out.println(price.getText());
            Double priceDouble = Double.parseDouble(price.getText().replace(",",""));
            Assert.assertTrue(priceDouble+" is less than "+priceRange,priceDouble>=priceRange);
        }
    }
    @When("User click on {string} module")
    public void user_click_on_module(String module) {
        switch (module) {
            case "Fashion Favorites":
                etsyHomePage.fashionFavoritesTab.click();
                break;
            case "Jewelry & Accessories":
                etsyHomePage.jewelryAccessoriesTab.click();
                break;
            case "Clothing & Shoes":
                etsyHomePage.clothingShoesTab.click();
                break;
            case "Home & Living":
                etsyHomePage.homeLivingTab.click();
                break;
            case "Wedding & Party":
                etsyHomePage.weddingPartyTab.click();
                break;
            case "Toys & Entertainment":
                etsyHomePage.toysEntertainmentTab.click();
                break;
            case "Art & Collectibles":
                etsyHomePage.artCollectiblesTab.click();
                break;
            case "Craft Supplies & Tools":
                etsyHomePage.craftSuppliesTab.click();
                break;
            case "Gifts & Gift Cards":
                etsyHomePage.giftCardsTab.click();
                break;
        }

    }

    @Then("User validates the {string}")
    public void user_validates_the(String title) {
        Assert.assertEquals("Title is incorrect", title, driver.getTitle());
    }
}
