package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PersonService personService;
	
	List<Orderline> orderLineList = new ArrayList<Orderline>();
	
	Order order = new Order();
	
	@RequestMapping(value="/user/listItems", method=RequestMethod.GET)
	public String listOrder(Model model){
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("products",productList);
		return "listItems";
	}
	
	//@RequestMapping(value="/user/selectOrder/{id}")
	
	@RequestMapping(value="/user/order/{id}/quantity", method=RequestMethod.GET)
	public String loadQuantityPage(@PathVariable("id") int id, Model model, HttpSession session){
		Orderline orderLine = new Orderline();
		session.setAttribute("orderLine", orderLine);
//		Product selectedProduct = productService.getProduct(id);
		
		model.addAttribute("orderLine",orderLine);
//		model.addAttribute("selectedProduct", selectedProduct);
		
		return "selectQuantity";
	}
	
	@RequestMapping(value="/user/order/{id}/quantity", method=RequestMethod.POST)
	public String addToCart(@PathVariable("id") int id, Model model, 
			@ModelAttribute("orderLine") Orderline orderLine, HttpSession session){
		
		Orderline cart = new Orderline();
		
		Product selectedProduct = productService.getProduct(id);
		
		cart.setQuantity(orderLine.getQuantity());
		cart.setProduct(selectedProduct);
		
		order.addOrderLine(cart);
		
		session.setAttribute("totalItems", order.getOrderLines().size());
		
		return "redirect:/user/listItems";
	}
	
	@RequestMapping(value="/user/order/submitOrder", method=RequestMethod.GET)
	public String submitFinalOrder(HttpSession session){
		order.setPerson(personService.findById(new Long(7)));
		order.setOrderDate(new Date());
		orderService.save(order);
		order.clearOrderLines();
		
		session.removeAttribute("totalItems");
		
		return "thankCustomer";
	}
	
	@RequestMapping(value="/admin/listOrders", method=RequestMethod.GET)
	public String loadOrderPage(Model model){
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orders",orderList);
		return "orderList";
	}
	
	@RequestMapping(value="/admin/order/orderDetails/{id}", method=RequestMethod.GET)
	public String loadOrderDetailsPage(@PathVariable("id") int id, Model model){
		List<Orderline> orderLineList = orderService.findById(id).getOrderLines();
		model.addAttribute("orderLineList",orderLineList);
		return "orderDetails";
	}
}
