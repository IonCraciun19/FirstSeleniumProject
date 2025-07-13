package registration.utils;

import org.testng.annotations.DataProvider;
import registration.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviders {

    @DataProvider
    public Iterator<Object[]> createUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Erwin", "Elwerer", "elwer12@gm.com", "Erwin$123"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> createNewUserFromCsv() throws IOException{
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/newUsers.csv")));
        String line = reader.readLine();
        while (line !=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
