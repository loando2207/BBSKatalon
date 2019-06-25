<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Multiply Calculator</name>
   <tag></tag>
   <elementGuidId>f0d8624b-e8d7-4c5a-bcad-92aaa9744408</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?>
&lt;s:Envelope xmlns:s=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot;>
  &lt;s:Body>
    &lt;Multiply xmlns=&quot;http://CalculatorService&quot;>
      &lt;n1>${number1}&lt;/n1>
      &lt;n2>${number2}&lt;/n2>
    &lt;/Multiply>
  &lt;/s:Body>
&lt;/s:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>Multiply</soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress> http://webservice.toscacloud.com/Soap11.svc?wsdl</wsdlAddress>
</WebServiceRequestEntity>
