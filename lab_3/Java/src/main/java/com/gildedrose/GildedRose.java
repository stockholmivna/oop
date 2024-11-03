package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]); //i call the new method to exchange the nested logic
            updateSellIn(items[i]); //new method to update sellIn
            handleExpiredItems(items[i]); //analogous to the previous method
        }
    }

    private void increaseQuality(Item item) { 
        if (item.quality < 50) { //if quality is less than 50, we increase it by 1
            item.quality += 1;
        }
    }

    //New method selIn to avoid nested logic
    private void updateSellIn(Item item) { //we use the same logic as before, selIn decrease by 1 for every item except Sulfuras
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { 
        item.sellIn -= 1;
    }
}

    private void handleExpiredItems(Item item) { //new method to handle expired items
        if (item.sellIn >= 0) return; //if sellIn is greater than 0, we return

        if (item.name.equals("Aged Brie")) { //condition for Aged Brie
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);
        } else {
                    decreaseQuality(item); //i will add a new method soon
                }
            }

        private void decreaseQuality(Item item) {
            if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality -= 1;
            }
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

