package ua.auto.market.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.criteria.Expression;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import ua.auto.market.domain.CreateProduct;
import ua.auto.market.domain.CreateProduct2;
import ua.auto.market.domain.CustomerRegistrationRequest;
import ua.auto.market.domain.DescriptionOrderFilter;
import ua.auto.market.domain.LoginRequest;
import ua.auto.market.domain.ProductNameFilter;
import ua.auto.market.entity.CarImage;
import ua.auto.market.entity.Customer;
import ua.auto.market.entity.DescriptionOrder;
import ua.auto.market.entity.ProductOnSell;
import ua.auto.market.entity.enumeration.Manufacture;
import ua.auto.market.entity.enumeration.TypeProduct;
import ua.auto.market.mapper.CreateProductMapper;
import ua.auto.market.mapper.CustomerMapper;
import ua.auto.market.repository.CarImageRepository;
import ua.auto.market.service.CarImageService;
import ua.auto.market.service.CustomerService;
import ua.auto.market.service.DescriptionOrderService;
import ua.auto.market.service.ProductOnSellService;
import ua.auto.market.service.util.CustomFileUtils;








@Controller
@SessionAttributes({"manufactures", "typeProducts"})
public class BaseController {

	@Autowired private CustomerService customerService;
	@Autowired private ProductOnSellService productOnSellService;
	@Autowired private DescriptionOrderService descriptionOrderService;
	@Autowired private CarImageService carImageService;
	@Autowired private CarImageRepository carImageRepository;
	
	@GetMapping({"/", "/home"})
	public String showHome(
		Model model
			) throws IOException {

		//List<DescriptionOrder> descriptionOrder = descriptionOrderService.findAllDescriptionOrder();
	
		
		
		
		List<CarImage> carImage = carImageService.findAllCarImage();
		
	
		

       for(int i = 0; i < carImage.size(); i++) {
    	   String image = carImage.get(i).getCarImage1();
    	   if(image.isEmpty()) {
   			image="";
   		}
			carImage.get(i).setCarImage1(
					CustomFileUtils.getImage2(
							image)
							);
			
		}

		model.addAttribute("manufactures", Manufacture.values());
		model.addAttribute("typeProducts", TypeProduct.values());
		model.addAttribute("descriptionOrderList", descriptionOrderService.findAllDescriptionOrder());
        model.addAttribute("carImageList", carImage);	
	
		return "home";
	}
	
	
	@GetMapping("/{username}")
	public String addPage(Model model, Principal principal) {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());

		model.addAttribute("Customer", customer);
		return "user/customerpagecontrole";
	}
	
	@GetMapping("user/{username}/add")
	public String addProduct(Model model, Principal principal, @PathVariable ("username")String nameCustomer) {

		CreateProduct createProduct = new CreateProduct();

		model.addAttribute("createProduct", createProduct);
		model.addAttribute("manufactures", Manufacture.values());
		model.addAttribute("typeProducts", TypeProduct.values());
		model.addAttribute("nameCustomer", nameCustomer);
		return "user/add";
	}

	@PostMapping("user/{username}/add")
	public String addProductPost(Model model,Principal principal,  @PathVariable ("username")String nameCustomer, @ModelAttribute("createProduct") CreateProduct createProduct) throws IOException {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());
		DescriptionOrder descr = CreateProductMapper.createProductToDescriptionOrder(createProduct);
	   CarImage carImageSave =  CreateProductMapper.createProductToDescriptionOrder2(createProduct);

	   descr.setStatus("expectation");
	 //  MainOrder mainOrder = new MainOrder(descr, customer);
		descr.setCustomer(customer);
	    carImageSave.setDescriptionOrder(descr);
		
		descriptionOrderService.saveDescriptionOrder(descr, carImageSave);

		
