import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.event.KeyEvent as KeyEvent

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def _Tab = KeyEvent.VK_TAB

def _Enter = KeyEvent.VK_ENTER

def _Character = KeyEvent.VK_G

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_Key presses', ('_Title') : 'Key Presses'], 
    FailureHandling.STOP_ON_FAILURE)

'Presses "ENTER" key'
CustomKeywords.'com.kms.web.Utility.pressKeys'(_Enter, null)

'Verify message: You entered: ENTER\r\n'
	WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: ENTER')

'Presses "TAB" key\r\n'
CustomKeywords.'com.kms.web.Utility.pressKeys'(_Tab, null)

'Verify message: You entered: TAB\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: TAB')

'Presses "G" key\r\n'
CustomKeywords.'com.kms.web.Utility.pressKeys'(_Character, null)

'Verify message: You entered: G\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Result'), 'You entered: G')

