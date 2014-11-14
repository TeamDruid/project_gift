package com.detroitlabs.teamdruid.project_gift.models;

import android.content.Context;
import android.content.res.Resources;
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

    Resources res = context.getResources();
    String[] ratTermsArray = res.getStringArray(R.array.rat_terms);
    String[] oxTermsArray = res.getStringArray(R.array.ox_terms);
    String[] tigerTermsArray = res.getStringArray(R.array.tiger_terms);
    String[] rabbitTermsArray = res.getStringArray(R.array.rabbit_terms);
    String[] dragonTermsArray = res.getStringArray(R.array.dragon_terms);
    String[] snakeTermsArray = res.getStringArray(R.array.snake_terms);
    String[] horseTermsArray = res.getStringArray(R.array.horse_terms);
    String[] sheepTermsArray = res.getStringArray(R.array.sheep_terms);
    String[] monkeyTermsArray = res.getStringArray(R.array.monkey_terms);
    String[] roosterTermsArray = res.getStringArray(R.array.rooster_terms);
    String[] dogTermsArray = res.getStringArray(R.array.dog_terms);
    String[] pigTermsArray = res.getStringArray(R.array.pig_terms);

    public String getRandomSearchTerm(String[] animalTermsArray) {
        int randomIndex = rand.nextInt(animalTermsArray.length);
        keyword = (animalTermsArray[randomIndex]);
        return keyword;
    }

    public AnimalModel rat = new AnimalModel(res.getString(R.string.rat),
            res.getDrawable(R.drawable.rat),
            getRandomSearchTerm(ratTermsArray));

    AnimalModel ox = new AnimalModel(res.getString(R.string.ox),
            res.getDrawable(R.drawable.cow),
            getRandomSearchTerm(oxTermsArray));

    AnimalModel tiger = new AnimalModel(res.getString(R.string.tiger),
            res.getDrawable(R.drawable.tiger),
            getRandomSearchTerm(tigerTermsArray));

    AnimalModel rabbit = new AnimalModel(res.getString(R.string.rabbit),
            res.getDrawable(R.drawable.rabbit),
            getRandomSearchTerm(rabbitTermsArray));

    AnimalModel dragon = new AnimalModel(res.getString(R.string.dragon),
            res.getDrawable(R.drawable.dragon),
            getRandomSearchTerm(dragonTermsArray));

    AnimalModel snake = new AnimalModel(res.getString(R.string.snake),
            res.getDrawable(R.drawable.snake),
            getRandomSearchTerm(snakeTermsArray));

    AnimalModel horse = new AnimalModel(res.getString(R.string.horse),
            res.getDrawable(R.drawable.horse),
            getRandomSearchTerm(horseTermsArray));

    AnimalModel sheep = new AnimalModel(res.getString(R.string.sheep),
            res.getDrawable(R.drawable.ram),
            getRandomSearchTerm(sheepTermsArray));

    AnimalModel monkey = new AnimalModel(res.getString(R.string.monkey),
            res.getDrawable(R.drawable.monkey),
            getRandomSearchTerm(monkeyTermsArray));

    AnimalModel rooster = new AnimalModel(res.getString(R.string.rooster),
            res.getDrawable(R.drawable.rooster),
            getRandomSearchTerm(roosterTermsArray));

    AnimalModel dog = new AnimalModel(res.getString(R.string.dog),
            res.getDrawable(R.drawable.dog),
            getRandomSearchTerm(dogTermsArray));

    AnimalModel pig = new AnimalModel(res.getString(R.string.pig),
            res.getDrawable(R.drawable.pig),
            getRandomSearchTerm(pigTermsArray));

}
