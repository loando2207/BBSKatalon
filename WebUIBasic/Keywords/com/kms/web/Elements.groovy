package com.kms.web

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.event.KeyEvent

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Elements {
	@Keyword
	public static void selectContextMenu(String[] menuNodes){

		menuNodes.each{
			WebElement _Menu = WebUiCommonHelper.findWebElement(findTestObject('Menu/mnu_Menu Options', [MenuOption: it]), GlobalVariable.LongTime)
			'Select Menu Options'
			WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(_Menu))
		}
	}

	@Keyword
	public void moveSlider (TestObject _Slider, TestObject _Result,double _Value){

		double _CurrentPos = Double.parseDouble(WebUI.getText(_Result))
		double _Press

		/**
		 * Handle case change slider from small to big value
		 */
		if(_Value>_CurrentPos){
			_Press=(_Value-_CurrentPos)*2
			SliderControl(KeyEvent.VK_RIGHT, Keys.ARROW_RIGHT, _Slider, _Press)
		}

		/**
		 * Handle case change slider from big to small value
		 */
		else {
			_Press=(_CurrentPos-_Value)*2
			SliderControl(KeyEvent.VK_LEFT, Keys.ARROW_LEFT, _Slider, _Press)
		}
	}

	/**
	 * Control the slider
	 */
	public void SliderControl (def _KeyIE, def _KeyOther, TestObject _Object, double _Value){
		if(DriverFactory.getExecutedBrowser() == WebUIDriverType.IE_DRIVER){
			WebUI.waitForElementClickable(_Object, GlobalVariable.ShortTime)
			for (int j = 0; j < _Value; j++) {
				WebUI.click(_Object)
				Utility.pressKeys(_KeyIE, null)
			}
		}
		else{
			for (int i = 0; i < _Value; i++) {
				WebUI.waitForElementClickable(_Object, GlobalVariable.ShortTime)
				WebUI.sendKeys(_Object, Keys.chord(_KeyOther))
			}
		}
	}
}
