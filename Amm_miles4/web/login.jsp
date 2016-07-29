<%-- 
    Document   : login
    Created on : 19-lug-2016, 19.41.35
    Author     : Ignazio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mascia Ignazio">
        <meta name="description" content="Pagina di login dell'e-commerce">
        <meta name="keywords"
              content="compravendita oggetti nuovi e usati commercio oggetti">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    </head>
    <body>
    
    	<div id="container">
        <div id="header">
        	<h1>Login.</h1>
            <div id="logo">
            <!--Serve a far da riferimento per il codice css...-->
            </div>
        </div>
        
        <div id="contentsss">
                    <!--Form per il login-->
                    <form method="POST" action="LoginServlet">
                        <!--Username e password utente-->
                        <div class="login">
                        	<div class="Usr">
                                <div class="Info_in">
                                	<label for="username">Username</label>
                                </div>
                                <div class="Info_out">
                                	<input type="text" name="username" id="username" value="nome utente" />
                                </div>    
                            </div>
                            <div class="Psw">
                            	<div class="Info_in">
                           			<label for="passwd">Password</label>
                                </div>
                                <div class="Info_out">
                                	<input type="password" name="passwd" id="passwd" value="xxxxxxxx"/>       
                        		</div>
                        	</div>
                    	</div>
                        
                        <div class="invio_input_login">
                        	<div class="info_in">
                                <input type="submit" name="submit" value="Invia">
                        	</div>
                        </div>
                    </form>
        </div>
        
        <!--Sezione per il link al login-->
        <div id="navigazione">
        	<h2 id="link_esterni">Vai a:</h2>
            <ul>
                <li><a href="index.jsp">Descrizione del sito</a></li>
                <li><a href="venditore.jsp">Profilo venditore</a></li>
                <li><a href="cliente.jsp">Profilo cliente</a></li>
        	</ul>
        </div>
        
        </div>
                
    </body>
</html>