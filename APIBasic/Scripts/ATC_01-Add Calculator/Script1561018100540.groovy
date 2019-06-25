import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager as WSResponseManager

response = WS.sendRequest(findTestObject('Add Calculator',[number1:13,number2:2]))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'AddResult', 15)

