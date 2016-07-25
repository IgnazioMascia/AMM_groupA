<%-- 
    Document   : venditore
    Created on : 19-lug-2016, 19.41.22
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
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mascia Ignazio">
        <meta name="description" content="Pagina del veditore">
        <meta name="keywords"
              content="compravendita oggetti nuovi e usati commercio oggetti">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    </head>
    
    <body>
    	<div id="container">
        <div id="header">
        	<h1>Area venditore</h1>
            <div id="logo">
            <!--Serve a far da riferimento per il codice css...-->
            </div>
        </div>
        
        <div id="contentsss" >
        	<div class="Infoinput">
                    
                <h3> Bentornato,  ${venditore.nome} ${venditore.cognome}</h3>
                <p>Inserire le informazioni dell'oggetto da mettere in vendita:</p>
                
                    <!--Form per l'inserimento delle info dell'oggetto-->
                    <form name="objectInSale" method="POST" action="VenditoreServlet">
                    	<div class="titolo_input">
                            <div class="info_in">
                                <label for="nomeOggetto">Titolo inserzione:</label>
                            </div>
                            <div class="Info_out">
                                <input type="text" name="nomeOggetto" id="nomeOggetto" />
                        	</div>
                        </div>
                        
                        <div class="immagine_input"> 
                        	<div class="info_in">
                                <label for="urlImmagine">Inserisci l'url dell'immagine dell'oggetto:</label>
                            </div>
                            <div class="Info_out">
                                <input type="url" name="urlImmagine" id="urlImmagine">
                        	</div>
                        </div>
                        
                        <div class="dettagli_input">
                        	<div class="info_in">
                                <label for="descrizioneOgg">Immetti una breve descrizione dell'oggetto:</label>
                            </div>
                            <div class="Info_out">                             
                                <textarea name="descrizioneOgg" id="descrizioneOgg"
                                              cols="40" rows="10" >Descrizione</textarea>
                        	</div>
                        </div>
                        
                        <div class="quantita_input">
                       		<div class="info_in">
                                <label for="quantita">Inserire la quantit&agrave; da vendere:</label>
                            </div>
                            <div class="Info_out">
                                <input type="number" name="quantita" id="quantita" min="1" max="1000">
                       		</div>
                        </div> 
                              
                        <div class="prezzo_input">
                        	<div class="info_in">
                                <label for="prezzo">Prezzo per unit&agrave;: &euro;</label>
                            </div>
                            <div class="Info_out">
                                <input type="number" step="any" name="prezzo" id="prezzo" min="1" max="1000">
                        	</div>
                        </div>
                        
                        <div class="invio_input_oggetto">
                        	<div class="info_in">
                                <input type="submit" name="submit" value="Invia">
                        	</div>
                        </div>
        			</form>
                    </div>

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