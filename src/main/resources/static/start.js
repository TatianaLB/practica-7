//BUSCAR

function BuscarPrenda(){
    var inputValue = document.getElementById("idPrenda").value;
    var address;

    if(inputValue == '' || inputValue == 'all'){
        address = '/api/v1/prendas';
    }else{
        address = '/api/v1/prenda/'+inputValue;
    }
    console.log(address);
    window.location.href = address;
    return false;

}
function BuscarTienda(){
    var inputValue = document.getElementById("idTienda").value;
    var address;

        if(inputValue == '' || inputValue == 'all'){
            address = '/api/v1/tiendas';
        }else{
            address = '/api/v1/tienda/'+inputValue;
        }
    window.location.href = address;
    return false;

}

//BORRAR

function BorrarPrenda(){

    var inputValue = document.getElementById("idPrenda").value;
    var address = '/api/v1/prenda/delete/'+inputValue;
    var currentAddress = window.location.href;
    window.location.href = address;
    window.location.href = currentAddress;
    alert("La prenda de ropa se ha borrado correctamente.");

    return false;
}

function BorrarTienda(){
    var inputValue = document.getElementById("idTienda").value;
    var address = '/api/v1/tienda/delete/'+inputValue;
    var currentAddress = window.location.href;
    window.location.href = address; //Consumimos el endpoint
    window.location.href = currentAddress; //Volvemos a la página instantáneamente
    alert("La tienda de ropa se ha borrado correctamente.");

    return false;
}
