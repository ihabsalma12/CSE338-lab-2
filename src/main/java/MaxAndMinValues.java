public class MaxAndMinValues {
    Integer arr[];

    public void initArray(Integer arr[]){
        this.arr = arr;
        for(int i = 0; i < arr.length; i++)
            this.arr[i] = arr[i];
    }

    public Integer Max(){
        Integer max = -99999;
        for(int i = 0; i < this.arr.length; i++){
            if(arr[i] > max) max = this.arr[i];
        }
        return max;
    }

    public Integer Min(){
        Integer min = 99999;
        for(int i = 0; i < this.arr.length; i++){
            if(arr[i] < min) min = this.arr[i];
        }
        return min;
    }
}
