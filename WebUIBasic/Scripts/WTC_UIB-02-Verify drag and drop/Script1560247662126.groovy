import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.testng.reporters.Files.readFile
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select Drag and Drop link'
WebUI.click(findTestObject('Page_The Internet/lnk_Drag and Drop'))

'Drag and Drop header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Drag and Drop')

String _jsLoader = ''

File file = new File('D:/BBS/Katalon/WebUIBasic/Data Files/drag_and_drop_helper.js')

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

WebUI.closeBrowser()

