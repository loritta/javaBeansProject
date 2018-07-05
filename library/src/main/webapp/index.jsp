<!DOCTYPE html>
<html>
<jsp:include page="Shared/_head.jsp"></jsp:include>

<body>
   <jsp:include page="Shared/_navbarUser.jsp"></jsp:include>


    <br />
    <br />
    <div class="container body-content" style="margin-top:45px">
        
        
<!--         THE BODY CONTENT STARTS HERE -->
        
        
        <h1> Here is USER page</h1>

<!-- 		<div style="display: inline-block; margin: 0 auto"> -->
<!-- 			@foreach (var a in Model) { -->

<!-- 			<div class="asset-item"> -->
<!-- 				<a href="~/Asset/Details/@a.Id"> -->
<!-- 					<div> -->
<!-- 						<div style="text-align: center"> -->
<!-- 							<h4> -->
<!-- 								@if (a.Title.Length <= 34) { @a.Title } else { -->
<!-- 								@a.Title.Substring(0, 34)<span>...</span> } -->
<!-- 							</h4> -->
<!-- 						</div> -->
<!-- 						<div style="text-align: center"> -->
<!-- 							<img src=@a.ImageUrl style="height: 230px;" title="@a.Title" -->
<!-- 								alt="@a.Title" /><br /> <br /> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</a> -->
<!-- 			</div> -->
<!-- 			} -->
<!-- 		</div> -->





		<!--         END OF THE BODY CONTENT-->
        
      
        <hr />
        
        <jsp:include page="Shared/_footer.jsp"></jsp:include>
    </div>

<jsp:include page="Shared/_scripts_bundle.jsp"></jsp:include>
</body>

</html>
