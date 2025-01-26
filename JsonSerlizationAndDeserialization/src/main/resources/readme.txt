Json Agenda
============
1. Introduction
2. Json Syntax and Data Types
3. XML Vs JSON
4. Json Serialization and Json Deserialization
5. Importance of JACKSON
6. Jsonn Annotations
7. Json  Examples
8. Realtime Usecases
9. Summary
==================================================================================
1. Introduction:

JSON
====
=> It stands for Java Script Object Notation.
=> It is derived from Java Script but not depending on JavaScript.
=> Json data is light weight and human readable text.
=> Json file names are extension with .json.
=> Json Internet Media Type is "application/json".
=> Json data is an interoperable(able to operate b/w every application).
=> In WebService and Rest API developement we use JSON format to exchange the data between the applications.

Q) Why shoul i learn Json and What is the importance of Json?
Ans. Json is used to  communicate between application, Since Json is not specific to any technologies, it should be generic for
     all the technologies. "Every technology developer must learn Json".

==============================================================================================================


2. Json Syntax and Data types:
   ===========================

#1. JSON Data is in the form of Key Value pair

#2. JSON Syntax is  : {key1:value1, key2:value2, key3:value3,....etc}
	Where Key = String  and Value  = String, Number, Boolean, Object, NULL, Array

#3. JSON data types: There 6 JSON data types
  1. String
  2. Number
  3. Boolean(true/false)
  4. Object
  5. Null
  6. Array


#4. JSON data types Examples

	1. { "oid" : 123, "name":"mobile", "isDelivered" : true, "dec":null  }

	2. {
		"orders" :
			   [
				   {
					"oid" : 123,
					"name":"mobile",
					"isDelivered" : true
				   },

				   {
					"oid" : 456,
					"name":"laptop",
					"isDelivered" : false
				   },

				   {
					"oid" : 789,
					"name":"watch",
					"isDelivered" : true
				   }

				  :
				  :
			  ]
	 }

 #3. JSON data always enclosed with curly braces { } . Root element is curly braces {
 #4. JSON Array data enclosed with sqaure brances [] .


3. XML VS JSON:
   =============

	#1. XML is Heavy Weight where as Json is light weight

		<order>
                   <oid>123</oid>
		   <name>mobile</name>
		   <isDeliver>true</IsDeliver>
		   <description>good</description>
		</order>

	Rule of XML :
		#1. Root Element is mandatory for every XML document
                #2. Every XML start element end element is mandatory
                #3. To read the XML document from web/UI developer should write the code manully.
		#4. XSD are used to validate the XML

==========================================================================================================================
	JSON
		{
		 "oid" : 789,
		 "name":"watch",
		 "isDelivered" : true
		}

	Rule of JSON:
		#1. No need root element
		#2. No need start and end element
		#3. To read the JSON data from web/UI, no need to write the code, browser will take care to parse and read the data.
		#4. JSON Schemas are used to validate the JSON

Advantage
========
 1. When compared XML, Json data is less in size, so JSON data can transfer in network very speed, if it is XML will take more time.


Note: use case of amaozon.in(searching for books)

Books Usecase  :   bookid, name, author, price, isbn, offer, title, reveiws, image, stock, pages, ... 20 properties

		   20(rows)*5(each row books) = 100 books  == 100 * 20  = 2000 properties


Json
=====
 {
	 "books" :
		[
		  {
		    "id" : ""

		  },
		  {
		   "id" : ""

		  },
		 {
		   "id" : ""

		 },
              :
	    100
  }

XML
===
<Books>
   <Book>
	<id>1234</id>
   </Book>
    ...
    ...
</Books>


4. Json Serialization and Json Deserialization :
=================================================

a. Json Serialization :

	#1. The process of converting Java Object into JSON is called Json Serialization.

        #2. For every request at the Consumer end JSON Serialization will happen and For every response at the Provider end JSON
            Serialization will happen.

b. Json Deserialization:

	#1. The process of convertig JSON to Java Object is called Json Deserialization.

	#2. For every response at the Consumer end JSON Deserialization will  happen and for every request at the Provider
            end JSON Deserialization will happen.


Q) Who will do Json Serialization and Json Deserialization in Java?
Sol : JACKSON Library:: "The JACKSON is used to perform JSON Serialization and JSON Deserialization"


How to enable JAKCSON library:
==============================

	We need to add JACKSON dependency in pom.xml

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>				jackson-databind
    <artifactId>jackson-databind</artifactId>					  | --- Jackson-core
    <version>2.14.1</version>								  | --- Jackson-annotations
