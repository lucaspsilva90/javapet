<%@page import="br.com.petbittencourt.controller.ControllerPet"%>
<%@page import="br.com.petbittencourt.beans.Pet"%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String data = request.getParameter("dataNascimento");
    int idCliente = Integer.parseInt(request.getParameter("clienteId"));

    Pet pet = new Pet(id,nome,data,idCliente);
    ControllerPet cp = new ControllerPet();
    cp.alteraPet(pet);
    response.sendRedirect("http://localhost:8080/pet/crud-pets/pets.jsp");
%>