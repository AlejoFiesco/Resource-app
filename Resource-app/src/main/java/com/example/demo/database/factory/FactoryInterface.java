package com.example.demo.database.factory;

import java.util.List;

public interface FactoryInterface {
	public <T> T create(T object, String id) throws Exception;
	public <T> List<T> getList(Class<?> class1) throws Exception;
	public <T> T getById(Class<?> class1, String id) throws Exception;
}
