import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
	
	public static void main(String[] args) {
		
		Configuration cfg= new Configuration().configure("hibernet2.cfg.xml");
		
		SessionFactory sf =cfg.buildSessionFactory();
		
		//ProductDetails(sf);
		
		Session session=sf.openSession();
		
		Transaction ts= session.beginTransaction();
		
		Company company=session.get(Company.class, 201);
		System.out.println(company);
//		Company c = new Company();
//		c.setCid(201);
//		c.setCname("Google");
//		c.setCaddress("Pune");
//		
//		session.save(c);
		
		//ts.commit();
		
		//System.out.println("Company Details Saved Successfully");
	}

	private static void ProductDetails(SessionFactory sf) {
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Product p = new Product();
		p.setPid(102);
		p.setPname("SamsungS24Ultra");
		p.setPaddress("Pune");
		
		session.save(p);
		
		tx.commit();
		System.out.println("Product Details Saved Successfully");
	}

}
