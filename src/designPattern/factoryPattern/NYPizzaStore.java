package designPattern.factoryPattern;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-05
 * 풀이방법
 **/


public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String item) {

       if((item.equals("cheese"))){
           return new NYStypleCheesePizza();
       }else if((item.equals("veggie"))){
           return new NYStyleVeggiePizza();
       }else if((item.equals("clam"))){
           return new NYStyleClamPizz();
       }else if((item.equals("pepperoni"))){
           return new NYStylePepperoniPizza();
       }else
           return null;

    }

}
