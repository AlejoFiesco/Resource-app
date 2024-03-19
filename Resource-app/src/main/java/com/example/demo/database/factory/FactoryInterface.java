package com.example.demo.database.factory;

import java.util.List;

public interface FactoryInterface {
	public Object create(Object object) throws Exception;
	<T> List<T> getList(Class<?> class1) throws Exception;
}
