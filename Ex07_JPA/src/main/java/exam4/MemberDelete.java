package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberDelete {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Member4 user = em.find(Member4.class, "mem@tjoeun.com");
			
			if(user == null) {
				System.out.println("존재하지 않습니다");
				return;
			}
			em.remove(user);	
			
			
			em.getTransaction().commit();
			System.out.println("회원 탈퇴 되었습니다.");
		} catch(Exception e) {
		e.printStackTrace();
		em.getTransaction().rollback();
		} 
		em.close();
		emf.close();
	}
}
