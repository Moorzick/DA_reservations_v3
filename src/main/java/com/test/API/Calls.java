package com.test.API;

public class Calls {
    public static GetRoomNumbers getRoomNumbers;
    //public static GetRoomNumbers getRoomNumbers;

    public static GetRoomNumbers getRoomNumbers(){
        if (getRoomNumbers==null){
            getRoomNumbers=new GetRoomNumbers();
        }
        return getRoomNumbers;
    }

}
