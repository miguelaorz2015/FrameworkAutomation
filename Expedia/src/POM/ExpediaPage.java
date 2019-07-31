package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExpediaPage {
	private static WebElement element = null;
    private static List<WebElement> elementlist = null;
    
    public static WebElement FlightTab(WebDriver driver){	
     element = driver.findElement(By.id("tab-flight-tab-hp"));
     return element;
     }
    
    public static WebElement FlightSource(WebDriver driver){	
        element = driver.findElement(By.id("flight-origin-hp-flight"));
        return element;
        }

    public static WebElement FlightDestination(WebDriver driver){	
        element = driver.findElement(By.id("flight-destination-hp-flight"));
        return element;
        }
    
    public static WebElement FlightDepartingDate(WebDriver driver){	
        element = driver.findElement(By.id("flight-departing-hp-flight"));
        return element;
        }
    
    public static WebElement FlightReturningDate(WebDriver driver){	
        element = driver.findElement(By.id("flight-returning-hp-flight"));
        return element;
        }
    
    public static WebElement DateCloseButton(WebDriver driver){	
        element = driver.findElement(By.cssSelector("button.datepicker-close-btn.close.btn-text"));
        return element;
        }
    
    public static WebElement FlightSearch(WebDriver driver){	
        element = driver.findElement(By.cssSelector("button.btn-primary.btn-action.gcw-submit"));
        return element;
        }
    
    public static WebElement FlightSort(WebDriver driver){	
        element = driver.findElement(By.id("sortDropdown"));
        return element;
        }
    
    public static WebElement FlightSelect(WebDriver driver){	
        element = driver.findElement(By.cssSelector("button.btn-secondary.btn-action.t-select-btn"));
        return element;
        }
    
    public static WebElement FlightSelectFair(WebDriver driver){	
        element = driver.findElement(By.cssSelector("div.basic-economy-footer.uitk-grid.all-grid-align-end > button.btn-secondary.btn-action.t-select-btn"));
        return element;
        }
 
    public static WebElement Nothanks(WebDriver driver){	
        element = driver.findElement(By.id("forcedChoiceNoThanks"));
        return element;
        }
    
    public static WebElement FlightBook(WebDriver driver){	
    	element = driver.findElement(By.cssSelector("#bookButton"));
        //element = driver.findElement(By.id("bookButton"));
        return element;
        }
    
}
