package mx.edu.itvo.biblioteca.xml.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.springframework.web.multipart.MultipartFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

/**
 * Utilidades para la creación,
 * lectura y manipulación
 * de documentos XML.
 *
 * Centraliza todas las operaciones
 * comunes utilizadas por el
 * Framework XML.
 *
 * @author Conce
 * @version 4.0
 * @since 2.0
 */
public final class XmlUtils {

    /**
     * Constructor privado.
     */
    private XmlUtils() {
    }

    /**
     * Crea un documento XML vacío.
     *
     * @return Documento XML.
     */
    public static Document crearDocumento() {

        try {

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            return builder.newDocument();

        } catch (ParserConfigurationException ex) {

            throw new IllegalStateException(

                    "No fue posible crear "
                    + "el documento XML.",

                    ex

            );

        }

    }

    /**
     * Crea un documento XML
     * con su nodo raíz.
     *
     * @param nodoRaiz Nodo raíz.
     * @return Documento XML.
     */
    public static Document crearDocumento(
            String nodoRaiz) {

        Document document =
                crearDocumento();

        Element raiz =
                document.createElement(
                        nodoRaiz);

        document.appendChild(
                raiz);

        return document;

    }

    /**
     * Crea un Transformer
     * configurado para generar
     * XML legible.
     *
     * @return Transformer.
     */
    public static Transformer
            crearTransformer() {

        try {

            Transformer transformer =
                    TransformerFactory
                            .newInstance()
                            .newTransformer();

            transformer.setOutputProperty(

                    OutputKeys.INDENT,

                    "yes"

            );

            transformer.setOutputProperty(

                    OutputKeys.ENCODING,

                    "UTF-8"

            );

            transformer.setOutputProperty(

                    "{http://xml.apache.org/xslt}"
                    + "indent-amount",

                    "4"

            );

            return transformer;

        } catch (Exception ex) {

            throw new IllegalStateException(

                    "No fue posible crear "
                    + "el Transformer.",

                    ex

            );

        }

    }
            
    /**
     * Convierte un documento XML
     * a ByteArrayInputStream.
     *
     * @param document Documento XML.
     * @return Archivo XML.
     */
    public static ByteArrayInputStream
            documentoAByteArray(
                    Document document) {

        try {

            ByteArrayOutputStream output =
                    new ByteArrayOutputStream();

            Transformer transformer =
                    crearTransformer();

            transformer.transform(

                    new javax.xml.transform.dom.DOMSource(
                            document),

                    new javax.xml.transform.stream.StreamResult(
                            output)

            );

            return new ByteArrayInputStream(

                    output.toByteArray()

            );

        } catch (Exception ex) {

            throw new IllegalStateException(

                    "No fue posible generar "
                    + "el archivo XML.",

                    ex

            );

        }

    }

    /**
     * Agrega un elemento hijo
     * al nodo padre.
     *
     * @param document Documento XML.
     * @param padre Nodo padre.
     * @param nombre Nombre del nodo.
     * @param valor Valor del nodo.
     */
    public static void agregarElemento(

            Document document,

            Element padre,

            String nombre,

            Object valor) {

        Element elemento =
                document.createElement(
                        nombre);

        elemento.setTextContent(

                valor == null
                        ? ""
                        : valor.toString()

        );

        padre.appendChild(
                elemento);

    }
        /**
     * Lee un archivo XML y lo convierte
     * en un documento DOM.
     *
     * @param archivo Archivo XML.
     * @return Documento XML.
     */
    public static Document leerDocumento(
            MultipartFile archivo) {

        try (InputStream input =
                archivo.getInputStream()) {

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory
                            .newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document document =
                    builder.parse(input);

            document.getDocumentElement()
                    .normalize();

            return document;

        } catch (ParserConfigurationException
                | SAXException
                | IOException ex) {

            throw new IllegalStateException(

                    "No fue posible leer "
                    + "el archivo XML.",

                    ex

            );

        }

    }

    /**
     * Obtiene todos los nodos con
     * el nombre indicado.
     *
     * @param document Documento XML.
     * @param nombreNodo Nombre del nodo.
     * @return Lista de nodos.
     */
    public static NodeList obtenerNodos(
            Document document,
            String nombreNodo) {

        return document.getElementsByTagName(
                nombreNodo);

    }

    /**
     * Obtiene el contenido de un nodo.
     *
     * @param element Elemento padre.
     * @param nombre Nombre del nodo.
     * @return Texto del nodo o cadena vacía.
     */
    public static String obtenerTexto(
            Element element,
            String nombre) {

        NodeList lista =
                element.getElementsByTagName(
                        nombre);

        if (lista.getLength() == 0) {

            return "";

        }

        if (lista.item(0) == null) {

            return "";

        }

        String valor =
                lista.item(0)
                        .getTextContent();

        return valor == null
                ? ""
                : valor.trim();

    }
        /**
     * Obtiene un Integer.
     *
     * @param element Elemento.
     * @param nombre Nombre del nodo.
     * @return Valor Integer o null.
     */
    public static Integer obtenerInteger(
            Element element,
            String nombre) {

        String valor =
                obtenerTexto(
                        element,
                        nombre);

        if (valor.isBlank()) {

            return null;

        }

        return Integer.valueOf(
                valor);

    }

    /**
     * Obtiene un Byte.
     *
     * @param element Elemento.
     * @param nombre Nombre del nodo.
     * @return Valor Byte o null.
     */
    public static Byte obtenerByte(
            Element element,
            String nombre) {

        String valor =
                obtenerTexto(
                        element,
                        nombre);

        if (valor.isBlank()) {

            return null;

        }

        return Byte.valueOf(
                valor);

    }

    /**
     * Obtiene un Short.
     *
     * @param element Elemento.
     * @param nombre Nombre del nodo.
     * @return Valor Short o null.
     */
    public static Short obtenerShort(
            Element element,
            String nombre) {

        String valor =
                obtenerTexto(
                        element,
                        nombre);

        if (valor.isBlank()) {

            return null;

        }

        return Short.valueOf(
                valor);

    }

    /**
     * Obtiene un Boolean.
     *
     * @param element Elemento.
     * @param nombre Nombre del nodo.
     * @return Valor Boolean o null.
     */
    public static Boolean obtenerBoolean(
            Element element,
            String nombre) {

        String valor =
                obtenerTexto(
                        element,
                        nombre);

        if (valor.isBlank()) {

            return null;

        }

        return Boolean.valueOf(
                valor);

    }

    /**
     * Obtiene una fecha.
     *
     * @param element Elemento.
     * @param nombre Nombre del nodo.
     * @return Fecha o null.
     */
    public static LocalDate obtenerLocalDate(
            Element element,
            String nombre) {

        String valor =
                obtenerTexto(
                        element,
                        nombre);

        if (valor.isBlank()) {

            return null;

        }

        return LocalDate.parse(
                valor);

    }

}