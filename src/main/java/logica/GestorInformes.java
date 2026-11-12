package logica;

import model.Cliente;
import model.Coche;
import model.Vehiculo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import static app.Main.clientes;
import static app.Main.vehiculos;

public class GestorInformes {
    public static void generarInformeXML() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();


            Element root = doc.createElement("javadrive");
            doc.appendChild(root);


            Element empresa = doc.createElement("empresa");

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("JavaDrive S.L."));
            empresa.appendChild(nombre);

            Element ubicacion = doc.createElement("ubicacion");
            ubicacion.appendChild(doc.createTextNode("Sede Central - Madrid"));
            empresa.appendChild(ubicacion);

            root.appendChild(empresa);

            Element vehiculosXML = doc.createElement("Vehiculos");

            for (Vehiculo v : vehiculos) {
                Element vehiculo = doc.createElement("vehiculo");

                String tipo = (v instanceof Coche) ? "Coche" : "Furgoneta";
                vehiculo.setAttribute("tipo", tipo);

                Element matricula = doc.createElement("matricula");
                matricula.appendChild(doc.createTextNode(v.getMatricula()));

                Element marca = doc.createElement("marca");
                marca.appendChild(doc.createTextNode(v.getMarca()));

                Element modelo = doc.createElement("modelo");
                modelo.appendChild(doc.createTextNode(v.getModelo()));

                Element disponible = doc.createElement("disponible");
                disponible.setTextContent(String.valueOf(v.isDisponible()));
                vehiculo.appendChild(disponible);

                Element especifico = doc.createElement("especifico");
                especifico.appendChild(doc.createTextNode(v.obtenerDetalles()));

                vehiculo.appendChild(matricula);
                vehiculo.appendChild(marca);
                vehiculo.appendChild(modelo);
                vehiculo.appendChild(especifico);

                vehiculosXML.appendChild(vehiculo);
            }

            root.appendChild(vehiculosXML);


            Element clientesXML = doc.createElement("clientes");

            for (Cliente c : clientes) {
                Element cliente = doc.createElement("cliente");

                Element dni = doc.createElement("dni");
                dni.appendChild(doc.createTextNode(c.getDni()));

                Element nombreC = doc.createElement("nombre");
                nombreC.appendChild(doc.createTextNode(c.getNombre()));

                Element telefono = doc.createElement("telefono");
                telefono.appendChild(doc.createTextNode(c.getTelefono()));

                cliente.appendChild(dni);
                cliente.appendChild(nombreC);
                cliente.appendChild(telefono);

                clientesXML.appendChild(cliente);
            }

            root.appendChild(clientesXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();


            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("reporte_completo.xml"));

            transformer.transform(source, result);

            System.out.println("[OK] XML generado con DOM");

        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
