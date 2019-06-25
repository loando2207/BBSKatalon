import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.util.concurrent.TimeUnit as TimeUnit
import java.util.function.Function

import org.openqa.selenium.NotFoundException as NotFoundException
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.support.ui.FluentWait as FluentWait
import org.openqa.selenium.support.ui.Wait as Wait

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String _ExpectedFileName = 'menu.csv'

File _File = new File((System.getProperty('user.home') + '\\Downloads\\') + _ExpectedFileName)

'Deleted the existed file (if any)\r\n'
if (_File.exists()) {
    _File.delete()
}

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select \'JQuery UI Menus\' link'
WebUI.click(findTestObject('Page_The Internet/lnk_JQuery UI Menus'))

'Verify JQueryUI - Menu header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'JQueryUI - Menu')

WebElement _Enabled = WebUiCommonHelper.findWebElement(findTestObject('Menu/mnu_Enabled'), GlobalVariable.LongTime)

'Select Enabled '
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_Enabled))

'Click JQuery UI menu'
WebUI.click(findTestObject('Menu/mnu_Back to JQueryUI'))

WebUI.waitForPageLoad(GlobalVariable.MediumTime)

'Verify JQuery UI header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'JQuery UI')

'Click on \'Menu\' link'
WebUI.click(findTestObject('Menu/lnk_Menu link of JQuery UI page'))

WebUI.waitForPageLoad(GlobalVariable.MediumTime)

'Verify JQueryUI - Menu header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'JQueryUI - Menu')

_Enabled = WebUiCommonHelper.findWebElement(findTestObject('Menu/mnu_Enabled'), GlobalVariable.LongTime)

'Select Enabled'
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_Enabled))

WebElement _Download = WebUiCommonHelper.findWebElement(findTestObject('Menu/mnu_Downloads'), GlobalVariable.LongTime)

'Select Downloads '
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_Download))

WebElement _csv = WebUiCommonHelper.findWebElement(findTestObject('Menu/mnu_Downloads CSV'), GlobalVariable.LongTime)

Robot _robot = new Robot()

'Select CSV'
/**
 * In IE, user must press ALT+S to accept the confirmation message
 * In FF, user must press ALT+S to select Save option and press Enter to close the Download window
 */
if (DriverFactory.getExecutedBrowser() == WebUIDriverType.IE_DRIVER) {
    WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_csv))

    _robot.setAutoDelay(250)

    _robot.keyPress(KeyEvent.VK_ALT)

    WebUI.delay(GlobalVariable.ShortTime)

    _robot.keyPress(KeyEvent.VK_S)

    _robot.keyRelease(KeyEvent.VK_ALT)

    _robot.keyRelease(KeyEvent.VK_S)
} else if (DriverFactory.getExecutedBrowser() == WebUIDriverType.FIREFOX_DRIVER) {
    WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_csv))

    _robot.setAutoDelay(250)

    _robot.keyPress(KeyEvent.VK_ALT)

    WebUI.delay(GlobalVariable.ShortTime)

    _robot.keyPress(KeyEvent.VK_S)

    _robot.keyRelease(KeyEvent.VK_ALT)

    _robot.keyRelease(KeyEvent.VK_S)

    _robot.keyPress(KeyEvent.VK_ENTER)

    _robot.keyRelease(KeyEvent.VK_ENTER)
} else {
    WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_csv))
}

'Wait for downloading'
/**
 * Through 10 seconds, in every 3 seconds, it will verified if the file exists. 
 * After 10 seconds, if the file doesn't exist, it will throw NotFoundException
 */
Wait fluentWait = new FluentWait(_File).withTimeout(10, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS).ignoring(NotFoundException.class)

fluentWait.until(new Function<File, Boolean>() {
            @Override
            public Boolean apply(File _fileExist) {
                if(_fileExist.exists()) return true;
                else throw new NotFoundException("File is not found");
            }
		})

WebUI.closeBrowser()

