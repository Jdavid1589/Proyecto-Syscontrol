
function validarCampo(input) {
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

function validarFormulario() {
    var camposObligatorios = [
         "fecha", "idSeguimiento",
        "idUsuarios", "idProductos", "lotes", "cant_noconf",
        "txtTanque", "lotes", "txtCantkg",
        "r325", "pH_1", "pH_2", "pH_3", "pH_promedio", "dtp", "dtp1", "AA",
        "BR", "Wh", "cant_noconf", "humedad_1",
        "humedad_2", "humedad_3", "humedad_4", "humedad_5", "humedad_6",
        "humedad_7", "humedad_8", "humedad_9", "humedad_10", "sol_promedio" 
    ];
    for (var i = 0; i < camposObligatorios.length; i++) {
        var input = document.getElementById(camposObligatorios[i]);
        if (input.tagName.toLowerCase() === "select") {
            validarCampoCombo(input);
        } else {
            validarCampo(input);
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




function calcularPromedioPS() {
    var inputs = document.querySelectorAll('[id^="humedad_"]');
    var suma = 0;
    var cantidadValores = 0;
    inputs.forEach(function (input) {
        var valor = parseFloat(input.value);
        if (!isNaN(valor) && valor > 0) {
            suma += valor;
            cantidadValores++;
        }
    });
    var promedio = cantidadValores > 0 ? suma / cantidadValores : null;
    // Actualizar el campo con el promedio o limpiarlo si no hay valores válidos
    document.getElementById('sol_promedio').value = promedio !== null ? promedio.toFixed(2) : "";
}


function calcularPromedioPH() {
// Obtener todos los campos de entrada de humedad
    var inputs = document.querySelectorAll('[id^="pH"]');
    // Inicializar variables para el cálculo del promedio
    var suma = 0;
    var cantidadValores = 0;
    // Recorrer los campos y calcular el promedio
    inputs.forEach(function (input) {
        var valor = parseFloat(input.value);
        if (!isNaN(valor) && valor > 0) {
            // Si el valor es un número válido y mayor que cero, sumarlo al total y aumentar la cantidad de valores
            suma += valor;
            cantidadValores++;
        }
    });
    // Calcular el promedio solo si hay al menos un valor válido
    if (cantidadValores > 0) {
        var promedio = suma / cantidadValores;
        document.getElementById('pH_promedio').value = promedio.toFixed(2);
    } else {
// Limpiar el campo si no hay valores válidos
        document.getElementById('pH_promedio').value = "";
    }
}




function calcularPromedioHum() {
// Obtener todos los campos de entrada de humedad
    var inputs = document.querySelectorAll('[id^="humedad_"]');
    // Inicializar variables para el cálculo del promedio
    var suma = 0;
    var cantidadValores = 0;
    // Recorrer los campos y calcular el promedio
    inputs.forEach(function (input) {
        var valor = parseFloat(input.value);
        if (!isNaN(valor) && valor > 0) {
            // Si el valor es un número válido y mayor que cero, sumarlo al total y aumentar la cantidad de valores
            suma += valor;
            cantidadValores++;
        }
    });
    // Calcular el promedio solo si hay al menos un valor válido
    if (cantidadValores > 0) {
        var promedio = suma / cantidadValores;
        document.getElementById('sol_promedio').value = promedio.toFixed(2);
    } else {
// Limpiar el campo si no hay valores válidos
        document.getElementById('sol_promedio').value = "";
    }

}














