package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchChannel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 NOCHANNELTOPIC chanName
 */
public class NoChannelTopic implements Command {
    private String line;
    private ServerState serverState;

    public NoChannelTopic(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString();
        SearchChannel searchChannel = new SearchChannel();
        com.jamerlan.model.Channel channel = searchChannel.byChanName(serverState, chanName);
        channel.setTopicAuthor("");
        channel.setTopicChangedTime("");
        channel.setTopic("");
    }
}
