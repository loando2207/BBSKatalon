import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_Horizontal slider', ('_Title') : 'Horizontal Slider'],
	FailureHandling.STOP_ON_FAILURE)

'Set Slider to 1'
CustomKeywords.'com.kms.web.Elements.moveSlider'(findTestObject('Horizontal Slider/sld_Slider'), findTestObject('Horizontal Slider/lbl_Range'), 1)

'Verify slider value is 1'
WebUI.verifyElementText(findTestObject('Horizontal Slider/lbl_Range'), '1')

'Set Slider to 2.5\r\n'
CustomKeywords.'com.kms.web.Elements.moveSlider'(findTestObject('Horizontal Slider/sld_Slider'), findTestObject('Horizontal Slider/lbl_Range'), 2.5)

'Verify slider value is 2.5'
WebUI.verifyElementText(findTestObject('Horizontal Slider/lbl_Range'), '2.5')

'Set Slider to 4.5\r\n'
CustomKeywords.'com.kms.web.Elements.moveSlider'(findTestObject('Horizontal Slider/sld_Slider'), findTestObject('Horizontal Slider/lbl_Range'), 4.5)

'Verify slider value is 4.5\r\n'
WebUI.verifyElementText(findTestObject('Horizontal Slider/lbl_Range'), '4.5')





