package practice.ch14;

import java.io.*;

public class findComilerOrNotPage465 {

    public static void main(String[] args){
        try {
//            FileReader fileReader = new FileReader();
//            BufferedReader reader = new BufferedReader(fileReader);
            //fail

//            FileOutputStream f = new FileOutputStream(new File("Foo.ser"));
//            ObjectOutputStream os = new ObjectOutputStream(f);
            // pass

//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                makeCard(line);
//            }
            // pass, just need to declare variable and method

//            ObjectInputStream is = new ObjectInputStream(new FileOutputStream("Game.ser"));
//            GameCharacter oneAgain = (GameCharacter) is.readObject();
            // fail
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
