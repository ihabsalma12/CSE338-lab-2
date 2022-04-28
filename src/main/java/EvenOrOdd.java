public class EvenOrOdd {

    private Integer num;

    public void initNum(Integer num){
        this.num = num;
    }
    public boolean isEven(){
        if(num % 2 == 0 && num >= 0) return true;
        return false;
    }

    public boolean isOdd(){
        if(num % 2 == 1 && num >= 0) return true;
        return false;
    }

    public String evenOrOdd(){
        if(num % 2 == 0 && num >= 0) return "even";
        else if(num % 2 == 1 && num >= 0) return "odd";
        else return "neither";
    }
}
