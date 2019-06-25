package common

import java.awt.Robot
import java.awt.event.KeyEvent

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Slider {
	@Keyword
	public void moveSlider (TestObject _Slider, TestObject _Result,double _Value){

		double _CurrentPos = Double.parseDouble(WebUI.getText(_Result))

		double _Press=(_Value-_CurrentPos)*2

		if(DriverFactory.getExecutedBrowser() == WebUIDriverType.IE_DRIVER){
			Robot move = new Robot()
			WebUI.waitForElementClickable(_Slider, 5)
			for (int j = 0; j < _Press; j++) {
				WebUI.click(_Slider)
				move.keyPress(KeyEvent.VK_RIGHT);
				move.keyRelease(KeyEvent.VK_RIGHT)
			}
		}
		else{
			for (int i = 0; i < _Press; i++) {
				WebUI.waitForElementClickable(_Slider, 5)
				WebUI.sendKeys(_Slider, Keys.chord(Keys.ARROW_RIGHT))
			}
		}
	}
}