package com.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


/*
Note this section is unfinished and will be cleaned up and documented later.
This just sets up startup info/makes visuals/imports data
 */
public class setup {

    //label and buttons
    public static JLabel moneyLabel;
    public static JButton studentButton;
    public static JButton juniorButton;
    public static JButton seniorButton;
    public static JButton managerButton;
    static ConcurrentHashMap<String, Object> dataMap = (ConcurrentHashMap<String, Object>) App.getDataMap();

    public static void main(String[] args) {

    }
    public static void setupGame() {



        File data = new File("data.json");

        if(!data.exists() || data.isDirectory()) {
            gameAspects money = new Money("Money", 0,null);
            dataMap.put("Money", money);
            gameAspects student = new Student("Student", 0, 10);
            dataMap.put("Student", student);
            gameAspects junior = new Junior("Junior", 0, 100);
            dataMap.put("Junior",junior);
            gameAspects senior = new Senior("Senior", 0, 1000);
            dataMap.put("Senior",senior);
            gameAspects manager = new Manager("Manager", 0, 10000);
            dataMap.put("Manager",manager);
        }else {
            System.out.println("Saved Data found, loading in.");
            try(FileReader reader = new FileReader(data)){
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(reader).getAsJsonObject();
                for(String key: jsonObject.keySet()){
                    if(key.equals("Money")){
                        gameAspects money = new Money(jsonObject.getAsJsonObject(key).get("focus").getAsString(),
                                jsonObject.getAsJsonObject(key).get("quantity").getAsInt(),
                                null);
                        dataMap.put(key,money);
                    }else if(key.equals("Student")){
                        gameAspects student = new Student(jsonObject.getAsJsonObject(key).get("focus").getAsString(),
                                jsonObject.getAsJsonObject(key).get("quantity").getAsInt(),
                                jsonObject.getAsJsonObject(key).get("cost").getAsInt());
                        dataMap.put(key,student);
                    }else if(key.equals("Junior")){
                        gameAspects junior = new Junior(jsonObject.getAsJsonObject(key).get("focus").getAsString(),
                                jsonObject.getAsJsonObject(key).get("quantity").getAsInt(),
                                jsonObject.getAsJsonObject(key).get("cost").getAsInt());
                        dataMap.put(key,junior);
                    }else if(key.equals("Senior")){
                        gameAspects senior = new Senior(jsonObject.getAsJsonObject(key).get("focus").getAsString(),
                                jsonObject.getAsJsonObject(key).get("quantity").getAsInt(),
                                jsonObject.getAsJsonObject(key).get("cost").getAsInt());
                        dataMap.put(key,senior);
                    }else if(key.equals("Manager")){
                        gameAspects manager = new Manager(jsonObject.getAsJsonObject(key).get("focus").getAsString(),
                                jsonObject.getAsJsonObject(key).get("quantity").getAsInt(),
                                jsonObject.getAsJsonObject(key).get("cost").getAsInt());
                        dataMap.put(key,manager);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



        // General screen info
        JFrame frame = new JFrame();
        frame.setSize(700,600);
        //put in close operation
        frame.setResizable(false); // false until I can get a working display
        frame.setLocationRelativeTo(null);

        // Panel Layout
        JPanel topPanel = createTopPanel();
        JPanel rightUnitPanel = createRightUnitPanel();
        JPanel whaleObjectThing = createWhalePanel();
//        JPanel bottomLogPanel = createBottomLogPanel();

        // Add game sections to gamescreen
        frame.setLayout(new BorderLayout());

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(rightUnitPanel, BorderLayout.EAST);
        frame.add(whaleObjectThing, BorderLayout.CENTER);
//        frame.add(bottomLogPanel, BorderLayout.SOUTH);



        frame.setVisible(true);
    }
    private static JPanel createTopPanel(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,5));

        // Set up labels and buttons
        moneyLabel = new JLabel("Money: ");
        JLabel linesOfCodeLabel = new JLabel("Lines of Code: ");
        JButton upgradeButton = new JButton("Upgrade");
        JButton achievementButton = new JButton("Achievements");
        JButton prestigeButton = new JButton("Prestige");
        JButton settingsButton = new JButton("Settings");


        topPanel.add(moneyLabel);
        topPanel.add(upgradeButton);
        topPanel.add(achievementButton);
        topPanel.add(prestigeButton);
        topPanel.add(settingsButton);
        topPanel.add(linesOfCodeLabel);
        topPanel.add(new JPanel()); // the empty sections are for spacing cause I haven't learned proper positioning yet.
        topPanel.add(new JPanel());
        topPanel.add(new JPanel());
        topPanel.add(new JPanel());


        return topPanel;
    }

    private static JPanel createWhalePanel() {
        JPanel whalePanel = new JPanel();


        ImageIcon originalIcon = new ImageIcon("src/main/tempWhale.png");
        Image originalImg = originalIcon.getImage();
        Image scaledImg = originalImg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JButton whaleButton = new JButton(scaledIcon);


        // Action listener to add to money
        whaleButton.addActionListener(e -> {
            gameAspects value = (gameAspects) dataMap.get("Money");
            updateButton(value);

        });
        whalePanel.add(whaleButton);

        return whalePanel;
    }

    private static JPanel createRightUnitPanel() {
        JPanel rightUnitPanel = new JPanel();
        rightUnitPanel.setLayout(new GridLayout(4,1));

        studentButton = new JButton("Student \n Quantity: 0\n Price: 10");
        juniorButton = new JButton("Junior Developer \n" +
                "Quantity: \n" +
                "Price: ");
        seniorButton = new JButton("Senior Developer \n" +
                "Quantity: \n" +
                "Price: ");
        managerButton = new JButton("Team Manager \n" +
                "Quantity: \n" +
                "Price: ");


        rightUnitPanel.add(studentButton);
        rightUnitPanel.add(juniorButton);
        rightUnitPanel.add(seniorButton);
        rightUnitPanel.add(managerButton);


        studentButton.addActionListener(e -> {
            gameAspects value = (gameAspects) dataMap.get("Money");
            int coin = value.getQuantity();
            gameAspects value2 = (gameAspects) dataMap.get("Student");
            int cost = value2.getCost();
            if( coin>=cost){
                value.setQuantity(coin - cost);
                int qty = value2.getQuantity();
                qty++;
                double dCost = (1.0/10.0)*Math.pow(qty,3)+10;
                cost = (int)dCost;
                value2.setQuantity(qty);
                value2.setCost(cost);
                studentButton.setText(String.format("Student \n Quantity: %s\n Price: %s",qty,cost));
            }

        });

        juniorButton.addActionListener(e -> {
            gameAspects value = (gameAspects) dataMap.get("Money");
            int coin = value.getQuantity();
            gameAspects value2 = (gameAspects) dataMap.get("Junior");
            int cost = value2.getCost();
            if( coin>=cost){
                value.setQuantity(coin - cost);
                int qty = value2.getQuantity();
                qty++;
                double dCost = (1.0/10.0)*Math.pow(qty,3)+100;
                cost = (int)dCost;
                value2.setQuantity(qty);
                value2.setCost(cost);
                juniorButton.setText(String.format("Junior \n Quantity: %s\n Price: %s",qty,cost));
            }

        });

        seniorButton.addActionListener(e -> {
            gameAspects value = (gameAspects) dataMap.get("Money");
            int coin = value.getQuantity();
            gameAspects value2 = (gameAspects) dataMap.get("Senior");
            int cost = value2.getCost();
            if( coin>=cost){
                value.setQuantity(coin - cost);
                int qty = value2.getQuantity();
                qty++;
                double dCost = (1.0/10.0)*Math.pow(qty,3)+1000;
                cost = (int)dCost;
                value2.setQuantity(qty);
                value2.setCost(cost);
                seniorButton.setText(String.format("Senior \n Quantity: %s\n Price: %s",qty,cost));
            }

        });

        managerButton.addActionListener(e -> {
            gameAspects value = (gameAspects) dataMap.get("Money");
            int coin = value.getQuantity();
            gameAspects value2 = (gameAspects) dataMap.get("Manager");
            int cost = value2.getCost();
            if( coin>=cost){
                value.setQuantity(coin - cost);
                int qty = value2.getQuantity();
                qty++;
                double dCost = (1.0/10.0)*Math.pow(qty,3)+10000;
                cost = (int)dCost;
                value2.setQuantity(qty);
                value2.setCost(cost);
                managerButton.setText(String.format("Manager \n Quantity: %s\n Price: %s",qty,cost));
            }

        });

        return rightUnitPanel;
    }
    private static void updateButton(gameAspects value){
        String focus = value.getFocus();
        if (focus.equals("Money")){
            int coin = value.getQuantity();

            coin ++;
            value.setQuantity(coin);

            moneyLabel.setText(String.format("Money: %s",coin));
        }
    }




}
