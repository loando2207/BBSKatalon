import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_Checkboxes', ('_Title') : 'Checkboxes'], FailureHandling.STOP_ON_FAILURE)

' Check checkbox 1'
WebUI.check(findTestObject('Checkboxes/chk_Checkbox1'))

'Verify checkbox 1 is checked'
WebUI.verifyElementChecked(findTestObject('Checkboxes/chk_Checkbox1'), GlobalVariable.ShortTime)

' Uncheck checkbox 2'
WebUI.uncheck(findTestObject('Checkboxes/chk_Checkbox2'))

'Verify checkbox 2 is un-checked'
WebUI.verifyElementNotChecked(findTestObject('Checkboxes/chk_Checkbox2'), GlobalVariable.ShortTime)


