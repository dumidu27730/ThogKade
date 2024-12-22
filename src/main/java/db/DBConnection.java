package db;

import model.Customer;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    private List<Customer> connection1;
    private List<Item> connection2;

    private DBConnection(){
        connection1=new ArrayList<Customer>();
        connection2=new ArrayList<Item>();
    }


    public java.util.List<Customer> getConnection1() {
        return connection1;
    }
    public java.util.List<Item> getConnection2() {
        return connection2;
    }

    public static DBConnection getInstance(){
        return null==instance?instance = new DBConnection():instance;
    /* if(null == instance){
        return instance=new DBConnection();
        }
        return instance;
     */
    }
}
