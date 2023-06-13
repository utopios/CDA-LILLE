package org.example;

import jdk.jshell.spi.ExecutionControl;

public class Year {
    public boolean isLeap(int y) throws ExecutionControl.NotImplementedException {
        return (y%400 == 0 || (y%4==0 && y%100 != 0) || y%4000 == 0);
//        throw new ExecutionControl.NotImplementedException("");
    }
}
