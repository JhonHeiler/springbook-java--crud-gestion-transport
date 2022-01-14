// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarProductoMaritima()
cargarCliente()
});

async function registrarUsuario(){

    let datos = {};
    datos.cantidad_producto = document.getElementById("cantidad_producto").value;
    datos.id_cliente = localStorage.id_cliente;
    datos.fecha_entrega = document.getElementById("fechaEntrega").value;
    datos.fecha_registro= document.getElementById("fechaRegistro").value;
    datos.numero_guia = document.getElementById("numeroGuia").value;
    datos.numero_flota = document.getElementById("numeroFlota").value;
    datos.precio_envio = document.getElementById("precioEnvio").value;
    datos.id_producto_maritimo = document.getElementById("productoTerrestre").value;


  const request = await fetch('api/maritimas', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(datos)
    });
     alert("Envio registrado con exito!");
     window.location.href= 'maritima.html'
}


async function cargarProductoMaritima(){
  const request = await fetch('api/productoMaritimos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
  });
  const productoMaritimos = await request.json();

  let listadoHtml=""
  for (let productoMaritimo of productoMaritimos){
      let productoMaritimohtml = '<option value="'+ productoMaritimo.id+'">'+productoMaritimo.nombre+'</option>'
      listadoHtml += productoMaritimohtml;
  }

   var option= document.getElementById("productoTerrestre");
   option.innerHTML = '<option selected>Selecione el tipo producto</option>'+ listadoHtml;
}

