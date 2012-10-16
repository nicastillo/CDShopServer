<%-- 
    Document   : index
    Created on : Oct 10, 2012, 10:09:36 AM
    Author     : Aman
--%>

<%@page import="com.etechies.server.dbagent.DBAgent"%>
<%@page import="java.util.ArrayList"%>
<%--<%@page import="com.etechies.server.beans.Product"%>
<%@page import="com.etechies.server.dbagent.DBAgent"%>
<%@page import="com.etechies.server.dbagent.ConnectionPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>e-Techies CD Store</title>
    </head>
    <body>
        
        
        <% DBAgent db = new DBAgent();
        ArrayList<String> categories = new ArrayList<String>();
        categories = db.getCategoryList();%>
        
        <div id="main">
            
            <div id="header">
                  <div id="widgetBar">
                        <div class="headerWidget">
                            [ language toggle ]
                        </div>
                        

                        <div class="headerWidget">
                            [ items in cart ]
                        </div>
                        
                        <div class="headerWidget">
                            [ login or Hi, user]
                        </div>
                        

                    </div>

                    <a href="#">
                        <img src="images/logo.png" id="logo" alt="Store Logo">
                    </a>

                    <div id="logoText">
                        CSI5380 </br></br>
                        E-Techies  CD Store
                    </div>
                    
                
            </div>  <!-- End of Header -->
            <div id="menu">
                [placeholder]
            </div>
            <!-- Start of content left and right column-->
            <div id="indexLeftColumn">
				<p>PRODUCTS BY:</p>
				<ul id="order">

					
						<div class="categoryBox"> 
							<span class="categoryLabelText"> Category List </span>
						</div>
					

					<!--<li class="bold">Category</li>
					<form method="POST"
						  action="Controller"></form>
					<select name="category" size="1">
						
					</select>
					<input type="submit"> 
					<ul>

					</ul> 
					<li class="bold">Price</li>
					<ul>
						<li> Lowest to Highest</li>
						<li> Highest to Lowest</li>
					</ul>

					<li class="bold">Title</li>
					<ul>
						<li> A to Z</li>
						<li> Z to A</li>
					</ul>
				</ul>

				<!--[Placeholder]-->
			</div>
		

			<div id="indexRightColumn">
				<h2>Results</h2>
					
						<div class="categoryBox"> 
							<span class="categoryLabelText"> Title of CD </span>
							</br> Price </br>[add to cart button]
						</div>
						

			</div>
                        <!-- End of content left and right column-->
			<div id="footer">
                            <hr>
                            <p id="footerText">[ footer text ]</p>
			</div>
		</div>
    </body>
</html>