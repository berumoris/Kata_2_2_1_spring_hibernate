package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
//      String hql = "FROM User";
      User user = null;

      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      List<User> list = query.getResultList();
      for (User u : list) {
         if (u.getCar().getModel().equals(model) && u.getCar().getSeries() == series) {
            user = u;
         }
//         System.out.println(car);
//         System.out.println(car.getUser());
//         user = car.getUser();
      }

//      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
//      List<Car> list = query.getResultList();
//      for (Car car : list) {
////         if (car.getSeries() == series && car.getModel().equals(model)) {
////            user = car.getUser();
////         }
//         System.out.println(car);
//         System.out.println(car.getUser());
//         user = car.getUser();
//      }

//      String HQL="FROM Address addr LEFT OUTER JOIN FETCH addr.employee WHERE addr.addressId=:addrId";
//      Address address = session.createQuery(HQL, Address.class).setParameter("addrId", 1).uniqueResult();

//      String HQL="SELECT User FROM Car c LEFT OUTER JOIN FETCH c.user WHERE c.series=:series";
//      User user = sessionFactory.openSession().createQuery(HQL, User.class).setParameter(series, 1).uniqueResult();
//      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("SELECT user from Car");

      return user;

   }


}
