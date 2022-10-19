import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scrapper {

    public static Document getDocument(String url) {
        Connection conn = Jsoup.connect(url);
        Document document = null;
        try {
            document = conn.get();
        } catch (IOException e) {
            e.printStackTrace();
            // handle error
        }
        return document;
    }

    public static void main(String[] args) {
        Document doc = getDocument("https://en.wikipedia.org/wiki/Jsoup");

        Element firstHeading = doc.getElementsByClass("firstHeading").first();
        System.out.println(firstHeading.text());

    }
}
