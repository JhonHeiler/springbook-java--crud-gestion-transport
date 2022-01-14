// Call the dataTables jQuery plugin
$(document).ready(function() {
 cargarCliente()

  $('#clientes').DataTable();
  actualizarEmailDelUsuario();
});
function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

async function  cargarCliente(){
  const request = await fetch('api/clientes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',

    },
  });
  const clientes = await request.json();

  let listadoHtml=""
  for (let cliente of clientes){
      let botonEliminar ='<a href="#" onClick="eliminarCliente('+cliente.id+')" class="btn btn-danger btn-circle" ><i class="fas fa-trash"></i></a>'
      let clientehtml = ' <tr><td>'+cliente.id+'</td><td>'+cliente.nombre+'</td><td>'+cliente.email+'</td><td>'+botonEliminar+'</td></tr>'
      listadoHtml += clientehtml;
  }
   var tbody= document.getElementById("tbody");
   tbody.innerHTML = listadoHtml;
}

async function eliminarCliente(id){
        if(!confirm('Desea eliminar este cliente?')){
            return;
        }
        const request = await fetch('api/clientes/'+id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
            },
          });
           Location.reload();
   }
