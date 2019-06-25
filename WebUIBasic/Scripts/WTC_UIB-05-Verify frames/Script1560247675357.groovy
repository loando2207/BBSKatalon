import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select WYSIWYG Editor link'
WebUI.click(findTestObject('Page_The Internet/lnk_WYSIWYG editor'))

'An iFrame containing the TinyMCE WYSIWYG Editor title is displayed'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'An iFrame containing the TinyMCE WYSIWYG Editor')

WebUI.switchToFrame(findTestObject('iFrame/ifr_Frame'), GlobalVariable.ShortTime)

'Verify the deafult content body is \'Your content goes here.\''
WebUI.verifyElementText(findTestObject('iFrame/ifr_Frame content'), 'Your content goes here.')

WebUI.clearText(findTestObject('iFrame/ifr_Frame content'))

WebElement _FrameContent = WebUiCommonHelper.findWebElement(findTestObject('iFrame/ifr_Frame content'), GlobalVariable.LongTime)

'Set new content "Hello, how are you?'
WebUI.executeJavaScript('arguments[0].innerText = arguments[1];', Arrays.asList(_FrameContent, 'Hello, how are you?'))

'The content body is Hello, how are you?'
WebUI.verifyElementText(findTestObject('iFrame/ifr_Frame content'), 'Hello, how are you?')

WebUI.closeBrowser()

