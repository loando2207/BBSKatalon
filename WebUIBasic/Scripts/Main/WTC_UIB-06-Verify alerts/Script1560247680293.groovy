import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_JavaScript Alerts', ('_Title') : 'JavaScript Alerts'], FailureHandling.STOP_ON_FAILURE)

'Click Click for JS Alert button'
WebUI.click(findTestObject('Alerts/btn_JSAlert'))

'Verify \'I am a JS Alert\' message is displayed\r\n'
WebUI.verifyEqual(WebUI.getAlertText(), 'I am a JS Alert')

if (DriverFactory.getExecutedBrowser() == WebUIDriverType.EDGE_DRIVER) WebUI.delay(GlobalVariable.ShortTime)

'Click OK button to close Alert'
WebUI.acceptAlert()

'Verify the result message: You successfuly clicked an alert'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You successfuly clicked an alert')

if (DriverFactory.getExecutedBrowser() == WebUIDriverType.EDGE_DRIVER) WebUI.delay(GlobalVariable.ShortTime)

'Click I am a JS Confirm button'
WebUI.click(findTestObject('Alerts/btn_JSConfirm'))

'Click Cancel button to close Alert'
WebUI.dismissAlert()

'Verify the result message: You clicked: Cancel'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You clicked: Cancel')

if (DriverFactory.getExecutedBrowser() == WebUIDriverType.EDGE_DRIVER) WebUI.delay(GlobalVariable.ShortTime)

'Click Click for JS Prompt button'
WebUI.click(findTestObject('Alerts/btn_JSPrompt'))

'Set text "Hello"'
WebUI.setAlertText('Hello')

'Click "OK" button to close Alert'
WebUI.acceptAlert()

'Verify the result message: You entered: Hello'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: Hello')

if (DriverFactory.getExecutedBrowser() == WebUIDriverType.EDGE_DRIVER) WebUI.delay(GlobalVariable.ShortTime)


