<%-- 
    Document   : listaOggettiJson
    Created on : 28-lug-2016, 21.01.13
    Author     : Ignazio
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetto" items="${listaOggetti}">
        <json:object>
            <json:property name="nome" value="${oggetto.nome}"/>
            <json:property name="descrizione" value="${oggetto.descrizione}"/>
            <json:property name="urlImmagine" value="${oggetto.urlImmagine}"/>
            <json:property name="prezzo" value="${oggetto.prezzo}"/>
            <json:property name="id" value="${oggetto.id}"/>
        </json:object>
    </c:forEach>
</json:array>