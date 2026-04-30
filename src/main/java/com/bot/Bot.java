import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.JDA;
import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {

    private static final String TOKEN = "YOUR_BOT_TOKEN"; // Replace with your actual bot token

    public static void main(String[] args) {
        try {
            JDA jda = JDABuilder.createDefault(TOKEN).build();
            jda.addEventListener(new Bot());
            jda.awaitReady(); // Blocking guarantees that JDA will be fully loaded
            System.out.println("Bot is ready!");
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Failed to create JDA instance.");
        }
    }
}