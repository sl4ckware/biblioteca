package mx.edu.itvo.biblioteca.xml.adapter;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Convierte una categoría
 * en un elemento XML.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class CategoriaXmlAdapter
        implements XmlAdapter<CategoriaResponseDTO> {

    @Override
    public Element convertir(
            Document document,
            CategoriaResponseDTO categoria) {

        Element elemento =
                document.createElement(
                        "categoria");

        XmlUtils.agregarElemento(
                document,
                elemento,
                "idCategoria",
                categoria.getIdCategoria());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "codigo",
                categoria.getCodigo());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "nombre",
                categoria.getNombre());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "descripcion",
                categoria.getDescripcion());

        XmlUtils.agregarElemento(
                document,
                elemento,
                "activo",
                categoria.getActivo());

        return elemento;

    }

}