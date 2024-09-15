package model;

import java.io.*;
import java.util.*;

public class CowModel {
    private List<Cow> cows = new ArrayList<>();
    private final String FILE_PATH = "data/cow_data.csv";
    

    public CowModel() {
        loadCowData();
    }

    // Load cow data from CSV file
    private void loadCowData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Cow cow = new Cow(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    cows.add(cow);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Find cow by ID
    public Cow findCowById(String id) {
        for (Cow cow : cows) {
            if (cow.getId().equals(id)) {
                return cow;
            }
        }
        return null;
    }

    // Save updated cow  CSV file
    public void saveCowData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Cow cow : cows) {
                bw.write(cow.getId() + "," + cow.getAgeYears() + "," + cow.getAgeMonths() + "," + cow.getNumUdders());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Update cow udders
    public void updateCowUdders(String id, int newUdders) {
        Cow cow = findCowById(id);
        if (cow != null) {
            cow.setNumUdders(newUdders);
            saveCowData();
        }
    }

    // Return all cows
    public List<Cow> getAllCows() {
        return cows;
    }
}

