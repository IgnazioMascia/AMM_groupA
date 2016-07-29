<%-- 
    Document   : objectInSaleInput
    Created on : 20-lug-2016, 13.14.36
    Author     : Ignazio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>RiepilogoOggettoInVendita</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mascia Ignazio">
        <meta name="description" content="Pagina di riepilogo della vendita">
        <meta name="keywords"
              content="compravendita oggetti nuovi e usati commercio oggetti">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    </head>
    <body>
    
    	<div id="container">
        <div id="header">
            <div id="logo">
            <!--Serve a far da riferimento per il codice css...-->
            </div>
        </div>
        
        <div id="contentsss">
            Riepilogo info vendita :
                <div>
                    <br>Titolo inserzione: ${obj.nome}.
                    <br>Descrizione oggetto: ${obj.descrizione}.
                    <br>Quantit&agrave; oggetti: ${obj.num_Pezzi}.
                    <br>Prezzo: ${obj.prezzo}.
                </div>
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