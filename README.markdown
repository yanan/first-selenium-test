# First selenium test

## This is a test project for a sample liferay forms
https://forms.liferay.com/web/forms/shared/-/form/122548

## Java and Browser
Java 1.8
Firefox 98.0 (64-bit)

## Run tests
Use the following command to run tests in the command line:

```
$ ./gradlew clean test
```

## Test Duration
Within 2 min

## Key test functions
- submit forms
- submit again to submit new forms
- select a date using date-picker
- switch language

## More about the project

- Use junit 4
- There are two test cases in `AcceptanceTest.java` file
- Mainly using cssSelector and absolut XPath locators(Need more search on improvements)
- The tests need to be updated once existing bugs fixed
- Ignore bugs to ensure test scripts can work and run successfully for now
