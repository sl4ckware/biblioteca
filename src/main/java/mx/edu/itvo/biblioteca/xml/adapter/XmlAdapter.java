package mx.edu.itvo.biblioteca.xml.adapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Define el contrato para convertir un objeto
 * de dominio en un elemento XML.
 *
 * Cada implementación será responsable de
 * generar la representación XML de una entidad.
 *
 * @param <T> Tipo de objeto a convertir.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface XmlAdapter<T> {

    /**
     * Convierte un objeto en un elemento XML.
     *
     * @param document Documento XML al que
     *                 pertenecerá el elemento.
     * @param dto Objeto a convertir.
     * @return Elemento XML generado.
     */
    Element convertir(
            Document document,
            T dto);

}