public class singleton {
    private singleton(){

    }
    @Override
    public String toString(){
        return "Only one Object is allowed...";
    }
    private static singleton instance;
    public static singleton getinstance(){
        if(instance == null){
            instance = new singleton();
        }
        return instance;
    }
}