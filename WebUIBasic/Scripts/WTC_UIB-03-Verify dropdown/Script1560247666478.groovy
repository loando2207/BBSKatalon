import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Go to https://the-internet.herokuapp.com/'
WebUI.click(findTestObject('Page_The Internet/lnk_Dropdown'))

'Dropdown List header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Dropdown List')

'Select item by label Option 2' 
WebUI.selectOptionByValue(findTestObject('Dropdown/cbo_Dropdown list'), '2', true)

'Verify the current item is \'Option 2\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 2', false, GlobalVariable.ShortTime)

'Select item by index 1'
WebUI.selectOptionByValue(findTestObject('Dropdown/cbo_Dropdown list'), '1', true)

'Verify the current item is \'Option 1\''
WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 1', false, GlobalVariable.ShortTime)

'Select item by value 2'
WebUI.selectOptionByValue(findTestObject('Dropdown/cbo_Dropdown list'), '2', true)

'Verify the current item is Option 2'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/cbo_Dropdown list'), 'Option 2', false, GlobalVariable.ShortTime)

WebUI.closeBrowser()

