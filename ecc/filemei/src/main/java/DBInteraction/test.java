package DBInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DBController.DBController;

public class test {
	public test() {
		DBController a= new DBController();
		a.Connect("testd");
	}
}
