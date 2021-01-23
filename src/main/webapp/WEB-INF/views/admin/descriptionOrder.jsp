<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div id="content">
			<div class="content">
		
				<div class="main_wrapper">
			
					<div class="cars_id">
						<div class="id">Offer ID <span></span></div>
					<!-- 	<div class="views">The offer had 1944 Views</div> -->
					</div>
					<h1><strong>${decriptionOrder.descriptionOrder.nameProduct}</strong>  ${decriptionOrder.descriptionOrder.manufacture}</h1>
					<div class="car_image_wrapper car_group">
						<div class="big_image">
							<a href="/resources/images/placeholders/480x292.gif?v=1" class="car_group">
								<img src="/resources/images/zoom.png" alt="" class="zoom"/>
									<img src="data:image/png;base64,${decriptionOrder.carImage1}"/>
							</a>
						</div>
						<div class="small_img">
							<a href="/resources/images/placeholders/620x425.gif?v=1" class="car_group">
								<img src="data:image/png;base64,${decriptionOrder.carImage2}"/>
							</a>
							<a href="/resources/images/placeholders/620x425.gif" class="car_group">
								<img src="data:image/png;base64,${decriptionOrder.carImage3}"/>
							</a>
							<a href="/resources/images/placeholders/620x425.gif" class="car_group">
								<img src="data:image/png;base64,${decriptionOrder.carImage4}"/>
							</a>
							<a href="/resources/images/placeholders/620x425.gif" class="car_group">
							<img src="data:image/png;base64,${decriptionOrder.carImage5}"/>
							</a>
							<a href="/resources/images/placeholders/620x425.gif" class="car_group">
								<img src="data:image/png;base64,${decriptionOrder.carImage6}"/>
							</a>
						</div>
					</div>
								
					<div class="car_characteristics">
						<a href="#" class="print"></a>
						<div class="price">${decriptionOrder.descriptionOrder.price} <span>* Price negotiable</span></div>
						<div class="clear"></div>
						<div class="features_table">
							<div class="line grey_area">
								<div class="left">Model, Body type:</div>
								<div class="right">${decriptionOrder.descriptionOrder.typeProduct}</div>
							</div>
							<div class="line">
								<div class="left">Quantity:</div>
								<div class="right">${decriptionOrder.descriptionOrder.quantity}</div>
							</div>
							</div>
						<div class="wanted_line">
							<div class="left">You want to sell a similar car?</div>
							<div class="right">
								<%-- <a href="${pageContext.request.contextPath}/product/${decriptionOrder.descriptionOrder.id}/buy">Buy</a> --%>
			
			
		
					
							
				
							<h1>Manufacturer:</h1>
		
                     <form method="POST" action="${pageContext.request.contextPath}/admin/${nameCustomer}/comfirm/product/${id}/setstatus">
						<select name = "status" class="select_5" >
								<c:forEach items="${status}" var="statu" >
								<option  
								
									<c:choose>
							<c:when test="${statusV == statu}">
						selected
							
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
							</c:choose>
							
								 >${statu}</option>
								</c:forEach>
							</select>   
							
							
							<input type="submit" value="Set Status">
							
						</form>
						
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>
							<br/>   
								
						
			
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="info_box">
						<div class="car_info">
							<div class="info_left">
								<h2><strong>Vehicle</strong> information</h2>
								<p><strong>Features:</strong><br/>alloy wheels, xenon headlights, fog lights, tinted glass</p>
								<p><strong>Other parameters:</strong><br/>service book</p>
								<p><strong>Safety:</strong><br/>ABS, traction control, alarm, airbags, immobilizer, anti-th, ESP, EDS, protection framework</p>
								<p><strong>Comfort:</strong><br/>electric windows, electric mirrors, air conditioning, leathe upholstery, navigation system, central locking, radio / CD, power steering, onboard computer, cruise control, heated seats, rain sensor, steering wheel controls, parking sensor</p>
							</div>
							<div class="info_right">
								<h2><strong>More</strong> info</h2>
								<p class="first"><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean aliquet fringilla metus, a ultricies ligula consequa at maecenas eget massa at eros.</strong></p>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit aenean aliquet fringilla metus, a ultricies ligula consequa at. Maecenas eget massa at eros ornare rhoncus. In sit a enim risus, in mattis felis a ultricies ligula consequat at. Maecenas eget massa at eros ornare.</p>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean aliquet fringilla metus, a ultricies ligula consequa at. Maecenas eget massa at eros ornare rhoncus. In sit a enim risus, in mattis felis</p>
							</div>
							<div class="clear"></div>
						</div>
						<div class="car_contacts">
							<h2><strong>Contact</strong> details</h2>
							<p>AutoMarket does not store additional information about the seller except for those contained in the announcement.</p>
							<div class="left">
								<div class="phones detail single_line spaced">0040 742 016 756</div>
								<div class="email detail single_line"><a href="mailto:#" class="markered">Contact vendor via e-mail</a></div>
							</div>
							<div class="right">
								<div class="addr detail single_line">Berlin, Germany, nr. 250330, main street</div>
								<div class="web detail single_line"><a href="#">http://www.dealer.automarket.com</a></div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="car_sidebar">
						<div class="calculator">
							<h3><strong>Loan</strong> calculator</h3>
							<label><strong>Loan Amount:</strong></label>
							<div class="select_box_1">
								<select class="select_3">
									<option value="0">0.00 Euro</option>
									<option value="1">10.00 Euro</option>
									<option value="2">100.00 Euro</option>
									<option value="3">1000.00 Euro</option>
									<option value="4">10000.00 Euro</option>
									<option value="5">100000.00 Euro</option>
									<option value="6">1000000.00 Euro</option>
									<option value="7">10000000.00 Euro</option>
									<option value="8">100000000.00 Euro</option>
								</select>
							</div>
							<label><strong>Down Payment:</strong></label>
							<div class="select_box_1">
								<select class="select_3">
									<option value="0">0.00 Euro</option>
									<option value="1">10.00 Euro</option>
									<option value="2">100.00 Euro</option>
									<option value="3">1000.00 Euro</option>
									<option value="4">10000.00 Euro</option>
									<option value="5">100000.00 Euro</option>
									<option value="6">1000000.00 Euro</option>
									<option value="7">10000000.00 Euro</option>
									<option value="8">100000000.00 Euro</option>
								</select>
							</div>
							<label><strong>Annual Rate:</strong></label>
							<div class="select_box_1">
								<select class="select_3">
									<option value="0">0.00 %</option>
									<option value="1">10.00 %</option>
									<option value="2">20.00 %</option>
									<option value="3">30.00 %</option>
									<option value="4">40.00 %</option>
									<option value="5">50.00 %</option>
								</select>
							</div>
							<label><strong>Loan Period:</strong></label>
							<div class="select_box_1">
								<select class="select_3">
									<option value="0">3 Years</option>
									<option value="1">4 Years</option>
									<option value="2">5 Years</option>
									<option value="3">6 Years</option>
									<option value="4">7 Years</option>
								</select>
							</div>
							<input type="submit" value="calculate" class="btn_calc"/>
							<div class="clear"></div>
						</div>
						<div class="banner">
							<a href="#"><img src="/resources/images/pics/banner_car.jpg" alt=""/></a>
						</div>
					</div>
					<div class="clear"></div>
					<div class="recent_cars">
						<h2><strong>Similar</strong> offers</h2>
						<ul>
							<li>
								<a href="#">
									<img src="/resources/images/placeholders/220x164.gif" alt=""/>
									<div class="description">Registration 2010<br/>3.0 Diesel<br/>230 HP<br/>Body Coupe<br/>80 000 Miles</div>
									<div class="title">Mercedes-Benz <span class="price">$ 115 265</span></div>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="/resources/images/placeholders/220x164.gif" alt=""/>
									<div class="description">Registration 2010<br/>3.0 Diesel<br/>230 HP<br/>Body Coupe<br/>80 000 Miles</div>
									<div class="title">Mercedes-Benz <span class="price">$ 115 265</span></div>
								</a>
							</li>
							<li>
								<a href="#">
									<img src="/resources/images/placeholders/220x164.gif" alt=""/>
									<div class="description">Registration 2010<br/>3.0 Diesel<br/>230 HP<br/>Body Coupe<br/>80 000 Miles</div>
									<div class="title">Mercedes-Benz <span class="price">$ 115 265</span></div>
								</a>
							</li>
							<li class="last">
								<a href="#">
									<img src="/resources/images/placeholders/220x164.gif" alt=""/>
									<div class="description">Registration 2010<br/>3.0 Diesel<br/>230 HP<br/>Body Coupe<br/>80 000 Miles</div>
									<div class="title">Mercedes-Benz <span class="price">$ 115 265</span></div>
								</a>
							</li>
						</ul>
					</div>
					
				</div>
			</div>
		</div>
