package com.apex.api.test.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

//import com.apex.bean.Fruit;

//import jakarta.xml.bind.JAXBContext;
//import jakarta.xml.bind.JAXBException;
//import jakarta.xml.bind.Marshaller;
//import jakarta.xml.bind.Unmarshaller;
import com.apex.api.test.core.*;
import com.apex.customer.bean.CustomerPost;

public class ApexXMLUtil {
	
		 //Object
		  public static void marshller(Object o,String xmlFilePath,JAXBContext jaxbContext ) throws FileNotFoundException {
			    try {
			    
			 
		          
			          Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			          // output pretty printed
			          jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			      
			          // output to a xml file
			        //  FileOutputStream closedStream = new FileOutputStream(xmlFilePath);
			        
			       //   String result=
			        //  jaxbMarshaller.marshal(jaxbMarshaller, closedStream );
			          jaxbMarshaller.marshal(o, new File(xmlFilePath));

			      } catch (JAXBException ex) {
			          ex.printStackTrace();
			      }
				
			}
			

	/*		public static void unMarshller( String xmlFilePath,JAXBContext jaxbContext) {
			try {

				   


				    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

				    Fruit o = (Fruit) jaxbUnmarshaller.unmarshal(new File(xmlFilePath));

				    System.out.println(o);

				} catch (JAXBException e) {
				    e.printStackTrace();
				}
			}*/
		

}
