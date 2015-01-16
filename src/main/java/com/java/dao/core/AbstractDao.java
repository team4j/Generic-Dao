package com.java.dao.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao<E extends IEntity<PK>, PK extends Serializable>
		implements IDao<E, PK>
{

	@Autowired
	protected ApplicationContext context;

	@Autowired
	protected SessionFactory sf;

	@SuppressWarnings("rawtypes")
	private static Map<String, IEntityPersistListener> lsnrMap = null;

	@SuppressWarnings("rawtypes")
	private EntityPersistListenerAdapter lsnrs = new EntityPersistListenerAdapter();

	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDao()
	{
		this.entityClass = (Class<E>) ((ParameterizedType) (this.getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostConstruct
	public void init()
	{
		if (null == lsnrMap)
		{
			lsnrMap = context.getBeansOfType(IEntityPersistListener.class);
		}

		for (IEntityPersistListener lsnr : lsnrMap.values())
		{
			if (this.getEntityClass().isAssignableFrom(lsnr.forEntityClass()))
			{
				lsnrs.add(lsnr);
			}
		}
	}

	public Class<E> getEntityClass()
	{
		return this.entityClass;
	}

	public Session getCurrentSession()
	{
		return this.sf.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(E e)
	{
		this.lsnrs.beforeInsert(e);
		this.getCurrentSession().save(e);
		this.lsnrs.afterInsert(e);
		this.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(E e)
	{
		this.lsnrs.beforeDelete(e);
		this.getCurrentSession().delete(e);
		this.lsnrs.afterDelete(e);
	}

	@Override
	public void delete(PK pk)
	{
		this.delete(this.get(pk));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(E e)
	{
		this.lsnrs.beforeUpdate(e);
		this.getCurrentSession().saveOrUpdate(e);
		this.lsnrs.afterUpdate(e);
		this.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(PK pk)
	{
		return (E) this.getCurrentSession().get(this.getEntityClass(), pk);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll()
	{
		return (List<E>) this.getCurrentSession()
				.createCriteria(this.getEntityClass()).list();
	}

	@Override
	public boolean isExists(PK pk)
	{
		return null != this.get(pk);
	}

}
