/**
 * Dashboard Frontend
 * Sistema Integral de Biblioteca
 *
 * Consumo de información ejecutiva.
 *
 * @author Conce
 */


document.addEventListener(
    "DOMContentLoaded",
    () => {


        validarSesion();


        cargarDashboard();



        const botonCerrar =
            document.getElementById(
                "cerrarSesion"
            );


        if(botonCerrar){

            botonCerrar.addEventListener(
                "click",
                cerrarSesion
            );

        }



        const botonPDF =
            document.getElementById(
                "btnPDF"
            );


        if(botonPDF){

            botonPDF.addEventListener(
                "click",
                exportarPDF
            );

        }



        const botonExcel =
            document.getElementById(
                "btnExcel"
            );


        if(botonExcel){

            botonExcel.addEventListener(
                "click",
                exportarExcel
            );

        }


    }

);





/**
 * Valida existencia del JWT.
 */
function validarSesion(){


    const token =
        localStorage.getItem(
            "token"
        );


    if(!token){

        window.location.href =
            "login.html";

    }

}







/**
 * Carga información dashboard.
 */
async function cargarDashboard(){


    try{


        const respuesta =
            await consumirAPI(
                "/api/dashboard"
            );



        console.log(
            "Dashboard:",
            respuesta
        );



        const dashboard =
            respuesta.data ??
            respuesta;



        actualizarUsuario();



        actualizarIndicadores(
            dashboard
        );



        actualizarAlertas(
            dashboard
        );



        actualizarOperacion(
            dashboard
        );



        actualizarRankings(
            dashboard
        );



    }
    catch(error){


        console.error(
            "Error dashboard:",
            error
        );


    }


}








/**
 * Consume API protegida.
 */
async function consumirAPI(
        url){


    const token =
        localStorage.getItem(
            "token"
        );



    const respuesta =
        await fetch(
            url,
            {


                method:"GET",


                headers:{


                    "Authorization":
                    "Bearer "
                    + token,


                    "Content-Type":
                    "application/json"

                }


            }

        );



    if(!respuesta.ok){

        throw new Error(
            "Error consultando API "
            + respuesta.status
        );

    }



    return await respuesta.json();


}








/**
 * Actualiza indicadores.
 */
function actualizarIndicadores(
        dashboard){



    const resumen =
        dashboard.resumen
        ?? {};



    colocarValor(
        "totalLibros",
        resumen.totalLibros
    );



    colocarValor(
        "totalUsuarios",
        resumen.totalUsuarios
    );



    colocarValor(
        "totalEjemplares",
        resumen.totalEjemplares
    );



    colocarValor(
        "ejemplaresDisponibles",
        resumen.ejemplaresDisponibles
        ??
        resumen.disponibles
    );



    colocarValor(
        "prestamosActivos",
        resumen.prestamosActivos
    );



    colocarValor(
        "reservasActivas",
        resumen.reservasActivas
    );



    colocarValor(
        "prestamosVencidos",
        resumen.prestamosVencidos
    );



}








function colocarValor(
        id,
        valor){



    const elemento =
        document.getElementById(
            id
        );



    if(elemento){


        elemento.textContent =
            valor ?? 0;


    }


}








/**
 * Actualiza alertas.
 */
function actualizarAlertas(
        dashboard){



    const alertas =
        dashboard.alertas
        ??
        {};



    const contenedor =
        document.getElementById(
            "alertas"
        );



    if(!contenedor){

        return;

    }



    contenedor.innerHTML = `

        <p>
        ⚠️ Préstamos vencidos:
        ${alertas.prestamosVencidos ?? 0}
        </p>


        <p>
        📌 Reservas activas:
        ${alertas.reservasActivas ?? 0}
        </p>

    `;


}









/**
 * Actualiza operación diaria.
 */
function actualizarOperacion(
        dashboard){



    const operacion =
        dashboard.operacionDia
        ??
        {};



    const contenedor =
        document.getElementById(
            "operacion"
        );



    if(!contenedor){

        return;

    }



    contenedor.innerHTML = `


        <p>
        📚 Préstamos hoy:
        ${operacion.prestamosHoy ?? 0}
        </p>


        <p>
        🔄 Devoluciones hoy:
        ${operacion.devolucionesHoy ?? 0}
        </p>


    `;


}









/**
 * Actualiza rankings.
 */
function actualizarRankings(
        dashboard){


    crearRanking(
        "topLibros",
        dashboard.topLibros
    );


    crearRanking(
        "topCategorias",
        dashboard.topCategorias
    );


    crearRanking(
        "topAutores",
        dashboard.topAutores
    );


}






function crearRanking(
        id,
        datos){


    const elemento =
        document.getElementById(
            id
        );



    if(!elemento){

        return;

    }



    if(!datos ||
       datos.length===0){


        elemento.innerHTML =
        "<p>Sin información</p>";


        return;

    }




    let html =
        "<ul>";



    datos.forEach(
        item => {


            html += `

            <li>
            ${item.nombre}
            -
            ${item.totalPrestamos}
            </li>

            `;


        }

    );



    html += "</ul>";



    elemento.innerHTML =
        html;


}









/**
 * Usuario visible.
 */
function actualizarUsuario(){


    const tipo =
        localStorage.getItem(
            "type"
        );



    const elemento =
        document.getElementById(
            "usuarioSesion"
        );



    if(elemento){

        elemento.textContent =
            tipo ??
            "Administrador";

    }

}









/**
 * Exportar PDF.
 */
function exportarPDF(){


    descargarArchivo(
        "/api/reportes/dashboard/pdf"
    );


}






/**
 * Exportar Excel.
 */
function exportarExcel(){


    descargarArchivo(
        "/api/reportes/dashboard/excel"
    );


}






async function descargarArchivo(
        url){


    const token =
        localStorage.getItem(
            "token"
        );


    const respuesta =
        await fetch(
            url,
            {

                headers:{

                    "Authorization":
                    "Bearer "
                    + token

                }

            }

        );



    const blob =
        await respuesta.blob();



    const enlace =
        document.createElement(
            "a"
        );


    enlace.href =
        window.URL
        .createObjectURL(
            blob
        );


    enlace.download =
        "reporte-dashboard";


    enlace.click();


}








/**
 * Cerrar sesión.
 */
function cerrarSesion(){


    localStorage.removeItem(
        "token"
    );


    localStorage.removeItem(
        "type"
    );



    window.location.href =
        "login.html";


}