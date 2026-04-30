package com.bot.commands.moderation;

import com.bot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class KickCommand extends Command {
    public KickCommand() {
        super("kick", "Kick a user from the server", "!kick <@user> [reason]", new String[] {"k"});
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        if (args.length < 1) {
            event.getChannel().sendMessage("Usage: " + getUsage()).queue();
            return;
        }
        String reason = args.length > 1 ? String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length)) : "No reason provided";
        event.getGuild().kick(event.getMessage().getMentionedMembers().get(0), reason).queue();
        event.getChannel().sendMessage("User kicked!").queue();
    }
}