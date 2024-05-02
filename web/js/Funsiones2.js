function validarFormulario() {
  // Obtener todos los campos del formulario
  var campos = document.getElementsByClassName('form-control');

  // Bandera para verificar si hay campos vacíos
  var camposVacios = false;

  // Recorrer todos los campos
  for (var i = 0; i < campos.length; i++) {
    // Verificar si el campo está vacío
    if (campos[i].value === '') {
      // Mostrar una alerta para completar los datos
      alert('Por favor, complete todos los campos');
      
      // Autorellenar el campo vacío con cero
      campos[i].value = '0';
      
      // Cambiar el color del campo vacío para resaltarlo
      campos[i].style.backgroundColor = 'yellow';
      
      // Establecer la bandera en verdadero
      camposVacios = true;
    }
  }

  // Si no hay campos vacíos, enviar el formulario
  if (!camposVacios) {
    document.getElementById('custom-form').submit();
  }
}

function calcularPromedio2() {
    // Obtener los valores de las entradas de humedad
    var humedad1 = parseFloat(document.getElementById('humedad_1').value);
    var humedad2 = parseFloat(document.getElementById('humedad_2').value);
    var humedad3 = parseFloat(document.getElementById('humedad_3').value);
    var humedad4 = parseFloat(document.getElementById('humedad_4').value);
    var humedad5 = parseFloat(document.getElementById('humedad_5').value);
    var humedad6 = parseFloat(document.getElementById('humedad_6').value);
    var humedad7 = parseFloat(document.getElementById('humedad_7').value);
    var humedad8 = parseFloat(document.getElementById('humedad_8').value);
    var humedad9 = parseFloat(document.getElementById('humedad_9').value);
    var humedad10 = parseFloat(document.getElementById('humedad_10').value);

    // Calcular el promedio
    var promedio = (humedad1 + humedad2 + humedad3 + humedad4 + humedad5 + humedad6 + humedad7 + humedad8 + humedad9 + humedad10) / 10;

    // Mostrar el promedio en el campo de entrada de humedad promedio
    document.getElementById('humedad_promedio').value = promedio.toFixed(2);
}



function validarCampo2(input) {
    var valor = input.value.trim();
    if (valor === "") {
        input.classList.add("campo-invalido"); // Agrega la clase CSS para resaltar el campo
    } else {
        input.classList.remove("campo-invalido"); // Quita la clase CSS si el campo tiene un valor
    }
}




function calcularPromedio3() {
    // Obtener todos los campos de entrada de humedad
    var inputs = document.querySelectorAll('[id^="Humedad_"]');

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



function validarCampolp(input) {
    var valor = input.value.trim();
    if (valor === "") {
        input.classList.add("campo-invalido"); // Agrega la clase CSS para resaltar el campo
    } else {
        input.classList.remove("campo-invalido"); // Quita la clase CSS si el campo tiene un valor
    }
}

function validarYAutoRellenarConCerolp(input) {
    var valor = input.value.trim();
    if (valor === "") {
        input.value = "0"; // Auto-rellena con cero si el campo está vacío
    }
}


//captura los datos
function validarFormulariolp() {
    var solidosInput = document.getElementById("Solidos");
    var humedadInput = document.getElementById("Humedad");
    var fechaInput = document.getElementById("fecha");
    var lotesInput = document.getElementById("lotes");
    var numtanqueInput = document.getElementById("numtanque");
    var r325Input = document.getElementById("r325");
    var phInput = document.getElementById("ph");
    var dv_50Input = document.getElementById("dv_50");
    var dv_90Input = document.getElementById("dv_90");

    validarCampolp(solidosInput);
    validarCampolp(humedadInput);
    validarCampolp(fechaInput);
    validarCampolp(lotesInput);
    validarCampolp(numtanqueInput);
    validarCampolp(r325Input);
    validarCampolp(phInput);
    validarCampolp(dv_50Input);
    validarCampolp(dv_90Input);


    // Auto-rellena con cero

    validarYAutoRellenarConCerolp(humedadInput);
    validarYAutoRellenarConCerolp(r325Input);
    validarYAutoRellenarConCerolp(phInput);
    validarYAutoRellenarConCerolp(dv_50Input);
    validarYAutoRellenarConCerolp(dv_90Input);
    validarYAutoRellenarConCerolp(numtanqueInput);
    validarYAutoRellenarConCerolp(lotesInput);


    if (solidosInput.classList.contains("campo-invalido") ||
            humedadInput.classList.contains("campo-invalido") ||
            r325Input.classList.contains("campo-invalido") ||
            fechaInput.classList.contains("campo-invalido") ||
            numtanqueInput.classList.contains("campo-invalido") ||
            dv_50Input.classList.contains("campo-invalido") ||
            dv_90Input.classList.contains("campo-invalido") ||
            phInput.classList.contains("campo-invalido")) {

        alert("Por favor, complete todos los campos obligatorios.");
        return false;
    }

    // Si todos los campos están llenos o auto-rellenados con cero, el formulario se enviará
    return true;
}

