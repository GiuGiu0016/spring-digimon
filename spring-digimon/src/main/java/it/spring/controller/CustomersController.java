package it.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.spring.model.Customers;
import it.spring.service.CustomersService;

@Controller
public class CustomersController {

	@Autowired 
	private CustomersService cService;
	
	@RequestMapping("/new")
	public String newForm(Map<String, Object> model) {
		Customers c = new Customers();
		model.put("customers", c);
		return "new_customers";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("customers") Customers customers) {
		cService.save(customers);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_customers");
		Customers c = cService.get(id);
		mav.addObject("customers", c);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteForm(@RequestParam long id) {
		cService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Customers> result = cService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}
}
