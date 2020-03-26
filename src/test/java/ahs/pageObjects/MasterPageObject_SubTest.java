package ahs.pageObjects;

import ahs.Screens.MasterScreen_SubTest;
import ahs.support.BrowserFactory;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class MasterPageObject_SubTest extends basePage{
     WebDriver driver;
    MasterScreen_SubTest masterScreen_subTest=new MasterScreen_SubTest();
    public MasterPageObject_SubTest(){
        driver= BrowserFactory.getBrowser();
        PageFactory.initElements(driver,masterScreen_subTest);
    }
    public void validateSubTest(){
       masterScreen_subTest.subtest_link.click();
    }
    public String verifyPageText() throws InterruptedException {
        Thread.sleep(2000);
        return masterScreen_subTest.page_text.getText();
    }
    public String validateReturnPage(){
        return driver.getCurrentUrl();
    }
    public String verifySubTestPage() throws InterruptedException {
        return masterScreen_subTest.subTestPage_text.getText();
    }
    public void useDeleteButton(){
        masterScreen_subTest.delete_btn.click();
        driver.switchTo().alert().accept();

    }
    public String validateErrorMsg(){
        String alert=masterScreen_subTest.errorMassge.getText();
        System.out.println(alert);
        if (alert.contains("Oops!Unable to delete")){
            driver.navigate().to("http://ahs.bananaapps.co.uk/Master/SubTestPricesList");
        }else {
            System.out.println("false");
        }
      return alert;
    }
    public void validateAddButton(){
        masterScreen_subTest.add_btn.click();
    }

    public void addDetailsInMainTest(String subtest,String price) throws InterruptedException {
        WebElement element =masterScreen_subTest.select_test;
        Select select=new Select(element);
        List<WebElement> list=select.getOptions();
        int noOfItem=list.size();
        Random num=new Random();
        int iSelect=num.nextInt(noOfItem);
        select.selectByIndex(iSelect);
        Thread.sleep(2000);
        masterScreen_subTest.subtest_name.sendKeys(subtest);
        masterScreen_subTest.test_price.clear();
        masterScreen_subTest.test_price.sendKeys(price);
    }

    public void enterDataToTable(DataTable table) throws InterruptedException {//for(List<String> rowData:data)


        List<List<String>> data = table.raw();
        //int i=0;
        for(int i=0;i<data.size();i++) {
            driver.findElement(By.cssSelector("#SubUntervals_"+i+"__Units")).sendKeys(data.get(i).get(1));
            driver.findElement(By.cssSelector("#SubUntervals_"+i+"__MaleIntervals")).sendKeys(data.get(i).get(2));
            driver.findElement(By.cssSelector("#SubUntervals_"+i+"__FeMaleIntervals")).sendKeys(data.get(i).get(3));
        }

        /*
        List<List<String>> data = table.raw();
        for(int i=0;i<5;i++){
            for(int j=1;j<data.size();j++){
                driver.findElement(By.cssSelector("#SubUntervals_"+i+"__Units")).sendKeys(data.get(j).get(1));
                driver.findElement(By.cssSelector("#SubUntervals_"+i+"__MaleIntervals")).sendKeys(data.get(j).get(2));
                driver.findElement(By.cssSelector("#SubUntervals_"+i+"__FeMaleIntervals")).sendKeys(data.get(j).get(3));
            }
        }
         */




        //old style for each cell
      /*  for (int i=0;i<data.size();i++) {
            driver.findElement(By.cssSelector("#SubUntervals_0__Units")).sendKeys(data.get(1).get(1));
            driver.findElement(By.cssSelector("#SubUntervals_1__Units")).sendKeys(data.get(2).get(1));
            driver.findElement(By.cssSelector("#SubUntervals_2__Units")).sendKeys(data.get(3).get(1));
            driver.findElement(By.cssSelector("#SubUntervals_3__Units")).sendKeys(data.get(4).get(1));

            driver.findElement(By.cssSelector("#SubUntervals_0__MaleIntervals")).sendKeys(data.get(1).get(2));
            driver.findElement(By.cssSelector("#SubUntervals_1__MaleIntervals")).sendKeys(data.get(2).get(2));
            driver.findElement(By.cssSelector("#SubUntervals_2__MaleIntervals")).sendKeys(data.get(3).get(2));
            driver.findElement(By.cssSelector("#SubUntervals_3__MaleIntervals")).sendKeys(data.get(4).get(2));

            driver.findElement(By.cssSelector("#SubUntervals_0__FeMaleIntervals")).sendKeys(data.get(1).get(3));
            driver.findElement(By.cssSelector("#SubUntervals_1__FeMaleIntervals")).sendKeys(data.get(2).get(3));
            driver.findElement(By.cssSelector("#SubUntervals_2__FeMaleIntervals")).sendKeys(data.get(3).get(3));
            driver.findElement(By.cssSelector("#SubUntervals_3__FeMaleIntervals")).sendKeys(data.get(4).get(3));

        }

        */
    }
    public void validateSubmiteBtn(){
        masterScreen_subTest.submit_button.click();
    }

}
