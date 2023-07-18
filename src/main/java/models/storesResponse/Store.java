package models.storesResponse;

import java.util.ArrayList;
import java.util.Date;

public class Store {

		public int id;
	    public String name;
	    public String type;
	    public String address;
	    public String address2;
	    public String city;
	    public String state;
	    public String zip;
	    public double lat;
	    public double lng;
	    public String hours;
	    public Date createdAt;
	    public Date updatedAt;
	    public ArrayList<Service> services;
}
