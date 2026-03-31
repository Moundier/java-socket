import java.util.Arrays;
import java.util.List;

public class HtmlBuilder {

    public HtmlBuilder() { }

    public static String tag(String tag, String... children) {
        StringBuilder content = new StringBuilder();
        List<String> elements = Arrays.asList(children);
        elements.forEach(e -> { content.append(e); });
        return String.format("<%s>%s</%s>", tag, content.toString(), tag);
    }

    public static String Div(String... children) {
        return tag("div", children);
    }

    public static String Span(String... children) {
        return tag("span", children);
    }

    public static String Paragraph(String... children) {
        return tag("p", children);
    }

    public static String H1(String... children) {
        return tag("h1", children);
    }

    public static String H2(String... children) {
        return tag("h2", children);
    }

    public static String H3(String... children) {
        return tag("h3", children);
    }

    // NOTE: Table related element tags

    public static String Table(String... children) {
        return tag("table", children);
    }

    public static String Tr(String... children) {
        return tag("tr", children);
    }

    public static String Th(String... children) {
        return tag("th", children);
    }

    public static String Td(String... children) {
        return tag("td", children);
    }

    public static String Thead(String... children) {
        return tag("thead", children);
    }

    public static String Tbody(String... children) {
        return tag("tbody", children);
    }

    public String getExample() {

        return Div(

            H1("Welcome to My Page"), 

            Div(
                Span("This page contains a table of products"),
                Paragraph("Here's the product list:")
            ),

            Table(
                
                Thead(
                    Tr(
                        Th("Product Name"),
                        Th("Category"),
                        Th("Price"),
                        Th("Stock")
                    )
                ),

                Tbody(
                    Tr(
                        Td("Laptop"),
                        Td("Electronics"),
                        Td("$999.99"),
                        Td("25")
                    ),
                    Tr(
                        Td("Desk Chair"),
                        Td("Furniture"),
                        Td("$149.99"),
                        Td("50")
                    ),
                    Tr(
                        Td("Coffee Maker"),
                        Td("Appliances"),
                        Td("$79.99"),
                        Td("100")
                    ),
                    Tr(
                        Td("Headphones"),
                        Td("Electronics"),
                        Td("$199.99"),
                        Td("75")
                    )
                )
            ),

            Paragraph("Final message")

        );
    }
}