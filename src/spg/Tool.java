package spg;

public interface Tool {
    int MAXCAPACITY = 10;                  //最大乘客量

    enum Status {normality, delay, cancel} //航班的三种状态

    String[] AIRWAYS = {"中国国际航空公司", "中国南方航空公司", "中国东方航空公司", "海南航空公司", "深圳航空公司"};

    String[] PLACE = {"无", "北京", "上海", "西安", "昆明", "成都", "重庆", "广州", "郑州", "长沙", "深圳",
            "武汉", "南京", "贵阳", "杭州", "青岛", "香港", "澳门", "台北", "长春", "哈尔滨"};
}