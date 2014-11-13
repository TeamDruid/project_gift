package com.detroitlabs.teamdruid.project_gift.models;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.detroitlabs.teamdruid.project_gift.R;

import java.util.Random;

/**
 * Created by elyseturner on 11/13/14.
 */
public class AnimalModel {

    private String animalName;
    private Drawable animalDrawable;
    private String animalSearchTerm;
    private String keyword;
    private Context context;

    public Random rand = new Random();

    public AnimalModel(String animalName, Drawable animalDrawable, String animalSearchTerm) {
        this.animalName = animalName;
        this.animalDrawable = animalDrawable;
        this.animalSearchTerm = animalSearchTerm;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Drawable getAnimalDrawable() {
        return animalDrawable;
    }

    public void setAnimalDrawable(Drawable animalDrawable) {
        this.animalDrawable = animalDrawable;
    }

    public String getAnimalSearchTerm() {
        return animalSearchTerm;
    }

    public void setAnimalSearchTerm(String animalSearchTerm) {
        this.animalSearchTerm = animalSearchTerm;
    }

    String[] ratTermsArray = {"stationery", "soap", "lip balm", "macaroon", "friendship", "mug", "laptop bag", "infinity scarf", "pet tag", "antique jewelry"};

    String[] oxTermsArray = {"journal", "farm", "hand quilted", "embroidery", "jigsaw puzzle", "candle", "plants", "tea", "beer kit", "canned goods"};

    String[] tigerTermsArray = {"picture frame", "politics", "notebook", "pen", "book", "organization", "mirror", "leather bag", "iPhone cover", "liquor"};

    String[] rabbitTermsArray = {"feelings", "color", "decorative", "pretty", "locket", "pocket watch", "landscape", "paris", "diary", "gold"};

    String[] dragonTermsArray = {"computers","inventor","leader","roller skates","bike helmet","diary","stickers","hat","glitter pen","jewelry box"};

    String[] snakeTermsArray = {"inspirational quotes","story book","stress ball","headphones","orchid","cactus","pottery","paint","dreamcatcher","video games"};

    String[] horseTermsArray = {"panda", "woodworking", "basketball", "shiny tank top", "butterfly clips", "joke book", "smiley face", "teddy bear", "saddle", "custom riding boots"};

    String[] sheepTermsArray = {"wool coat", "wool socks", "wool hat", "wool sweater", "wool blanket", "bah bah black sheep", "wool yarn", "irish wool", "smart wool", "wool"};

    String[] monkeyTermsArray = {"football","musical","puzzle","phone","wilderness","outdoors","jokes","basketball","chrysanthemum","science"};

    String[] roosterTermsArray = {"gemstone rings","cashmere","leather journal","gold bar necklace","watches","book shelf","workout", "mirrors", "lucky number7","organization" };

    String[] dogTermsArray = {"poodle dog","secrets","love", "high end gifts", "cashmere blanket", "dog", "snuggly","travel", "journal", "business cards"};

    String[] pigTermsArray = {"sleep mask","optimism", "mans handkerchief", "chivalry","food", "cooking", "great job","hard work","8 ball", "work out" };

    public String getRandomSearchTerm(String[] animalTermsArray) {
        int randomIndex = rand.nextInt(animalTermsArray.length);
        keyword = (animalTermsArray[randomIndex]);
        return keyword;
    }

    AnimalModel Rat = new AnimalModel("rat", context.getResources().getDrawable(R.drawable.rat),
            getRandomSearchTerm(ratTermsArray));

}
