package stepDefinitions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.lexer.Th;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.runner.RunWith;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }


    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^Navigate to url \"([^\"]*)\"$")
    public void navigateToUrl(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
    }

//  Task1
    @Given("^I enter the base page$")
    public void iEnterTheBasePage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }
//  Task1
    @Given("^I navigate to base page$")
    public void iNavigateToBasePage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter the text: \"([^\"]*)\"$")
    public void iEnterTheText(String text) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(text);
    }

    @And("^I click submit input text$")
    public void iClickSubmitInputText() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void iSeeAMessage(String message) throws Throwable {
        String actualMessage = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(message, actualMessage);
    }
    //Task2

    @When("^I am on the basepage$")
    public void iAmOnTheBasePAge () {
        driver.get ("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^I click Add$")
    public void iClickAdd() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And ("^I enter new name$")
    public void iEnterNewName () throws Throwable {
        driver.findElement(By.id("name")).sendKeys("Alek");
    }

    @And ("^I enter new surname$")
    public void iEnterNewSurname () throws Throwable {
        driver.findElement(By.id("surname")).sendKeys("Volk");
    }

    @And("^I enter new job$")
    public void iEnterNewJob () throws Throwable {
        driver.findElement(By.id("job")).sendKeys("CEO");
    }

    @And("^I enter new dob$")
    public void iEnterNewDob () throws Throwable{
        driver.findElement(By.id("dob")).sendKeys("10/10/1970");
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        dateWidget.findElement(By.className("ui-state-default")).click();
    }

    @And("^I enter new language$")
    public void iEnterNewLanguage () throws Throwable{
        By.cssSelector("#english").findElement(driver).click();
    }

    @And("^I enter new gender$")
    public void iEnterNewGender () throws Throwable{
        driver.findElement(By.id("male")).click();
    }

    @And("^I enter new status$")
    public void iEnterNewStatus () throws Throwable{
        Select statusDropdown = new Select(driver.findElement(By.id("status")));
        statusDropdown.selectByIndex(1);
    }

    @And("^I click add button$")
    public void iClickAddButton () throws Throwable{
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^Person is added$")
    public void personIsAdded() throws Throwable{
        assertEquals("https://kristinek.github.io/site/tasks/list_of_people.html", driver.getCurrentUrl());
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());
    }

    @When("^I click pencil$")
    public void iClickPencil() throws Throwable{
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
    }
    @And ("^I edit surname$")
    public void iEditSurname() throws Throwable{
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("Burn");
    }

    @And("^I press edit button$")
    public void iPressEditButton() throws Throwable{
        Thread.sleep(5000);
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I see edited person")
    public void iSeeEditedPerson() throws Throwable{
        assertEquals("https://kristinek.github.io/site/tasks/list_of_people.html", driver.getCurrentUrl());
        String editedName = driver.findElement(By.xpath("//*[@id=\"person0\"]/div/span[2]")).getText();
        assertTrue(editedName.contains("Burn"));
    }

    @When("^I click cross$")
    public void iClickCross () throws Throwable {
        Thread.sleep(20000);
        WebElement cross = driver.findElement(By.cssSelector("#person0 > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium"));
        assertTrue(cross.isEnabled());
        cross.click();
    }

    @Then("^I do not see a person$")
    public void iDoNotSeeAPerson() throws Throwable{
        assertEquals("https://kristinek.github.io/site/tasks/list_of_people.html", driver.getCurrentUrl());
        String textInBox = driver.findElement(By.className("w3-container")).getText();
        assertFalse(textInBox.contains("Mike"));
    }

    @And("^I press reset list$")
    public void iPressResetList() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @Then("^I do not see a new person$")
    public void iDoNotSeeANewPerson() throws Throwable{
        String textInBox = driver.findElement(By.className("w3-container")).getText();
        assertFalse(textInBox.contains("Alek"));
    }

    @Then("^I do not see edited person$")
    public void iDoNotSeeEditedPerson () throws Throwable {
        String textInBox = driver.findElement(By.className("w3-container")).getText();
        assertFalse(textInBox.contains("Burn"));
    }

    @Then("^I see a deleted person$")
    public void iSeeADeletedPerson () throws Throwable{
        String textInBox = driver.findElement(By.xpath("/html/body/div[3]")).getText();
        //Thread.sleep(15000);
        //assertTrue(textInBox.contains("Mike"));
        Thread.sleep(20000);
        assertTrue(textInBox.contains("Mike"));
    }

    @And("^I click clear button$")
    public void iClickClearButton () throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @Then ("^Person form is empty$")
    public void personFormIsEmpty () throws Throwable{
        assertNull(driver.findElement(By.xpath("//*[@id='addEditPerson']")).getAttribute("value"));
    }
}


