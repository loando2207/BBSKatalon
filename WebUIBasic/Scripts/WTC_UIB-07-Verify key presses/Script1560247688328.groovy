import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def _Tab = Keys.TAB

def _Enter = Keys.ENTER

def _Character = 'G'

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

WebDriver _driver = DriverFactory.getWebDriver()

Actions _actions = new Actions(_driver)

'Select Key Presses link'
WebUI.click(findTestObject('Page_The Internet/lnk_Key presses'))

'Verify Key Presses header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Key Presses')

'Presses ENTER key'
_actions.sendKeys(_Enter).build().perform()

'Verify the result message: You entered: ENTER'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: ENTER')

'Presses TAB key'
_actions.sendKeys(_Tab).build().perform()

'Verify the result message: You entered: TAB'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: TAB')

'Presses G key'
_actions.sendKeys(_Character).build().perform()

'Verify the result message: You entered: G'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: '+_Character)

WebUI.closeBrowser()

