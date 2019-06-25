import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://the-internet.herokuapp.com/')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select \' Checkboxes\' link'
WebUI.click(findTestObject('Page_The Internet/lnk_Checkboxes'))

'Checkboxes header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Checkboxes')

' Check checkbox 1'
WebUI.check(findTestObject('Checkboxes/chk_Checkbox1'))

'Verify checkbox 1 is checked'
WebUI.verifyElementChecked(findTestObject('Checkboxes/chk_Checkbox1'), GlobalVariable.ShortTime)

' Uncheck checkbox 2'
WebUI.uncheck(findTestObject('Checkboxes/chk_Checkbox2'))

'Verify checkbox 2 is un-checked'
WebUI.verifyElementNotChecked(findTestObject('Checkboxes/chk_Checkbox2'), GlobalVariable.ShortTime)

WebUI.closeBrowser()

