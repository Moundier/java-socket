import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {

        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Servidor rodando na porta " + port);

            while (true) {
                try (Socket client = server.accept();
                     InputStream in = client.getInputStream();
                     OutputStream out = client.getOutputStream()) {

                    String line;
                    InputStreamReader inputStreamReader = new InputStreamReader(in);
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    System.out.println("LOG --- Requisição Recebida ---");
                    while (!(line = reader.readLine()).isEmpty()) {
                        System.out.println(line); 
                    }

                    String body;

                    HtmlBuilder htmlBuilder = new HtmlBuilder();
                    body = htmlBuilder.getExample();

                    byte[] bodyBytes = body.getBytes(StandardCharsets.UTF_8);

                    String headers = "HTTP/1.1 200 OK\r\n" +
                                     "Content-Type: text/html; charset=UTF-8\r\n" +
                                     "Content-Length: " + bodyBytes.length + "\r\n" +
                                     "Connection: close\r\n" + 
                                     "\r\n"; 

                    out.write(headers.getBytes(StandardCharsets.UTF_8));
                    out.write(bodyBytes);
                    out.flush(); 
                }  catch (Exception e) {
                    System.err.println("Erro no client accept: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao criar o servidor: " + e.getMessage());
        }
    }
}