</dependency>



Jackson has provided some predefiend utility classes to perform Json Serialization and Json Deserialization

	ObjectMapper
		|
		|-writeValue() : Java Object to Json
		|
		|-readValue()  : Json to Java Object


eg#1.
public class Order{
	private int oid;
	private String name;
	private boolean delivered;
	private String desc;

	//setters and getters

}

writeValue() method has some overload methods

	1. String writeValue(java object) : i/p : java object  , o/p: json as string // ouptut will be print console

	2. void writeValue(new File("customer.json"),java object)


readValue() method has some overload methods

	1.   Customer customer   = readValue(new File("customer.json"), Customer.class);

	2.   Customer customer   = readValue(new URL("http://pwskills.com/api/customer.json"), Customer.class);

	3.   Customer customer   = readValue({"name":"nitin","email":"nitin@pw.live","address":"bengaluru"}, Customer.class);

=> In Realtime, we dont want Java Properties as Json keys by default, we want our own properties as json keys then we should use Json Annotations

=> Json annotations are used customize the json data while doing JSON Seriliazation

JSON Annotations:
===============

	1. @JsonProperty

	2. @JsonPropertyOrder

	3. @JsonIgnoreProperties

	4. @JsonInclude

	5. @JsonRootName

	6. @JsonSerialize

	7. @JsonDeserialize


Sample output without formatting
================================
customerjson is :{"firstname":"nitin","latName":"manjunath","emalId":"nitinmanjunath@gmail.com","address":"bengaluru",
	"dob":1673153307847,"orders":[{"oid":1234,"name":"mobile","desc":"good","delivered":true},{"oid":1234,"name":null,"desc":null,"delivered":false},
	{"oid":0,"name":null,"desc":null,"delivered":false}],"account":{"acctNumber":"05211140058239","bankName":"Hdfc","balance":10000}}


Note: To write the output in a pretty way during serialization we use
	1. mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object)

	2. mapper.enable(SerializationFeature.INDENT_OUTPUT);
	   mapper.writeValueAsString(object)



case1::
Customer customer = new Customer("nitin", "manjunath", "nitin@gmail.com", "bengaluru", new Date(), orders, account);
String customerJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
System.out.println(customerJson);

case2::
ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.INDENT_OUTPUT);
Customer customer = new Customer("nitin", "manjunath", "nitin@gmail.com", "bengaluru", new Date(), orders, account);
String customerJson = mapper.writeValueAsString(customer);
System.out.println(customerJson);

Output
{
  "firstname" : "nitin",
  "latName"   : "manjunath",
  "emalId"    : "nitinmanjunath@gmail.com.com",
  "address"   : "bengaluru",
  "dob"       : 1673153490213,
  "orders"    :
	      [
		{
    			"oid" : 1234,
    			"name" : "mobile",
    			"desc" : "good",
    			"delivered" : true
  		},
		{
    			"oid" : 1234,
    			"name" : "mobile",
    			"desc" : "good",
    			"delivered" : true
  		},
		{
    			"oid" : 1234,
    			"name" : "mobile",
    			"desc" : "good",
    			"delivered" : true
  		}
	     ],
  "account"  :
              {
   		  "acctNumber" : "05211140058239",
    		  "bankName" : "Hdfc",
    		  "balance" : 10000
  	      }
}

Annotations used in Jackson API
===============================

1. @JsonProperty :
     => It is used to format propery name, JSON serialization will use @JsonProperty() name as Json key name
     => The scope is only at method level,field level and class level.

eg::
@JsonProperty("first_name")
private String firstName;

@JsonProperty("last_name")
private String lastName;


2. @JsonPropertyOrder:
     => In whatever order we need the json keys to be , this annotation will generate json data in same order.
     => scope at class level

eg::
@JsonPropertyOrder(value = {"orders_info","address","emailId"})
public class Customer {

	private String firstName;
	private String lastName;
	private String emailId;
	private String address;

	private Date dob;

	private List<Order> orders_info;
	private Account account;

}


3. @JsonInclude:
a. Using Include.NON_NULL and Include.NON_EMPTY at the Property level
b. Using Include.NON_NULL and Include.NON_EMPTY at the Class level
c. Using Include.NON_NULL and Include.NON_EMPTY globally with ObjectMapper

eg#1.
@JsonInclude(value = Include.NON_NULL)
public class Order {
	private Integer oid;
	@JsonInclude(value= Include.NON_EMPTY)
	private String name;
	private String desc;
	private boolean delivered;
}

