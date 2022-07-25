package com.test.API;

public class Calls {
    public static GetRoomNumbers getRoomNumbers;
    public static GetReservationFromPMSID getReservationFromPMSID;
    public static PatchReservation patchReservation;

    public static GetRoomNumbers getRoomNumbers(){
        if (getRoomNumbers==null){
            getRoomNumbers=new GetRoomNumbers();
        }
        return getRoomNumbers;
    }

    public static GetReservationFromPMSID getReservation(){
        if (getReservationFromPMSID ==null){
            getReservationFromPMSID =new GetReservationFromPMSID();
        }
        return getReservationFromPMSID;
    }

    public static PatchReservation patchReservation(){
        if(patchReservation==null){
            patchReservation=new PatchReservation();
        }
        return patchReservation;
    }

}
