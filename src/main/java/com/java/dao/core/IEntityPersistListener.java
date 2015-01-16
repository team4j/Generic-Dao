package com.java.dao.core;

@SuppressWarnings("rawtypes")
public interface IEntityPersistListener<E extends IEntity>
{
	void beforeInsert(E e);

	void afterInsert(E e);

	void beforeDelete(E e);

	void afterDelete(E e);

	void beforeUpdate(E e);

	void afterUpdate(E e);

	Class<E> forEntityClass();
}
