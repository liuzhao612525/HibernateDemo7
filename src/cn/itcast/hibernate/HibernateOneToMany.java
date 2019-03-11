package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.manytomany.Role;
import cn.itcast.manytomany.User;
import cn.itcast.uitls.HibernateUtils;

public class HibernateOneToMany {
	
	
	@Test
	public void testUpDateDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			User user = session.get(User.class, 2);
			Role role =  session.get(Role.class, 11);
			
			user.getRoles().add(role);
//			role.getUsers().add(user);

			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testDeleteDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			User user = session.get(User.class, 6);
			session.delete(user);
			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testAddDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			User user1 = new User();
			user1.setUser_name("张三");
			user1.setUser_password("fdfdf");
			
			User user2 = new User();
			user2.setUser_name("李四");
			user2.setUser_password("ddd");
			
			Role role1 = new Role();
			role1.setRole_name("aaa");
			role1.setRole_desc("fdfadfa");
			
			Role role2 = new Role();
			role2.setRole_name("bbb");
			role2.setRole_desc("fdfadfa");
			
			Role role3 = new Role();
			role3.setRole_name("ccc");
			role3.setRole_desc("fdfadfa");
			
			
			user1.getRoles().add(role1);
			user1.getRoles().add(role2);
			
			user2.getRoles().add(role2);
			user2.getRoles().add(role3);
			
			//保存
			session.save(user1);
			session.save(user2);
			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
