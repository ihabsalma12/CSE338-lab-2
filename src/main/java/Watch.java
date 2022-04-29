public class Watch {
    private String state, state1;
    private Integer m, h, D, M, Y;

    public void setNull(){
        state = null; state = null;
        m = null; h = null; D = null; M = null; Y = null;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public void setm(Integer m) {
        this.m = m;
    }

    public void seth(Integer h){
        this.h = h;
    }

    public void setY(Integer Y) {
        this.Y = Y;
    }

    public void setM(Integer M) {
        this.M = M;
    }

    public void setD(Integer D) {
        this.D = D;
    }

    public String getState() {
        return state;
    }

    public String getState1() {
        return state1;
    }

    public Integer getm() {
        return m;
    }

    public Integer geth() {
        return h;
    }

    public Integer getY() {
        return Y;
    }

    public Integer getM(){
        return M;
    }

    public Integer getD() {
        return D;
    }

    public Watch(){
        setState("NORMAL");
        setState1("TIME");
        setm(0); seth(0); setD(1); setM(1); setY(2000);
    }

    public void takeInput(char letter){
        switch(state){
            case "NORMAL":
                if(letter == 'c'){
                    state = "UPDATE";
                    state1 = "MIN";
                }
                if(letter == 'b'){
                    state = "ALARM";
                    state1 = "ALARM";
                }
                if(letter == 'a') {
                   if(state1.equals("TIME")) state1 = "DATE";
                   else state1 = "TIME";
                }
            case "UPDATE":
                if(letter == 'd'){
                    state = "NORMAL";
                    state1 = "TIME";
                }
                if(letter == 'a') {
                    if(state1.equals("MIN")) state1 = "HOUR";
                    else if (state1.equals("HOUR")) state1 = "DAY";
                    else if (state1.equals("DAY")) state1 = "MONTH";
                    else if (state1.equals("MONTH")) state1 = "YEAR";
                    else if (state1.equals("YEAR")){
                        state = "NORMAL";
                        state1 = "TIME";
                    }
                }
                if(letter == 'b') {
                    if(state1.equals("MIN")) m = (m + 1) % 60;
                    else if (state1.equals("HOUR")) h = (h + 1) % 24;
                    else if (state1.equals("DAY")) D = (D + 1) % 31;
                    else if (state1.equals("MONTH")) M = (M + 1) % 12;
                    else if (state1.equals("YEAR")) {
                        if(Y + 1 > 2100) Y = 2000;
                        else Y++;
                    }
                }
            case "ALARM":
                if(letter == 'a'){
                    if(state1.equals("ALARM")) state1 = "CHIME";
                }
                if(letter == 'd'){
                    state = "NORMAL";
                    state1 = "TIME";
                }
            default:
        }
    }

    public void displayDate() {
        System.out.println(Y + "-" + M + "-" + D);
    }
    public void displayTime() {
        System.out.println(h + ":" + m);
    }
/*
    set state= NORMAL;
    set state1=TIME;
    set m=0,h=0, D=1,M=1, Y=2000.
    For each input do
            switch(state)
    Case NORMAL:{
        If (input ==c) state=UPDATE
        If (input ==b) state=ALARM
        If (input ==a)
        If (state1==TIME)
        state1=DATE
            else
        state1=TIME
    }
    Case UPDATE: ..
    Case ALARM: ..
}
    DisplayDate() {print Y+"-"+M+"-"+D}
    DisplayTIME() {print h+":"+m}

e.g. to do state coverage one input like  "abadcaaaaa" is enough
1) Complete the algorithm and code it using C/java, so it can be used as a real watch
2) find test suite for edge coverage
3) create an ADUP test suite based on variables: minutes, seconds, hours, day, month and year*/


}
