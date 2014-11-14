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

    AnimalModel rat = new AnimalModel("rat", context.getResources().getDrawable(R.drawable.rat),
            getRandomSearchTerm(ratTermsArray));

    AnimalModel ox = new AnimalModel("ox", context.getResources().getDrawable(R.drawable.cow),
            getRandomSearchTerm(oxTermsArray));

    AnimalModel tiger = new AnimalModel("tiger", context.getResources().getDrawable(R.drawable.tiger),
            getRandomSearchTerm(tigerTermsArray));

    AnimalModel rabbit = new AnimalModel("rabbit", context.getResources().getDrawable(R.drawable.rabbit),
            getRandomSearchTerm(rabbitTermsArray));

    AnimalModel dragon = new AnimalModel("dragon", context.getResources().getDrawable(R.drawable.dragon),
            getRandomSearchTerm(dragonTermsArray));

    AnimalModel snake = new AnimalModel("snake", context.getResources().getDrawable(R.drawable.snake),
            getRandomSearchTerm(snakeTermsArray));

    AnimalModel horse = new AnimalModel("horse", context.getResources().getDrawable(R.drawable.horse),
            getRandomSearchTerm(horseTermsArray));

    AnimalModel sheep = new AnimalModel("sheep", context.getResources().getDrawable(R.drawable.ram),
            getRandomSearchTerm(sheepTermsArray));

    AnimalModel monkey = new AnimalModel("monkey", context.getResources().getDrawable(R.drawable.monkey),
            getRandomSearchTerm(monkeyTermsArray));

    AnimalModel rooster = new AnimalModel("rooster", context.getResources().getDrawable(R.drawable.rooster),
            getRandomSearchTerm(roosterTermsArray));

    AnimalModel dog = new AnimalModel("dog", context.getResources().getDrawable(R.drawable.dog),
            getRandomSearchTerm(dogTermsArray));

    AnimalModel pig = new AnimalModel("pig", context.getResources().getDrawable(R.drawable.pig),
            getRandomSearchTerm(pigTermsArray));

}
