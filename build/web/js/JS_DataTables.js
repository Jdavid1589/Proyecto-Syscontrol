$(document).ready(function () {
// Inicializa la tabla DataTables
    $('#miTabla').DataTable({
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
                    doc.pageMargins = [5, 5, 5, 5]; // [left, top, right, bottom]*/
                    doc.defaultStyle.fontSize = 10;

                    // Establece el ancho de la tabla en 50%
                    /* doc.content[1].table.widths = ['50%', '50%'];*/
                    /*-------*/
                    // Ajusta el tamaño de la fuente
                    doc.defaultStyle.fontSize = 8; // Por ejemplo, establece el tamaño de la fuente en 10 puntos

                    // Filtra las columnas que quieres imprimir
                    var filteredColumns = [0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 23]; // Índices de las columnas que quieres imprimir

                    // Remueve las columnas no deseadas
                    doc.content[1].table.body.forEach(function (row) {
                        row.splice(0, row.length, ...row.filter((cell, index) => filteredColumns.includes(index)));
                    });

                }
            }
            /*  {
             extend: 'print',
             text: '<i class="fa fa-print"></i> ',
             titleAttr: 'Imprimir',
             className: 'btn btn-info',
             },*/
        ],
        lengthMenu: [10, 15, 20, 100],
        columnDefs: [
            {className: 'centered', targets: '_all'}, // Aplica la clase 'centered' a todas las columnas
            {orderable: false, targets: [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                    22, 23, 24, 25, 26, 27, 28, 29
                ]},
            {searchable: false, targets: [0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11]}
        ],
        pageLength: 6,
        destroy: true,
        language: {
            processing: 'Procesando...',
            lengthMenu: 'Mostrar _MENU_ registros por página',
            zeroRecords: 'No se encontraron resultados',
            emptyTable: 'Ningún dato disponible en esta tabla',
            info: 'Mostrando _START_ a _END_ de _TOTAL_ entradas',
            infoEmpty: 'Mostrando 0 a 0 de 0 entradas',
            infoFiltered: '(filtrado de un total de _MAX_ entradas)',
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