eg#2. applicable at the ObjectMapper level

ObjectMapper mapper = new ObjectMapper();
mapper.setSerializationInclusion(Include.NON_NULL);
mapper.setSerializationInclusion(Include.NON_EMPTY);


4.  @JsonIgnoreProperties :
	If we dont want some of the properties into Json during Serialization then add those properties in  @JsonIgnoreProperties annotation.
        This would avoid exception at the runtime.

5. @JsonRootName : add the root element in json

@JsonRootName(value = "customer")
public class Customer {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	private String emailId;
	private String address;

	private Date dob;

	private List<Order> orders_info;
	private Account account;

}

ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.INDENT_OUTPUT);
mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);//we need to enable the root value
Customer customer = new Customer("nitin", "manjunath", "nitin@gmail.com", "bengaluru", new Date(), orders, account);
String customerJson = mapper.writeValueAsString(customer);
System.out.println(customerJson);


6. @JsonSerialize
	In realtime, JsonSerialize will provide the default values of date, numbers.

	For example :  balance is "balance" : 10000 but client is asking 10000.00 or 10000.0
		    : date object default format is "dob" : 1673154940896 but we want print our own format as per client requirements

	If we want our own/custom format date then we should use @JsonSerialize

eg#1.

Customer class
==============
@JsonSerialize(using = CustomDateSerializer.class)
@JsonDeserialize(using = CustomDateDeSerialization.class)
private Date dob;

Account class
=============
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String accNo;
	private String bankName;

	@JsonSerialize(using = CustomSalarySerializer.class)
	private BigDecimal balance;
}


Serialization of Date object using jackson api
==============================================

package com.app.nitin.serialization;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date> {


	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

		gen.writeString(sdf.format(date));
	}
}

Serialization of BigDecimal object using jackson api
===================================================

package com.app.nitin.serialization;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomSalarySerializer extends JsonSerializer<BigDecimal> {

	@Override
	public void serialize(BigDecimal salary, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		gen.writeString(formatter.format(salary));
	}
}


DeSerialization of Date object using jackson api
================================================
package com.app.nitin.deserialization;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeSerialization extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String text = p.getText();
		Date date = null;
		try {
			date = sdf.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}

In Spring Boot or Spring Rest:
===============================

	#1. Developer no need write manuall code on JsonSerialization and JsonDeserialization

	#2. JACKSON library will be included/part of springboot-starter-web jar. i.e. we don't need to add jackson library manually in pom.xml

	#3. @RequestBody annotation will take of JsonDeserialization

			i.e. consumer/client will send json data input , at proivder end @RequestBody will take care to convert Json to Java Object

			i.e. @RequedtBody annotation internally will use JACKSON to perform json to java object ( JsonDeserialization )

	#4. @ResponseBody annotation will take care JsonSerialization

			i.e. provider will send the response object to consumer, while sending response object at provider end response
                             object will be converted to json

			i.e. @ResponseBody annotation internally will use JACKSON to perform Java Object to Json ( JsonSerialization )



If already Json is there why YAML is so popular in market?
Sol : when compared with JSON , YAML is light weight

{
  "customer" : {
      "account" : {
          "acctNumber" : "05211140058239",
          "bankName" : "Hdfc",
          "balance" : 10000
      },
      "orders" :
		[
			{
      				"oid" : 1234,
      				"name" : "mobile",
      				"delivered" : true
    			},
			{
      				"oid" : 1234,
      				"name" : " ",
      				"delivered" : true
    			},
			{
     				 "oid" : 1234,
      				"name" : "mobile",
      				"delivered" : true
    			}
		],
    	"emalId" : "nitnmanjunath@gmail.com",
    	"dob" : "08-01-2023 10:54:29",
    	"first_name" : "nitin",
    	"last_name" : "manjunath"
    }
}

YAML :
======
=> stands for YAML ain't markup language and is a superset of JSON.
=> lists begin with a hyphen, dependent on whitespace / indentation.
=> Better suited for configuration than json.
=> yaml is mainly used for configuration.

---
customer:
  account:
    acctNumber: '05211140058239'
    bankName: Hdfc
    balance: 10000
  orders:
  - oid: 1234
    name: mobile
    delivered: true
  - oid: 1234
    name: " "
    delivered: true
  - oid: 1234
    name: mobile
    delivered: true
  emalId: nitinmanjunath@gmail.com
  dob: '08-01-2023 10:54:29'
  first_name: nitin
  last_name: manjunath

Note:: Response Entity : Response Body +  response headers + http satus code




















































