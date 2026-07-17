package mx.edu.itvo.biblioteca.xml.parser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Parser encargado de convertir un
 * elemento XML en un LibroRequestDTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class LibroXmlParser
        implements XmlParser<LibroRequestDTO> {

    /**
     * Convierte un elemento XML
     * en un LibroRequestDTO.
     *
     * @param element Elemento XML.
     * @return DTO.
     */
    @Override
    public LibroRequestDTO convertir(
            Element element) {

        LibroRequestDTO dto =
                new LibroRequestDTO();

        dto.setIsbn13(

                XmlUtils.obtenerTexto(

                        element,

                        "isbn13"

                )

        );

        dto.setTitulo(

                XmlUtils.obtenerTexto(

                        element,

                        "titulo"

                )

        );

        dto.setSubtitulo(

                XmlUtils.obtenerTexto(

                        element,

                        "subtitulo"

                )

        );

        dto.setNumeroEdicion(

                XmlUtils.obtenerByte(

                        element,

                        "numeroEdicion"

                )

        );

        dto.setFechaPublicacion(

                XmlUtils.obtenerLocalDate(

                        element,

                        "fechaPublicacion"

                )

        );

        dto.setNumeroPaginas(

                XmlUtils.obtenerShort(

                        element,

                        "numeroPaginas"

                )

        );

        dto.setClasificacion(

                XmlUtils.obtenerTexto(

                        element,

                        "clasificacion"

                )

        );

        dto.setSinopsis(

                XmlUtils.obtenerTexto(

                        element,

                        "sinopsis"

                )

        );

        dto.setImagenPortada(

                XmlUtils.obtenerTexto(

                        element,

                        "imagenPortada"

                )

        );

        dto.setIdCategoria(

                XmlUtils.obtenerInteger(

                        element,

                        "idCategoria"

                )

        );

        dto.setIdEditorial(

                XmlUtils.obtenerInteger(

                        element,

                        "idEditorial"

                )

        );

        dto.setIdIdioma(

                XmlUtils.obtenerInteger(

                        element,

                        "idIdioma"

                )

        );

        dto.setActivo(

                XmlUtils.obtenerBoolean(

                        element,

                        "activo"

                )

        );

        return dto;

    }

}