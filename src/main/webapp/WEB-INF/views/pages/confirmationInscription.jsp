<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
<%@include file="includes/internationalisation.jsp" %>
<h1>V�uillez v�rifier votre adresse mail </h1> 
<div class="panel panel-default">
  <div class="panel-heading">Niveau de poste actuel</div>
  <div class="panel-body">
  	
  	<div class="form-group">
	  <label for="sel1">Niveau de poste actuel:</label>
	  <select class="form-control" id="sel1">
	    <option>Etudiant</option>
	    <option>Jeune Dipl�m�</option>
	    <option>Junior</option>
	    <option>Coonfirm�/Senior</option>
	    <option>Responsable d'�quipe</option>
	    <option>Responsable de D�partement</option>
	    <option>Dirigeant/Entrepreneur</option>
	  </select>
	</div>
	
	<div class="form-group">
	  <label for="sel1">Niveau de dipl�me:</label>
	  <select class="form-control" id="sel1">
	    <option>Bac non valid�</option>
	    <option>Lyc�e,Niveau bac</option>
	    <option>Bac Professionnel,BEP,CAP</option>
	    <option>DUT,BTS,BAC+2</option>
	    <option>Dipl�m� non valid�</option>
	    <option>Licence,Bac+3</option>
	    <option>Ma�trise,IEP,IUP,BAC + 4</option>
	    <option>DESS,DEA,Grandes Ecoles,Bac + 5</option>
	    <option>Doctorat,3 �me cycle </option>
	    <option>Expert,Recherche</option>
	  </select>
	</div>
  
  	<div class="panel panel-primary">
      <div class="panel-heading">Panel with panel-primary class</div>
      <div class="panel-body">Panel Content</div>
    </div>
  </div>
</div>
</div>