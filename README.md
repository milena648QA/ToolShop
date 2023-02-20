# javaSelenium
Default Java Selenium project

Create new java class in tests package which extends BaseTest. (as in ProbnaKlasaTest)
BaseTest will start Chrome before each test and close it after.
Create JUnit @Test annotation and create a method bellow.
You have run test button next to method signature.
You can use variable driver (as WebDriver) and wdWait (as WebDriverWait)
which are inherited from BaseHelper.
Each page/helper class should extend BaseHelper.

Chromedriver (https://chromedriver.chromium.org/downloads) for appropriate version 
for your chrome should be downloaded and extracted to root (next to pom.xml).

## Dependencies and tools
<p>
<img src="http://icons.iconarchive.com/icons/tatice/cristal-intense/128/Java-icon.png" alt="Java" width="" height="64">
<img src="https://i2.wp.com/blog.knoldus.com/wp-content/uploads/2020/01/TESTNG.png" alt="TestNG" width="" height="64">
<img src="https://www.seleniumhq.org/images/selenium-logo.png" alt="Selenium" width="" height="64">
<img src="https://www.seleniumhq.org/images/selenium-grid-logo.png" alt="Selenium Grid" width="" height="64">
<img src="https://miro.medium.com/max/620/1*DQG6VNUYTQdTxeK9tvH0Rg.png" alt="Cucumber" width="" height="64">
<img src="https://img.icons8.com/color/160/intellij-idea.png" alt="Intellij IDEA" width="" height="64">
</p>


# Requirements (Mac OS X operating system)

## Intellij IDEA as IDE
As a IDE for project [IDEA](https://www.jetbrains.com/idea) is used. Download can be found in [link](https://www.jetbrains.com/idea/download/#section=mac).
Upon installing additional steps are required:
* Lombok plugin - Installation of this plugin is done in Plugins section of IDE. Go to Preferences > Plugins and from Marketplace search for Lombok and install it.

## JDK 11
As programming language Java 11 is required. Install instruction is on [link](https://confluence.tx.group/display/PMDQA/Install+multiple+JDKs+on+Big+Sur).

## Maven
Maven is installable via brew. Installing brew is done with command:

```/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"```

and upon successful installing brew maven is installed via command:

```
brew update
brew install maven
``` 

As additional check that Maven is installed and functional you can run command:

```mvn -version```

## Run tests
Tests can be run manually with command:

```mvn clean test -P TestSuite```

Additional configuration can be changed inside TestNG's suite XML configuration.

For different runs use command:

```mvn clean test -P TestSuite -DserviceProvider=SauceLabs -Dplatform=win10 -Dbrowser=chrome -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=SauceLabs -Dplatform=win10 -Dbrowser=firefox -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=SauceLabs -Dplatform=mojave -Dbrowser=chrome -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=SauceLabs -Dplatform=mojave -Dbrowser=safari -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=BrowserStack -Dplatform=windows -DplatformVersion=10 -Dbrowser=chrome -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=BrowserStack -Dplatform=windows -DplatformVersion=10 -Dbrowser=firefox -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=BrowserStack -Dplatform='OS X' -DplatformVersion='Big Sur' -Dbrowser=chrome -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```

```mvn clean test -P TestSuite -DserviceProvider=BrowserStack -Dplatform='OS X' -DplatformVersion='Big Sur' -Dbrowser=safari -DbrowserVersion=latest -Djava.util.logging.config.file=logging.properties```