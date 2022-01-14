// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarProductoTerrestre()
cargarCliente()
});

async function registrarUsuario(){

    let datos = {};
    datos.cantidad_producto = document.getElementById("cantidad_producto").value;
    datos.id_cliente = localStorage.id_cliente;
    datos.fecha_entrega = document.getElementById("fechaEntrega").value;
    datos.fecha_registro= document.getElementById("fechaRegistro").value;
    datos.numero_guia = document.getElementById("numeroGuia").value;
    datos.placa_vehiculo = document.getElementById("placaVehiculo").value;
    datos.precio_envio = document.getElementById("precioEnvio").value;
    datos.id_producto_terrestre = document.getElementById("productoTerrestre").value;


  const request = await fetch('api/terrestres', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(datos)
    });
     alert("Envio registrado con exito!");
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
   option.innerHTML = '<option selected>Selecione el tipo producto</option>'+ listadoHtml;
}

