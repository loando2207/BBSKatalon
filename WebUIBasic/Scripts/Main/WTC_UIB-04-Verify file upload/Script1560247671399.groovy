import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def _filepath = RunConfiguration.getProjectDir().replace('/', '\\') + '\\Data Files\\pororo.png'

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_File upload', ('_Title') : 'File Uploader'], FailureHandling.STOP_ON_FAILURE)

'Click on Choose File button and upload a png file '
WebUI.uploadFile(findTestObject('UploadFile/btn_Upload'), _filepath)

'Click on Upload button'
WebUI.click(findTestObject('UploadFile/btn_Submit'))

'Verify the Title pf page is "File Uploaded!"'
WebUI.verifyElementVisible(findTestObject('Global Object/lbl_Title', [Title: 'File Uploaded!']))

'Verify The png file is upload successful'
WebUI.verifyElementText(findTestObject('UploadFile/lbl_Uploaded file name'), 'pororo.png')


