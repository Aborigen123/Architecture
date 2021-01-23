<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <table border="1" width="100%" cellpadding="5">
  <c:forEach items="${customer.descriptionOrder}" var="item">
 
   <tr>
    <th>Name</th>
    <th>Type product</th>
    <th>manufacture</th>
          <th>price</th>
             <th>change</th>
                <th>delete</th>
   </tr>
   <tr>
    <td><c:out value="${item.nameProduct}" /></td>
    <td><c:out value="${item.typeProduct}" /></td>
      <td><c:out value="${item.manufacture}" /></td>
        <td><c:out value="${item.price}" /></td>
            <td><a href="message/${item.id}/change">change</a></td>
                <td><a href="message/${item.id}/delete">delete</a></td>
  </tr>

  </c:forEach>
</table>