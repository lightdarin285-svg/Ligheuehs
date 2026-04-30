package com.bot.commands.moderation;
import com.bot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.entities.Member;

public class BanCommand extends Command {
    public BanCommand() {
        super("ban", "Ban a user from the server", "!ban <@user> [reason]", new String[]{"b"});
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        if (args.length < 1) {
            event.getChannel().sendMessage("Usage: " + getUsage()).queue();
            return;
        }
        if (!event.getMember().canInteract(event.getMessage().getMentionedMembers().get(0))) {
            event.getChannel().sendMessage("You cannot ban this user!").queue();
            return;
        }
        String reason = args.length > 1 ? String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length)) : "No reason provided";
        event.getGuild().ban(event.getMessage().getMentionedMembers().get(0), 0, reason).queue();
        event.getChannel().sendMessage("User banned!").queue();
    }
}