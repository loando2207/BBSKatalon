import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

'Go to https://the-internet.herokuapp.com/'
WebUI.navigateToUrl('https://the-internet.herokuapp.com/')

'Select \'Sortable Data Tables\' link'
WebUI.click(findTestObject('Page_The Internet/lnk_Sortable data tables'))

'Verify Data Tables header title is displayed\r\n'
WebUI.verifyElementText(findTestObject('Global Object/lbl_Title'), 'Data Tables')

'Verify header at column 3 on Table 1'
WebUI.verifyElementText(findTestObject('Data Table/tbl_Header Name of Table',[TableName:'table1',Column: 3]), 'Email')

'Verify cell value (row 3, column 2) on Table 1'
WebUI.verifyElementText(findTestObject('Data Table/tbl_Data Table',[TableName:'table1', Row: 3, Column: 2]), 'Jason')

'Verify cell value (row 2, column 4) on Table 1'
WebUI.verifyElementText(findTestObject('Data Table/tbl_Data Table',[TableName:'table1', Row: 2, Column: 4]), '$51.00')

/**
 * @param list is the default list data of the Email column in Table 2
 */
ArrayList<String> _List = new ArrayList<String>()

for (int i = 1; i < 5; i++) {
    _List.add(WebUI.getText(findTestObject('Data Table/tbl_Data Table',[TableName:'table2', Row: i, Column: 3])))
}

//Sort this list
Collections.sort(_List)

'Click on \'Email\' header column on Table 2'
WebUI.click(findTestObject('Data Table/tbl_Header Name of Table',[TableName:'table2',Column: 3]))

/**
 * @param sortedList is the current list data of the Email column in Table 2
 */
ArrayList<String> _SortedList = new ArrayList<String>()

for (int i = 1; i < 5; i++) {
	_SortedList.add(WebUI.getText(findTestObject('Data Table/tbl_Data Table',[TableName:'table2', Row: i, Column: 3])))
}

//Verify the Email column sort by alphabetical from A-Z
WebUI.verifyEqual(_SortedList, _List)

WebUI.closeBrowser()

