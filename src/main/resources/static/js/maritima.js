// Call the dataTables jQuery plugin
$(document).ready(function() {
 cargarMaritima()
  $('#terrestre').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
   document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

async function cargarMaritima(){
  const request = await fetch('api/maritimas', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      //'Authorization': localStorage.token
    },
  });
  const maritimas = await request.json();

  let listadoHtml=""
  for (let maritima of maritimas){
      let botonEliminar ='<a href="#" onClick="eliminarTerrestre('+ maritima.id +')" class="btn btn-danger btn-circle" ><i class="fas fa-trash"></i></a>'
      let maritimahtml = ' <tr><td>'+maritima.id+'</td><td>'+maritima.productoMaritimo.nombre+ '</td><td> '+maritima.cantidad_producto+'</td><td>'+maritima.fecha_registro+'</td><td>'+maritima.precio_envio+'</td><td>'+maritima.numero_flota+'</td><td>'+botonEliminar+'</td></tr>'
      listadoHtml += maritimahtml;
  }
   var tbody= document.getElementById("tbody");
   tbody.innerHTML = listadoHtml;
}

async function eliminarTerrestre(id){
        if(!confirm('Desea eliminar el envio?')){
            return;
        }
        const request = await fetch('api/maritimas/'+id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
            },
          });
          window.location.reload();
   }
