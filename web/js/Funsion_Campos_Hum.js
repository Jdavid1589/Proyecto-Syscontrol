let contadorCamposHumedad = 1; // Inicializar la variable fuera de la función

function agregarCampoHumedad() {
    const divCamposHumedad = document.getElementById('campos-humedad');
    const nuevoCampoHumedad = document.createElement('div');
    const campoId = `campo-humedad-${contadorCamposHumedad}`;
    nuevoCampoHumedad.id = campoId;
    nuevoCampoHumedad.classList.add('form-group', 'row', 'align-items-center');

    // Concatenar el nombre del campo correctamente
    const nombreCampo = "humedad_" + contadorCamposHumedad.toString();

    nuevoCampoHumedad.innerHTML = `
  
        <div class="formulario__grupo"  class="col-md-6">
          <label class="formulario__label" for="humedad_${contadorCamposHumedad}" class=" col-form-label">%Humedad-${contadorCamposHumedad}</label>
            <input type="number" step="0.01" class="form-control campo-humedad" id="humedad_${contadorCamposHumedad}"
                name="${nombreCampo}"
                placeholder="Ingrese % Hum" >
        </div>
        <div >
            <button class="btn btn-sm ml-2 mt-5 btn-danger" type="button" onclick="eliminarCampoHumedad(${contadorCamposHumedad})">
                <i class="fas fa-trash"></i>
            </button>
        </div>
    `;

    divCamposHumedad.appendChild(nuevoCampoHumedad);

    // Incrementar el contador después de agregar el campo
    contadorCamposHumedad++;
}


function eliminarCampoHumedad(id) {
    const campoHumedad = document.getElementById(`campo-humedad-${id}`);
    campoHumedad.remove();
    console.log(`Campo humedad eliminado: ${id}`);
    //calcularPromedioHumedad(); // Recalcular el promedio al eliminar un campo
}

// Agregar campos de humedad inicialmente al cargar la página (opcional)
window.onload = function () {
    const numCamposIniciales = 2; // Puedes ajustar este valor según tus necesidades
    for (let i = 0; i < numCamposIniciales; i++) {
        agregarCampoHumedad();
    }
    // calcularPromedioHumedad(); // Calcular el promedio inicialmente
};

/*function calcularPromedioHumedad() {
 const camposHumedad = document.querySelectorAll('[id^="humedad_"]');
 
 let totalHumedad = 0;
 let numCamposValidos = 0;
 
 camposHumedad.forEach(campo => {
 const valorCampo = parseFloat(campo.value);
 if (!isNaN(valorCampo)) { // Verificar si el valor es un número válido
 totalHumedad += valorCampo;
 numCamposValidos++;
 }
 });
 
 if (numCamposValidos > 0) {
 const promedioHumedad = totalHumedad / numCamposValidos;
 document.getElementById('sol_promedio').value = promedioHumedad.toFixed(2); // Actualizar el valor del campo de humedad promedio
 } else {
 // Si no hay campos válidos, establecer el campo de humedad promedio como vacío o algún valor predeterminado
 document.getElementById('sol_promedio').value = 0;
 }
 }*/


