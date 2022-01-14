// Call the dataTables jQuery plugin
$(document).ready(function() {
 cargarTerrestre()
  $('#terrestre').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
   document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

async function cargarTerrestre(){
  const request = await fetch('api/terrestres', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      //'Authorization': localStorage.token
    },
  });
  const terrestres = await request.json();

  let listadoHtml=""
  for (let terrestre of terrestres){
   let actualizarTerrestre ='<a href="#" onClick="editarUsuario('+ terrestre.id+')" class="btn btn-primary btn-circle btn-sm" ><i class="fas fa-edit"></i></a>'
      let botonEliminar ='<a href="#" onClick="eliminarTerrestre('+ terrestre.id +')" class="btn btn-danger btn-circle" ><i class="fas fa-trash"></i></a>'
      let terrestrehtml = ' <tr><td>'+terrestre.id+'</td><td>'+terrestre.productoTerrestre.nombre+ '</td><td> '+terrestre.cantidad_producto+'</td><td>'+terrestre.fecha_registro+'</td><td>'+terrestre.precio_envio+'</td><td>'+terrestre.placa_vehiculo+'</td><td>'+botonEliminar+' '+actualizarTerrestre+'</td></tr>'
      listadoHtml += terrestrehtml;
  }
   var tbody= document.getElementById("tbody");
   tbody.innerHTML = listadoHtml;
}

async function eliminarTerrestre(id){
        if(!confirm('Desea eliminar el envio?')){
            return;
        }
        const request = await fetch('api/terrestres/'+id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
            },
          });
          window.location.reload();
   }
    function editarUsuario(id) {
           window.location.href = 'actualizarTerrestre.html?id=' + id;
       }
