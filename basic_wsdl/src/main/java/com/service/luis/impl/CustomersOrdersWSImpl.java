package com.service.luis.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.service.luis.CreateOrdersRequest;
import com.service.luis.CreateOrdersResponse;
import com.service.luis.CustomerOrdersPortType;
import com.service.luis.GetOrdersRequest;
import com.service.luis.GetOrdersResponse;
import com.service.luis.Order;
import com.service.luis.Product;

public class CustomersOrdersWSImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	
	int currentCustomerId;

	public CustomersOrdersWSImpl() {
		init();
	}

	public void init() {
		List<Order> orders = new ArrayList<Order>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		Product product = new Product();
		product.setDescription("IPhone");
		product.setId("1");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentCustomerId), orders);
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);

		GetOrdersResponse response = new GetOrdersResponse();
		List<Order> responseOrders = response.getOrder();
		for (Order order : orders) {
			responseOrders.add(order);
		}

		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		Order order = request.getOrder();

		List<Order> currentOrders = customerOrders.get(request.getCustomerId());
		currentOrders.add(order);
		CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();

		createOrdersResponse.setResult(true);
		return createOrdersResponse;
	}
}
