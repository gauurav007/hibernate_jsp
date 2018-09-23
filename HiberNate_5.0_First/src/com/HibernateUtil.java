package com;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil 
{
	
	private static StandardServiceRegistry registry;
	
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory()
	{
		
		
		
		if(sessionFactory==null)
		{
			
			registry = new StandardServiceRegistryBuilder().configure().build();
			
			
			MetadataSources metadataSources = new MetadataSources(registry);
			
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			
		}
		
		return sessionFactory;
	}

}
