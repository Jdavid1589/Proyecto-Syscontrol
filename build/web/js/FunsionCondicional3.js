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
        "idUsuarios", "idProductos", "fecha", "lote",
        "r325", "pH_1", "pH_2", "pH_3", "pH_promedio", "dtp", "dtp1", "AA",
        "BR", "Wh", "idclientes", "cant_noconf", "Humedad_1",
        "Humedad_2", "Humedad_3", "Humedad_4", "Humedad_5", "Humedad_6",
        "Humedad_7", "Humedad_8", "Humedad_9", "Humedad_10", "Humedad_Promedio"
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





function calcularPromedioHum() {

    // Obtener todos los campos de entrada de humedad
    var inputs = document.querySelectorAll('[id^="Humedad_"]');

    // Función para calcular el promedio
    function calcular() {
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
            document.getElementById('Humedad_Promedio').value = promedio.toFixed(2);
        } else {
            // Limpiar el campo si no hay valores válidos
            document.getElementById('Humedad_Promedio').value = "";
        }
    }

    // Agregar eventos de escucha a los campos de entrada
    inputs.forEach(function (input) {
        input.addEventListener('input', calcular);
        input.addEventListener('blur', calcular);
    });
}



// Función Para Calcular promedio pH

function calcularPromedioPH() {
    // Obtener todos los campos de entrada de humedad
    var inputs = document.querySelectorAll('[id^="pH_"]');

    // Función para calcular el promedio
    function calcular() {
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

    // Agregar eventos de escucha a los campos de entrada
    inputs.forEach(function (input) {
        input.addEventListener('input', calcular);
        input.addEventListener('blur', calcular);
    });
}
