package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();

    // FilePointer is an offset in the file when next read or write will start from.
    // If the file pointer is at position 100 and we have read 5 bytes then the next file pointer will be at 105
    // An offset is byte location at a file.
    // When using RAF, the dataset collectively is called as records. In our case, the locationID, description and exits
    // will call as records.
    // Every file has an index associated with it. Index stores the offset and record length of each data
    // Reading location data using RAF will involve two step process
    // Firstly we are going to get the index of the location and then use the index value to get the data of the
    // location.
    // every location will have the same index length.

    // 1. First four bytes will contain the no. of locations. (0-3)
    // 2. The next four bytes will contain the start offset of the location section (4-7)
    // 3. The next section will contain the index (Index starts from 8 through 1699) bytes.
    // 4. Final section of the file will contain location records. It will start at byte 1700.


    public static void main(String[] args) throws IOException{
        try(RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            rao.writeInt(locations.size());  // "rwd" is the RandomAccessFile mode. It will open file in read, write
                                            // and will ensure that synchronization is handled by RandomAccessFile class
                                            // writing will occur synchronously

            // each index records will contain three integers.
            // 1. Location ID
            // 2. Offset of the location
            // 3. The size of the location record.
            int indexSize = locations.size() * 3 * Integer.BYTES; // Hence, we are multiplying locations size with three
                                                                  // ints and the BYTES contain in an integer.
            int locationStart = (int) (indexSize + rao.getFilePointer()
                + Integer.BYTES);                                 // Here we are casting it to an int since filePointer
                                                                  // contains the long value
            rao.writeInt(locationStart);
            // Next we are going to write the index of each location. First we will be writing all the  locations and
            // then we will load the index of each location record in the memory.
            long indexStart = rao.getFilePointer();  // Once we have written all the location we want to jump back to
                                                     // the the location where the location record starts, hence we are
                                                     // writing the indexStart position here


            int startPointer = locationStart;
            rao.seek(startPointer);

            for (Location location:locations.values()) {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction:location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());
                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            // Now that we have stored the locationsID and each location record in a Map, we need to move back to the
            // indexStart position and write the index of locationID, location StartByte and length of each location
            // record

            rao.seek(indexStart);
            for (Integer locationID:index.keySet()) {
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }

        }
    }

    // Keeping just one instance of data by initializing it in static block.

    static {
        try(ObjectInputStream locFile = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + ": " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                } catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found Exception: " + e.getMessage());
                }
            }
        } catch (InvalidClassException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locId = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locId + ": " + description);
//                    System.out.println("Found " + numExits + " exits");
//                    for (int i=0; i<numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                    locations.put(locId, new Location(locId, description, exits));
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }

//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
////            scanner = new Scanner(new FileReader("locations_big.txt"));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Location is " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            }
//
//        // Read exits from the directions.txt file
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                // alternative way of reading data by splitting the line into array of words using delimiter
//
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + "," + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
