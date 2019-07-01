import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_WYSIWYG editor', ('_Title') : 'An iFrame containing the TinyMCE WYSIWYG Editor'], FailureHandling.STOP_ON_FAILURE)

'Verify the deafult content body is \'Your content goes here.\''
WebUI.verifyElementText(findTestObject('iFrame/ifr_Frame content'), 'Your content goes here.')

WebUI.clearText(findTestObject('iFrame/ifr_Frame content'))

WebUI.switchToFrame(findTestObject('iFrame/ifr_Frame'), GlobalVariable.ShortTime)

WebElement _FrameContent = WebUI.findWebElement(findTestObject('iFrame/ifr_Frame content'), GlobalVariable.ShortTime)

'Set new content "Hello, how are you?'
WebUI.executeJavaScript('arguments[0].innerText = arguments[1];', Arrays.asList(_FrameContent, 'Hello, how are you?'))

WebUI.switchToDefaultContent()

'The content body is Hello, how are you?'
WebUI.verifyElementText(findTestObject('iFrame/ifr_Frame content'), 'Hello, how are you?')

