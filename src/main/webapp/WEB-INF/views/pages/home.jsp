<div class="container">
  <form id="contactForm" class="form">
 	<h1>Nouveaux utilisateurs : inscrivez-vous maintenant</h1> 
 	<div class="form-group row">
	  <label for="nom" class="col-sm-2 col-form-label">*  Votre Nom :</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text" id="nom" min="3" required type="text" data-error-msg="Must enter your name?" >
	  </div>
	</div>
	 <div class="form-group row">
	  <label for="prenom" class="col-sm-2 col-form-label">*  Votre Prenom :</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text"  id="prenom">
	  </div>
	</div>	
    <div class="form-group row">
      <label for="email" class="col-sm-2 col-form-label">*  Email</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" name="email" id="email" placeholder="Email">
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
        <input type="password" class="form-control" id="password" placeholder="Password">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="cpassword" class="col-sm-2 col-form-label">*  Confirmez votre Password</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="cpassword" placeholder="Password">
      </div>
    </div>
    <h1>Coordonnées</h1>
    
    <div class="form-group row">
	  <label for="telephone" class="col-sm-2 col-form-label">Téléphone</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text" id="telephone">
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
	    <input class="form-control" type="text" id="pays">
	  </div>
	</div>
	<div class="form-group row">
	  <label for="ville" class="col-sm-2 col-form-label">Ville</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text"  id="ville">
	  </div>
	</div>	
	<div class="form-group row">
	  <label for="code_postal" class="col-sm-2 col-form-label">Code Postal</label>
	  <div class="col-sm-10">
	    <input class="form-control" type="text"  id="code_postal">
	  </div>
	</div>	
	    
    
    
    

    <div class="form-group row">
      <label class="col-sm-2">Checkbox</label>
      <div class="col-sm-10">
        <div class="form-check">
          <label class="form-check-label">
            <input class="form-check-input" type="checkbox"> Check me out
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
        <button type="submit" class="btn btn-primary">Sign in</button>
      </div>
    </div>
  </form>
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
            fullName: {
                validators: {
                    notEmpty: {
                        message: 'The full name is required and cannot be empty'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The email address is not valid'
                    }
                }
            },
            
            cemail: {
                validators: {
                    identical: {
                        field: 'email',
                        message: 'The mail and its confirm are not the same'
                    }
                }
            },
            title: {
                validators: {
                    notEmpty: {
                        message: 'The title is required and cannot be empty'
                    },
                    stringLength: {
                        max: 100,
                        message: 'The title must be less than 100 characters long'
                    }
                }
            },
            content: {
                validators: {
                    notEmpty: {
                        message: 'The content is required and cannot be empty'
                    },
                    stringLength: {
                        max: 500,
                        message: 'The content must be less than 500 characters long'
                    }
                }
            }
        }
    });
});

</script>