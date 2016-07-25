<%-- 
    Document   : RiepilogoOrdine
    Created on : 21-lug-2016, 10.57.55
    Author     : Ignazio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String idCliente = request.getParameter("idCliente"); %>
<% String costoOgg = request.getParameter("prezzoOgg"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>RiepilogoAcquisto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mascia Ignazio">
        <meta name="description" content="Pagina di riepilogo dell'acquisto">
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
            Riepilogo ordine:
            
            <br><% out.println(request.getParameter("nomeOggetto"));%>
            <br><% out.println(request.getParameter("descrizioneOgg"));%>
            <br>Prezzo: &euro; <% out.println(request.getParameter("prezzoOgg"));%>
            
            
            <br>
            <br>Procedere?
            <div id="risposta">
                <form name="risp" method="post" action="ClienteServlet">
                    <div class="info_in">
                        <input type="hidden" name="idCliente" value="<% out.print(idCliente); %>">
                        <input type="hidden" name="costoOgg" value="<% out.print(costoOgg); %>">
                        <input type="submit" name="submit" value="procedi">
                    </div>
                </form>
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