/*-----------------*/
// Funsion para Datatable

$(document).ready(function () {
    $('#miTabla').DataTable({
        "paging": true, // Habilita la paginación
        "pageLength": 7, // Número de registros por página
        "language": {
            "processing": "Procesando...",
            //"lengthMenu": "<span style='color: #09f; font-size: 18px;  position: absolute;  margin-left: -300px; '>Mostrar _MENU_ Registros </span>", // CIU
            "lengthMenu": "<span style='color: #09f; font-size: 18px; position: absolute; left: 50%; transform: translateX(-110%);'>Mostrar _MENU_ Registros</span>",
            "zeroRecords": "No se encontraron resultados",
            "emptyTable": "Ningún dato disponible en esta tabla",
            "info": "Mostrando _START_ a _END_ de _TOTAL_ entradas",
            "infoEmpty": "Mostrando 0 a 0 de 0 entradas",
            "infoFiltered": "(filtrado de un total de _MAX_ entradas)",
            "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "aria": {
                "sortAscending": ": Activar para ordenar la columna ascendente",
                "sortDescending": ": Activar para ordenar la columna descendente"
            }
        },
        "scrollX": false // Habilita el desplazamiento horizontal
    });
});

/*-------------------------------------------------------*/

// Funsion Validar Formulario Consecutivo

function validarFormulario() {
    var camposObligatorios = [
        "idUsuarios", "nroRemision", "idespecificaciones",
        "fechaCertificado", "lote", "fechaProduccion", "cantidadMaterial"
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

// Funsion Modal Calculadora
function abrirCalculadora() {
    // Limpiar campos al abrir el modal
    limpiarCampos();
    // Muestra el modal con la calculadora
    $('#calculadoraModal').modal('show');
}
function limpiarCampos() {
    // Limpiar los valores de los campos
    document.getElementById('numero1').value = '';
    document.getElementById('numero2').value = '';
    document.getElementById('cantidadMaterial').value = ''; // Esto debería ser el id correcto del campo a limpiar
}

function limpiarCampos() {
    // Limpiar los valores de los campos
    console.log('Limpiando campos');  // Agrega esta línea para imprimir en la consola
    document.getElementById('numero1').value = '';
    document.getElementById('numero2').value = '';
    // document.getElementById('cantidadMaterial').value = ''; // Asegúrate de que estás utilizando el id correcto
}

// Funsion Calculadora

function calcular(operacion) {
    // Obtén los valores de los campos de la calculadora
    var numero1 = parseFloat(document.getElementById('numero1').value);
    var numero2 = parseFloat(document.getElementById('numero2').value);

    // Realiza la operación seleccionada y entrega un Int
    switch (operacion) {
        case 'sumar':
            resultado = Math.trunc(numero1 + numero2);
            break;
        case 'restar':
            resultado = Math.trunc(numero1 - numero2);
            break;
        case 'multiplicar':
            resultado = Math.trunc(numero1 * numero2);
            break;
        case 'dividir':
            resultado = numero2 !== 0 ? Math.trunc(numero1 / numero2) : 'Error: División por cero';
            break;
        default:
            resultado = 'Error: Operación no válida';
    }
    // Actualiza el campo de cantidadMaterial en el formulario principal
    document.getElementById('cantidadMaterial').value = resultado;

    // Cierra el modal
    $('#calculadoraModal').modal.close('hide');
}

/*-------------------------------------------------------------*/



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
        "idUsuarios", "nroRemision",
        "fechaCertificado", "fechaProduccion", "cantidadMaterial"
    ];

    var camposValidos = true;

    for (var i = 0; i < camposObligatorios.length; i++) {
        var input = document.getElementById(camposObligatorios[i]);
        if (input.tagName.toLowerCase() === "select") {
            if (!validarCampoCombo(input)) {
                camposValidos = false;
            }
        } else {
            validarCampo(input);
            if (input.classList.contains("campo-invalido")) {
                camposValidos = false;
            }
        }
    }

    if (camposValidos) {
        Swal.fire({
            position: "center", // Centra el mensaje
            icon: "success",
            title: "Reporte Eliminado con Éxito",
            showConfirmButton: false,
            timer: 6000,
            customClass: {
                popup: 'swal2-popup-centered'
            }
        });

        return true;
    } else {
        Swal.fire({
            icon: "error",
            title: "Error",
            text: "Por favor, complete todos los campos obligatorios.",
        });
        return false;
    }
}


function eliminarConsecutivo(id) {

    // Verificar si el registro se puede eliminar
    if (!canDeleteConsecutivo(id)) {
        // Mensaje de error si el mensaje esta en uso
        Swal.fire({
            position: "center",
            icon: "error",
            title: '<span class="id-error"> <strong>' + 'El Registro con ID: ' + id + '</strong></span>' + ' No se puede eliminar,  porque está en uso',
            showConfirmButton: false,
            timer: 2500
        });
        return;
    }

    // Si el registro se puede eliminar se realiza Cuadro de dialogo de confirmación
    swal({
        title: "¿Estás seguro?",
        text: "Una vez eliminado, no podrás recuperar este reporte.",
        icon: "warning",
        buttons: true,
        dangerMode: true
    }).then((willDelete) => {
        if (willDelete) {
            // Muestra el mensaje de éxito
            Swal.fire({
                position: "center",
                icon: "success",
                title: "Reporte Eliminado con Éxito",
                showConfirmButton: false,
            });

            // Rediriges a la URL de eliminación después de 1.5 segundos (1500 milisegundos)
            setTimeout(() => {
                window.location.href = "ControladorConsecutivo?accion=eliminar2&id=" + id;
            }, 1500);
        } else {
            swal("Operación cancelada.", {
                icon: "error",
                title: "Cancelado"
            });
        }
    });
}

function canDeleteConsecutivo(id) {
    // Envíe una solicitud AJAX al servidor para verificar si el registro se puede eliminar
    return $.ajax({
        url: "ControladorConsecutivo?accion=canDelete&id=" + id,
        type: "GET",
        async: false
                // aca se recibe la respuesta del servidor (ControladorConsecutivo?accion=canDelete) y esta se alamacena 
    }).responseText.trim() === "true";
}


/*
 function eliminarConsecutivo2(id) {
 swal({
 title: "¿Estás seguro?",
 text: "Una vez eliminado, no podrás recuperar este reporte.",
 icon: "warning",
 buttons: true,
 dangerMode: true
 }).then((willDelete) => {
 if (willDelete) {
 // Muestra el mensaje de éxito
 Swal.fire({
 position: "center", // Centra el mensaje
 icon: "success",
 title: "Reporte Eliminado con Éxito",
 showConfirmButton: false,
 
 });
 
 // Rediriges a la URL de eliminación después de 1.5 segundos (1500 milisegundos)
 setTimeout(() => {
 window.location.href = "ControladorConsecutivo?accion=eliminar2&id=" + id;
 }, 1500);
 } else {
 swal("Operación cancelada.", {
 icon: "error",
 title: "Cancelado"
 });
 }
 });
 }*/
















