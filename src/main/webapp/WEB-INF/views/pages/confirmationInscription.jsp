<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
<%@include file="includes/internationalisation.jsp" %>
<h1>Véuillez vérifier votre adresse mail </h1> 
<div class="panel panel-default">
  <div class="panel-heading">Niveau de poste actuel</div>
  <div class="panel-body">
  	
  	<div class="form-group">
	  <label for="sel1">Niveau de poste actuel:</label>
	  <select class="form-control" id="sel1">
	    <option>Etudiant</option>
	    <option>Jeune Diplômé</option>
	    <option>Junior</option>
	    <option>Coonfirmé/Senior</option>
	    <option>Responsable d'équipe</option>
	    <option>Responsable de Département</option>
	    <option>Dirigeant/Entrepreneur</option>
	  </select>
	</div>
	
	<div class="form-group">
	  <label for="sel1">Niveau de diplôme:</label>
	  <select class="form-control" id="sel1">
	    <option>Bac non validé</option>
	    <option>Lycée,Niveau bac</option>
	    <option>Bac Professionnel,BEP,CAP</option>
	    <option>DUT,BTS,BAC+2</option>
	    <option>Diplômé non validé</option>
	    <option>Licence,Bac+3</option>
	    <option>Maîtrise,IEP,IUP,BAC + 4</option>
	    <option>DESS,DEA,Grandes Ecoles,Bac + 5</option>
	    <option>Doctorat,3 éme cycle </option>
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