<%-- 
    Document   : index
    Created on : 19-lug-2016, 19.06.55
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
        <title>Benvenuto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mascia Ignazio">
        <meta name="description" content="Sito di benvenuto dell'e-commerce">
        <meta name="keywords"
              content="compravendita oggetti nuovi e usati commercio oggetti">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    </head>
    <body>
    	<div id="container">
        
            <!--Messaggio di benvenuto e sommario-->
            <div id="header">
                <h1>Benvenuto sull' e-commerce del future</h1>
                <div id="logo">
                <!--Serve a far da riferimento per il codice css...-->
                </div>
                
                <div id="menu">
                	<ul>
                    	<li><a href="#descrizione">Descrizione</a></li>
                    	<li><a href="#servizi">Servizi</a></li>
                    	<li><a href="#link_esterni">Login</a></li>
                    </ul>
           		</div>
            </div>
            
            
            
            <!-- Sezione di descrizione sito-->
            <div id="contentsss">
                <div class="description">
                    <h2 id="descrizione">Descrizione</h2>
                        Questo è un sito di e-commerce che ti permetterà di comprare e
                        <br/>vendere oggetti di diverso tipo:
                        <ul>
                            <li>Elettronica</li>
                            <li>Giocattoli</li>
                            <li>Gadget</li>
                            <li>Vestiario</li>
                            <li>Cancelleria</li>
                            <li>Arredamento</li>
                            <li>Informatica</li>
                            <li>Audio</li>
                        </ul>
        
                        Non è permesso mettere in vendita oggetti del tipo:
                        <br/>
                        <ul>
                            <li>Immobili</li>
                            <li>Autovetture</li>
                            <li>Alimentari</li>
                        </ul>
                </div>
                
                <!--Sezione di descrizione delle azioni cliente-->
                <div class="services">
                <h2 id="servizi">Tipologia servizi</h2>
                        
                    <h3>Per compratore:</h3>
                        <ul>
                            <li>Offerta del giorno</li>
                            <li>Aste a tempo</li>
                            <li>App Compratore</li>
                            <li>Consigli sugli acquisti</li>
                            <li>Protezione sugli acquisti</li>
                            <li>Tariffe spedizione</li>
                        </ul>
                    
                    <h3>Per venditore:</h3>
                        <ul>
                            <li>Come vendere</li>
                            <li>App Venditore</li>
                            <li>Vetrine</li>
                            <li>Tariffe vendite</li>
                            <li>Protezione sulle vendite</li>
                            <li>Tariffe spedizione</li>
                        </ul>  
                </div>
            </div>
                    
            <!--Sezione per il link al login-->
            <div id="navigazione">
            <h2 id="link_esterni">Login utente:</h2>
                <ul>
                	<li><a href="login.jsp">Vai alla pagina di login.</a> </li>
                </ul>
            </div>
     	
        </div>
                
    </body>
</html>