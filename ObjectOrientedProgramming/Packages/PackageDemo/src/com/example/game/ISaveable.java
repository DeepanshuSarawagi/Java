package com.example.game;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    List<String> writeData();
    void read(List<String> savedValues);

}
