package com.acc.rahul.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.acc.rahul.dto.Address;
import com.acc.rahul.dto.FourWheeler;
import com.acc.rahul.dto.Student;
import com.acc.rahul.dto.TwoWheeler;
import com.acc.rahul.dto.Vehicle;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Address homeAddr = new Address();
		homeAddr.setCity("home city");
		homeAddr.setPincode("home pin");
		homeAddr.setState("home state");
		homeAddr.setStreetName("home street name");
				
		Address officeAddr = new Address();
		officeAddr.setCity("office city");
		officeAddr.setPincode("office pin");
		officeAddr.setState("office state");
		officeAddr.setStreetName("office street name");
		
		Student s1 = new Student();		
		s1.setsName("rahul");
		
		Student s2 = new Student();		
		s2.setsName("pratik");
		
		/*s1.getListOfAddresses().add(officeAddr);
		s1.getListOfAddresses().add(homeAddr);*/
		
		Vehicle v1 = new Vehicle();
		//v1.setVehicleId(1);
		v1.setVehicleName("vehicle");
		
		TwoWheeler v2 = new TwoWheeler();
		//v2.setVehicleId(2);
		v2.setVehicleName("bike");
		v2.setSteeringHandle("bike handle");
		
		FourWheeler v3 = new FourWheeler();
		//v3.setVehicleId(3);
		v3.setVehicleName("car");
	v3.setSteeringwheel("Car steeringWheel");
		
		
		
		Session session = null;
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = new Configuration().configure("hib.xml")
					.buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Vehicle v;
			
			
			
			/*for(int i=0;i<10;i++){
				v= new Vehicle();
				v.setVehicleName("vehicle "+(i+1)+"where 1=1");
			session.save(v);
			}
			session.getTransaction().commit();
			*/
			Query query = session.getNamedQuery("vehicle.byVehicleId");
			query.setInteger(0, 6);
			//query.setFirstResult(2);
			List<Vehicle> vehicle = (List<Vehicle>) query.list();
			session.getTransaction().commit();
			System.out.println(vehicle.size());
		
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();			
		} finally {
			session.close();
		}
		
		Set<Integer> set = new HashSet<Integer>();
	}

}
