package test.annotation;

/**
 * @author GuanBin
 * @version FruitTest.java, v1 2018/4/23 下午11:47 GuanBin Exp $$
 */
public class Fruit {

    @FruitName(value = "Apple")
    private String fruitName;

    @FruitColor
    private String fruitColor;

    @FruitProvider(id=1,name = "陕西红富士",address = "陕西延安")
    private String fruitProvider;


    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(String fruitColor) {
        this.fruitColor = fruitColor;
    }

    public String getFruitProvider() {
        return fruitProvider;
    }

    public void setFruitProvider(String fruitProvider) {
        this.fruitProvider = fruitProvider;
    }
}
