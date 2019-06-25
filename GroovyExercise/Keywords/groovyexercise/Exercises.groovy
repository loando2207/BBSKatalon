package groovyexercise

import java.text.SimpleDateFormat
import java.time.*

import com.kms.katalon.core.annotation.Keyword

public class Exercises {

	@Keyword
	public String ConvertNumberToString(int month) {
		String value = null;
		switch (month) {
			case "1":
				value = "January";
				break;
			case "2":
				value = "February";
				break;
			case "3":
				value = "March";
				break;
			case "4":
				value = "April";
				break;
			case "5":
				value = "May";
				break;
			case "6":
				value = "June";
				break;
			case "7":
				value = "July";
				break;
			case "8":
				value = "August";
				break;
			case "9":
				value = "September";
				break;
			case "10":
				value = "October";
				break;
			case "11":
				value = "November";
				break;
			case "12":
				value = "December";
				break;
			default:
				value = 'This month is NOT existent';
		}
		return value;
	}

	@Keyword
	public def QuadraticEquation(def a, def b ,def c){
		def x1=0,x2=0
		def delta = b*b-4*a*c
		if (delta > 0){
			x1 = (-b + Math.sqrt(delta))/(2*a)
			x2 = (-b - Math.sqrt(delta))/(2*a)
			println('X1 = '+x1)
			println('X2 = '+x2)
		}
		else {
			if (delta == 0.0){
				x1= (-b)/(2*a)
				println('X1 = '+x1)
			}
			else {
				if (delta <0 ) println('These are no result')
			}
		}
	}

	@Keyword
	public def SubstringInString(def value, def startSub ,def endSub){
		def returnValue
		println("String = "+value)
		println("start-substring = "+startSub)
		println("end-substring = "+endSub)
		int startpos = value.indexOf(startSub)+startSub.length();
		int endpos = value.indexOf(endSub)
		returnValue = value.substring(startpos,endpos)
		println("output result => " +returnValue)
		return returnValue
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

	@Keyword
	public def SortOrderStatusForDate(def list){
		def status = ""
		def tmp= ""
		for (int i=0;i<list.size()-1;i++){
			def first = list[i]
			def second = list[i+1]
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

	@Keyword
	public def ConvertSystemDate(def format){
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String strDate = dateFormat.format(date);
		println("println the result: "+strDate)
		return strDate
	}
}
