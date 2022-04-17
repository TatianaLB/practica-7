function AddTienda(){

    try {
        var idTienda = document.getElementById("idTienda").value;
        var nombre = document.getElementById("nombre").value;
        var ciudad = document.getElementById("ciudad").value;
        var direccion = document.getElementById("direccion").value;
        var telefono = document.getElementById("telefono").value;
        var horario = document.getElementById("horario").value;

        var data = {
                    "idTienda":idTienda,
                    "nombre":nombre,
                    "ciudad":ciudad,
                    "direccion":direccion,
                    "telefono":telefono,
                    "horario":horario
                    };
        const address = 'api/v1/tienda/add';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if(data.result == "OK") {
                    alert("Tienda añadida");
                    document.location.href="/api/v1/tiendas";
                } else {
                    alert("Error");
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}