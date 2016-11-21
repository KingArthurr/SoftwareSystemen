package ss.week3.test;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.Bill.Item;
import ss.week3.hotel.BillItem;

import static org.junit.Assert.*;

public class BillTest {
	
    private Bill bill;
    private Item item;
    private Item item2;
    private static final double som1 = 0;
    private static final double som2 = 5;

    @Before
    public void setUp() {
        bill = new Bill(System.out);
        item = new BillItem("1", 2.00);
        item2 = new BillItem("2", 3.00);
    }

    @Test
    public void testGetSum() {
    	assertTrue(som1 == bill.getSum());
        
        bill.newItem(item);
        bill.newItem(item2);
        
        assertTrue(som2 == bill.getSum());
        
        bill.close();
    }
}