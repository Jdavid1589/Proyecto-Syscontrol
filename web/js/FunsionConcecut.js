function validarFormulario() {
    var camposObligatorios = [
        "idUsuarios", "nroRemision",  "idespecificaciones", "lote",
        "fechaCertificado", "fechaProduccion", "cantidadMaterial"
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

   
}







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



//fUNSION PARA VALIDAR FORMULARIO
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



/*
 function validarFormulario() {
 // Obtener los valores de los campos
 var nroRemision = document.getElementById('nroRemision');
 var nroConsecutivo = document.getElementById('nroConsecutivo');
 var fechaCertificado = document.getElementById('fechaCertificado');
 var fechaProduccion = document.getElementById('fechaProduccion');
 var cantidadMaterial = document.getElementById('cantidadMaterial');
 
 // Verificar que los campos no estén vacíos
 if (!validarCampo(nroRemision) || !validarCampo(nroConsecutivo) ||
 !validarCampo(fechaCertificado) || !validarCampo(fechaProduccion) ||
 !validarCampo(cantidadMaterial)) {
 return false; // Evitar que el formulario se envíe
 }
 
 // Agrega más validaciones si es necesario
 
 return true; // Permitir que el formulario se envíe
 }
 
 function validarCampo(campo) {
 // Eliminar espacios en blanco al inicio y al final
 var valor = campo.value.trim();
 
 // Verificar que el campo no esté vacío o sea nulo
 if (valor === '') {
 campo.style.borderColor = 'red'; // Pintar el borde del campo de rojo
 return false;
 } else {
 campo.style.borderColor = ''; // Restablecer el color del borde
 return true;
 }
 }
 
 */


function eliminarConsecutivo(id) {
    swal({
        title: "¿Estás seguro?",
        text: "Una vez eliminado, no podrás recuperar este reporte.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((willDelete) => {
                if (willDelete) {
                    // Aquí rediriges a la URL de eliminación
                    window.location.href = "ControladorConsecutivo?accion=eliminar&id=" + id;
                } else {
                    swal("El Reporte está a salvo.");
                }

            });
}



$(document).ready(function () {
    $(document).on("click", ".btnDelete", function () {
        var idp = $(this).data("id");
        confirmarEliminacion(idp);
    });

    function confirmarEliminacion(idp) {
        swal({
            title: "¿Está seguro de eliminar Cliente?",
            text: "Una vez eliminado deberá agregar de nuevo.",
            icon: "warning",
            buttons: {
                confirmar: "Sí, Eliminar",
                cancelar: "No, Cancelar"
            },
        }).then((isConfirm) => {
            if (isConfirm) {
                eliminarRegistro(idp);
            } else {
                swal("Cancelado", "Cancelaste la eliminación", "error");
            }
        });
    }

    function eliminarRegistro(idp) {
        var url = "ControladorClientes?accion=eliminar&id=" + idp;

        console.log("URL de eliminación:", url);

        $.ajax({
            type: 'POST',
            url: url,
            async: true,
        }).done(function (response) {
            console.log("Respuesta del servidor:", response);

            if (response === "success") {
                swal("Eliminado", "El Cliente se ha eliminado", "success");
                setTimeout(function () {
                    window.location.href = "ControladorClientes?accion=listar";
                }, 1000);
            } else {
                swal("Error Cliente en Uso", response, "error");
            }
        }).fail(function () {
            swal("Error", "Hubo un problema al intentar eliminar el Cliente", "error");
        });
    }
});


