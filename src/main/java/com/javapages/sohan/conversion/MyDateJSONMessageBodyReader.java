package com.javapages.sohan.conversion;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javapages.sohan.model.MyDate;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MyDateJSONMessageBodyReader implements MessageBodyReader<MyDate> {

	@Override
	public boolean isReadable(Class<?> rawType, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return MyDate.class.isAssignableFrom(rawType);
	}

	@Override
	public MyDate readFrom(Class<MyDate> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream in) throws IOException, WebApplicationException {
		System.out.println("JSON to object conversion: " + type);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(in, type);
	}

}
