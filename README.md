# elfie
### Requirement
The following packages need to be installed:
- brew install node  
- brew install maven
- brew install allure 
- npm i --location=global appium
- appium driver install uiautomator2
- brew install --cask android-platform-tools
Make sure $ANDROID_HOME is exported to directory which contains android platform tools  
### How to run
- Make sure your test device is plugged in or if you are using simulator, make sure it turned on
- Install the test .apk into the device
- If you want the apk installed automatically, you can first downnload the apk and change the device capabilities: remove appPackage and appActivity, add app which value is the directory to the apk file 
- Run with CLI: 
  - To run test: _maven test_
  - After test run is finished, it will generate allure-results folder which is the report data
  - To generate allure report: _allure serve allure-results_
- Run with IDE (IntelliJ) for debugging:
  - Run as TestNG
  - Make sure ANDROID_HOME is set as Environment Variables
- Screenshots will be attached in allure report. They are also saved in folder target/screenshots
### Demos 
- Test run record:
https://github.com/thangatran/elfie/assets/5816644/727f0f4d-0076-4848-b047-b220c328c4c4
- Allure report 
![image](https://github.com/thangatran/elfie/assets/5816644/940c7fe0-aa54-45a9-8606-99ea0a97a46d)
