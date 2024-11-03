package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]); //i call the new method to exchange the nested logic
        }
    }

//i add new method to avoid nested logic
    private void updateItemQuality(Item item) {
        if (!item.name.equals("Aged Brie") 
        && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality -= 1;
            }
        } else {
            if (item.quality < 50) { 
                item.quality += 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { 
                    if (item.sellIn < 11 && item.quality < 50) { 
                        item.quality += 1;
                    }
                    if (item.sellIn < 6 && item.quality < 50) {
                        item.quality += 1;
                    }
                }
            }
        }
    }
}

