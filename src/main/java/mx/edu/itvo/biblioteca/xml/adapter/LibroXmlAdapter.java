package mx.edu.itvo.biblioteca.xml.adapter;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;

/**
 * Convierte un LibroResponseDTO
 * en un elemento XML.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class LibroXmlAdapter
        implements XmlAdapter<LibroResponseDTO> {

    /**
     * Convierte un libro
     * en un nodo XML.
     *
     * @param document Documento XML.
     * @param libro Libro.
     * @return Elemento XML.
     */
    @Override
    public Element convertir(
            Document document,
            LibroResponseDTO libro) {

        Element libroElement =
                document.createElement("libro");

        agregarElemento(
                document,
                libroElement,
                "idLibro",
                libro.getIdLibro());

        agregarElemento(
                document,
                libroElement,
                "isbn13",
                libro.getIsbn13());

        agregarElemento(
                document,
                libroElement,
                "titulo",
                libro.getTitulo());

        agregarElemento(
                document,
                libroElement,
                "subtitulo",
                libro.getSubtitulo());

        agregarElemento(
                document,
                libroElement,
                "numeroEdicion",
                libro.getNumeroEdicion());

        agregarElemento(
                document,
                libroElement,
                "fechaPublicacion",
                libro.getFechaPublicacion());

        agregarElemento(
                document,
                libroElement,
                "numeroPaginas",
                libro.getNumeroPaginas());

        agregarElemento(
                document,
                libroElement,
                "clasificacion",
                libro.getClasificacion());

        agregarElemento(
                document,
                libroElement,
                "sinopsis",
                libro.getSinopsis());

        agregarElemento(
                document,
                libroElement,
                "imagenPortada",
                libro.getImagenPortada());

        agregarElemento(
                document,
                libroElement,
                "categoria",
                libro.getCategoria());

        agregarElemento(
                document,
                libroElement,
                "editorial",
                libro.getEditorial());

        agregarElemento(
                document,
                libroElement,
                "idioma",
                libro.getIdioma());

        agregarElemento(
                document,
                libroElement,
                "activo",
                libro.getActivo());

        return libroElement;

    }

    /**
     * Agrega un nodo hijo al elemento XML.
     *
     * @param document Documento XML.
     * @param padre Elemento padre.
     * @param nombre Nombre del nodo.
     * @param valor Valor del nodo.
     */
    private void agregarElemento(
            Document document,
            Element padre,
            String nombre,
            Object valor) {

        Element elemento =
                document.createElement(nombre);

        elemento.setTextContent(

                valor == null
                        ? ""
                        : valor.toString()

        );

        padre.appendChild(elemento);

    }

}