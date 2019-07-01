import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl(GlobalVariable._URL)

'Select link'
WebUI.click(findTestObject(_TestObject))

'Verify the title is displayed'
WebUI.verifyElementVisible(findTestObject('Global Object/lbl_Title', [Title:_Title]))
