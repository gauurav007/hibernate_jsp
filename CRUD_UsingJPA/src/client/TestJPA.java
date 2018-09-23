package client;

import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Student;

public class TestJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_First");
		
		EntityManager entityManager = factory.createEntityManager();
		
		
		while(true)
		{
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n\n1.Insert Data");
			System.out.println("2.Update Data");
			System.out.println("3.Read Data");
			System.out.println("4.Delete Data");
			System.out.println("5.Search Data");
			System.out.println("6.Exit\n\n");
			
			
			
			System.out.println("Enter a choice");
			
			int choice = sc.nextInt();
			
			
			switch (choice) 
			{
			case 1:
				
				
				System.out.println("how many students data u wnt to insert");
				int totalStudent = sc.nextInt();
				
				
				for(int i=0;i<=totalStudent;i++)
				{
				
					entityManager.getTransaction().begin();
					
					Student stu = new Student();
				
					
					System.out.println("Enter students name");
					stu.setName(sc.next());
					
					System.out.println("Enter students address");
					stu.setAddress(sc.next());
					
					
					entityManager.persist(stu);
					
					entityManager.getTransaction().commit();
				
				}
				
					
			//	entityManager.close();
				
				
				break;
				
			case 2:
				
				
				readStudentData();
				
				entityManager.getTransaction().begin();
				

				System.out.println("enter roll whose data u wnt to update");
				
				int update_roll = sc.nextInt();
				
				Student stu2 = entityManager.find(Student.class, update_roll);
				
				System.out.println("Enter a new name");
				stu2.setName(sc.next());
				
				System.out.println("Enter a new address");
				stu2.setAddress(sc.next());
				
				entityManager.getTransaction().commit();
				
				break;
				
			case 3:
	
				
				
				readStudentData();
				
				
				
				/*System.out.println("enter id whose data u ewnt to read");
				
				int roll = sc.nextInt();
				
				Student stu3 = entityManager.find(Student.class, roll);
				
				System.out.println(stu3.getRoll()+" "+stu3.getAddress()+" "+stu3.getName());*/
				
				break;
		
				case 4:
				
					
					System.out.println("enter roll whose data u wnt to delete");
					
					int rolll = sc.nextInt();
					entityManager.getTransaction().begin();
					
					
					Student stu4 = entityManager.find(Student.class, rolll);
					
					entityManager.remove(stu4);
					
					entityManager.getTransaction().commit();
					
					break;

					
				case 5:
					
					//System.exit(0);
					
					System.out.println("enter stu name u want to search");
					String stu_name = sc.next();
					
					Query query = entityManager.createQuery("select s from Student s where name='"+stu_name+"' ");
					List<Student> students = ((Object) query).getResultList();
					
					if(students.isEmpty())
					{
						System.out.println("data no found");
					}
					else
					{
						
						for (Student student : students) {
							
							
							System.out.println(student.getRoll()+"\t\t"+student.getName()+"\t\t"+student.getAddress());
						}
					
						
					}
				
					
					
					
					
					break;
					
				case 6:
					
					System.exit(0);
					
					break;
					
			default:
				
				System.out.println("invalid choice");
				
				break;
			}

			
			
		}
		
			
		
	
	}

	private static void readStudentData() {
		// TODO Auto-generated method stub
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_First");
		
		EntityManager entityManager = factory.createEntityManager();
		
		
		Query query = entityManager.createQuery("select s from Student s");
		
		
		List<Student> students = query.getResultList();
		
		for (Student student : students) {
			
			
			System.out.println(student.getRoll()+" "+student.getAddress()+" "+student.getName());
			
			
		}
	}

}
