package mx.edu.itvo.biblioteca.xml.adapter;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Convierte una editorial
 * en un elemento XML.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class EditorialXmlAdapter
        implements XmlAdapter<EditorialResponseDTO> {

    @Override
    public Element convertir(
            Document document,
            EditorialResponseDTO editorial) {

        Element elemento =
                document.createElement(
                        "editorial");

        XmlUtils.agregarElemento(
                document,
                elemento,
                "idEditorial",
                editorial.getIdEditorial());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "nombre",
                editorial.getNombre());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "pais",
                editorial.getPais());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "ciudad",
                editorial.getCiudad());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "telefono",
                editorial.getTelefono());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "correo",
                editorial.getCorreo());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "sitioWeb",
                editorial.getSitioWeb());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "activo",
                editorial.getActivo());

        return elemento;

    }

}