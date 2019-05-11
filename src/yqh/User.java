package yqh;

import spg.Flight;

import java.util.ArrayList;

public class User {
    int id;//ID
    ArrayList ticketlist = new ArrayList();//已购航班

    public Flight getflight(String flightNum) {//参数为航班号，返回指定航班，未完成
        Flight x = new Flight();
        return x;
    }
    /*public int buy(Flight x, Type.PlaceEnum t){//参数为航班x和上下机情况t，购票成功返回1并修改x，失败返回0，x无变化
        switch (t){ //检查余票，无余票返回0退出。有则余票数减1
            case FULL:
                if(x.getResTicket()[0]==0&&x.getResTicket()[1]==0)
                    return 0;
                x.getResTicket()[0]--;
                x.getResTicket()[1]--;
                break;
            case FIRST:
                if(x.getResTicket()[0]==0)
                    return 0;
                break;
                x.getResTicket()[0]--;
            case SECOND:
                if(x.getResTicket()[1]==0)
                    return 0;
                break;
                x.getResTicket()[1]--;
        }
        for(int i=0;i<x.getWaybill().length;i++)//更新x的乘客列表
            if(x.getWaybill()[i]==0){
                x.getWaybill()[i]=id;
                break;
            }
        Ticket a = new Ticket(x,t);//更新用户已购航班列表
        ticketlist.add(a);
        return 1;
    }*/
}
