import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_Dropdown', ('_Title') : 'Dropdown List'], FailureHandling.STOP_ON_FAILURE)

'Select item by label Option 2' 
WebUI.selectOptionByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 2', true)

'Verify the current item is \'Option 2\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 2', false, GlobalVariable.ShortTime)

'Select item by index 1'
WebUI.selectOptionByIndex(findTestObject('Dropdown/cbo_Dropdown list'), 1)

'Verify the current item is \'Option 1\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 1', false, GlobalVariable.ShortTime)

'Select item by value 2'
WebUI.selectOptionByValue(findTestObject('Dropdown/cbo_Dropdown list'), '2', true)

'Verify the current item is Option 2'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 2', false, GlobalVariable.ShortTime)

