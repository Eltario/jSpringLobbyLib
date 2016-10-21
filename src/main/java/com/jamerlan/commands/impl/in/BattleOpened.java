package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchBattle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * BATTLEOPENED battleID type natType founder ip port maxPlayers passworded rank mapHash {engineName} {engineVersion} {map} {title} {gameName}
 *
 * BATTLEOPENED 20535 0 0 EvoRTSDedicated4 54.183.228.213 8254 8 0 0 540337253 Archers Battlefield - v05	Evolution RTS Dedicated Host 4	Evolution RTS - v10.17
 */
public class BattleOpened implements Command {
    private String line;
    private ServerState serverState;

    public BattleOpened(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleId = parser.getInt(" ");
        int type = parser.getInt(" ");
        int natType = parser.getInt(" ");
        String founder = parser.getString(" ");
        String ip = parser.getString(" ");
        int port = parser.getInt(" ");
        int maxPlayers = parser.getInt(" ");
        int passworded = parser.getInt(" ");
        int rank = parser.getInt(" ");
        int mapHash = parser.getInt(" ");
        String mapName = parser.getString("\t");
        String title = parser.getString("\t");
        String gameName = parser.getString();

        SearchBattle searchBattle = new SearchBattle();
        Battle battle = searchBattle.byBattleId(serverState, battleId);
        System.out.println(battleId + " " + type);
        battle.setType(type);
        battle.setNatType(natType);
        battle.setFouder(founder);
        battle.setIp(ip);
        battle.setPort(port);
        battle.setMaxPlayers(maxPlayers);
        battle.setPassworded(passworded);
        battle.setRank(rank);
        battle.setMapHash(mapHash);
        battle.setMapName(mapName);
        battle.setTitle(title);
        battle.setGameName(gameName);

        battle.setUsers(new HashSet<User>());
    }
}
