<%-- 
    Document   : cliente
    Created on : 19-lug-2016, 19.30.36
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
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mascia Ignazio">
        <meta name="description" content="Pagina per l'acquisto di oggetti">
        <meta name="keywords"
              content="compravendita oggetti nuovi e usati commercio oggetti">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">

    
    </head>
    <body>
    	<div id="container">
            <div id="header">
                <h1>Sezione compratore.</h1>
                <div id="logo">
                <!--Serve a far da riferimento per il codice css...-->
                </div>
            </div>
            
            <div id="contentsss">
                <h3> Bentornato, ${cliente.nome} ${cliente.cognome} </h3>
                
                <!--Inizio lista dei cinque oggetti-->
            
                <ul id= "oggettistica">
                    
                    <c:forEach var="oggetto" items="${oggetti}">
                        <li>
                            <div class="ogg_image">
                                <img src=${oggetto.urlImmagine} width="50" height="50">
                            </div>       
                            <div class="ogg_desc">
                                <h3>${oggetto.nome}</h3>
                                ${oggetto.descrizione}
                                <br/>Prezzo per unit&agrave;: ${oggetto.prezzo} &euro;
                                <br/><a href="RiepilogoOrdine.jsp?idOggetto=${oggetto.id}
                                                &nomeOggetto=${oggetto.nome}
                                                &descrizioneOgg=${oggetto.descrizione}
                                                &prezzoOgg=${oggetto.prezzo}
                                                &idCliente=${cliente.id}" name="oggetto">Aggiungi al carrello.</a><br/>
                            </div>
                        </li>
                    </c:forEach>
                    
                </ul>
            </div>
            
            <!--Sezione per i link esterni-->
            <div id="navigazione">
            <h2 id="link_esterni">Vai a:</h2>
            	<ul>
           	        <li><a href="index.jsp">Descrizione del sito</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
            </div>
       	
        </div>
    </body>
</html>
