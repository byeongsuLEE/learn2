package designPattern.factoryPattern;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-05
 * 풀이방법
 **/


public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String item){
        if((item.equals("cheese"))){
            return new ChicagoStyleCheesePizza();
        }else if((item.equals("veggie"))){
            return new ChicagoStyleCheesePizza();
        }else if((item.equals("clam"))){
            return new ChicagoStyleClamPizz();
        }else if((item.equals("pepperoni"))){
            return new ChicagoStylePepperoniPizza();
        }else
            return null;


    }


}
