import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Acciones> accion = null;

	public Parser() {

		accion = new ArrayList<Acciones>();

	}

	public void parseFicheroXml(String fichero) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fichero);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {

		Element docEle = dom.getDocumentElement();

		NodeList nl = docEle.getElementsByTagName("accion");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element el = (Element) nl.item(i);

				Acciones ac = getAccion(el);

				accion.add(ac);
			}
		}
	}

	private Acciones getAccion(Element accionEle) {

		String nombre = getTextAtribute(accionEle, "accion");
		ArrayList<Operaciones> operacion = getOperacion(accionEle);

		Acciones acc = new Acciones(nombre, operacion);

		return acc;
	}

	private String getTextAtribute(Element ele, String tagName) {

		String nm = null;

		NodeList n1 = ele.getElementsByTagName(tagName);

		if (n1 != null && n1.getLength() > 0) {

			Element el = (Element) n1.item(0);

			nm = el.getAttribute("nombre");
		}

		return nm;
	}

	private ArrayList<Operaciones> getOperacion(Element libro) {
		ArrayList<Operaciones> Operacion = new ArrayList<Operaciones>();

		NodeList nl = libro.getElementsByTagName("operaciones");

		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			NodeList nl1 = libro.getElementsByTagName("operacion");
			if (nl1 != null && nl1.getLength() > 0) {

				for (int i = 0; i < nl1.getLength(); i++) {

					Element el1 = (Element) nl1.item(i);

					String tipo = getTextValue(el1, "tipo");
					int cantidad = getIntValue(el1, "cantidad");
					double precio = getDoubleValue(el1, "precio");

					Operaciones auxiliar = new Operaciones(tipo, cantidad, precio);
					Operacion.add(auxiliar);
				}

			}

		}

		return Operacion;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

	private int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele, tagName));
	}

	private double getDoubleValue(Element ele, String tagName) {

		return Double.parseDouble(getTextValue(ele, tagName));
	}

	public void print() {

		Iterator it = accion.iterator();
		System.out.println("Longitud: " + accion.size() + "\n");
		while (it.hasNext()) {
			Acciones ac = (Acciones) it.next();
			System.out.println(ac.print());
		}
	}

}
