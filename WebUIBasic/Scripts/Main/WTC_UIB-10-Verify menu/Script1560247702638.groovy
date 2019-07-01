import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit as TimeUnit
import java.util.function.Function as Function

import org.openqa.selenium.NotFoundException as NotFoundException
import org.openqa.selenium.support.ui.FluentWait as FluentWait
import org.openqa.selenium.support.ui.Wait as Wait

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String _ExpectedFileName = 'menu.csv'

File _File = new File((System.getProperty('user.home') + '\\Downloads\\') + _ExpectedFileName)

'Deleted the existed file (if any)'
if (_File.exists()) {
    _File.delete()
}

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_JQuery UI Menus', ('_Title') : 'JQueryUI - Menu'], 
    FailureHandling.STOP_ON_FAILURE)

String[] contextMenu = ['Enabled', 'Back to JQuery UI']

'Select Enabled -> JQuery UI menu'
CustomKeywords.'com.kms.web.Elements.selectContextMenu'(contextMenu)

'Verify JQuery UI header title is displayed\r\n'
WebUI.verifyElementVisible(findTestObject('Global Object/lbl_Title', [Title:'JQuery UI']))

'Click on "Menu" link'
WebUI.click(findTestObject('Menu/lnk_Menu link of JQuery UI page'))

'Verify JQueryUI - Menu header title is displayed'
WebUI.verifyElementVisible(findTestObject('Global Object/lbl_Title', [Title:'JQueryUI - Menu']))

contextMenu = ['Enabled', 'Downloads', 'CSV']

'Select Enabled -> Downloads -> CSV menu'
CustomKeywords.'com.kms.web.Elements.selectContextMenu'(contextMenu)

'Save File'
CustomKeywords.'com.kms.web.Utility.saveFile' ()

/**
 * Through 10 seconds, in every 3 seconds, it will verified if the file exists. 
 * After 10 seconds, if the file doesn't exist, it will throw NotFoundException
 */
'Wait for downloading'
Wait fluentWait = new FluentWait(_File).withTimeout(10, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS).ignoring(NotFoundException.class)

fluentWait.until(new Function<File, Boolean>() {
            @Override
            public Boolean apply(File _fileExist) {
                if(_fileExist.exists()) return true;
                else throw new NotFoundException("File is not found");
            }
		})





