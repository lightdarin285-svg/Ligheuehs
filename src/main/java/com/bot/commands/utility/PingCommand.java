package com.bot.commands.utility;

import com.bot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand extends Command {
    public PingCommand() {
        super("ping", "Check bot latency", "!ping", new String[]{"p", "latency"});
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        long latency = event.getJDA().getGatewayPing();
        event.getChannel().sendMessage("Pong! Latency: " + latency + "ms").queue();
    }
}