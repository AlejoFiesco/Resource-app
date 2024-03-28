package com.example.demo.database.factory;

import java.util.List;

public interface FactoryInterface {
	public Object create(Object object) throws Exception;
	public <T> List<T> getList(Class<?> class1) throws Exception;
	public Object getById(Class<?> class1, String id) throws Exception;
}
