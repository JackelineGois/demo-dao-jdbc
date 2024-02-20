import java.util.List;
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
  }
}
