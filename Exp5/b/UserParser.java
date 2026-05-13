import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class UserParser {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter User ID: ");
            String uid = sc.nextLine();

            File file = new File("users.xml");

            DocumentBuilderFactory f =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder b = f.newDocumentBuilder();

            Document doc = b.parse(file);

            NodeList list = doc.getElementsByTagName("user");

            for (int i = 0; i < list.getLength(); i++) {

                Element e = (Element) list.item(i);

                String id =
                        e.getElementsByTagName("id")
                         .item(0)
                         .getTextContent();

                if (id.equals(uid)) {

                    System.out.println("Name : " +
                            e.getElementsByTagName("name")
                             .item(0)
                             .getTextContent());

                    System.out.println("City : " +
                            e.getElementsByTagName("city")
                             .item(0)
                             .getTextContent());
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}