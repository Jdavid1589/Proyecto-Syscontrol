
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

