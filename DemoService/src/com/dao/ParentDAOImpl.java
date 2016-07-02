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

	@Override
	public void createParent(Parent parent) {
		entityManager.getTransaction().begin();
		entityManager.persist(parent);
		entityManager.getTransaction().commit();
	}

	@Override
	public void deleteParent(int parentId) {
		Parent parent = getParentById(parentId);
		if (parent != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(parent);
			entityManager.getTransaction().commit();
		}
	}

	public Parent getParentById(int parentId) {
		return entityManager.find(Parent.class, parentId);
	}

	@Override
	public void updateParent(Parent parent) {
		Parent foundParent = getParentByUsernameAndPassword(parent.getTuser().getEmail(),
				parent.getTuser().getPassword());
		if (foundParent != null) {
			Parent parent2 = new Parent();
			parent2.setName(parent.getName());
			parent2.setSurname(parent.getSurname());
			parent2.setTelNumber(parent.getTelNumber());
			parent2.setTuser(parent.getTuser());
			entityManager.getTransaction().begin();
			entityManager.remove(foundParent);
			entityManager.persist(parent2);
			entityManager.getTransaction().commit();
		}
	}

	private Parent getParentByUsernameAndPassword(String email1, String password1) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Parent> criteriaQuery = builder.createQuery(Parent.class);

		ParameterExpression<String> email = builder.parameter(String.class, "email");
		ParameterExpression<String> password = builder.parameter(String.class, "password");

		Root<Parent> empRoot = criteriaQuery.from(Parent.class);

		criteriaQuery.select(empRoot).where(builder.equal(empRoot.get("tuser").get("email"), email),
				builder.equal(empRoot.get("tuser").get("password"), password));

		TypedQuery<Parent> query = entityManager.createQuery(criteriaQuery).setParameter("email", email1)
				.setParameter("password", password1);

		return query.getSingleResult();
	}

}
