package xyz.jeevan.code.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Problem statement - You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has
 * pills of weight 1.1 grams. Given a scale that provides an exact measurement, how would you find
 * the heavy bottle? You can only use the scale once. In programming terms, using the scale only
 * once means iterate the collection only once.
 *
 * @author jeevan
 */
public class HeavyPillProblem {

  private static int NUMBER_OF_BOTTLES = 20;
  private static double DEFAULT_PILL_WEIGHT = 1.0;
  private static double FAULTY_PILL_WEIGHT = 1.1;

  public static void main(String[] args) {
    int heavyBottle = new HeavyPillProblem().findHeavyBottle(getBottleContainer());
    System.out.println("Heavy bottle number is : " + heavyBottle);
  }

  // prepare bottle data
  private static Container getBottleContainer() {
    Random random = new Random();
    int bottleWithHeavyPill = random.nextInt(NUMBER_OF_BOTTLES) + 1;
    System.out.println(bottleWithHeavyPill);

    List<Bottle> bottles = new LinkedList<>();
    double weight = 0.0;
    for (int i = 1; i <= NUMBER_OF_BOTTLES; i++) {
      double bottleWeight = (i == bottleWithHeavyPill ? FAULTY_PILL_WEIGHT : DEFAULT_PILL_WEIGHT);
      weight += bottleWeight;
      bottles.add(new Bottle(i, bottleWeight));
    }
    Container container = new Container(bottles);
    container.setWeight(weight);
    return container;
  }

  public int findHeavyBottle(Container container) {
    double totalWeight = container.getWeight();
    List<Bottle> bottles = container.getBottles();

    double idealWeight = 0;
    for (int i = 1; i < bottles.size(); i++) {
      idealWeight += (i * DEFAULT_PILL_WEIGHT);
    }

    System.out.println("total weight - " + totalWeight);
    System.out.println("ideal weight - " + idealWeight);

    Double heavyPill = (totalWeight - idealWeight) / DEFAULT_PILL_WEIGHT;

    return heavyPill.intValue();
  }
}

class Container {

  private List<Bottle> bottles;
  private double weight;  // total weight of bottles

  public Container(List<Bottle> bottles) {
    this.bottles = bottles;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public List<Bottle> getBottles() {
    return bottles;
  }

  public double getWeight() {
    return weight;
  }
}

class Bottle {

  private int id;
  private double weightOfPill;

  public Bottle(int id, double weightOfPill) {
    this.id = id;
    this.weightOfPill = weightOfPill;
  }

  public int getId() {
    return id;
  }

  public double getWeightOfPill() {
    return weightOfPill;
  }
}
