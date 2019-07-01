import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Set Up'), [('_TestObject') : 'Page_The Internet/lnk_Sortable data tables', ('_Title') : 'Data Tables'], 
    FailureHandling.STOP_ON_FAILURE)

'Verify header at column 3 on Table 1'
WebUI.verifyElementText(findTestObject('Data Table/tbl_Header Name of Table', [('TableName') : 'table1', ('Column') : 3]), 
    'Email')

'Verify cell value (row 3, column 2) on Table 1'
WebUI.verifyElementText(findTestObject('Data Table/tbl_Data Table', [('TableName') : 'table1', ('Row') : 3, ('Column') : 2]), 
    'Jason')

'Verify cell value (row 2, column 4) on Table 1'
WebUI.verifyElementText(findTestObject('Data Table/tbl_Data Table', [('TableName') : 'table1', ('Row') : 2, ('Column') : 4]), 
    '$51.00')

'Click on "Email" header column on Table 2'
WebUI.click(findTestObject('Data Table/tbl_Header Name of Table', [('TableName') : 'table2', ('Column') : 3]))

'Get the list data of column Email'
ArrayList<String> _List = new ArrayList<String>()

for (int i = 1; i < 5; i++) {
    _List.add(WebUI.getText(findTestObject('Data Table/tbl_Data Table', [('TableName') : 'table2', ('Row') : i, ('Column') : 3])))
}

'Verify the status of list data'
CustomKeywords.'com.kms.web.Utility.SortOrderStatus'(_List)

