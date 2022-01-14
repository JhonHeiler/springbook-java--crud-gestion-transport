// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#btnEditarTerreste').click(actualizarTerrestre);
    let id = window.location.href.split('id=')[1];
    cargarTerrestre(id)
    cargarProductoTerrestre()
});


async function cargarTerrestre(id){
  const request = await fetch('api/mostrarTerrestre/'+id, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      //'Authorization': localStorage.token
    },
  });
  const terrestres = await request.json();
  cargarFormulario(terrestres)
}
  function cargarFormulario(terrestres) {
            $('#cantidad_producto').val(terrestres.cantidad_producto);
            $('#fechaEntrega').val(terrestres.fecha_entrega);
            $('#fechaRegistro').val(terrestres.fecha_registro);
            $('#numeroGuia').val(terrestres.numero_guia);
            $('#placaVehiculo').val(terrestres.placa_vehiculo);
            $('#precioEnvio').val(terrestres.precio_envio);
        }

async function actualizarTerrestre(){

    let datos = {};
    datos.id = window.location.href.split('id=')[1];
    datos.cantidad_producto = document.getElementById("cantidad_producto").value;
    datos.fecha_entrega = document.getElementById("fechaEntrega").value;
    datos.fecha_registro= document.getElementById("fechaRegistro").value;
    datos.numero_guia = document.getElementById("numeroGuia").value;
    datos.placa_vehiculo = document.getElementById("placaVehiculo").value;
    datos.precio_envio = document.getElementById("precioEnvio").value;
    datos.id_producto_terrestre = document.getElementById("productoTerrestre").value;


  const request = await fetch('api/ediTerrestres', {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(datos)
    });
     alert("los datos fueron actualizados con exito!");
     window.location.href= 'terrestre.html'
}


async function cargarProductoTerrestre(){
  const request = await fetch('api/productoTerrestres', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
  });
  const productoTerrestres = await request.json();

  let listadoHtml=""
  for (let productoTerrestre of productoTerrestres){
      let productoTerrestrehtml = '<option value="'+ productoTerrestre.id+'">'+productoTerrestre.nombre+'</option>'
      listadoHtml += productoTerrestrehtml;
  }

   var option= document.getElementById("productoTerrestre");
   option.innerHTML = listadoHtml;
}

