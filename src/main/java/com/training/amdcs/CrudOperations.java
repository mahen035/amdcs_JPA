package com.training.amdcs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CrudOperations {
	
	public void insertEntity() {
		EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entity = emFactoryObj.createEntityManager();
		entity.getTransaction().begin();
		
		Employee emp=new Employee("Joe", 1500);
		entity.persist(emp);
		entity.getTransaction().commit();
		entity.close();
		emFactoryObj.close();
	}
	
	public void updateEntity() {
		EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entity = emFactoryObj.createEntityManager();
		entity.getTransaction().begin();
		
		Employee emp = entity.find(Employee.class, 1);
		
		emp.setSalary(2300);
		entity.getTransaction().commit();
		entity.close();
		emFactoryObj.close();
	
	}
	
	public void findEntity() {
		EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entity = emFactoryObj.createEntityManager();
		entity.getTransaction().begin();
		Employee emp = entity.find(Employee.class, 1);
		System.out.println("Employee Name: "+emp.getEmpName());
		entity.getTransaction().commit();
		entity.close();
		emFactoryObj.close();
		
	}
	
	public void removeEntity() {
		EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entity = emFactoryObj.createEntityManager();
		entity.getTransaction().begin();
		
		Employee emp = entity.find(Employee.class, 1);
		
		entity.remove(emp);
		entity.getTransaction().commit();
		entity.close();
		emFactoryObj.close();
		
	}

}
