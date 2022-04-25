package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();


    public List<Player> findAll() {
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void registerAll(List<Player> players) {
        this.players.addAll(players);
    }



    public void register(Player player) {
        this.players.add(player);
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
