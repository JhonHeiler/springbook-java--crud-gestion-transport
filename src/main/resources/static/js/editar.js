$(document).ready(function() {
             $('#btnEditarCliente').click(editarUsuario);
            let id = window.location.href.split('id=')[1]; //split corta un strin y los separas
           cargarUsuario(id)
        });

        async function cargarUsuario(id){

          const request = await fetch('api/mostrarUsuarios/'+id, {
            method: 'GET',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
          });
          const usuarios = await request.json();
          cargarFormulario(usuarios);
          }

        function cargarFormulario(usuarios) {

            $('#txtNombre').val(usuarios.nombre);
            $('#txtApellido').val(usuarios.apellido);
            $('#txtEmail').val(usuarios.email);
            $('#txtTelefono').val(usuarios.telefono);
        }

    async function editarUsuario(){

        let datos = {};
        datos.id = window.location.href.split('id=')[1];
        datos.nombre = document.getElementById("txtNombre").value;
        datos.apellido = document.getElementById("txtApellido").value;
        datos.email = document.getElementById("txtEmail").value;
        datos.telefono = document.getElementById("txtTelefono").value;
        console.log(datos);
      const request = await fetch('api/editarUsuarios', {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body:JSON.stringify(datos)
      });
      alert("la datos fueron actualizados con exito!");
    }


