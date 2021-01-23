<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <table border="1" width="100%" cellpadding="5">
  <c:forEach items="${item}" var="item">
 
   <tr>
    <th>Name</th>
    <th>Type product</th>
    <th>manufacture</th>
          <th>price</th>
          <th>LINK</th>
     
   </tr>
   <tr>
    <td><c:out value="${item.nameProduct}" /></td>
    <td><c:out value="${item.typeProduct}" /></td>
      <td><c:out value="${item.manufacture}" /></td>
        <td><c:out value="${item.price}" /></td>
     <td><a href="${pageContext.request.contextPath}/admin/${nameCustomer}/comfirm/product/${item.id}">link</a></td>
  </tr>

  </c:forEach>
</table>