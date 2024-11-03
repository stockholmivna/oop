package com.gildedrose;

public class Item {

    public String name;
    
    public int sellIn;
    
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void increaseQuality() {
        if (quality < 50) {
            quality++;
        }
    }

    public void decreaseQuality() {
        if (quality > 0 && !isSulfuras()) {
            quality--;
        }
    }

    public void decreaseSellIn() {
        if (!isSulfuras()) {
            sellIn--;
        }
    }

    public boolean isExpired() {
        return sellIn < 0;
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    public boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
