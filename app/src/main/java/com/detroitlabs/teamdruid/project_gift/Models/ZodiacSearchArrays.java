package com.detroitlabs.teamdruid.project_gift.models;

import java.util.Random;

/**
 * Created by elyseturner on 11/4/14.
 */
public class ZodiacSearchArrays {


    //private list of animals, create an animal model, in constructor ... new animal name = ...
    Random rand = new Random();
    private String keyWord;

    String[] Rat = {"stationery", "soap", "lip balm", "macaroon", "friendship", "mug", "laptop bag", "infinity scarf", "pet tag", "antique jewelry"};

    String[] Ox = {"journal", "farm", "hand quilted", "embroidery", "jigsaw puzzle", "candle", "plants", "tea", "beer kit", "canned goods"};

    String[] Tiger = {"picture frame", "politics", "notebook", "pen", "book", "organization", "mirror", "leather bag", "iPhone cover", "liquor"};

    String[] Rabbit = {"feelings", "color", "decorative", "pretty", "locket", "pocket watch", "landscape", "paris", "diary", "gold"};

    String[] Dragon = {"computers","inventor","leader","roller skates","bike helmet","diary","stickers","hat","glitter pen","jewelry box"};

    String[] Snake = {"inspirational quotes","story book","stress ball","headphones","orchid","cactus","pottery","paint","dreamcatcher","video games"};

    String[] Horse = {"panda", "woodworking", "basketball", "shiny tank top", "butterfly clips", "joke book", "smiley face", "teddy bear", "saddle", "custom riding boots"};

    String[] Sheep = {"wool coat", "wool socks", "wool hat", "wool sweater", "wool blanket", "bah bah black sheep", "wool yarn", "irish wool", "smart wool", "wool"};

    String[] Monkey = {"football","musical","puzzle","phone","wilderness","outdoors","jokes","basketball","chrysanthemum","science"};

    String[] Rooster = {"gemstone rings","cashmere","leather journal","gold bar necklace","watches","book shelf","workout", "mirrors", "lucky number7","organization" };

    String[] Dog = {"poodle dog","secrets","love", "high end gifts", "cashmere blanket", "dog", "snuggly","travel", "journal", "business cards"};

    String[] Pig = {"sleep mask","optimism", "mans handkerchief", "chivalry","food", "cooking", "great job","hard work","8 ball", "work out" };

    public String getRat() {
        int randonIndex = rand.nextInt(Rat.length);
        keyWord = (Rat[randonIndex]);
        return keyWord;
    }

    public String getOx() {
        int randonIndex = rand.nextInt(Ox.length);
        keyWord = (Ox[randonIndex]);
        return keyWord;
    }

    public String getTiger() {
        int randonIndex = rand.nextInt(Tiger.length);
        keyWord = (Tiger[randonIndex]);
        return keyWord;
    }

    public String getRabbit() {
        int randonIndex = rand.nextInt(Rabbit.length);
        keyWord = (Rabbit[randonIndex]);
        return keyWord;
    }

    public String getDragon() {
        int randonIndex = rand.nextInt(Dragon.length);
        keyWord = (Dragon[randonIndex]);
        return keyWord;
    }

    public String getSnake() {
        int randonIndex = rand.nextInt(Snake.length);
        keyWord = (Snake[randonIndex]);
        return keyWord;
    }

    public String getHorse() {
        int randonIndex = rand.nextInt(Horse.length);
        keyWord = (Horse[randonIndex]);
        return keyWord;
    }

    public String getSheep() {
        int randonIndex = rand.nextInt(Sheep.length);
        keyWord = (Sheep[randonIndex]);
        return keyWord;
    }

    public String getMonkey() {
        int randonIndex = rand.nextInt(Monkey.length);
        keyWord = (Monkey[randonIndex]);
        return keyWord;
    }

    public String getRooster() {
        int randonIndex = rand.nextInt(Rooster.length);
        keyWord = (Rooster[randonIndex]);
        return keyWord;
    }

    public String getDog() {
        int randonIndex = rand.nextInt(Dog.length);
        keyWord = (Dog[randonIndex]);
        return keyWord;
    }

    public String getPig() {
        int randonIndex = rand.nextInt(Pig.length);
        keyWord = (Pig[randonIndex]);
        return keyWord;
    }

}

