package com.javapages.sohan.conversion;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.javapages.sohan.model.MyDate;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class MyDateXMLMessageBodyReader implements MessageBodyReader<MyDate> {

	@Override
	public boolean isReadable(Class<?> rawType, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return MyDate.class.isAssignableFrom(rawType);
	}

	@Override
	public MyDate readFrom(Class<MyDate> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream in) throws IOException, WebApplicationException {
		try {
			System.out.println("XML to object conversion: " + type);
			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			return (MyDate) jaxbContext.createUnmarshaller().unmarshal(in);
		} catch (JAXBException jaxbException) {
			throw new ProcessingException("Error deserializing a MyBean.", jaxbException);
		}
	}

}
