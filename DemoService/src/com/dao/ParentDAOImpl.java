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

import com.model.Parent;
import com.model.Tuser;

@Repository
public class ParentDAOImpl implements ParentDAO {
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void saveParent(Parent parent) {
		entityManager.getTransaction().begin();
		entityManager.persist(parent);
		entityManager.getTransaction().commit();
	}

	@Override
	public boolean loginUser(Tuser tuser) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuser> criteriaQuery = builder.createQuery(Tuser.class);

		ParameterExpression<String> email = builder.parameter(String.class, "email");
		ParameterExpression<String> password = builder.parameter(String.class, "password");

		Root<Tuser> empRoot = criteriaQuery.from(Tuser.class);

		criteriaQuery.select(empRoot).where(builder.equal(empRoot.get("email"), email),
				builder.equal(empRoot.get("password"), password));

		TypedQuery<Tuser> query = entityManager.createQuery(criteriaQuery).setParameter("email", tuser.getEmail())
				.setParameter("password", tuser.getPassword());

		if (query.getResultList().size() > 0) {
			return true;
		}
		return false;
	}
}
