
/*-------------------------------------------------------------*/

function validarCampo(input) {
    var valor = input.value.trim();
    input.classList.toggle("campo-invalido", valor === "");
    if (valor === "") {
        input.value = ""; // Auto-rellena con cero si el campo está vacío
    }
}

function validarCampoCombo(input) {
    var valor = input.value;
    input.classList.toggle("campo-invalido", valor === "0" || valor === "");
    return valor !== "0" && valor !== "";
}

function validarFormulario() {
    var camposObligatorios = [
        "nombres", "telefono", "correo", "usuario",
        "clave", "tipoPerfil"
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
            title: "Reporte Registrado con Éxito",
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



function eliminarUsuario(id) {

    // Verificar si el registro se puede eliminar
    if (!canDeleteUser(id)) {
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
                window.location.href = "ControladorUsuarios?accion=eliminar2&id=" + id;
            }, 1500);
        } else {
            swal("Operación cancelada.", {
                icon: "error",
                title: "Cancelado"
            });
        }
    });
}

function canDeleteUser(id) {
    // Envíe una solicitud AJAX al servidor para verificar si el registro se puede eliminar
    return $.ajax({
        url: "ControladorUsuarios?accion=canDelete&id=" + id,
        type: "GET",
        async: false
                // aca se recibe la respuesta del servidor (ControladorConsecutivo?accion=canDelete) y esta se alamacena 
    }).responseText.trim() === "true";
}

