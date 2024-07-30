import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class Product {
    private String name;
    private String category;
    private int quantity;

    public Product(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }
public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }
    public void increaseQuantity(String name, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setQuantity(product.getQuantity() + quantity);
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public void decreaseQuantity(String name, int quantity) {
        for (Product product : products) {
    if (product.getName().equals(name)) {
                int newQuantity = product.getQuantity() - quantity;
                if (newQuantity < 0) {
                    System.out.println("Insufficient quantity.");
                    return;
                }
                product.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Product not found.");
    }
