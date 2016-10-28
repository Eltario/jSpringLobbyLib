package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.Bot;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchBattle;

import java.io.IOException;
import java.io.PrintWriter;

/**
 ADDBOT battleID name owner battleStatus teamColor {ai dll}
 */
public class AddBot implements Command {
    private String line;
    private ServerState serverState;

    public AddBot(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt(" ");
        String name = parser.getString(" ");
        String owner = parser.getString(" ");
        String battleStatus = parser.getString(" ");
        String teamColor = parser.getString();

        Bot bot = new Bot(name, owner, " ");
        bot.setBattleStatus(battleStatus);
        bot.setTeamColor(teamColor);
        serverState.getUsersOnline().add(bot);
        SearchBattle searchBattle = new SearchBattle();
        Battle battle = searchBattle.byBattleId(serverState, battleID);
        battle.getUsers().add(bot);
    }
}
