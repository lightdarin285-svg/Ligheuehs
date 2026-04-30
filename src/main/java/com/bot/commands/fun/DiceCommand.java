package com.bot.commands.fun;

import com.bot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DiceCommand extends Command {
    public DiceCommand() {
        super("dice", "Roll a dice", "!dice [sides]", new String[]{"roll", "d"});
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        int sides = args.length > 0 ? Integer.parseInt(args[0]) : 6;
        int result = (int) (Math.random() * sides) + 1;
        event.getChannel().sendMessage("You rolled a " + result + " on a " + sides + "-sided dice!").queue();
    }
}