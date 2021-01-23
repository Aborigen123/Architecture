package ua.auto.market.controller;

import java.io.IOException;
import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.auto.market.domain.CreateProduct;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.Customer;
import ua.auto.market.entity.DescriptionOrder;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.Status;
import ua.auto.market.entity.enumeration.TypeProduct;
import ua.auto.market.mapper.CreateProductMapper;
import ua.auto.market.service.CarImageService;
import ua.auto.market.service.CustomerService;
import ua.auto.market.service.DescriptionOrderService;
import ua.auto.market.service.util.CustomFileUtils;



@Controller
@RequestMapping("/admin")
public class AdminController {

@Autowired private CustomerService customerService;
@Autowired private DescriptionOrderService descriptionOrderService;
@Autowired private CarImageService carImageService;
	@GetMapping
	public String addPage(Model model, Principal principal) {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());
		
		model.addAttribute("Customer", customer);
		return "admin/pagecontrole";
	}
	

	
@GetMapping("/{nameCustomer}/add")
public String addProduct(Model model, Principal principal, @PathVariable ("nameCustomer")String nameCustomer) {

	CreateProduct createProduct = new CreateProduct();

	model.addAttribute("createProduct", createProduct);
	model.addAttribute("manufactures", Manufacture.values());
	model.addAttribute("typeProducts", TypeProduct.values());
	model.addAttribute("nameCustomer", nameCustomer);
	return "admin/add";
}

@PostMapping("/{nameCustomer}/add")
public String addProductPost(Model model,Principal principal,  @PathVariable ("nameCustomer")String nameCustomer, @ModelAttribute("createProduct") CreateProduct createProduct) throws IOException {
	Customer customer = customerService.findUserByNameCustomer(principal.getName());
	DescriptionOrder descr = CreateProductMapper.createProductToDescriptionOrder(createProduct);
   CarImage carImageSave =  CreateProductMapper.createProductToDescriptionOrder2(createProduct);

   descr.setStatus("expectation");
 //  MainOrder mainOrder = new MainOrder(descr, customer);
	descr.setCustomer(customer);
    carImageSave.setDescriptionOrder(descr);
	
	descriptionOrderService.saveDescriptionOrder(descr, carImageSave);

	
//	CustomFileUtils.createFolder("admin_product_"+ customer.getId());
	CustomFileUtils.createImageInUpload("admin_product_" + customer.getId(), createProduct.getCarImage1(),createProduct.getCarImage2(),createProduct.getCarImage3(),createProduct.getCarImage4(),createProduct.getCarImage5(),createProduct.getCarImage6());
	return "redirect:/admin/"+ nameCustomer+"/add";
}

		@GetMapping("/{nameCustomer}/comfirm")
		public String userMessages(Model model, Principal principal, @PathVariable ("nameCustomer")String nameCustomer) {

			model.addAttribute("nameCustomer",nameCustomer);
			model.addAttribute("item",descriptionOrderService.findProductByStatus("expectation"));
			return "admin/usermessages";
		}
		

		@GetMapping("/{nameCustomer}/comfirm/product/{id}")
		public String userDescribeOrder(Model model, Principal principal, @PathVariable ("nameCustomer")String nameCustomer, @PathVariable("id")Long id) throws IOException {
System.out.println("id = " + id);				
				DescriptionOrder descr = descriptionOrderService.findDuscriptionOrderImageById(id);//findDuscriptionOrderImageById
				CarImage carImage = carImageService.findCarImageById(id);
			
				DescriptionOrder descrProd = descriptionOrderService.findDescriptionOrderById(id);
					String image1 = carImage.getCarImage1();
					if(image1.isEmpty()) {
						image1 = "";
					}else {
					carImage.setCarImage1(
							CustomFileUtils.getImage(
									"admin_product_" + carImage.getId(), 
									image1));
					}
					String image2 = carImage.getCarImage2();
					if(image2.isEmpty()) {
						image2 = "";
					}else {
					carImage.setCarImage2(
							CustomFileUtils.getImage(
									"admin_product_" + carImage.getId(), 
									image2));
					}
					String image3 = carImage.getCarImage3();
					if(image3.isEmpty()) {
						image3 = "";
					}else {
					carImage.setCarImage3(
							CustomFileUtils.getImage(
									"admin_product_" + carImage.getId(), 
									image3));
					}
					String image4 = carImage.getCarImage4();
					if(image4.isEmpty()) {
						image4 = "";
					}else {
					carImage.setCarImage4(
							CustomFileUtils.getImage(
									"admin_product_" + carImage.getId(), 
									image4));
					}
					
					String image5 = carImage.getCarImage5();
					if(image5.isEmpty()) {
						image5 = "";
					}else {
					carImage.setCarImage5(
							CustomFileUtils.getImage(
									"admin_product_" + carImage.getId(), 
									image5));
					}
					
					String image6 = carImage.getCarImage6();
					if(image6.isEmpty()) {
						image6 = "";
					}else {
					carImage.setCarImage6(
							CustomFileUtils.getImage(
									"admin_product_" + carImage.getId(), 
									image6));
					}
				model.addAttribute("decriptionOrder",carImage);
				model.addAttribute("carImageList",carImage);
				model.addAttribute("status", Status.values());
			
				
//				CreateProduct createProduct = new CreateProduct();
//
//				model.addAttribute("createProduct", createProduct);
				
				
				System.out.println( " descrProd.getStatus() = " +  descrProd.getStatus());
				model.addAttribute("statusV", descrProd.getStatus());
				model.addAttribute("status", Status.values());
				model.addAttribute("id", descrProd.getId());
				model.addAttribute("nameCustomer", principal.getName());
				
			model.addAttribute("item",descriptionOrderService.findProductByStatus("expectation"));
			return "admin/descriptionOrder";
		}
		
		
		@PostMapping("/{nameCustomer}/comfirm/product/{id}/setstatus")
		public String setStatus(Model model,Principal principal,@RequestParam ("status")String status,  @PathVariable ("nameCustomer")String nameCustomer, @PathVariable("id") Long id) throws IOException {
			System.out.println("StatusSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			System.out.println("Status = "+ status);
			
			DescriptionOrder descr = descriptionOrderService.findDescriptionOrderById(id);
			
			descr.setStatus(status);
			
			descriptionOrderService.saveDescriptionOrderOne(descr);
			return "redirect:/admin/"+ nameCustomer+"/comfirm/product/"+id;
		}
}
