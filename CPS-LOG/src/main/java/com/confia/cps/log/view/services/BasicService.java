package com.confia.cps.log.view.services;

import java.util.List;


public interface BasicService <T,K>{
	List<T> listAll();

 	T getById(K id);

 	T saveOrUpdate(T entity);

    void delete(K id);
}
