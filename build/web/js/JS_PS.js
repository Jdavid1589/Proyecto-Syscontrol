
// Función para DataTables
$(document).ready(function () {
    // Inicializa la tabla DataTables
    $('#miTabla2').DataTable({
        dom: 'Blftrip', // Mueve los elementos de paginación al final de la tabla
        buttons: [
            {
                extend: 'excelHtml5',
                text: '<i class="fas fa-file-excel"></i> ',
                titleAttr: 'Exportar a Excel',
                className: 'btn btn-success'
            },
            {
                extend: 'pdfHtml5',
                text: '<i class="fas fa-file-pdf"></i> ',
                titleAttr: 'Exportar a PDF',
                className: 'btn btn-danger',
                orientation: 'landscape', // Establece la orientación horizontal
                customize: function (doc) {
                    // Ajusta las márgenes
                    doc.pageMargins = [20, 5, 5, 5]; // [left, top, right, bottom]
                    doc.defaultStyle.fontSize = 10;
                    // Ajusta el tamaño de la fuente
                    doc.defaultStyle.fontSize = 8; // Por ejemplo, establece el tamaño de la fuente en 10 puntos
                    // Filtra las columnas que quieres imprimir
                    var filteredColumns = [0, 1, 2, 3, 4, 5, 16, 17, 18, 20, 21, 22, 23, 24, 25]; // Índices de las columnas que quieres imprimir
                    // Remueve las columnas no deseadas
                    doc.content[1].table.body.forEach(function (row) {
                        row.splice(0, row.length, ...row.filter((cell, index) => filteredColumns.includes(index)));
                    });
                }
            }
        ],
        lengthMenu: [10, 15, 20, 100],
        columnDefs: [
            {className: 'centered', targets: '_all'}, // Aplica la clase 'centered' a todas las columnas
            {orderable: false, targets: [3, 4, 5, 6]},
            {searchable: false, targets: [3, 4, 5, 6]}
        ],
        pageLength: 6,
        destroy: true,
        language: {
            processing: 'Procesando...',
            lengthMenu: 'Mostrar _MENU_ Registros por Página',
            zeroRecords: 'No se encontraron resultados',
            emptyTable: 'Ningún dato disponible en esta tabla',
            info: 'Mostrando _START_ a _END_ de _TOTAL_ entradas',
            infoEmpty: 'Mostrando 0 a 0 de 0 entradas',
            infoFiltered: '(filtrado de un total de _MAX_ Entradas)',
            search: 'Buscar:',
            paginate: {
                first: 'Primero',
                last: 'Último',
                next: 'Siguiente',
                previous: 'Anterior'
            },
            aria: {
                sortAscending: ': Activar para ordenar la columna ascendente',
                sortDescending: ': Activar para ordenar la columna descendente'
            }
        }
    });


});


//Funsion para agregar Campos Dinamicos de humedad a la lista

document.getElementById("agregarCampoHumedad").addEventListener("click", function () {
    var numCamposHumedad = document.querySelectorAll("#miTabla2 th[id^='Hum_']").length + 1; // Obtener el número actual de campos de humedad y sumar 1
    var nuevoCampoHumedad = document.createElement("th");
    nuevoCampoHumedad.textContent = "Hum_" + numCamposHumedad;
    nuevoCampoHumedad.id = "Hum_" + numCamposHumedad;
    document.querySelectorAll("#miTabla2 thead tr")[0].appendChild(nuevoCampoHumedad); // Agregar el nuevo campo de humedad a la cabecera de la tabla

    // Agregar el nuevo campo de humedad a cada fila de la tabla
    var filas = document.querySelectorAll("#miTabla2 tbody tr");
    filas.forEach(function (fila) {
        var nuevaCelda = document.createElement("td");
        // Aquí establece el valor de humedad correspondiente para cada fila
        var numCamposHumedad = document.querySelectorAll("#miTabla2 th[id^='Hum_']").length;
        var numFila = fila.querySelectorAll("td").length - 1; // Restar 1 para compensar la columna de ID al principio
        nuevaCelda.textContent = "12";
        fila.appendChild(nuevaCelda);
    });
});





