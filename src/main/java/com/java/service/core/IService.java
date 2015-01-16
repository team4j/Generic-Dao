package com.java.service.core;

import java.io.Serializable;
import java.util.List;

import com.java.dao.core.IEntity;

public interface IService<E extends IEntity<PK>, PK extends Serializable>
{
	void insert(E e);

	void delete(E e);

	void delete(PK pk);

	void update(E e);

	E get(PK pk);

	List<E> getAll();
}
