package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINBATTLEREQUEST userName ip
 TODO: When the client receives this command, he must send either a JOINBATTLEACCEPT or a JOINBATTLEDENY command to the server.
 */
public class JoinBattleRequest implements Command {
    private String line;
    private ServerState serverState;

    public JoinBattleRequest (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        String ip = parser.getString();
    }
}
