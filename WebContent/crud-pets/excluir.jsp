<%@page import="br.com.petbittencourt.controller.ControllerPet"%>
<%@page import="br.com.petbittencourt.beans.Pet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Pet pet = new Pet(id,"","",0);
    ControllerPet cp = new ControllerPet();
    cp.excluiPet(pet);
    
    response.sendRedirect("http://localhost:8080/pet/crud-pets/pets.jsp");
%>