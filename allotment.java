public class allotment {

    String seatNo;
    String roll1;
    // String roll2;

    allotment(String seatNo, String roll1 /*String roll2*/){
        this.seatNo = seatNo;
        this.roll1 = roll1;
        // this.roll2 = roll2;
    }


    public allotment() {
    }


    String SEAT(classOccupancy ob , int num){

        seatNo = ob.roomNo +"_"+ Integer.toString(num);

        return seatNo;
    }

    String ROLL1(String filename, section ob){
        roll1 = filename + ob.roll;
        return roll1;
    }

    // String ROLL2(){

    //     return roll2;
    // }
    
}
