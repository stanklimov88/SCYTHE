# SCYTHE

> The Most Beautiful Testing Framework You Have Ever Seen

No bullshit, only what you need
- Selenium for browser automation
- Selenide for simplicity and stability
- And one Cucumber to [rule them all](https://github.com/tsundberg/gradle-cucumber-runner)

Provided with fully functional test project, so you can understand the basics and play around a little

### Run it

    ./gradlew cucumber


### Run it clean

    ./gradlew clean cucumber


### Run it fast

    ./gradlew clean cucumber --threads 2


### Run it with different browsers

    ./gradlew clean cucumber -Dselenide.browser=chrome

    ./gradlew clean cucumber -Dselenide.browser=firefox

    ./gradlew clean cucumber -Dselenide.browser=safari


### Run it against different environments

    ./gradlew clean cucumber -Dselenide.baseUrl=https://your-staging-server.com/

    ./gradlew clean cucumber -Dselenide.baseUrl=https://your-production-server.com/


### Use tags simply

    ./gradlew clean cucumber --tags @smoke

    ./gradlew clean cucumber --tags "not @flaky"


### Use tags smart

    ./gradlew clean cucumber -Dcucumber.filter.tags="@regression and not (@flaky or @wip)"


### See reports and screenshots

    open build/reports/cucumber-report.html

    open build/reports/execution-timeline/index.html

    open build/reports/tests


### Have fun


