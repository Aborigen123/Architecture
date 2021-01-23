<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<div id="content">
			<div class="content">
				<div class="breadcrumbs">
					<a href="#">Home</a>
					<img src="/resources/images/marker_2.gif" alt=""/>
					<a href="#">Dealers</a>
					<img src="/resources/images/marker_2.gif" alt=""/>
					<span>Dealer name</span>
				</div>
				<div class="main_wrapper">
					<h1><strong>Registration</strong> here</h1>
					<div class="blog">
					
						<form:form method="POST" action="/registration" modelAttribute="registerModel">
						
						<form:errors path="*" cssClass="error"/>
						
						
						<div class="input_wrapper large">
							<label><span>1. </span><strong>Name User:</strong></label>
							<form:input path="nameCustomer" class="txb large" title="Name User" />
						</div>
						<br>
						<div class="input_wrapper large">
							<label><span>2. </span><strong>Phone number:</strong></label>
							<form:input path="phoneNumber" class="txb large" title="Phone Number" />
						</div>
						<br>
						
						<div class="input_wrapper large">
							<label><span>3. </span><strong>Password:</strong></label>
							<form:password path="Password" class="txb large" title="Password" />
						</div>
						<br>
						
							<div class="input_wrapper large">
							<label><span>4. </span><strong>Password Confirmation:</strong></label>
							<form:password path="passwordConfirmation" class="txb large" title="Password Confirmation" />
						</div>
						<br>
						
						
						
						<div class="offers">
						<input type="submit" class="all" value="Register" />
						</div>
                         </form:form>
						
						<ul class="dealer_catalog">
							
						</ul>
					
					</div>
					<div class="sidebar">
						<div class="widget grey">
							<h2><strong>About</strong> us</h2>
							<div class="post">
								<p>Lorem ipsum stet dolor sit amet, ad dolor consect etur et adipiscing elit aliquam set hendrerit sagittis lorem ipsum set dolor.</p>
								<p>Lorem ipsum stet dolor sit amet, ad dolor consect etur et adipiscing elit aliquam set hendrerit sagittis lorem ipsum set dolor. Lorem ipsum stet dolor sit amet, ad dolor consect etu et adipiscing elit aliqua et hendrerit sagittis lorem ipsum set doloretur stet adipiscing elit.</p>
								<p>Lorem ipsum stet dolor sit amet, ad dolor consect etur et adipiscing elit aliquam set hendrerit sagittis lorem ipsum set dolor. </p>
							</div>
						</div>
						<div class="widget contacts_widget">
							<h2><strong>Contact</strong> details</h2>
							<div class="addr detail">Berlin, Germany, nr. 250330,<br/>main street</div>
							<div class="phones detail">0040 742 016 756<br/>0040 742 016 756</div>
							<div class="email detail single_line"><a href="mailto:#" class="markered">office@autodealer.com</a></div>
							<div class="web detail single_line"><a href="#">http://www.autodealer.com</a></div>
						</div>
						<div class="widget_divider"></div>
						<div class="widget schedule_widget">
							<h2><strong>Schedule</strong></h2>
							<ul>
								<li>
									Monday
									<span>09:00-18:00</span>
								</li>
								<li>
									Tuesday
									<span>09:00-18:00</span>
								</li>
								<li>
									Wednesday
									<span>09:00-18:00</span>
								</li>
								<li>
									Thursday
									<span>09:00-18:00</span>
								</li>
								<li>
									Friday
									<span>09:00-18:00</span>
								</li>
								<li>
									Saturday
									<span>10:00-14:00</span>
								</li>
								<li>
									Sunday
									<span>Closed</span>
								</li>
							</ul>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
