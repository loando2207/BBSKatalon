import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.testng.reporters.Files.readFile

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_Drag and Drop', ('_Title') : 'Drag and Drop'], FailureHandling.STOP_ON_FAILURE)

String _jsLoader = ''

File file = new File(RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\drag_and_drop_helper.js')

try {
    _jsLoader = readFile(file)
}
catch (Exception ex) {
    ex.printStackTrace()
} 

WebUI.executeJavaScript(_jsLoader, null)

WebElement _colA = WebUiCommonHelper.findWebElement(findTestObject('Drag And Drop/lbl_Column A'), GlobalVariable.LongTime)

WebElement _colB = WebUiCommonHelper.findWebElement(findTestObject('Drag And Drop/lbl_Column B'), GlobalVariable.LongTime)

'Drag and Drop column A to column B'
WebUI.executeJavaScript('$(arguments[0]).simulateDragDrop({ dropTarget: arguments[1]})', Arrays.asList(_colA, _colB))

'Verify Column A changed to column B'
WebUI.verifyElementText(findTestObject('Drag And Drop/lbl_Column A'), 'B')

'Verify Column B changed to column A'
WebUI.verifyElementText(findTestObject('Drag And Drop/lbl_Column B'), 'A')

