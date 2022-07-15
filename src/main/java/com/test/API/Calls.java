package com.test.API;

public class Calls {
    public static GetRoomNumbers getRoomNumbers;
    public static GetReservation getReservation;
    public static PatchReservation patchReservation;

    public static GetRoomNumbers getRoomNumbers(){
        if (getRoomNumbers==null){
            getRoomNumbers=new GetRoomNumbers();
        }
        return getRoomNumbers;
    }

    public static GetReservation getReservation(){
        if (getReservation ==null){
            getReservation =new GetReservation();
        }
        return getReservation;
    }

    public static PatchReservation patchReservation(){
        if(patchReservation==null){
            patchReservation=new PatchReservation();
        }
        return patchReservation;
    }

}
