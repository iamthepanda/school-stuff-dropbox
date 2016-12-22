// DO NOT ADD NEW METHODS OR NEW DATA FIELDS!

package PJ3;

class Customer
{
    private int customerID;
    private int serviceTime;
    private int arrivalTime;

    // default constructor
    Customer()
    {
	// add statements
    }

    // constructor to set customerID, serviceTime and arrivalTime
    Customer(int customerid, int servicetime, int arrivaltime)
    {
	// add statements
  	arrivalTime = arrivaltime;
    }

    int getServiceTime() 
    {
	// add statements
  	return 0;
    }

    int getArrivalTime() 
    {
	// add statements
  	return 0;
    }

    int getCustomerID() 
    {
        return customerID;
    }

    public String toString()
    {
    	return "customerID="+customerID+":serviceTime="+
               serviceTime+":arrivalTime="+arrivalTime;

    }

    public static void main(String[] args) {
        // quick check!
	Customer mycustomer = new Customer(1,35,5);
	System.out.println("Customer Info --> "+mycustomer);

    }
}
