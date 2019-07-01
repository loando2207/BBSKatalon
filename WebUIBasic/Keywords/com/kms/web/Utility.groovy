package com.kms.web

import java.awt.Robot
import java.awt.event.KeyEvent

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Utility {

	public static void saveFile() {
		if (DriverFactory.getExecutedBrowser() == WebUIDriverType.IE_DRIVER) {
			pressKeys(KeyEvent.VK_ALT,KeyEvent.VK_S)
		} else if (DriverFactory.getExecutedBrowser() == WebUIDriverType.FIREFOX_DRIVER) {
			pressKeys(KeyEvent.VK_ALT,KeyEvent.VK_S)
			WebUI.delay(GlobalVariable.ShortTime)
			pressKeys(KeyEvent.VK_ENTER, null)
		}
	}

	@Keyword
	public static void pressKeys(def _Key1, def _Key2){
		WebDriver _driver = DriverFactory.getWebDriver()
		Robot move = new Robot()
		if(_Key2==null){
			move.keyPress(_Key1)
			move.keyRelease(_Key1)
		}
		else {
			move.setAutoDelay(GlobalVariable.ShortTime)
			move.keyPress(_Key1)
			WebUI.delay(GlobalVariable.ShortTime)
			move.keyPress(_Key2)
			move.keyRelease(_Key1)
			move.keyRelease(_Key2)
		}
	}

	@Keyword
	public def SortOrderStatus(def list){
		def status = ""
		def tmp= ""
		for (int i=0;i<list.size()-1;i++){
			def first,second
			try{
				first = Integer.parseInt(list[i])
				second = Integer.parseInt(list[i+1])
			}
			catch(Exception e ) {
				first = list[i]
				second = list[i+1]
			}
			if (first > second) {
				tmp="Descending"
				if(status.equals("") || status.equals(tmp))	status=tmp
				else status = "normal"
			}
			else if (first < second) {
				tmp="Ascending"
				if(status.equals("") || status.equals(tmp))	status=tmp
				else status = "normal"
			}
		}
		println(status)
		return status
	}
}
