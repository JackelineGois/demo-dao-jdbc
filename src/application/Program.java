import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

  public static void main(String[] args) {
    SellerDao sellerDao = DaoFactory.creatSellerDao();

    System.out.println("=== Teste 1: sellerById ===");
    Seller seller = sellerDao.findById(3);
    System.out.println(seller);

    System.out.println("=== Teste 2: findByDepartment ===");
    Department department = new Department(2, null);
    List<Seller> list = sellerDao.findByDepartment(department);
    for (Seller obj : list) {
      System.out.println(obj);
    }

    System.out.println("=== Teste 3: findAll ===");

    list = sellerDao.findAll();
    for (Seller obj : list) {
      System.out.println(obj);
    }

    System.out.println("=== Teste 4: Insert ===");
    Seller newSeller = new Seller(
      null,
      "Jacke",
      "jacke@gmail.com",
      new Date(0),
      10.000,
      department
    );
    sellerDao.insert(newSeller);
    System.out.println("Inserted! new Id = " + newSeller.getId());

    System.out.println("=== Teste 5:  UPdate===");
    seller = sellerDao.findById(1);
    seller.setName("Martha Waine");
    sellerDao.update(seller);
    System.out.println("Update completed");

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter id for delete test: ");
    int n = sc.nextInt();
    seller = sellerDao.findById(n);
    sellerDao.deleteById(n);
    System.out.println("Id deletado!");
    sc.close();
  }
}
