<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">

  <a href="?mylocale=en">English </a> | <a href="?mylocale=de">German </a>
  <h3> <spring:message code="user.title"/></h3>

  <form:form action="register" method="post" id="contactForm" class="form">
 	<h1>Nouveaux utilisateurs : inscrivez-vous maintenant</h1> 
 	<div class="form-group row">
	  <label for="nom" class="col-sm-2 col-form-label">*  Votre Nom :</label>
	  <div class="col-sm-10">
	    <form:input class="form-control" path="nom" type="text" id="nom" name="nom" placeholder="Nom"/>
	  </div>
	</div>
	 <div class="form-group row">
	  <label for="prenom" class="col-sm-2 col-form-label">*  Votre Prénom :</label>
	  <div class="col-sm-10">
	    <form:input class="form-control" path="prenom" type="text"  id="prenom" name="prenom" placeholder="Prénom"/>
	  </div>
	</div>	
    <div class="form-group row">
      <label for="email" class="col-sm-2 col-form-label">*  Email</label>
      <div class="col-sm-10">
        <form:input type="email" class="form-control" path="email" name="email" id="email" placeholder="Email"/>
      </div>
    </div>
    
    <div class="form-group row">
      <label for="cemail" class="col-sm-2 col-form-label">*  Confirmez votre Email:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" name="cemail" id="cemail" placeholder="Email">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">*  Password</label>
      <div class="col-sm-10">
        <form:input type="password" class="form-control" path="password" name="password" id="password" placeholder="Password"/>
      </div>
    </div>
    
    <div class="form-group row">
      <label for="cpassword" class="col-sm-2 col-form-label">*  Confirmez votre Password</label>
      <div class="col-sm-10">
        <input type="password" class="form-control"  name="cpassword" id="cpassword" placeholder="Password">
      </div>
    </div>
    <h1>Coordonnées</h1>
    
    <div class="form-group row">
	  <label for="telephone" class="col-sm-2 col-form-label">Téléphone</label>
	  <div class="col-sm-10">
	    <form:input class="form-control" type="text" path="telephone" id="telephone"/>
	  </div>
	</div>
	 <div class="form-group row">
	  <label for="adresse_postale" class="col-sm-2 col-form-label">Adresse postale</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text"  id="adresse_postale">
	  </div>
	</div>	
 
 
 
 	<div class="form-group row">
	  <label for="pays" class="col-sm-2 col-form-label">Pays</label>
	  <div class="col-sm-10">
	    <form:input class="form-control" type="text"  path="pays" id="pays"/>
	  </div>
	</div>
	<div class="form-group row">
	  <label for="ville" class="col-sm-2 col-form-label">Ville</label>
	  <div class="col-sm-10">
	    <form:input class="form-control" type="text" path="ville"  id="ville"/>
	  </div>
	</div>	
	<div class="form-group row">
	  <label for="code_postal" class="col-sm-2 col-form-label">Code Postal</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text" id="code_postal">
	  </div>
	</div>	
	    
    
    
    <div class="form-group row">
	    <label for="exampleSelect1"  class="col-sm-2 col-form-label">Example select</label>
	    <div class="col-sm-10">
		    <select class="form-control" id="exampleSelect1">
		      <option>1</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
	    </div>
  </div>

    <div class="form-group row">
      <label class="col-sm-2">Checkbox</label>
      <div class="col-sm-10">
        <div class="form-check">
          <label class="form-check-label">
            <input class="form-check-input"  type="checkbox"> Check me out
          </label>
        </div>
      </div>
    </div>
    
        <!-- #messages is where the messages are placed inside -->
    <div class="form-group">
        <div class="col-md-9 col-md-offset-3">
            <div id="messages"></div>
        </div>
    </div>
    
    <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <form:button type="submit" class="btn btn-primary">Sign in</form:button>
      </div>
    </div>
  </form:form>
</div>


<script>
$(document).ready(function() {
    $('#contactForm').bootstrapValidator({
        container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nom: {
                validators: {
                    notEmpty: {
                        message: 'Le nom est un champ obligatoire.'
                    }
                }
            },
            prenom: {
                validators: {
                    notEmpty: {
                        message: 'Le prénom est un champ obligatoire.'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'L\'adresse email est un champ obligatoire.'
                    },
                    emailAddress: {
                        message: 'Votre adresse email n\'est pas valide.'
                    }
                }
            },
            
            cemail: {
                validators: {
                    identical: {
                        field: 'email',
                        message: 'Votre adresse email de confirmation ne correspond pas'
                    }
                }
            },

            password: {
                validators: {
                	notEmpty: {
                        message: 'L\'adresse email est un champ obligatoire.'
                    },
                    regexp: {
                        regexp: /^[a-z]{8}/,
                        message: 'Le password doit comporter 8 caracetres.'
                    }
                }
            },
            cpassword: {
                validators: {
                    identical: {
                        field: 'password',
                        message: 'Votre password de confirmation ne correspond pas'
                    }
                }
            }
        }
    });
});

</script>