//		CustomFileUtils.createFolder("admin_product_"+ customer.getId());
		CustomFileUtils.createImageInUpload("admin_product_" + customer.getId(), createProduct.getCarImage1(),createProduct.getCarImage2(),createProduct.getCarImage3(),createProduct.getCarImage4(),createProduct.getCarImage5(),createProduct.getCarImage6());
		return "redirect:/user/"+ nameCustomer+"/add";
	}

	
	
	@GetMapping("user/{username}/messages")
	public String message(Model model, Principal principal, @PathVariable ("username")String nameCustomer) {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());

	//	descriptionOrderService.findProductOnSellCurrentUser(customer.getId());
		model.addAttribute("customer", customer);
		model.addAttribute("nameCustomer", nameCustomer);
		return "user/mymessages";
	}
	
	@GetMapping("user/{username}/message/{id}/change")///user/qwe/1/change
	public String changeMessage(Model model, Principal principal, @PathVariable ("username")String nameCustomer,@PathVariable ("id")String id) {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());
		CreateProduct createProduct = new CreateProduct();

		
	//	descriptionOrderService.findProductOnSellCurrentUser(customer.getId());
		model.addAttribute("customer", customer);
		model.addAttribute("createProduct", createProduct);	
		model.addAttribute("nameCustomer", nameCustomer);
		
		model.addAttribute("username", customer.getPhoneNumber());	
		
		
		DescriptionOrder desc = descriptionOrderService.findDescriptionOrderById(Long.parseLong(id));
		
		CreateProduct2 createProduct2 = new CreateProduct2();
		createProduct2.setId(desc.getId());
		createProduct2.setNameProduct(desc.getNameProduct());
		createProduct2.setTypeProduct(desc.getTypeProduct());
		createProduct2.setQuantity(desc.getQuantity());
		createProduct2.setPrice(desc.getPrice());
		createProduct2.setManufacture(desc.getManufacture());
		createProduct2.setCarImage1(null);
		createProduct2.setCarImage2(null);
		createProduct2.setCarImage3(null);
		createProduct2.setCarImage4(null);
		createProduct2.setCarImage5(null);
		createProduct2.setCarImage6(null);
		
		model.addAttribute("id", desc.getId());
		model.addAttribute("item",createProduct2);
		
		
		//model.addAttribute("nameProduct", desc.getNameProduct());	
	//	model.addAttribute("manufacture", desc.getManufacture());	
	//	model.addAttribute("typeProduct", desc.getTypeProduct());	
	//	model.addAttribute("price", desc.getPrice());	
	//	model.addAttribute("quantity", desc.getQuantity());	
	
		
		return "user/changeMessage";
	}

	@PostMapping("user/{username}/message/{id}/change")
	public String changeMessage(Model model,Principal principal,  @PathVariable ("username")String nameCustomer, @ModelAttribute("item") CreateProduct2 createProduct,@PathVariable ("id")String id) throws IOException {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());
		DescriptionOrder descr = CreateProductMapper.createProductToDescriptionOrder3(createProduct);
	   CarImage carImageSave =  CreateProductMapper.createProductToDescriptionOrder4(createProduct);

	   
	 //  MainOrder mainOrder = new MainOrder(descr, customer);
		descr.setCustomer(customer);
	 //   carImageSave.setDescriptionOrder(descr);
	
		descriptionOrderService.saveDescriptionOrderOne(descr);

		
//		CustomFileUtils.createFolder("admin_product_"+ customer.getId());
		CustomFileUtils.createImageInUpload("admin_product_" + customer.getId(), createProduct.getCarImage1(),createProduct.getCarImage2(),createProduct.getCarImage3(),createProduct.getCarImage4(),createProduct.getCarImage5(),createProduct.getCarImage6());
		return "redirect:/home";
	}
	
	
	
	@GetMapping("user/{username}/message/{id}/delete")///user/qwe/1/change
	public String deleteMessage(Model model, Principal principal, @PathVariable ("username")String nameCustomer,@PathVariable ("id")String id) {
		Customer customer = customerService.findUserByNameCustomer(principal.getName());
		if (customer == null) {
			return "redirect:/home";
		}
System.out.println(" id " + id);
     //   descriptionOrderService.f
//  carImageService.deleteCarImageById(Long.parseLong(id));
		descriptionOrderService.deleteDescriptionOrderById(Long.parseLong(id));
	//	descriptionOrderService.findProductOnSellCurrentUser(customer.getId());
		
		
		
		return "redirect:/home";
	}

