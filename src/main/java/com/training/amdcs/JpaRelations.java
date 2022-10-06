package com.training.amdcs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JpaRelations {
	
	
	
	public static void main(String args[]) {
		EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("JPADemo");

		EntityManager entity = emFactoryObj.createEntityManager();
	
		entity.getTransaction().begin();
		//Session session = entity.unwrap(Session.class);
		Employee emp = new Employee("John", 1000);
		emp.setEmpName("Kevin");
		emp.setSalary(2000);
		//session.save(emp);
		entity.merge(emp);
		entity.getTransaction().commit();
		entity.close();
		emFactoryObj.close();
	}

}
