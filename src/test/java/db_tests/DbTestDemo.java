package db_tests;

import org.testng.annotations.Test;
import utilities.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTestDemo {


//we will not need the entire code because we separate it and put it in the (DBUtils) file
//    @Test
//    public void testDB(){
//        //this is the host name when we first connect to MySQL we have to add it
//        String dbUrl = "jdbc:mysql://stack-overflow.cfse9bqqndon.us-east-1.rds.amazonaws.com/CraterDBS";
//        String userName = "craterdbuser";//we have to add this when we first connect to MySQL
//        String password = "ptschool2023";//we have to add this when we first connect to MySQL
//        String query = "select * from CraterDBS.invoices order by invoice_number desc;";//query command
//
//        //1. Create a connection or build a connection
//        try {
//            /**
//             * A Connection object represents a connection with a database.
//             * A SQL statement is executed through the Connection object.
//             * The Connection object is used to create a Statement object.
//             */
//
//            //here we will use Connection class to get connect to data base and we have to pass those 3 dbUrl,
//            //userName, password. but the getConnection(dbUrl, userName, password); will complain so we will
//            //click on more action then surround it with try catch in case if we pass wrong user name or
//            //password so it will go directly to the catch statement in the bottom
//            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
//
//            //2. Create a statement for writing the query in the data base  bench work MySQL
//            Statement statement = connection.createStatement();
//
//            //3. Execute our query
//            /**
//             * A ResultSet object is a table of data representing a database result set,
//             * which is usually generated by executing a statement that queries the database.
//             * You need to import java.sql.ResultSet class to use this class.
//             * It maintains a cursor that points to the current row in the result set.
//             * Initially, the cursor is positioned before the first row.
//             * The next() method moves the cursor to the next row, and because it returns false when there are no more rows in the ResultSet object,
//             * it can be used in a while loop to iterate through the result set.
//             * The getXXX() method retrieves the value of a column in the current row.
//             * You must specify the column number to retrieve the value of that column.
//             *
//             */
//            //this is to execute the query and save it in a resultSet a type of ResultSet
//            ResultSet resultSet = statement.executeQuery(query);
//
//            //here we will use a method getMetaData() to get what we need of data from the result that we getting
//            //back from the query in MySQL work bench and we will assign it to rsmd a type of ResultSetMetaData
//            //because when we hover over the getMetaData() we will see the return type is  ResultSetMetaData
//            //note: as a testing engineer we need to know getColumnCount() and getColumnName(i) only
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            int colCount = rsmd.getColumnCount();//here we will get the number of columns
//            for (int i = 1; i < colCount ; i++) {//we put i = 1 because if we put 0 it will start from the column name
//                //System.out.println("Column name is " + rsmd.getColumnName(i));
//                //System.out.println("Column type is " + rsmd.getColumnType(i));
//                //System.out.println("Column display size is " + rsmd.getColumnDisplaySize(i));
//            }
//
//            //this is the biggest list that include all the rows list in it
//            List<List<String>> data = new ArrayList<>();
//            /**
//             * The next() method moves the cursor to the next row in the ResultSet object.
//             * Initially, the cursor is positioned before the first row.
//             * The next() method returns false when there are no more rows in the ResultSet object.
//             */
//            //this (while) will check the rows one after another because we are using the next() so it will go to
//            //the first row if it exists it will go to the second until there is non it will read false then stop
//            while(resultSet.next()){
//                //System.out.println(resultSet.getString("invoice_number"));
//
//                //here we will get a list of all rows
//                List<String> row = new ArrayList<>();
//
//                //this for loop will check each column in the row that coming from while loop above and once it is
//                //finished it will go to while loop to go to the second row and get all the columns in second row
//                //and to th end
//                for (int i = 1; i < colCount ; i++) {
//                    //System.out.print(resultSet.getString(i) + "|| ");
//                    row.add(resultSet.getString(i));
//                }
//                data.add(row);//to put all the rows in the list data
//                //System.out.println();
//            }
//            System.out.println(data);//to print the parent list
//
//            //you always make sure you close all your connection
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            System.out.println("Connection not successful");
//            e.printStackTrace();
//        }
//
//
//    }

    //declaring the query command
    String query = "select * from CraterDBS.invoices order by invoice_number desc;";

    @Test
    public void testDemoWithDBUtils(){
        //calling the methodexecuteQuery(query) and passing the query command inside
        DBUtils.executeQuery(query);
        System.out.println("---------");

        //calling the selectRecord(query) to get the first row with all columns in it
        DBUtils.selectRecord(query);
        System.out.println("---------");

        //calling the selectRecord(query) to get the first row and the column "invoice_number" inside of that
        //first row
        DBUtils.selectRecord(query, "invoice_number");
    }

}