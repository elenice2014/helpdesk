function logar() {  //quando clica no botao envia os dados p o java - back-end
 
    // get inputs
    var login = new Object(); 
    login.cpf = $('#cpf').val();
    login.senha = $('#senha').val();
 
    $.ajax({
        url: "logar",  //nome da servlet
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(login),
        contentType: 'application/json',
        mimeType: 'application/json',
 
        success: function (data) {  //resposta do back-end
        	alert(data)
            
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
}