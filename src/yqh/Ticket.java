package yqh;

import spg.Flight;

public class Ticket {
    public String flightNum;//航班号
    public String place[]=new String[2];//起飞地点，降落地点
    public Type.PlaceEnum placetype;
    public int fare;//机票价格
    public Ticket(){}
    public Ticket(Flight x, Type.PlaceEnum t) {
        placetype=t;
        flightNum=x.getFlightNum();
        switch (t){
            case FULL:
                place[0]=x.getPlace()[0];
                place[1]=x.getPlace()[2];
                fare=x.getPrice()[0]+x.getPrice()[1];
                break;
            case FIRST:
                place[0]=x.getPlace()[0];
                place[1]=x.getPlace()[1];
                fare=x.getPrice()[0];
                break;
            case SECOND:
                place[0]=x.getPlace()[1];
                place[1]=x.getPlace()[2];
                fare=x.getPrice()[1];
                break;
        }
    }
}
