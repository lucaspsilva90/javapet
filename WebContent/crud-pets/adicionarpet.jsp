<%@page import="br.com.petbittencourt.controller.ControllerPet"%>
<%@page import="br.com.petbittencourt.controller.ControllerCliente"%>
<%@page import="br.com.petbittencourt.beans.Pet"%>
<%@page import="br.com.petbittencourt.beans.Cliente"%>


  
<%  
 String nome = request.getParameter("nome");
 String dataNascimento = request.getParameter("dataNascimento");
 int clienteId = Integer.parseInt(request.getParameter("clienteId"));
 
 ControllerPet cp = new ControllerPet();
 Pet pet = new Pet(0,nome,dataNascimento,clienteId);

 cp.inserePet(pet);
 response.sendRedirect("http://localhost:8080/pet/crud-pets/pets.jsp");
%>  