import entities.Drink;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Order;

import java.util.Date;
import java.util.HashMap;

public class TestOrder {
    @Test
    public void testOrder(){
        Date date1 = new Date();
        Drink drink1 = new Drink("1", 1.0f, "I am description", "beef milk pig", 10, date1, date1, 1);
        Drink drink2 = new Drink("2", 2.0f, "I am description", "chicken milk pig", 1, date1, date1, 1);
        Drink drink3 = new Drink("3", 1.5f, "I am description", "beef orange superman", 100, date1, date1, 1);
        HashMap<Drink, Integer> orderlist1 = new HashMap<>();
        orderlist1.put(drink1, 1);
        orderlist1.put(drink2, 8);
        orderlist1.put(drink3, 3);
        Order order1 = new Order(orderlist1, "I am orderStatus");
        /*test getOrderList()*/
        HashMap<Drink, Integer> orderlist2 = order1.getOrderList();
        assertEquals(orderlist2, orderlist1);
        /*test setOrderNum() and getOrderNum()*/
        order1.setOrderNum(100);
        int ordernum1 = order1.getOrderNum();
        assertEquals(ordernum1, 100);
        /*test setOrderStatus() and getOrderStatus()*/
        order1.setOrderStatus("new status");
        String status1 = order1.getOrderStatus();
        assertEquals(status1, "new status");
        /*test setTotalOrder() and getTotalOrder()*/
        Order.setTotalOrder(10);
        int totalorder1 = order1.getTotalOrder();
        assertEquals(totalorder1, 10);
    }
}
