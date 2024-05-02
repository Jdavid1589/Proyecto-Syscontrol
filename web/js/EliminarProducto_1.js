




$(document).ready(function () {
    $(".btnDelete").click(function () {
        var idp = $(this).data("id");

        // Configurar el diálogo de confirmación SweetAlert
        swal({
            title: "¿Está seguro de eliminar Reporte?",
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
    });

    function eliminarRegistro(idp) {
        var url = "ControladorControlCalidad?accion=eliminar2&id=" + idp;

        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (response) {
                // Maneja acciones adicionales si es necesario
                console.log(response);

                if (response === "success") {
                    swal("Eliminado", "El Usuario se ha eliminado", "success");
                    setTimeout(function () {
                        // Redirigir a una página diferente después de una eliminación exitosa
                        window.location.href = "ControladorControlCalidad?accion=listar";
                    }, 1000);
                } else {
                    swal("Error Usuario en Uso", response, "error");
                }
            },
            error: function () {
                swal("Error ", "Hubo un problema al intentar eliminar el usuario", "error ");
            }
        });
    }
});


