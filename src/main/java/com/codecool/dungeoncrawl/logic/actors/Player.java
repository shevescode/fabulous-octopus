package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Sword;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    private List<Item> inventory;
    private int attack = 5;

    public Player(Cell cell) {
        super(cell);
        setHealth(20);
        inventory = new ArrayList<>();
    }

    public String getTileName() {
        return "player";
    }

    public void pickUpItem(Item item) {
        if(item instanceof Sword) {
            attack += ((Sword) item).getDamage();
        }
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void attackMonster(Actor actor) {
        actor.subtractHealthPoints(attack);
        this.subtractHealthPoints(actor.getAttack());
    }
}
