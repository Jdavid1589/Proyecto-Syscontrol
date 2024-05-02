function validarCampo2(input) {
    var valor = input.value.trim();
    input.classList.toggle("campo-invalido", valor === "");
    if (valor === "") {
        input.value = "0"; // Auto-rellena con cero si el campo está vacío
    }
}

function validarCampoCombo(input) {
    var valor = input.value;
    input.classList.toggle("campo-invalido", valor === "0" || valor === "");
    return valor !== "0" && valor !== "";
}

function validarFormulario2() {
    var camposObligatorios = [
        "solidos", "humedad", "fecha", "lote", "tanque", "r325", "pH",
        "Cantidadkg",  "dosisBiocidad",
        "Dv50", "Dv90", "cP", "ku", "Biocida", "Lt_biocida", "Brigh", "Wh", "cantid_kg", "AbsAceite",
         "kgAgua", "dispersante", "kgSodio", "espesante", "idUsuarios", "producto", "txtSto","Consecutivo"
    ];

    for (var i = 0; i < camposObligatorios.length; i++) {
        var input = document.getElementById(camposObligatorios[i]);
        if (input.tagName.toLowerCase() === "select") {
            validarCampoCombo(input);
        } else {
            validarCampo2(input);
        }
    }

    var camposInvalidos = camposObligatorios.some(function (campo) {
        var input = document.getElementById(campo);
        return input.classList.contains("campo-invalido");
    });

    if (camposInvalidos) {
        alert("Por favor, complete todos los campos obligatorios.");
        return false;
    }

    return true;
}

/*
function calcularHumedad(solidosInput) {
    var valor = solidosInput.value;
    var humedadInput = document.getElementById("Humedad");

    // Verificar si el valor ingresado es un número decimal válido
    var solidosDouble = parseFloat(valor); // Convertir a Double

    if (!isNaN(solidosDouble)) {
        var humedadDouble = 100 - solidosDouble;
        humedadInput.value = humedadDouble.toFixed(2); // Limitar a 2 decimales y asignar a Humedad
    } else {
        humedadInput.value = ''; // Limpiar el campo de "Humedad" si Solidos no es un número válido
    }
}

*/







