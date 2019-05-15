package spg;

import org.apache.commons.lang3.StringUtils;

import java.time.DateTimeException;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

public class Flight implements spg.Tool {
    private String flightNum;       //航班号
    private String airways;       //航空公司
    private String[] place = {"无", "无", "无"};        //起飞、经停、降落地点
    private Timestamp[] time = new Timestamp[4];     //起飞、经停、再飞、到达时间
    private int[] resTicket = {MAXCAPACITY, MAXCAPACITY};//余票
    private String status = "正常";      //航班状态
    private int[] price = {0, 0};        //全程或第一段票价、第二段票价
    private boolean isStop;       //是否经停
    private int[] waybill = new int[MAXCAPACITY];   //乘客名单
    private Queue<String> appointList = new LinkedList<String>();//FULL预约名单
    private Queue<String> appointList1 = new LinkedList<String>();//FIRST预约名单
    private Queue<String> appointList2 = new LinkedList<String>();//SECOND预约名单

    public Flight() {
        for (int i = 0; i < 4; i++) {
            time[i] = new Timestamp(119, 0, 0, 0, 0, 0, 0);
        }
    }

    //增加航班
    public void addFlight(String flightNum, String airways, boolean isStop,
                          String[] place, Timestamp[] time, int[] price) {
        this.flightNum = flightNum;
        this.airways = airways;
        this.isStop = isStop;
        for (int i = 0; i < 3; i++) this.place[i] = place[i];
        for (int i = 0; i < 4; i++) this.time[i] = time[i];
        for (int i = 0; i < 2; i++) this.price[i] = price[i];
    }

    //删除航班
    public static void delFlight(int flightNum) {

    }

    //修改航班信息
    public void updateInfo() {

    }

    //查找航班
    public static void seekFlight(int flightNum) {

    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getAirways() {
        return airways;
    }

    public void setAirways(String airways) {
        this.airways = airways;
    }

    public String[] getPlace() {
        return place;
    }

    public void setPlace(String[] place) {
        for (int i = 0; i < 3; i++)
            this.place[i] = place[i];
    }

    public Timestamp[] getTime() {
        return time;
    }

    public void setTime(Timestamp[] time) {
        for (int i = 0; i < 4; i++)
            this.time[i] = time[i];
    }

    public int[] getResTicket() {
        return resTicket;
    }

    public void setResTicket(int[] resTicket) {
        for (int i = 0; i < 2; i++)
            this.resTicket[i] = resTicket[i];
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        for (int i = 0; i < 2; i++)
            this.price[i] = price[i];
    }

    public boolean getIsStop() {
        return isStop;
    }

    public void setIsStop(boolean isStop) {
        this.isStop = isStop;
    }

    public int[] getWaybill() {
        return waybill;
    }

    public void setWaybill(int[] waybill) {
        for (int i = 0; i < waybill.length; i++) {
            this.waybill[i] = waybill[i];
        }
    }

    public Queue getAppointList() {
        return appointList;
    }

    public void setAppointList(String[] appointList) {
        for (int i = 0; i < appointList.length; i++) {
            this.appointList.offer(appointList[i]);
        }
    }

    public Queue getAppointList1() {
        return appointList1;
    }

    public void setAppointList1(String[] appointList1) {
        for (int i = 0; i < appointList1.length; i++) {
            this.appointList1.offer(appointList1[i]);
        }
    }

    public Queue getAppointList2() {
        return appointList2;
    }

    public void setAppointList2(String[] appointList2) {
        for (int i = 0; i < appointList2.length; i++) {
            this.appointList2.offer(appointList2[i]);
        }
    }
}