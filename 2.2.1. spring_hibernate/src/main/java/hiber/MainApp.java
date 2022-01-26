package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Mads", "Mikkelsen", "mikkelsen1965@mail.ru", new Car("Toyota", 11)));
      userService.add(new User("Johnny", "Depp", "amberturd@ya.ru", new Car("Lada", 9)));
      userService.add(new User("Helena ", "Carter", "crazyalise@bk.ru", new Car("Moskvisch", 412)));
      userService.add(new User("Keanu", "Reeves", "matix4@hmail.ru", new Car("Porshe", 911)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println();
      }

            System.out.println(userService.getUserByCar("Toyota", 11));

      context.close();
   }
}
