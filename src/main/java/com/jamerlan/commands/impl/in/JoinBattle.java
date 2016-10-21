package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINBATTLE battleID hashCode
 TODO: String hashCode don't use
 */
public class JoinBattle implements Command {
    private String line;
    private ServerState serverState;

    public JoinBattle (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt(" ");
        String hashCode = parser.getString();

        serverState.getAccount().setBattleID(battleID);
    }
}
