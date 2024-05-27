package com.example.demo.database.factory;

import java.util.List;

import com.example.demo.utilities.filters.Filter;

public interface FactoryInterface {
	public <T> T create(T object, String id) throws Exception;
	public <T> List<T> getList(Class<?> class1, Filter filter) throws Exception;
	public <T> T getById(Class<?> class1, String id) throws Exception;
}
