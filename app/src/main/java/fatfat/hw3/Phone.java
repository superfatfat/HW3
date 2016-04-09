package fatfat.hw3;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Created by user on 2016/4/9.
 */
public class Phone implements Serializable{
    private int image;
    private String name;
    private int price;

    public Phone(int image, String name, int price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return "$"+new DecimalFormat("#,###").format(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
