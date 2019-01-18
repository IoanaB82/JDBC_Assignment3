import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
//nu tb sa importam ceva java.util pt exceptie pt ca este inclus in celelalte doua importuri

public class Assignment3{
  public static Connection getConnection() throws Exception{
    //facem chestia asta ca sa testam daca se face legatura la server cu un utilizator si parola
    try{
      String url = "jdbc:mysql://localhost:3306/sqlandjava";
      String username = "user";
      String password = "password";
      Connection conn = DriverManager.getConnection(url, username, password);
      System.out.println("Connected to database!");
      return conn;
    } catch(Exception e){System.out.println(e);}
    return null;
  }





  public static void main(String[] args) throws Exception{
  //hampus recomanda ca in Windows sa folosim cmd pentru a scrie codul ca sa nu avem erori aiurea
//Get Connection
  Connection conn = getConnection();

  /*create query
  String query = "SELECT * FROM "*/

  //create statement
  Statement statement = conn.createStatement();


  //Execute SQL Query
  //ResultSet res = statement.executeQuery("select * from owners, people, cars");
  ArrayList<Owners> getEntries(){
    ArrayList<Owners> owners = new ArrayList<Owners>();
    ResultSet res = statement.executeQuery("select * from owners");
    while(res.next()){
      String owner_id = res.getString("owner_id");
      String person_id = res.getString("person_id");
      String car_id = res.getString("car_id");
    }
    return owners;
  }

  ArrayList<People> getEntries(){
    ArrayList<People> people = new ArrayList<People>();
    ResultSet res = statement.executeQuery("select * from people");
    while(res.next()){
      String person_id = res.getString("people_id");
      String firstname = res.getString("firstname");
      String lastname = res.getString("lastname");
    }
    return people;
  }

  ArrayList<Cars> getEntries(){
    ArrayList<cars> cars = new ArrayList<Cars>();
    ResultSet res = statement.executeQuery("select * from cars");
    while(res.next()){
      String car_id = res.getString("people_id");
      String brand = res.getString("brand");
      String color = res.getString("color");
    }
    return cars;
  }

  /*while (res.next()){

    String owner_id = res.getString("id");
    String person_id = res.getString("person_id");
    String car_id = res.getString("car_id");
    String firstname = res.getString("firstname");
    String lastname = res.getString("lastname");
    String brand = res.getString("brand");
    String color = res.getString("color");


    System.out.println(firstname +" "+ lastname+" "+ brand +" "+ color);
  }
    //process ResultSet
  /*while(res.next()){


    System.out.println(res.getString("car_id")+": "+res.getString("brand")+" "+res.getString("color"));

  }*/





  }

}
