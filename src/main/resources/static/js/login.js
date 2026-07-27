/**
 * Login Frontend
 * Sistema Integral de Biblioteca
 *
 * Gestiona autenticación mediante JWT.
 *
 * HT20.22
 *
 * @author Conce
 */


document.addEventListener(
    "DOMContentLoaded",
    () => {


        const formulario =
            document.getElementById(
                "formLogin"
            );


        const mensajeError =
            document.getElementById(
                "mensajeError"
            );



        formulario.addEventListener(
            "submit",
            async (evento) => {


                evento.preventDefault();



                /*
                 * Limpia sesión anterior.
                 */
                localStorage.removeItem(
                    "token"
                );


                localStorage.removeItem(
                    "type"
                );



                const correo =
                    document
                    .getElementById(
                        "correo"
                    )
                    .value
                    .trim();



                const password =
                    document
                    .getElementById(
                        "password"
                    )
                    .value
                    .trim();



                ocultarMensaje();



                try {



                    const respuesta =
                        await fetch(
                            "/api/auth/login",
                            {

                                method: "POST",

                                headers: {

                                    "Content-Type":
                                    "application/json"

                                },


                                body:
                                JSON.stringify(
                                    {

                                        correo:
                                        correo,


                                        password:
                                        password

                                    }
                                )

                            }
                        );





                    if (!respuesta.ok) {


                        throw new Error(
                            "Credenciales incorrectas."
                        );


                    }





                    const datos =
                        await respuesta.json();





                    if (!datos.token) {


                        throw new Error(
                            "No se recibió token JWT."
                        );


                    }





                    /*
                     * Guarda JWT para toda la aplicación.
                     */
                    localStorage.setItem(
                        "token",
                        datos.token
                    );



                    /*
                     * Guarda tipo de usuario.
                     */
                    localStorage.setItem(
                        "type",
                        datos.type ?? ""
                    );





                    console.log(
                        "Login correcto"
                    );



                    window.location.href =
                        "dashboard.html";





                }
                catch(error) {



                    mostrarMensaje(
                        error.message
                    );


                    console.error(
                        "Error login:",
                        error
                    );


                }



            }
        );



    }
);







/**
 * Muestra mensaje de error.
 *
 * @param {string} mensaje Mensaje.
 */
function mostrarMensaje(
        mensaje) {


    const mensajeError =
        document.getElementById(
            "mensajeError"
        );



    if(mensajeError){


        mensajeError.textContent =
            mensaje;



        mensajeError.classList.remove(
            "d-none"
        );


    }

}







/**
 * Oculta mensaje de error.
 */
function ocultarMensaje() {


    const mensajeError =
        document.getElementById(
            "mensajeError"
        );



    if(mensajeError){


        mensajeError.textContent =
            "";



        mensajeError.classList.add(
            "d-none"
        );


    }

}