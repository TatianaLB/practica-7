function AddPrenda(){

    try {
        var idPrenda = document.getElementById("idPrenda").value;
        var descripcion = document.getElementById("descripcion").value;
        var existencias = document.getElementById("existencias").value;

        var data = {
                    "idPrenda":idPrenda,
                    "descripcion":descripcion,
                    "existencias":existencias
                    };
        const address = 'api/v1/prenda/add';
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
                    alert("Prenda añadida");
                    document.location.href="/api/v1/prendas";
                } else {
                    alert("Error");
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}