// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registrarCiente(){

    let datos = {};
    datos.nombre = document.getElementById("nombre").value;
    datos.email = document.getElementById("email").value;
    datos.password = document.getElementById("password").value;
    let Rpassword = document.getElementById("Rpassword").value;

    if(Rpassword != datos.password){
        alert('La contrasena no coinciden')
        return
    }

  const request = await fetch('api/clientes', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(datos)
  });
  alert("la cuenta fue creada con exito!");
  window.location.href= 'index.html'
}
