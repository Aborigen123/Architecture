<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form:form method="POST" 
					action="/user/${username}/message/${id}/change" 
					modelAttribute="item"
					enctype="multipart/form-data">
		<div id="content">
			<div class="content">
				<div class="breadcrumbs">
					<a href="#">Home</a>
					<img src="images/marker_2.gif" alt=""/>
					<span>Add an offer</span>
				</div>
				<div class="main_wrapper">
					<div class="steps">
						<span>1. new offer</span>
						<a href="#"><span>2. preview</span></a>
						<a href="#"><span>3. submit</span></a>
					</div>
					<h1><strong>Sell</strong> your vehicle</h1>
					<div class="message">
						<h3>Sell ​​your car on <strong>AutoDealer</strong> and benefit from more than 1 million potential buyers every month!</h3>
						<p>Required fields are marked with *<br/>Please post offers only on the car (parts are a special category).<br/>If you are a dealer, please visit the dealers section<br/>If you have difficulties in posting an offer on the website, please call 0742 016 570</p>
					</div>
					
					
					
					
					
 				<form:hidden path="id" /> 
					<div class="sell_box sell_box_1">
						<h2><strong>Vehicle</strong> data</h2>
							<div class="input_wrapper large">
							<label><span> </span><strong>Name Product:</strong></label>
						
							<form:input path="nameProduct" class="txb large"  title = "Name Product" value="${nameProduct}"/>
				
					<div class="select_wrapper">
					
							
						
							<label><span>* </span><strong>Manufacturer:</strong></label>
	
							<form:select path = "manufacture" class="select_5" >
								<c:forEach items="${manufactures}" var="manufacture" >
								<form:option value="${manufacture}">${manufacture}</form:option>
								</c:forEach>
							</form:select>   
						
						</div>
			
						</div> 
						
						<div class="clear"></div>
					</div>
					<div class="sell_box sell_box_2">
						<h2><strong>Type Product</strong></h2>
						<div class="chb_group">
						

<c:forEach var="typeProducts" items="${typeProducts}">
 <form:radiobutton path="typeProduct" value="${typeProducts}"/><strong>${typeProducts}	</strong> 
</c:forEach>

							
							 
						</div> 
						<div class="clear"></div>
					
			
					<div class="sell_box sell_box_3">
						<h2><strong>Vehicle</strong> price and quantity</h2>
						<div class="select_wrapper">
							<label><span>* </span><strong>Price: </strong></label>
							<form:input path="price" class="txb"  />
						</div>
						<div class="input_wrapper">
							<label><span>* </span><strong>Quantity: </strong></label>
							<form:input path="quantity" class="txb"  />
						</div></div>
						
						
						
				
						<div class="clear"></div>
					</div>
					<div class="sell_box sell_box_4">
						<h2><strong>Vehicle</strong> photos<strong>In development</strong></h2>
						<div class="foto_wrapper">
							<a href="#">
								<img src="/resources/images/upload.png" alt="" class="upload"/>
								<form:input  path="carImage1" type="file" />
								upload photo
							</a>
						</div>
						<div class="foto_wrapper">
							<a href="#">
								<img src="/resources/images/upload.png" alt="" class="upload"/>
								<form:input  path="carImage2" type="file" />
								upload photo
							</a>
						</div>
						<div class="foto_wrapper">
							<a href="#">
								<img src="/resources/images/upload.png" alt="" class="upload"/>
								<form:input  path="carImage3" type="file" />
								upload photo
							</a>
						</div>
						<div class="foto_wrapper">
							<a href="#">
								<img src="/resources/images/upload.png" alt="" class="upload"/>
							<form:input  path="carImage4" type="file" />
								upload photo
							</a>
						</div>
						<div class="foto_wrapper">
							<a href="#">
								<img src="/resources/images/upload.png" alt="" class="upload"/>
								<form:input  path="carImage5" type="file" />
								upload photo
							</a>
						</div>
						<div class="foto_wrapper last">
							<a href="#">
								<img src="/resources/images/upload.png" alt="" class="upload"/>
								<form:input  path="carImage6" type="file" />
								upload photo
							</a>
						</div>
						<div class="clear"></div>
					</div>
		
						<input type="submit" value="Submit" class="sell_submit"/>
						<div class="clear"></div>
					</div>
		
				</div>
			</div>
		</div>

</form:form>