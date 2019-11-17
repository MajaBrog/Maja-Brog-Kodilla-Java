package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredientsList;


    public static class BigmacBuilder {
        private Bun bun = null;
        private int burgers = 0;
        private Sauce sauce = null;
        private List<Ingredients> ingredientsList = new ArrayList<>();

        public BigmacBuilder bun(Bun chosenBun) {
            this.bun = chosenBun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce chosenSauce) {
            this.sauce = chosenSauce;
            return this;
        }

        public BigmacBuilder ingredients(Ingredients chosenIngredient) {
            ingredientsList.add(chosenIngredient);
            return this;
        }


        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredientsList);
        }
    }

    public Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingredientsList) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredientsList = ingredientsList;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredientsList=" + ingredientsList +
                '}';
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredientsList;
    }
}