/*	ProductOnSell productOnSell;
@ModelAttribute("manufactures")
public List<Manufacture>  manufactureTupe(){
	return productOnSellService.findAllProductOnSell()
			.stream().map(productOnSell -> ((productOnSell) productOnSell).getManufacture()).collect(Collectors.toList());
}*/
	
	

	@GetMapping("/product/{productId}")
	public String descriptionOrder(Model model, @PathVariable("productId")Long id) throws IOException {
		
		DescriptionOrder descr = descriptionOrderService.findDuscriptionOrderImageById(id);//findDuscriptionOrderImageById
		CarImage carImage = carImageService.findCarImageById(id);
	
	
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
		return "descriptionOrder";
	}
	
	@PostMapping("/product/{productId}")
	public String buyProduct(Model model, @PathVariable("productId")Long id, @ModelAttribute("decriptionOrder")CarImage carImage) {
		DescriptionOrder desr = descriptionOrderService.findDescriptionOrderById(id);
		int quantity = desr.getQuantity();
		if(quantity <= 0) {
		System.out.println("Dont can buy");	
		}else {
		int newQuantity = quantity-1;
		desr.setQuantity(newQuantity);
		descriptionOrderService.saveDescriptionOrderOne(desr);
		}
		return "redirect:/product/"+ desr.getId();
	}
	
	
	@GetMapping("/404")
	public String show404() {
		return "404";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/registration")
	public String showRegistration(Model model) {
		model.addAttribute("registerModel", new CustomerRegistrationRequest());
		return "register";
	}
	
	@PostMapping("/registration")
	public String createCustomer(Model model, 
			@ModelAttribute("registerModel") @Valid CustomerRegistrationRequest customerRegistrationRequest,
			BindingResult result) {
		
		if(result.hasErrors()) {
		return "register";
		}
		
		customerService.saveCustomer(CustomerMapper.registerToCustomer(customerRegistrationRequest));
		return "redirect:/login";
	}
	
	@GetMapping("/search")
	public String search( Model model, @PageableDefault Pageable pageable, @RequestParam("search") String search) {
		Page<ProductOnSell> page = productOnSellService.findProductByName(pageable, new ProductNameFilter(search));//search
		
		model.addAttribute("productOnSellList", page.getContent());
		return "search";
	}
	
/*	@ModelAttribute("manufactures")
    public List<Manufacture> stickerTypes()
    {
        return Arrays.asList(Manufacture.values());
    }*/
	
	@GetMapping("/searches")//,typeProduct,manufacturer,year,pricefrom,pricedo
	public String searches( Model model, @PageableDefault Pageable pageable,	//	BindingResult result,
			@RequestParam("nameProduct") String nameProduct,
			@RequestParam("typeProduct") String typeProduct,
		@RequestParam("manufacture") String manufacture,
			//	@RequestParam("year") int year,
			@RequestParam("pricefrom") int pricefrom,
			@RequestParam("priceto") int priceto
			
			) {
		

		
		Page<DescriptionOrder> page = descriptionOrderService.findDescriptionOrderBy(pageable, new DescriptionOrderFilter(nameProduct,typeProduct,manufacture,pricefrom,priceto)); 
		model.addAttribute("descriptionOrderList", descriptionOrderService.findAllDescriptionOrder());
		model.addAttribute("descriptionOrderList", page.getContent());
		return "searches";

	}
	


}
