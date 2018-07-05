package com.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;



@Repository
public abstract class GenericDao<T> {
	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> clazz;
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public GenericDao(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		clazz = (Class)pt.getActualTypeArguments()[0];
	}
	
	public void merge(T entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}
	public void flush() {
		entityManager.flush();
	}
	public void refresh(T entity) {
		entityManager.refresh(entity);
	}
	public void persist(T entity) {
		entityManager.persist(entity);
	}
	public void remove(Object object) {
		entityManager.remove(object);
	}
	public void clear() {
		entityManager.clear();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public T find(int id) {
		return (T)entityManager.find(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(){
		String jpql = "FROM"+clazz.getName();
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(int firstResult, int maxResults){
		String jpql = "FROM"+clazz.getName();
		Query query = entityManager.createQuery(jpql);
		query.setFirstResult(firstResult).setMaxResults(maxResults);
		return query.getResultList();
	}
}
