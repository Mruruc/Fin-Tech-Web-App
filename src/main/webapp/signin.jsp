
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Love Bank">
        <meta name="keywords" content="Love Bank,love bank">
        <meta name="author" content="Omer Uruc">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign in</title>
    </head>
    <body style="text-align: center">
          <h1>We are exciting to see you among us :) </h1>

          <%
              Boolean visibilityWrapper = (Boolean) request.getAttribute("visibility");
              boolean visibility = visibilityWrapper != null && visibilityWrapper;

              String addressId = (String) request.getAttribute("addressId");

          %>
          <h3 <%= visibility  ? "hidden='hidden'" : "" %>>
              Lets Start With Your Address:
          </h3>

          <form action="<%=request.getContextPath()%>/addressServlet"
                method="post" <%= visibility  ? "hidden='hidden'" : "" %>>

              <label for="country">Country</label><br>
              <input type="text" id="country" name="country" required><br>

              <label for="city">City</label><br>
              <input type="text" id="city" name="city" required><br>

              <label for="street">Street</label><br>
              <input type="text" id="street" name="street" required><br>

              <label for="zip">Zip code</label><br>
              <input type="text" id="zip" name="zip" required><br>

              <label for="doorNo">Door Number</label><br>
              <input type="number" id="doorNo" name="doorNo" min="0" required><br>

              <input type="submit" value="Save">
          </form>

          <h3 <%= visibility  ?  "" : "hidden='hidden'" %> >
              Lets Get Know You Better
          </h3>

          <form action="<%=request.getContextPath()%>/clientServlet"
               method="post"   <%= visibility  ?  "" : "hidden='hidden'" %>>

              <label for="firstName">First Name</label><br>
              <input type="text" id="firstName" name="firstName" ><br>

              <label for="lastName">Last Name</label><br>
              <input type="text" id="lastName" name="lastName" ><br>

              <label for="dob">Date Of Birth</label><br>
              <input type="date" id="dob" name="dob" ><br>

              <label for="gender">Gender</label><br>
                 <select id="gender" name="gender" >
                     <option value="MALE">MALE</option>
                     <option value="FEMALE">FEMALE</option>
                     <option value="OTHERS">OTHERS</option>
                 </select>
              <br/>

              <label for="primaryPhone">Primary Phone</label><br>
              <input type="text" id="primaryPhone" name="phone1" ><br>

              <label for="secondPhone">Second Phone</label><br>
              <input type="text" id="secondPhone" name="phone2" ><br>

              <label for="email">Email</label><br>
              <input type="email" id="email" name="email" ><br>

              <input type="hidden"  name="addressId" value="<%=addressId%>" hidden="hidden">

              <input type="submit" value="Register">
          </form>
          <div>
              <% if(request.getAttribute("errorMessage") != null) {%>
              <p style="color: red;" >
                  <%= request.getAttribute("errorMessage")%>
              </p>
              <% } %>
          </div>
    </body>
</html>
