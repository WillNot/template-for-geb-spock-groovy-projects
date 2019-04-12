import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

baseUrl = "http://webdev4.mutualofomaha.com/SeleniumTestPages/"

String chromeDriverName = System.getProperty("os.name").contains("Windows") ? "chromedriver.exe" : "chromedriver";
String geckoDriverName = System.getProperty("os.name").contains("Windows") ? "geckodriver.exe" : "geckodriver";


driver = {System.properties << ["webdriver.chrome.driver": System.getProperty("user.dir") + "/src/functional-test/resources/$chromeDriverName"]
          new ChromeDriver()}

environments {
    // when system property 'geb.env' is set to 'chrome' use a chrome driver
    chrome {
        driver = {
            System.properties << ["webdriver.chrome.driver": System.getProperty("user.dir") + "/src/functional-test/resources/$chromeDriverName"]
            new ChromeDriver()
        }
    }

    // when system property 'geb.env' is set to 'firefox' use a gecko driver
    firefox {
        driver = {
            String geckoDriverLocation = System.getProperty("user.dir") + "/src/functional-test/resources/$geckoDriverName";
            System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
            driver = new FirefoxDriver();
        }
    }
}

    waiting {
            timeout = 10
            retryInterval = 0.5
            presets {
                slow {
                    timeout = 20
                    retryInterval = 0.05
                }
                quick {
                    timeout = 1
                    retryInterval = 0.05
                }
            }
}

