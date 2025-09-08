import java.util.Properties;
import javax.mail.*;

public class lab32 {
    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String username = "shreyapathak.9818@gmail.com";  
        String password = "kugd tfrp enmm nplg";  

        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            System.out.println("Total messages: " + messages.length);

            for (int i = 0; i < Math.min(5, messages.length); i++) {
                System.out.println("--------------------------------");
                System.out.println("Subject: " + messages[i].getSubject());
                System.out.println("From: " + messages[i].getFrom()[0]);
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
