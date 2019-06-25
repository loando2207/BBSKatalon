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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select \'Horizontal Slider\' link'
WebUI.click(findTestObject('Page_The Internet/lnk_Horizontal slider'))

'Verify Horizontal Slider header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Horizontal Slider')

'Set Slider to 1'
CustomKeywords.'common.Slider.moveSlider'(findTestObject('Horizontal Slider/sld_Slider'), findTestObject('Horizontal Slider/lbl_Range'), 1)

'Verify slider value is 1'
WebUI.verifyElementText(findTestObject('Horizontal Slider/lbl_Range'), '1')

'Set Slider to 2.5\r\n'
CustomKeywords.'common.Slider.moveSlider'(findTestObject('Horizontal Slider/sld_Slider'), findTestObject('Horizontal Slider/lbl_Range'), 2.5)

'Verify slider value is 2.5'
WebUI.verifyElementText(findTestObject('Horizontal Slider/lbl_Range'), '2.5')

'Set Slider to 4.5\r\n'
CustomKeywords.'common.Slider.moveSlider'(findTestObject('Horizontal Slider/sld_Slider'), findTestObject('Horizontal Slider/lbl_Range'), 4.5)

'Verify slider value is 4.5\r\n'
WebUI.verifyElementText(findTestObject('Horizontal Slider/lbl_Range'), '4.5')

WebUI.closeBrowser()

