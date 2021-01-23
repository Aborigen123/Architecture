<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

			<div class="content">
			<div class="recent">
	<div class="recent_carousel">
						<div class="slide">
	<a href="#">
	<c:forEach items="${productOnSellList}" var="product">
		<img src="/resources/images/placeholders/220x164.gif" alt=""/>
		<div class="description">${product.manufacture}<br/>3.0 Diesel<br/>230 HP<br/>Body Coupe<br/>80 000 Miles</div>
		<div class="title">${product.nameProduct} <span class="price">$ 115 265</span></div>
</c:forEach>
	</a>
 </div>
 </div>
 </div>
 </div>
