package designPattern.factoryPattern;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-04
 * 풀이방법
 **/


public abstract class PizzaStore {
    SimplePizzaFactory factory;

//    public PizzaStore(SimplePizzaFactory factory) {
//        this.factory = factory;
//    }

    public Pizza orderPizza(String type) {
        Pizza pizza ;
//        pizza = factory.createPizza(type);
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    //기타 메서드

    abstract Pizza createPizza(String type);
}
