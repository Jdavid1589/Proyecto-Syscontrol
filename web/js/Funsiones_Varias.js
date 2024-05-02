


// Función para ir al inicio de la tabla
$("#btnInicio").click(function () {
    var tableContainer = document.querySelector(".table-container");
    tableContainer.scrollTop = 0;
});

// Función para ir al final de la tabla
$("#btnFinal").click(function () {
    var tableContainer = document.querySelector(".table-container");
    tableContainer.scrollTop = tableContainer.scrollHeight;
});

$("#btnIzquierda").click(function () {
    var tableContainer = document.querySelector(".table-container");
    tableContainer.scrollLeft -= 100; // Puedes ajustar el valor según tus necesidades
});

$("#btnDerecha").click(function () {
    var tableContainer = document.querySelector(".table-container");
    tableContainer.scrollLeft += 100; // Puedes ajustar el valor según tus necesidades
});


//Funsion para dezplazarme horizontalmente
$("#btnIzquierda2").click(function () {
    var tableContainer = document.querySelector(".table-container");
    tableContainer.scrollLeft = tableContainer.scrollWidth;
});





       