package org.jsp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.DAO.MerchantDao;
import org.jsp.DTO.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("Hibernate_template.xml");
		MerchantDao dao = context.getBean(MerchantDao.class);
		boolean go = true;
		while (go) {
			System.out.println("enter 1 for Save Merchant: ");
			System.out.println("enter 2 for update Merchant:");
			System.out.println("enter 3 for delete Merchant:");
			System.out.println("enter 4 for fetch single object");
			System.out.println("enter 5 for fetch all objects");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Merchant m = new Merchant();
				System.out.println("enter name");
				m.setName(sc.next());
				System.out.println("enter phone");
				m.setPhone(sc.nextLong());
				System.out.println("enter email");
				m.setEmail(sc.next());
				System.out.println("enter password");
				m.setPassword(sc.next());
				System.out.println("enter gst");
				m.setGst(sc.nextDouble());
				int saveMerchant = dao.SaveMerchant(m);
				System.out.println(saveMerchant);
				break;
			case 2:
				Merchant m1 = new Merchant();
				System.out.println("enter id");
				m1.setId(sc.nextInt());
				System.out.println("enter name");
				m1.setName(sc.next());
				System.out.println("enter phone");
				m1.setPhone(sc.nextLong());
				System.out.println("enter email");
				m1.setEmail(sc.next());
				System.out.println("enter password");
				m1.setPassword(sc.next());
				System.out.println("enter gst");
				m1.setGst(sc.nextDouble());
				dao.UpdateMerchant(m1);
				System.out.println("one record updated");
				break;
			case 3:
				System.out.println("Enter Merchant Id to Delete :");
				String msg = dao.DeleteMerchantById(sc.nextInt());
				System.out.println(msg);
				break;
			case 4:
				System.out.println("Enter Merchant Id to Fetch Record:");
				Merchant fetchMe = dao.findById(sc.nextInt());
				System.out.println(fetchMe.getId() + " " + fetchMe.getName() + " " + fetchMe.getPhone() + " "
						+ fetchMe.getEmail() + " " + fetchMe.getPassword() + " " + fetchMe.getGst());
				break;
			case 5:
				List<Merchant> fetchAllMerchant = dao.findAll();
				for (Merchant me : fetchAllMerchant) {
					System.out.println(me.getId());
					System.out.println(me.getName());
					System.out.println(me.getPhone());
					System.out.println(me.getEmail());
					System.out.println(me.getPassword());
					System.out.println(me.getGst());
					System.out.println("_____________________");
				}
				break;
			default:
				System.out.println("invalid User Option:");
				break;
			}
		}
	}
}
