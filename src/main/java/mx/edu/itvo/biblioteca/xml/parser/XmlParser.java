package mx.edu.itvo.biblioteca.xml.parser;

import org.w3c.dom.Element;

/**
 * Contrato para convertir un
 * elemento XML en un DTO.
 *
 * @param <T> Tipo del DTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface XmlParser<T> {

    /**
     * Convierte un elemento XML
     * en un DTO.
     *
     * @param element Elemento XML.
     * @return DTO generado.
     */
    T convertir(
            Element element);

}