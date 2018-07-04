<!DOCTYPE html>
<%@page import="com.jac.web.controller.Globals"%>
<html>
<jsp:include page="Shared/_head.jsp"></jsp:include>

<body>
   <jsp:include page="Shared/_navbarAdmin.jsp"></jsp:include>
 

    <br />
    <br />
    <div class="container body-content" style="margin-top:45px">
        
        
<!--         THE BODY CONTENT STARTS HERE -->
        
		<%if (!Globals.IsAdmin){%>
			<jsp:forward page="welcome.jsp"/>
			<%}%>
        

        <h1> Here is admin page</h1>
        
        
        
        
        
        
<!--         END OF THE BODY CONTENT-->
        
      
        <hr />
        
        <jsp:include page="Shared/_footer.jsp"></jsp:include>
    </div>

<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
</body>

</html>
