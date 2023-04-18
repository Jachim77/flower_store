import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/engeto","user1","Klacicek456?1");
        Statement statement = connection.createStatement();
        //nacteni databaze
        System.out.println("Původní seznam květin:");
        ResultSet resulset = statement.executeQuery("select * from kvetiny");
        while (resulset.next()) {
            System.out.println(resulset.getString("name"));
        }
        System.out.println();
        //pridani dvou kvetin
        statement.executeUpdate("insert into kvetiny (name,colour,description,poisonous) values ('Bledule','bílá','4 květy',0)");
        statement.executeUpdate("insert into kvetiny (name,colour,description,poisonous) values ('Kopretina','bílá','Má ráda slunce',0)");
        System.out.println("Aktualizovaný seznam květin:");
        ResultSet resultSet1 = statement.executeQuery("select * from kvetiny");
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("name"));
        }
        System.out.println();
        //zmena desription
        statement.executeUpdate("update kvetiny set description = 'Pozor na cibulku, obsahuje největší koncentraci jedu !' where name = 'bledule'");

        //vymazání nejedovatých rostlin
        statement.executeUpdate("delete from kvetiny where poisonous = 0");
        System.out.println("Seznam všech jedovatých květin:");
        ResultSet resultSet2 = statement.executeQuery("select * from kvetiny");
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("name"));
        }
    }
}