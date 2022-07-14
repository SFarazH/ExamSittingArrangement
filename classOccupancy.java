public class classOccupancy {
    
    String roomNo;
    int capacity;

    classOccupancy(String roomNo, int capacity){
        this.roomNo = roomNo;
        this.capacity = capacity;
    }

    public void display(){
        
        System.out.println("  "+roomNo + "\t\t" + capacity);
    }

}
