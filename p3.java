import java.util.ArrayList;
import java.util.Random;

public class p3 extends Thread{
    ArrayList<String> arr = new ArrayList<>();
    p3(){
    for(int i=0;i<10;i++){
        arr.add("Male");
        arr.add("Female");
        }
    }
    synchronized void fish(p3 ob){
        Random ran = new Random();
        while(true){
        int f1 = ran.nextInt(20);
        int f2 = ran.nextInt(20);
        if((f1!=f2) && f1<arr.size() && f2<arr.size() && arr.size()>=2){
                if(arr.get(f1)=="Male" && arr.get(f2)=="Male")
                {
                    arr.remove(f2);
                    arr.remove(f1);
                }
                else if(arr.get(f1)=="Female" && arr.get(f2)=="Female"){
                    int t = ran.nextInt(2);
                    if(t==0)arr.remove(f1);
                    else arr.remove(f2); 
                }
                else 
                {
                    int child1 = ran.nextInt(2);
                    if(child1==0)arr.add("Male");
                    else arr.add("Female"); 
                    int child2 = ran.nextInt(2);
                    if(child2==0)arr.add("Male");
                    else arr.add("Female"); 
                }

            }
        if(arr.size()<2) System.exit(0);
        else System.out.println(arr.size());
        }
    }
    public void run(){
        fish(this);
    }
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Thread t = new p3();
            t.start();
        }
    }
}
