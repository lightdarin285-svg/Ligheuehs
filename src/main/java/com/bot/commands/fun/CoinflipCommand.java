package com.bot.commands.fun;

import com.bot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CoinflipCommand extends Command {
    public CoinflipCommand() {
        super("coinflip", "Flip a coin", "!coinflip", new String[]{"cf", "flip"});
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        String result = Math.random() > 0.5 ? "Heads" : "Tails";
        event.getChannel().sendMessage("Result: " + result).queue();
    }
}