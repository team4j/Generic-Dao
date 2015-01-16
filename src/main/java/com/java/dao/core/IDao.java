package com.java.dao.core;

import java.io.Serializable;
import java.util.List;

public interface IDao<E extends IEntity<PK>, PK extends Serializable>
{
	void insert(E e);
	
	void delete(E e);
	
	void delete(PK pk);
	
	void update(E e);
	
	E get(PK pk);
	
	List<E> getAll();
	
	boolean isExists(PK pk);
}
