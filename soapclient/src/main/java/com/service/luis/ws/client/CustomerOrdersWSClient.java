package com.service.luis.ws.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.service.luis.CustomerOrdersPortType;
import com.service.luis.CustomerOrdersService;
import com.service.luis.GetOrdersRequest;
import com.service.luis.GetOrdersResponse;
import com.service.luis.Order;
import com.service.luis.Product;

public class CustomerOrdersWSClient {

	public static void main(String[] args) {
		try {
			CustomerOrdersService service = new CustomerOrdersService(
					new URL("http://localhost:8080/basic_wsdl/services/customerOrders?wsdl"));
			CustomerOrdersPortType port = service.getCustomerOrdersPort();
			GetOrdersRequest request = new GetOrdersRequest();
			request.setCustomerId(BigInteger.valueOf(1));
			GetOrdersResponse response = port.getOrders(request);
			List<Order> orders = response.getOrder();
			for (Order order : orders) {
				List<Product> products = order.getProduct();
				for (Product product : products) {
					System.out.println("Product Description " + product.getDescription());
					System.out.println("Product Quantity  " + product.getQuantity());
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
