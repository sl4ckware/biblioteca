package mx.edu.itvo.biblioteca.xml.parser;

import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Parser encargado de convertir un
 * elemento XML en un CategoriaRequestDTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class CategoriaXmlParser
        implements XmlParser<CategoriaRequestDTO> {

    /**
     * {@inheritDoc}
     */
    @Override
    public CategoriaRequestDTO convertir(
            Element element) {

        CategoriaRequestDTO dto =
                new CategoriaRequestDTO();

        dto.setCodigo(

                XmlUtils.obtenerTexto(
                        element,
                        "codigo")

        );

        dto.setNombre(

                XmlUtils.obtenerTexto(
                        element,
                        "nombre")

        );

        dto.setDescripcion(

                XmlUtils.obtenerTexto(
                        element,
                        "descripcion")

        );

        return dto;

    }

}