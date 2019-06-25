import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select \'Challenging DOM\' link'
WebUI.click(findTestObject('Page_The Internet/lnk_Challenging DOM'))

'Verify Challenging DOM header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Challenging DOM')

'Verify font size of \'foo\' button\' is 16px'
WebUI.verifyEqual(WebUI.getCSSValue(findTestObject('Challenging DOM/btn_Button'), 'font-size'), '16px')

def _BackgroundColor = WebUI.getCSSValue(findTestObject('Challenging DOM/btn_Button Alert'), 'background-color')

'Verify background-color of \'qux\' button is Red color'
WebUI.verifyEqual(_BackgroundColor == 'rgba(198, 15, 19, 1)'|| _BackgroundColor == 'rgb(198, 15, 19)', true)

def _BorderTopColor = WebUI.getCSSValue(findTestObject('Challenging DOM/btn_Button Success'), 'border-top-color')

'Verify border-top-color of \'baz\' button is Green color'
WebUI.verifyEqual(_BorderTopColor == 'rgb(69, 122, 26)'||_BorderTopColor == 'rgba(69, 122, 26, 1)', true)

def _BorderRightColor = WebUI.getCSSValue(findTestObject('Challenging DOM/btn_Button Success'), 'border-right-color')

'Verify border-right-color of \'baz\' button is Green color'
WebUI.verifyEqual(_BorderRightColor == 'rgb(69, 122, 26)'||_BorderRightColor == 'rgba(69, 122, 26, 1)', true)

def _BorderBottomColor = WebUI.getCSSValue(findTestObject('Challenging DOM/btn_Button Success'), 'border-bottom-color')

'Verify border-bottom-color of \'baz\' button is Green color'
WebUI.verifyEqual(_BorderBottomColor == 'rgb(69, 122, 26)'||_BorderBottomColor == 'rgba(69, 122, 26, 1)', true)

def _BorderLeftColor = WebUI.getCSSValue(findTestObject('Challenging DOM/btn_Button Success'), 'border-left-color')

'Verify border-left-color of \'baz\' button is Green color'
WebUI.verifyEqual(_BorderLeftColor == 'rgb(69, 122, 26)'||_BorderLeftColor== 'rgba(69, 122, 26, 1)', true)

WebUI.closeBrowser()

