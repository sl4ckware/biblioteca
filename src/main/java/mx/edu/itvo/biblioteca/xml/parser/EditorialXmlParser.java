package mx.edu.itvo.biblioteca.xml.parser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Parser encargado de convertir un
 * elemento XML en un EditorialRequestDTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class EditorialXmlParser
        implements XmlParser<EditorialRequestDTO> {

    /**
     * {@inheritDoc}
     */
    @Override
    public EditorialRequestDTO convertir(
            Element element) {

        EditorialRequestDTO dto =
                new EditorialRequestDTO();

        dto.setNombre(

                XmlUtils.obtenerTexto(
                        element,
                        "nombre")

        );

        dto.setPais(

                XmlUtils.obtenerTexto(
                        element,
                        "pais")

        );

        dto.setCiudad(

                XmlUtils.obtenerTexto(
                        element,
                        "ciudad")

        );

        dto.setTelefono(

                XmlUtils.obtenerTexto(
                        element,
                        "telefono")

        );

        dto.setCorreo(

                XmlUtils.obtenerTexto(
                        element,
                        "correo")

        );

        dto.setSitioWeb(

                XmlUtils.obtenerTexto(
                        element,
                        "sitioWeb")

        );

        return dto;

    }

}