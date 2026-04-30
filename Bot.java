import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.JDA;
import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    private static final String TOKEN = System.getenv("DISCORD_TOKEN");

    public static void main(String[] args) {
        if (TOKEN == null || TOKEN.isEmpty()) {
            System.err.println("ERROR: DISCORD_TOKEN environment variable not set!");
            System.err.println("Please set DISCORD_TOKEN in your .env file or system environment");
            System.exit(1);
        }
        try {
            JDA jda = JDABuilder.createDefault(TOKEN).build();
            jda.addEventListener(new Bot());
            jda.awaitReady();
            System.out.println("Bot is online and ready!");
        } catch (LoginException e) {
            System.err.println("ERROR: Invalid Discord token provided!");
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            System.err.println("Bot startup was interrupted");
            e.printStackTrace();
            System.exit(1);
        }
    }
}