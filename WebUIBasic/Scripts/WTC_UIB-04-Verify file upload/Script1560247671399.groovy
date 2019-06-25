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

def _filepath = 'D:\\BBS\\Katalon\\WebUIBasic\\Data Files\\pororo.png'

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select File Upload link'
WebUI.click(findTestObject('Page_The Internet/lnk_File upload'))

'Verify File Uploader header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'File Uploader')

'Click on Choose File button and upload a png file '
WebUI.uploadFile(findTestObject('UploadFile/btn_Upload'), _filepath)

'Click on Upload button'
WebUI.click(findTestObject('UploadFile/btn_Submit'))

WebUI.waitForElementPresent(findTestObject('UploadFile/lbl_Uploaded file name'), GlobalVariable.MediumTime)

WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'File Uploaded!')

'Verify The png file is upload successful'
WebUI.verifyElementText(findTestObject('UploadFile/lbl_Uploaded file name'), 'pororo.png')

WebUI.closeBrowser()

