import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLDataStore implements DataStore {

    private static XMLDataStore instance;

    public static XMLDataStore getInstance() {
        if (instance == null) {
            instance = new XMLDataStore();
        }
        return instance;
    }

    @Override
    public List<Employee> readFile(String pathName, ArrayList<Employee> empList) {

        Document document;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            document = builder.parse(pathName);

            // For read file with file .dtd

//            builder.setEntityResolver(new EntityResolver() {
//                @Override
//                public InputSource resolveEntity(String publicId, String systemId)
//                        throws SAXException, IOException {
//                    if (systemId.contains("employee.dtd")) {
//                        return new InputSource(new FileReader("/Users/viktoriyasidenko/Documents/Projects/Hillel elementary/elemenaty_19/sidenko_vika/MappingXmlToCSV/employee.dtd"));
//                    } else {
//                        return null;
//                    }
//                }
//            });

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String name = null;
                    name = getTextValue(name, element, "Name");

                    String role = null;
                    role = getTextValue(role, element, "Role");

                    String salary = null;
                    salary = getTextValue(salary, element, "Salary");

                    empList.add(new Employees(name, role, salary));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return empList;
    }

    private String getTextValue(String def, Element element, String tag) {
        String value = def;
        NodeList nm = element.getElementsByTagName(tag);
        if (nm.getLength() > 0) {
            Node n = nm.item(0);
            NodeList child = n.getChildNodes();
            if (child == null) {
                value = null;
            } else {
                Node nn = child.item(0);
                if (nn == null){
                    value = "";
                } else {
                    value = nn.getTextContent();
                }
            }
        }
        return value;
    }

    @Override
    public void writeFile(String pathName, ArrayList<Employee> empList) {

        Document dom;
        Element e = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

            Element rootEle = dom.createElement("Employees");
            dom.appendChild(rootEle);


            for (Employee emp : empList) {

                Element Employee = dom.createElement("Employee");
                rootEle.appendChild(Employee);

                Element name = dom.createElement("Name");
                name.appendChild(dom.createTextNode(String.valueOf(emp.getName())));
                Employee.appendChild(name);

                Element role = dom.createElement("Role");
                role.appendChild(dom.createTextNode(String.valueOf(emp.getRole())));
                Employee.appendChild(role);

                Element salary = dom.createElement("Salary");
                salary.appendChild(dom.createTextNode(String.valueOf(emp.getSalary())));
                Employee.appendChild(salary);

            }

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//                tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "employee.dtd");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream(pathName)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
}
