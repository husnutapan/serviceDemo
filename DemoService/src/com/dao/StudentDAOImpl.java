package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student;
import com.model.Tuser;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Student getUIDWithTuser(Tuser tuser) {
		int tuserId = getParentId(tuser);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> empRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(empRoot).where(builder.equal(empRoot.get("id"), tuserId));
		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery).setParameter("tuserId", tuserId);
		return query.getSingleResult();
	}

	//PARENTID FOUND
	public int getParentId(Tuser tuser) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Integer> criteriaQuery = builder.createQuery(Integer.class);
		ParameterExpression<String> empNameExpression = builder.parameter(String.class, "email");
		Root<Tuser> empRoot = criteriaQuery.from(Tuser.class);
		criteriaQuery.select(empRoot.get("id")).where(builder.equal(empRoot.get("email"), empNameExpression));
		TypedQuery<Integer> query = entityManager.createQuery(criteriaQuery).setParameter("email", tuser.getEmail());
		return query.getSingleResult();
	}
}
