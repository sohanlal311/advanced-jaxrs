package com.javapages.sohan.conversion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.javapages.sohan.model.MyDate;

@Provider
public class MyDateParamConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] anns) {
		if (MyDate.class.isAssignableFrom(rawType)) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar cal = Calendar.getInstance();
					if ("tomorrow".equalsIgnoreCase(value)) {
						cal.add(Calendar.DATE, 1);
					}
					if ("yesterday".equalsIgnoreCase(value)) {
						cal.add(Calendar.DATE, -1);
					}
					MyDate myDate = new MyDate();
					myDate.setYear(cal.get(Calendar.YEAR));
					myDate.setMonth(cal.get(Calendar.MONTH));
					myDate.setDay(cal.get(Calendar.DAY_OF_MONTH));
					T result = rawType.cast(myDate);
					return result;
				}

				@Override
				public String toString(T bean) {
					if (bean == null) {
						return null;
					}
					return bean.toString();
				}

			};
		}
		return null;
	}

}
