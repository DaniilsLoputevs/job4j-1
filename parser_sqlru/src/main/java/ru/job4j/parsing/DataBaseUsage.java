package ru.job4j.parsing;

import java.util.List;

public interface DataBaseUsage {


    void insertData(List<? extends DataType> dataTypes);

     List<? extends DataType> getData();

     void init();

}
